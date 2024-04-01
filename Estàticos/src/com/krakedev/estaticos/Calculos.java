package com.krakedev.estaticos;

public class Calculos {
	// el final hace que el valor no se pueda cambiar
	// el atriibuto se vuelve una constante
	// constantes van toodo en mayuscula
	private final double IVA = 12;

	public double calcularIva(double monto) {
		return monto * IVA / 100;
	}
}
