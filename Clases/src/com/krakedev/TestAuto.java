package com.krakedev;

public class TestAuto {

	public static void main(String[] args) {
		// Instance 2 cars
		Auto auto1 = new Auto();
		Auto auto2 = new Auto();
		//Modify the attributes
		auto1.marca = "Chevrolet";
		auto1.anio = 2021;
		auto1.precio = 17000.50;
		auto2.marca = "Toyota";
		auto2.anio = 2020;
		auto2.precio = 21250.75;
		//Show the attributes
		System.out.println("Auto 1 - marca: " + auto1.marca);
		System.out.println("Auto1 - anio: " + auto1.anio);
		System.out.println("Auto 1 - precio: " + auto1.precio);
		System.out.println("-----------------------------------");
		System.out.println("Auto 2 - marca: " + auto2.marca);
		System.out.println("Auto 2 - anio: " + auto2.anio);
		System.out.println("Auto 2 - precio: " + auto2.precio);
	}

}
