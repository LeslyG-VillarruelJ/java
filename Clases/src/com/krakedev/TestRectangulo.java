package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1 = new Rectangulo();
		Rectangulo r2 = new Rectangulo();
		int areaR1;
		int areaR2;
		r1.base = 10;
		r1.altura = 5;
		r2.base = 8;
		r2.altura = 3;
		areaR1 = r1.calcularArea();
		areaR2 = r2.calcularArea();
		// Show the area
		System.out.println("Area r1: " + areaR1);
		System.out.println("Area r2: " + areaR2);
	}

}
