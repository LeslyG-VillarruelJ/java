package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Item;

public class TestItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item item1 = new Item();
		Item item2 = new Item();
		// setear productos Actuales
		item1.setNombre("Producto 1");
		item1.setProductosActuales(20);
		// invocar imprimir
		item1.imprimir();
		// probar los otros métodos
		item1.vender(15);
		item1.devolver(10);
		// Imprimimos luego de utilizar los metodos
		item1.imprimir();
		// realizar lo mismo con el otro item
		item2.setNombre("Producto 2");
		item2.setProductosActuales(35);
		// invocar imprimir
		item2.imprimir();
		// probar los otros métodos
		item2.vender(15);
		item2.devolver(5);
		// Imprimimos luego de utilizar los metodos
		item2.imprimir();
	}

}
