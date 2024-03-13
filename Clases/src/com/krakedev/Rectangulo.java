package com.krakedev;

public class Rectangulo {
	public int base;
	public int altura;
	
	public int calcularArea() {
		int area;
		area = base * altura;
		return area;
	}
	
	public double calcularPerimetro() {
		double perimetro = (2 * base) + (2 * altura);
		return perimetro;
	}
}
