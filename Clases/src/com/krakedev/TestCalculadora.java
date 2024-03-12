package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calcu = new Calculadora();
		int suma;
		int resta;
		double multiplicacion;
		double division;
		double promedio;
		suma = calcu.sumar(10, 8);
		resta = calcu.restar(21, 7);
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
		// other methods
		multiplicacion = calcu.multiplicar(7, 9);
		division = calcu.dividir(18, 5);
		promedio = calcu.promediar(9, 7, 6.5);
		// Show the results
		System.out.println("Multiplicación: " + multiplicacion);
		System.out.println("Division: " + division);
		System.out.println("Promedio: " + promedio);
		calcu.mostrarResultado();
	}

}
