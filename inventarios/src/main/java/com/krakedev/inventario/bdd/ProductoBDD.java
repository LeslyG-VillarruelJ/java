package com.krakedev.inventario.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.entidades.Producto;
import com.krakedev.inventario.entidades.UnidadMedida;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class ProductoBDD {
	public ArrayList<Producto> buscar(String subcadena) throws KrakeDevException {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Producto prod = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select pr.codigo_prod, pr.nombre as nombre_producto, udm.nombre as nombre_udm, udm.descripcion as descripcion_udm, cast(pr.precio_venta as decimal(5,2)), pr.tiene_iva, cast(pr.coste as decimal(6,2)), cat.codigo_cat, cat.nombre as nombre_categoria, pr.stock from productos pr, unidad_medida udm, categorias cat where pr.udm_cod = udm.nombre and pr.categoria_cod = cat.codigo_cat and upper(pr.nombre) like ?");
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codigoProducto = rs.getInt("codigo_prod");
				String nombreProducto = rs.getString("nombre_producto");
				String nombreUDM = rs.getString("nombre_udm");
				String descripcionUDM = rs.getString("descripcion_udm");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				boolean tieneIVA = rs.getBoolean("tiene_iva");
				BigDecimal coste = rs.getBigDecimal("coste");
				int codigoCategoria = rs.getInt("codigo_cat");
				String nombreCategoria = rs.getString("nombre_categoria");
				int stock = rs.getInt("stock");
				
				UnidadMedida udm = new UnidadMedida(nombreUDM, descripcionUDM, null);
				Categoria categoria = new Categoria(codigoCategoria, nombreCategoria, null);
				prod = new Producto(codigoProducto, nombreProducto, udm, precioVenta, tieneIVA, coste, categoria, stock);
				
				productos.add(prod);
			}
			
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}

		return productos;
	}
	
	public void insertar(Producto producto) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into productos(nombre, udm_cod, precio_venta, tiene_iva, coste, categoria_cod, stock)"
					+ "values (?, ?, ?, ?, ?, ?, ?)");
			
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidadMedida().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIVA());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getStock());
			
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
	
	public void actualizar(Producto producto) throws KrakeDevException{
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update productos set nombre = ?, udm_cod = ?, precio_venta = ?, tiene_iva = ?, coste = ?, categoria_cod = ? where codigo_prod = ?");
			ps.setString(1, producto.getNombre());
			ps.setString(2, producto.getUnidadMedida().getNombre());
			ps.setBigDecimal(3, producto.getPrecioVenta());
			ps.setBoolean(4, producto.isTieneIVA());
			ps.setBigDecimal(5, producto.getCoste());
			ps.setInt(6, producto.getCategoria().getCodigo());
			ps.setInt(7, producto.getCodigo());
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
	
	public Producto buscarProducto(int codigoProducto) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Producto prod = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select pr.codigo_prod, pr.nombre, pr.udm_cod, cast(pr.precio_venta as decimal(5,2)), pr.tiene_iva, cast(pr.coste as decimal(6,2)), pr.categoria_cod, pr.stock from productos pr where codigo_prod = ?");
			ps.setInt(1, codigoProducto);
			rs = ps.executeQuery();
			if(rs.next()) {
				int productoCodigo = rs.getInt(1);
				String nombreProducto = rs.getString(2);
				String nombreUDM = rs.getString(3);
				BigDecimal precioVenta = rs.getBigDecimal(4);
				boolean tieneIVA = rs.getBoolean(5);
				BigDecimal coste = rs.getBigDecimal(6);
				int codigoCategoria = rs.getInt(7);
				int stock = rs.getInt(8);
				
				UnidadMedida udm = new UnidadMedida(nombreUDM, null, null);
				Categoria categoria = new Categoria(codigoCategoria, null, null);
				prod = new Producto(productoCodigo, nombreProducto, udm, precioVenta, tieneIVA, coste, categoria, stock);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return prod;
	}
}
