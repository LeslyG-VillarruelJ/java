package com.krakedev;

public class Cuadrado {
	public double lado;
	
	public double calcularArea() {
		double area = lado * lado;
		return area;
	}
	
	public double calcularPerimetro() {
		double perimetro = 4 * lado;
		return perimetro;
	}
}