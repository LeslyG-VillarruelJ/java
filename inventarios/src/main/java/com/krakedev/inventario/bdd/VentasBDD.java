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

import com.krakedev.inventario.entidades.DetalleVenta;
import com.krakedev.inventario.entidades.Venta;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class VentasBDD {
	public void venta(Venta venta) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		PreparedStatement psHis = null;
		ResultSet rsClave = null;

		ArrayList<DetalleVenta> detalles = venta.getDetalles();
		Date fechaActual = new Date();
		Timestamp fecha = new Timestamp(fechaActual.getTime());
		int codigoCabecera = 0;

		try {
			con = ConexionBDD.obtenerConexion();
			// insertar cabecera de venta
			ps = con.prepareStatement(
					"insert into cabecera_venta(fecha, total_sin_iva, iva, total)" + "values (?, ?, ?, ?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setTimestamp(1, fecha);
			ps.setBigDecimal(2, BigDecimal.ZERO);
			ps.setBigDecimal(3, BigDecimal.ZERO);
			ps.setBigDecimal(4, BigDecimal.ZERO);
			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();
			
			if(rsClave.next()) {
				codigoCabecera =rsClave.getInt(1);
			}

			// Datos para actualizar cabecera
			BigDecimal totalSinIva = BigDecimal.ZERO;
			BigDecimal ivaTotal = BigDecimal.ZERO;
			BigDecimal total = BigDecimal.ZERO;
			// insertar detalles de venta
			for (int i = 0; i < detalles.size(); i++) {
				DetalleVenta det = detalles.get(i);
				psDet = con.prepareStatement("insert into detalle_venta(cabecera_venta_cod, producto_cod, cantidad, precio_venta, subtotal, subtotal_iva)"
						+ "values (?, ?, ?, ?, ?, ?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getProducto().getCodigo());
				psDet.setInt(3, det.getCantidad());
				psDet.setBigDecimal(4, det.getProducto().getPrecioVenta());
				BigDecimal pv = det.getProducto().getPrecioVenta();
				BigDecimal cantidad = new BigDecimal(det.getCantidad());
				BigDecimal subtotal = pv.multiply(cantidad);
				psDet.setBigDecimal(5, subtotal);
				totalSinIva = totalSinIva.add(subtotal);
				if(det.getProducto().isTieneIVA()) {
					BigDecimal iva = new BigDecimal(1.12);
					BigDecimal subtotalConIva = subtotal.multiply(iva);
					psDet.setBigDecimal(6, subtotalConIva);
					// sumar subtotal
					ivaTotal = ivaTotal.add(subtotal.multiply(new BigDecimal(0.12)));
				} else {
					psDet.setBigDecimal(6, subtotal);
				}
				psDet.executeUpdate();
		
				// registrar el movimiento de historial de stock
				psHis = con.prepareStatement("insert into historial_stock(fecha, referencia, producto_cod, cantidad)"
						+ "values (?, ?, ?, ?)");
				psHis.setTimestamp(1, fecha);
				psHis.setString(2, "VENTA " + codigoCabecera);
				psHis.setInt(3, det.getProducto().getCodigo());
				psHis.setInt(4, det.getCantidad());
				psHis.executeUpdate();
			}
			
			// actualizar cabecera
			total = totalSinIva.add(ivaTotal);
			ps = con.prepareStatement("update cabecera_venta set total_sin_iva = ?, iva = ?, total = ? where codigo_cv = ?");
			ps.setBigDecimal(1, totalSinIva);
			ps.setBigDecimal(2, ivaTotal);
			ps.setBigDecimal(3, total);
			ps.setInt(4, codigoCabecera);
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
}
