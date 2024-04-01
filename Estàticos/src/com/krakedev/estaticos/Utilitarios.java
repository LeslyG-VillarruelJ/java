package com.krakedev.estaticos;

public class Utilitarios {
	public static boolean validarRango(int valor) {
		if (valor >= 0 && valor <= 10) {
			return true;
		} else {
			return false;
		}
	}
}
