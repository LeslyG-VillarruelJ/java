package com.krakedev.inventario.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.Proveedor;
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
			ps = con.prepareStatement("select * from proveedores where upper(nombre) like ?");
			ps.setString(1, "%" +subcadena.toUpperCase() + "%");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String identificador = rs.getString("identificador");
				String tipoDocumento = rs.getString("tipo_documento_cod");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
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
}
