package com.krakedev.persistencia.servicios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.utils.ConexionBDD;

// System.out.println("Solo en los tests");
public class AdminPersonas {
	private static final Logger LOGGER = LogManager.getLogger(AdminPersonas.class);

	public static void insertar(Persona persona) throws Exception {
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona a insertar >>> " + persona);
		try {
			// Abrir conexion
			con = ConexionBDD.conectar();
			// ARMO LA SENTENCIA
			ps = con.prepareStatement(
					"insert into personas(cedula, nombre, apellido, estado_civil_codigo, numero_hijos, estatura, cantidad_ahorrada, fecha_nacimiento, hora_nacimiento)"
							+ "values(?,?,?,?,?,?,?,?,?)"); // valores no se conecen se los asigna
			ps.setString(1, persona.getCedula());
			ps.setString(2, persona.getNombre());
			ps.setString(3, persona.getApellido());
			ps.setString(4, persona.getEstadoCivil().getCodigo());
			ps.setInt(5, persona.getNumeroHijos());
			ps.setDouble(6, persona.getEstatura());
			ps.setBigDecimal(7, persona.getCantidadAhorrada());
			ps.setDate(8, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(9, new java.sql.Time(persona.getHoraNacimiento().getTime()));
			ps.executeUpdate();
		} catch (Exception e) {
			// mostrar el error al usuario de la excepción que se lanzó
			// System.out.println(e.getMessage());
			// logger el error
			LOGGER.error("Error al insertar", e);

			throw new Exception("Error al insertar");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha actualizado de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
	}

	public static void actualizar(Persona persona) throws Exception{
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona a actualizar >>> " + persona);
		try {
			con = ConexionBDD.conectar();
			// ARMAR SENTENCIA
			ps = con.prepareStatement(
					"update personas set nombre=?, apellido=?, estado_civil_codigo=?, numero_hijos=?, estatura=?, cantidad_ahorrada=?, fecha_nacimiento=?, hora_nacimiento=? where cedula = ?");
			ps.setString(1, persona.getNombre());
			ps.setString(2, persona.getApellido());
			ps.setDouble(5, persona.getEstatura());
			ps.setDate(7, new java.sql.Date(persona.getFechaNacimiento().getTime()));
			ps.setTime(8, new java.sql.Time(persona.getHoraNacimiento().getTime()));
			ps.setBigDecimal(6, persona.getCantidadAhorrada());
			ps.setInt(4, persona.getNumeroHijos());
			ps.setString(3, persona.getEstadoCivil().getCodigo());
			ps.setString(9, persona.getCedula());
			ps.executeUpdate();
			LOGGER.debug("Se ha actualizado de manera correcta");
		} catch (Exception e) {
			LOGGER.error("Error al actualizar", e);
			throw new Exception("Error al actualizar");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha cerrado la conexión de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
	}

	public static void eliminar(String cedula) throws Exception{
		Connection con = null;
		PreparedStatement ps;
		LOGGER.trace("Persona con número de cédula = " + cedula + " será eliminada");
		try {
			con = ConexionBDD.conectar();
			// ARMAR LA SENTENCIA
			ps = con.prepareStatement("delete from personas where cedula = ?");
			ps.setString(1, cedula);
			ps.executeUpdate();
			LOGGER.debug("Se ha eliminado correctamente");
		} catch (Exception e) {
			LOGGER.error("Error al eliminar", e);
			throw new Exception("Error al eliminar");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha actualizado de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
	}

	public static ArrayList<Persona> buscarPorNombre(String nombreBusqueda) throws Exception{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement ps;
		// una consulta de select se devuelve con
		ResultSet rx = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from personas where nombre like ?");
			ps.setString(1, "%" + nombreBusqueda + "%");
			
			rx = ps.executeQuery();
			
			// barrer los elementos
			while(rx.next()) {
				String cedula = rx.getString("cedula");
				String nombre = rx.getString("nombre");
				String apellido = rx.getString("apellido");
				double estatura = rx.getDouble("estatura");
				java.sql.Date fechaNacimiento = rx.getDate("fecha_nacimiento");
				java.sql.Time horaNacimiento = rx.getTime("hora_nacimiento");
				int numeroHijos = rx.getInt("numero_hijos");
				String estadoCivilCodigo = rx.getString("estado_civil_codigo");
				Persona p = new Persona();
				p.setCedula(cedula);
				p.setNombre(nombre);
				p.setApellido(apellido);
				p.setEstatura(estatura);
				p.setFechaNacimiento(fechaNacimiento);
				p.setHoraNacimiento(horaNacimiento);
				p.setNumeroHijos(numeroHijos);
				EstadoCivil ec = new EstadoCivil();
				ec.setCodigo(estadoCivilCodigo);
				p.setEstadoCivil(ec);
				personas.add(p);
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha actualizado de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
		return personas;
	}
	
	public static Persona busquedaPorCedula(String cedula) throws Exception{
		Persona p = new Persona();
		Connection con = null;
		PreparedStatement ps;
		ResultSet rx = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from personas where cedula = ?");
			ps.setString(1, cedula);
			rx = ps.executeQuery();
			if(rx.next()) {
				String cedulaN = rx.getString("cedula");
				String nombre = rx.getString("nombre");
				String apellido = rx.getString("apellido");
				double estatura = rx.getDouble("estatura");
				java.sql.Date fechaNacimiento = rx.getDate("fecha_nacimiento");
				java.sql.Time horaNacimiento = rx.getTime("hora_nacimiento");
				int numeroHijos = rx.getInt("numero_hijos");
				String estadoCivilCodigo = rx.getString("estado_civil_codigo");
				p.setCedula(cedulaN);
				p.setNombre(nombre);
				p.setApellido(apellido);
				p.setEstatura(estatura);
				p.setFechaNacimiento(fechaNacimiento);
				p.setHoraNacimiento(horaNacimiento);
				p.setNumeroHijos(numeroHijos);
				EstadoCivil ec = new EstadoCivil();
				ec.setCodigo(estadoCivilCodigo);
				p.setEstadoCivil(ec);
			} else {
				p = null;
			}
		} catch (Exception e) {
			LOGGER.error("Error al consultar por cedula", e);
			throw new Exception("Error al consultar por cedula");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha encontrado registro de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
		
		return p;
	}
	
	public static ArrayList<Persona> buscarPorNumeroHijos(int hijos) throws Exception{
		ArrayList<Persona> personas = new ArrayList<Persona>();
		Connection con = null;
		PreparedStatement ps;
		// una consulta de select se devuelve con
		ResultSet rx = null;
		try {
			con = ConexionBDD.conectar();
			ps = con.prepareStatement("select * from personas where numero_hijos = ?");
			ps.setInt(1, hijos);
			rx = ps.executeQuery();
			
			while(rx.next()) {
				String cedula = rx.getString("cedula");
				String nombre = rx.getString("nombre");
				String apellido = rx.getString("apellido");
				double estatura = rx.getDouble("estatura");
				java.sql.Date fechaNacimiento = rx.getDate("fecha_nacimiento");
				java.sql.Time horaNacimiento = rx.getTime("hora_nacimiento");
				int numeroHijos = rx.getInt("numero_hijos");
				String estadoCivilCodigo = rx.getString("estado_civil_codigo");
				Persona p = new Persona();
				p.setCedula(cedula);
				p.setNombre(nombre);
				p.setApellido(apellido);
				p.setEstatura(estatura);
				p.setFechaNacimiento(fechaNacimiento);
				p.setHoraNacimiento(horaNacimiento);
				p.setNumeroHijos(numeroHijos);
				EstadoCivil ec = new EstadoCivil();
				ec.setCodigo(estadoCivilCodigo);
				p.setEstadoCivil(ec);
				personas.add(p);
			}
			
		} catch (Exception e) {
			LOGGER.error("Error al consultar por nombre", e);
			throw new Exception("Error al consultar por nombre");
		} finally {
			try {
				// cerrar la conexion
				con.close();
				LOGGER.debug("Se ha actualizado de manera correcta");
			} catch (SQLException e) {
				LOGGER.error("Error con la base de datos", e);
				throw new Exception("Error con la base de datos");
			}
		}
		return personas;
	}
}
