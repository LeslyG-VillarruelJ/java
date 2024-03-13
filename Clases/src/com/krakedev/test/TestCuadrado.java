package com.krakedev.test;

import com.krakedev.Cuadrado;

public class TestCuadrado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado c1 = new Cuadrado();
		Cuadrado c2 = new Cuadrado();
		Cuadrado c3 = new Cuadrado();
		// Modify attributes
		c1.setLado(14.5);
		c2.setLado(8.9);
		c3.setLado(18.3);
		// Get area and perimeter
		double area1 = c1.calcularArea();
		double area2 = c2.calcularArea();
		double area3 = c3.calcularArea();
		double perimetro1 = c1.calcularPerimetro();
		double perimetro2 = c2.calcularPerimetro();
		double perimetro3 = c3.calcularPerimetro();
	}

}