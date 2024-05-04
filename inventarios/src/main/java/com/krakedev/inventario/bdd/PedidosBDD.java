package com.krakedev.inventario.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventario.entidades.DetallePedido;
import com.krakedev.inventario.entidades.Pedido;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class PedidosBDD{
	public void insertar(Pedido pedido) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		// fecha actual
		Date fechaActual = new Date();
		java.sql.Date fecha = new java.sql.Date(fechaActual.getTime());
		
		int codigoCabecera = 0;
		
		ArrayList<DetallePedido> detalles = pedido.getDetalles();
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido(proveedor_cod, fecha, estado_cod)"
					+ "values (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, pedido.getProveedor().getIdentificador());
			ps.setDate(2, fecha);
			ps.setString(3, "S");
			
			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();
			
			if(rsClave.next()) {
				codigoCabecera =rsClave.getInt(1);
			}
			
			for(int i = 0; i < detalles.size(); i++) {
				DetallePedido det = detalles.get(i);
				psDet = con.prepareStatement("insert into detalle_pedido(cabecera_pedido_cod, producto_cod, cantidad_solicitada, subtotal, cantidad_recibida)"
						+ "values (?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidadSolicitada());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(4, subtotal);
				psDet.setInt(5, 0);
				
				psDet.executeUpdate();
			}
			
		} catch (KrakeDevException e){
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
	
	public void recibirPedido(Pedido pedido) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psHis = null;
		ArrayList<DetallePedido> detalles = pedido.getDetalles();
		
		Date fechaActual = new Date();
		Timestamp fecha = new Timestamp(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update cabecera_pedido set estado_cod = 'R' where codigo_cp = ?");
			ps.setInt(1, pedido.getCodigo());
			ps.executeUpdate();
			
			for(int i = 0; i < detalles.size(); i++) {
				DetallePedido det = detalles.get(i);
				psDet = con.prepareStatement("update detalle_pedido set cantidad_recibida = ?, subtotal = ? where codigo_dp = ?");
				psDet.setInt(1, det.getCantidadRecibida());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidadRecibida());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(2, subtotal);
				psDet.setInt(3, det.getCodigo());
				
				psDet.executeUpdate();
				
				psHis = con.prepareStatement("insert into historial_stock(fecha, referencia, producto_cod, cantidad)"
						+ "values (?, ?, ?, ?)");
				psHis.setTimestamp(1, fecha);
				psHis.setString(2, "Pedido " + pedido.getCodigo());
				psHis.setInt(3, det.getProducto().getCodigo());
				psHis.setInt(4, det.getCantidadRecibida());
				psHis.executeUpdate();
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
}
