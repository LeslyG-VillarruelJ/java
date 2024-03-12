package com.krakedev;

public class Calculadora {
	public int sumar(int valor1, int valor2) {
		int resultado = valor1 + valor2;
		return resultado;
	}
	
	public int restar(int valor1, int valor2) {
		int resultado = valor1 - valor2;
		return resultado;
	}
	
	public double multiplicar(double valor1, double valor2) {
		double resultado = valor1 * valor2;
		return resultado;
	}

	public double dividir(double dividendo, double divisor) {
		double cociente = dividendo / divisor;
		return cociente;
	}
	
	public double promediar(double valor1, double valor2, double valor3) {
		double suma = valor1 + valor2 + valor3;
		double promedio = suma / 3;
		return promedio;
	}
	
	public void mostrarResultado() {
		System.out.println("Ahrita no joven. Salí al almuerzo. Regreso en 15 minutos");
	}
}
