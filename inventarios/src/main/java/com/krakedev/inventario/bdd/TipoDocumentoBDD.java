package com.krakedev.inventario.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.TipoDocumento;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class TipoDocumentoBDD {
	public ArrayList<TipoDocumento> recuperar() throws KrakeDevException {
		ArrayList<TipoDocumento> tipoDocumentos = new ArrayList<TipoDocumento>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		TipoDocumento tipDoc = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from tipo_documento");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String codigo = rs.getString("codigo_tp");
				String descripcion = rs.getString("descripcion");
				tipDoc = new TipoDocumento(codigo, descripcion);
				tipoDocumentos.add(tipDoc);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return tipoDocumentos;
	}
}

