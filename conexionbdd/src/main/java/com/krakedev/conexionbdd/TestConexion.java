package com.krakedev.conexionbdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection = null;
		PreparedStatement ps;
		try {
			Class.forName("org.postgresql.Driver");
			// recibe tres parametros (string de conexion, usuario, constraseña)
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres", "Les012105Vill@");
			System.out.println("Conexion exitosa");
			// ARMO LA SENTENCIA
			ps = connection.prepareStatement("insert into personas(cedula, nombre, apellido, estado_civil_codigo, numero_hijos, estatura, cantidad_ahorrada, fecha_nacimiento, hora_nacimiento)"
					+ "values(?,?,?,?,?,?,?,?,?)"); // valores no se conecen se los asigna
			ps.setString(1, "1900208644");
			ps.setString(2, "Maria");
			ps.setString(3, "Jumbo");
			ps.setString(4, "C");
			ps.setInt(5, 3);
			ps.setDouble(6, 1.50);
			ps.setBigDecimal(7, new BigDecimal(1200.34));
			// fecha
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
			String fechaStr;
			Date fecha;
			long fechaMillis;
			java.sql.Date fechaSQL;
			Time timeSQL;
			try {
				fechaStr = "1970/11/04 10:05:04";
				fecha = sdf.parse(fechaStr);
				System.out.println(fecha);
				fechaMillis = fecha.getTime();
				System.out.println(fechaMillis);
				// crea un java.sql.Date a partir de un java.util.Date
				fechaSQL = new java.sql.Date(fechaMillis);
				System.out.println(fechaSQL);
				
				timeSQL = new Time(fechaMillis);
				System.out.println(timeSQL);
				
				// insertar fecha y hora
				ps.setDate(8, fechaSQL);
				ps.setTime(9, timeSQL);
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			// TABLA CLIENTES - COMPRAS
			ps = connection.prepareStatement("insert into clientes(cedula, nombre, apellido, edad)"
					+ "values(?,?,?,?)");
			ps.setString(1, "1900208644");
			ps.setString(2, "Maria");
			ps.setString(3, "Jumbo");
			ps.setInt(4, 53);
			ps.executeUpdate();
			// TABLA COMPRAS
			ps = connection.prepareStatement("insert into compras(id_compra, cedula, fecha_compra, monto)"
					+ "values (?,?,?,?)");
			ps.setInt(1, 4);
			ps.setString(2, "1900208644");
			
			try {
				fechaStr = "2024/04/02 00:00:00";
				fecha = sdf.parse(fechaStr);
				System.out.println(fecha);
				fechaMillis = fecha.getTime();
				System.out.println(fechaMillis);
				// crea un java.sql.Date a partir de un java.util.Date
				fechaSQL = new java.sql.Date(fechaMillis);
				System.out.println(fechaSQL);
				ps.setDate(3, fechaSQL);
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			ps.setBigDecimal(4, new BigDecimal(15.30));

			// EJECUTO LA SENTENCIA
			ps.executeUpdate();
			System.out.println("Ejecucion exitosa");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

}
