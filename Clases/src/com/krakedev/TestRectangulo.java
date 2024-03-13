package com.krakedev;

public class TestRectangulo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangulo r1 = new Rectangulo(10, 5);
		Rectangulo r2 = new Rectangulo(8, 3);
		int areaR1;
		int areaR2;
		double perimetroR1;
		double perimetroR2;
		/*r1.setBase(10);
		r1.setAltura(5);
		r2.setBase(8);
		r2.setAltura(3);*/
		areaR1 = r1.calcularArea();
		areaR2 = r2.calcularArea();
		// Calculate perimeter
		perimetroR1 = r1.calcularPerimetro();
		perimetroR2 = r2.calcularPerimetro();
		// Show the area
		System.out.println("Area r1: " + areaR1);
		System.out.println("Area r2: " + areaR2);
		// Show the perimeter
		System.out.println("Perimetro r1: " + perimetroR1);
		System.out.println("Perimetro r2: " + perimetroR2);
	}

}