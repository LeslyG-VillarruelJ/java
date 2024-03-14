package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Producto;

public class TestProducto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Producto product = new Producto("Paracetamol", 2.5);
		product.setPrecio(-3.75);
		double precioPromo = product.calcularPrecioPromo(15);
	}

}
