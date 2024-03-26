package com.cmc.evaluacion.entidades;

public class Utilitario {
	public static double redondear(double valor) {
		double redondeado;
		redondeado = Math.round(valor * 100.0) / 100.0;
		return redondeado;
	}
}
