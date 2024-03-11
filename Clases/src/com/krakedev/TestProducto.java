package com.krakedev;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto productoA;
		Producto productoB;
		Producto productoC;
		// Instance the products
		productoA = new Producto();
		productoB = new Producto();
		productoC = new Producto();
		// Modify the attributes
		// productoA
		productoA.nombre = "Paracetamol";
		productoA.descripcion = "Analgésico y Antipirético";
		productoA.precio = 3.50;
		productoA.stockActual = 5;
		// productoB
		productoB.nombre = "Ibuprofeno";
		productoB.descripcion = "medicamento antiinflamatorio";
		productoB.precio = 4.80;
		productoB.stockActual = 10;
		// productoC
		productoC.nombre = "Omeprazol";
		productoC.descripcion = "medicamento utilizado para tratar úlceras gástricas";
		productoC.precio = 8.10;
		productoC.stockActual = 4;
		// Show the products
		System.out.println("ProductoA - nombre: " + productoA.nombre);
		System.out.println("ProductoA - descripción: " + productoA.descripcion);
		System.out.println("ProductoA - precio: " + productoA.precio);
		System.out.println("ProductoA - stock: " + productoA.stockActual);
		System.out.println("-----------------------------------");
		System.out.println("ProductoB - nombre: " + productoB.nombre);
		System.out.println("ProductoB - descripción: " + productoB.descripcion);
		System.out.println("ProductoB - precio: " + productoB.precio);
		System.out.println("ProductoB - stock: " + productoB.stockActual);
		System.out.println("-----------------------------------");
		System.out.println("ProductoC - nombre: " + productoC.nombre);
		System.out.println("ProductoC - descripción: " + productoC.descripcion);
		System.out.println("ProductoC - precio: " + productoC.precio);
		System.out.println("ProductoC - stock: " + productoC.stockActual);
		System.out.println("-----------------------------------");
	}

}
