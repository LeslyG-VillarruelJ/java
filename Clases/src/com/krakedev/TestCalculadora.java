package com.krakedev;

public class TestCalculadora {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculadora calcu = new Calculadora();
		int suma;
		int resta;
		suma = calcu.sumar(10, 8);
		resta = calcu.restar(21, 7);
		System.out.println("Suma: " + suma);
		System.out.println("Resta: " + resta);
	}

}
