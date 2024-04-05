package com.krakedev.persistencia.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Convertidor {
	private static final String FORMATO_FECHA = "yyyy/MM/dd";
	private static final String FORMATO_HORA = "hh:mm";
	private static final Logger LOGGER = LogManager.getLogger(Convertidor.class);;
	
	public static Date convertirADate(String fechaStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_FECHA);
		Date fechaDate = null;
		try {
			fechaDate = sdf.parse(fechaStr);
		} catch (ParseException e) {
			LOGGER.error("La fecha no tiene el formato correcto", e);
			throw new Exception("La fecha no tiene el formato correcto");
		}
		return fechaDate;
	}
	
	public static Date convertirAHora(String horaStr) throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat(FORMATO_HORA);
		Date horaDate = null;
		try {
			horaDate = sdf.parse(horaStr);
		} catch (ParseException e) {
			LOGGER.error("La hora no tiene el formato correcto", e);
			throw new Exception("La hora no tiene el formato correcto");
		}
		return horaDate;
	}
}
