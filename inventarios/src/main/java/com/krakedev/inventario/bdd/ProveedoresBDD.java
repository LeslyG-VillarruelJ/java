package com.krakedev.inventario.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.Proveedor;
import com.krakedev.inventario.entidades.TipoDocumento;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class ProveedoresBDD {
	public ArrayList<Proveedor> buscar(String subcadena) throws KrakeDevException {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Proveedor prov = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"select * from proveedores prov, tipo_documento td where prov.tipo_documento_cod = td.codigo_tp and upper(prov.nombre) like ?");
			ps.setString(1, "%" + subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String identificador = rs.getString("identificador");
				String tipoDocumentoCodigo = rs.getString("codigo_tp");
				String tipoDocumentoDescripcion = rs.getString("descripcion");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				TipoDocumento tipoDocumento = new TipoDocumento(tipoDocumentoCodigo, tipoDocumentoDescripcion);
				prov = new Proveedor(identificador, tipoDocumento, nombre, telefono, correo, direccion);
				proveedores.add(prov);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}

		return proveedores;
	}

	public void insertar(Proveedor proveedor) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Proveedor prov = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into proveedores(identificador, tipo_documento_cod, nombre, telefono, correo, direccion)"
							+ "values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, proveedor.getIdentificador());
			ps.setString(2, proveedor.getTipoDocumento().getCodigo());
			ps.setString(3, proveedor.getNombre());
			ps.setString(4, proveedor.getTelefono());
			ps.setString(5, proveedor.getCorreo());
			ps.setString(6, proveedor.getDireccion());

			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}
	
	public Proveedor buscarProveedor(String codigoProveedor) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Proveedor prov = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from proveedores where identificador = ?");
			ps.setString(1, codigoProveedor);
			rs = ps.executeQuery();
			if(rs.next()) {
				String identificador = rs.getString(1);
				String documentoCod = rs.getString(2);
				TipoDocumento tipDoc = new TipoDocumento();
				tipDoc.setCodigo(documentoCod);
				String nombre = rs.getString(3);
				String telefono = rs.getString(4);
				String correo = rs.getString(5);
				String direccion = rs.getString(6);
				prov = new Proveedor(identificador, tipDoc, nombre, telefono, correo, direccion);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return prov;
	}
}
