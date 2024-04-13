package com.krakedev.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.entidades.Cliente;
import com.krakedev.exceptiones.KrakeDevException;
import com.krakedev.utils.ConexionBDD;

public class ClientesBDD {
	public void insertar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into clientes (cedula, nombre, numerohijos) values(?,?,?)");
			ps.setString(1, cliente.getCedula());
			ps.setString(2, cliente.getNombre());
			ps.setInt(3, cliente.getNumeroHijos());

			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al insertar el cliente. Detalle: " + e.getMessage());
		} catch (KrakeDevException e) {
			throw e;
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void actualizar(Cliente cliente) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("update clientes set nombre = ?, numerohijos = ? where cedula = ?");
			ps.setString(1, cliente.getNombre());
			ps.setInt(2, cliente.getNumeroHijos());
			ps.setString(3, cliente.getCedula());

			ps.executeUpdate();

		} catch (KrakeDevException e) {
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al actualizar el cliente. Detalle: " + e.getMessage());
		} finally {
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
	

	public ArrayList<Cliente> recuperarTodos() throws KrakeDevException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Cliente cli = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from clientes");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numerohijos");
				cli = new Cliente(cedula, nombre, numeroHijos);
				clientes.add(cli);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return clientes;
	}
	
	public Cliente recuperarPorPK(String cedulaBusqueda) throws KrakeDevException {
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Cliente cli = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from clientes where cedula = ?");
			ps.setString(1, cedulaBusqueda);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numerohijos");
				cli = new Cliente(cedula, nombre, numeroHijos);
			} else {
				System.out.println("No existe el cliente");
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return cli;
	}
	
	public ArrayList<Cliente> recuperarPorNumeroHijos(int numeroHij) throws KrakeDevException {
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rs;
		Cliente cli = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select * from clientes where numerohijos >= ?");
			ps.setInt(1, numeroHij);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String cedula = rs.getString("cedula");
				String nombre = rs.getString("nombre");
				int numeroHijos = rs.getInt("numerohijos");
				cli = new Cliente(cedula, nombre, numeroHijos);
				clientes.add(cli);
			}
		} catch (KrakeDevException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakeDevException("Error al consultar. Detalle: " + e.getMessage());
		}
		
		return clientes;
	}
}
