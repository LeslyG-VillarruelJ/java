package com.krakedev.conexionbdd;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {
	
	public static void main(String[] args) {
		// Date - java.util.Date
		// Date - java.sql.Date
		// Formato de fecha ver en documentacion de SimpleDateFormat
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		String fechaStr = "1970/11/04 10:05:04";
		// Convertir string en formato date
		try {
			Date fecha = sdf.parse(fechaStr);
			System.out.println(fecha);
			long fechaMillis = fecha.getTime();
			System.out.println(fechaMillis);
			// crea un java.sql.Date a partir de un java.util.Date
			java.sql.Date fechaSQL = new java.sql.Date(fechaMillis);
			System.out.println(fechaSQL);
			
			// HORA
			Time timeSQL = new Time(fechaMillis);
			System.out.println(timeSQL);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
