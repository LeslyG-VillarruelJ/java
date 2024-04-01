package com.krakedev.estaticos.ejercicio.utils;

public class Util {
	public static String formatearHora(int valor) {
		String numero;
		if(valor>=0 && valor<=9) {
			numero = "0" + valor;
		}else {
			numero = valor + "";
		}
		return numero;
	}
	
	public static String formatearDia(int valor) {
		if(valor == 0) {
			return "Lunes";
		} else if(valor == 1) {
			return "Martes";
		} else if(valor == 2) {
			return "Miercoles";
		} else if(valor == 3) {
			return "Juevas";
		} else if(valor == 4) {
			return "Viernes";
		} else if(valor == 5) {
			return "Sabado";
		} else {
			return "Domingo";
		}
	}
}
