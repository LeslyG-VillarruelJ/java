package com.krakedev.inventario.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.excepciones.KrakeDevException;
import com.krakedev.inventario.utils.ConexionBDD;

public class CategoriaBDD {
	public void insertar(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into categorias(nombre, categoria_padre)" + "values (?, ?)");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}

	public void actualizar(Categoria categoria) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update categorias set nombre = ?, categoria_padre = ? where codigo_cat = ?");
			ps.setString(1, categoria.getNombre());
			ps.setInt(2, categoria.getCategoriaPadre().getCodigo());
			ps.setInt(3, categoria.getCodigo());
			ps.executeUpdate();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
	}

	public ArrayList<Categoria> mostrar() throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Categoria> categorias = new ArrayList<Categoria>();
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from categorias");
			rs = ps.executeQuery();
			while(rs.next()) {
				int codigo = rs.getInt(1);
				String nombre = rs.getString(2);
				int categoriaPadre = rs.getInt(3);
				Categoria catPadre = new Categoria();
				catPadre.setCodigo(categoriaPadre);
				Categoria cat = new Categoria(codigo, nombre, catPadre);
				categorias.add(cat);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		return categorias;
	}
}
