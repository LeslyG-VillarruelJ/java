package com.cmc.evaluacion.test;

import com.cmc.evaluacion.entidades.CalculadoraAmortizacion;
import com.cmc.evaluacion.entidades.Prestamo;

public class TestCalculadora2 {

	public static void main(String[] args) {
		Prestamo prestamo = new Prestamo(5000, 12, 15);

		CalculadoraAmortizacion.generarTabla(prestamo);
		CalculadoraAmortizacion.mostrarTabla(prestamo);
	}
}