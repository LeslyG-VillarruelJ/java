package com.entidades;

public class Random {
	public static int obtenerPosicion() {
		int aleatorio;
		aleatorio = (int) (Math.random() * 52); // debemos convertir en entero
		return aleatorio;
	}
}
