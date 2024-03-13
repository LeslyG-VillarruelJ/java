package com.krakedev.test;

import com.krakedev.Auto;

public class TestAuto {

	public static void main(String[] args) {
		// Instance 2 cars
		Auto auto1 = new Auto("Chevrolet", 17000.50, 2021);
		Auto auto2 = new Auto("Toyota", 21250.75, 2020);
		//Modify the attributes
		//The constructors have the attributes
		/*auto1.setMarca("Chevrolet");
		auto1.setAnio(2021);
		auto1.setPrecio(17000.50);
		auto2.setMarca("Toyota");
		auto2.setAnio(2020);
		auto2.setPrecio(21250.75);*/
		//Show the attributes
		System.out.println("Auto 1 - marca: " + auto1.getMarca());
		System.out.println("Auto1 - anio: " + auto1.getAnio());
		System.out.println("Auto 1 - precio: " + auto1.getPrecio());
		System.out.println("-----------------------------------");
		System.out.println("Auto 2 - marca: " + auto2.getMarca());
		System.out.println("Auto 2 - anio: " + auto2.getAnio());
		System.out.println("Auto 2 - precio: " + auto2.getPrecio());
	}

}