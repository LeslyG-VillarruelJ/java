package com.krakedev.test;

import com.krakedev.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto productoA;
		Producto productoB;
		Producto productoC;
		// Instance the products
		productoA = new Producto("Paracetamol", "Analgésico y Antipirético", 3.50, 5);
		productoB = new Producto("Ibuprofeno", "Ibuprofeno", 4.80, 10);
		productoC = new Producto("Omeprazol", "medicamento utilizado para tratar úlceras gástricas", 8.10, 4);
		// Modify the attributes
		// productoA
		/*productoA.setNombre("Paracetamol");
		productoA.setDescripcion("Analgésico y Antipirético");
		productoA.setPrecio(3.50);;
		productoA.setStockActual(5);;
		// productoB
		productoB.setNombre("Ibuprofeno");;
		productoB.setDescripcion("medicamento antiinflamatorio");;
		productoB.setPrecio(4.80);;
		productoB.setStockActual(10);;
		// productoC
		productoC.setNombre("Omeprazol");;
		productoC.setDescripcion("medicamento utilizado para tratar úlceras gástricas");;
		productoC.setPrecio(8.10);
		productoC.setStockActual(4);;*/
		// Show the products
		System.out.println("ProductoA - nombre: " + productoA.getNombre());
		System.out.println("ProductoA - descripción: " + productoA.getDescripcion());
		System.out.println("ProductoA - stock: " + productoA.getStockActual());
		System.out.println("-----------------------------------");
		System.out.println("ProductoB - nombre: " + productoB.getNombre());
		System.out.println("ProductoB - descripción: " + productoB.getDescripcion());
		System.out.println("ProductoB - precio: " + productoB.getPrecio());
		System.out.println("ProductoB - stock: " + productoB.getStockActual());
		System.out.println("-----------------------------------");
		System.out.println("ProductoC - nombre: " + productoC.getNombre());
		System.out.println("ProductoC - descripción: " + productoC.getDescripcion());
		System.out.println("ProductoC - precio: " + productoC.getPrecio());
		System.out.println("ProductoC - stock: " + productoC.getStockActual());
		System.out.println("-----------------------------------");
	}

}
