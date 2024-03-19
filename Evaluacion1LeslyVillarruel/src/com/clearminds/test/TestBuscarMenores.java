package com.clearminds.test;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarMenores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MaquinaDulces maquina = new MaquinaDulces();
		maquina.agregarCelda(new Celda("A1"));
		maquina.agregarCelda(new Celda("A2"));
		maquina.agregarCelda(new Celda("B1"));
		maquina.agregarCelda(new Celda("B2"));
		maquina.agregarCelda(new Celda("C1"));
		maquina.agregarCelda(new Celda("C2"));
		// cargar productos
		maquina.cargarProducto(new Producto("KE34","Papitas",0.85), "A1", 4);
		maquina.cargarProducto(new Producto("C123","Coca-Cola",1.25), "A2", 7);
		maquina.cargarProducto(new Producto("D456","Doritos",0.50), "B1", 6);
		maquina.cargarProducto(new Producto("LV98","Pop-Corn",1.75), "A2", 10);
		maquina.cargarProducto(new Producto("P465","Jet",0.25), "C1", 15);
		maquina.cargarProducto(new Producto("N943","DeTodito",0.60), "C2", 3);
		// Imprimir
		ArrayList<Producto> productosMenores = maquina.buscarMenores(0.9);
		Producto producto;
		System.out.println("Productos Menores: " + productosMenores.size());
		for(int i=0;i<productosMenores.size();i++) {
			producto = productosMenores.get(i);
			System.out.println("Nombre:" + producto.getNombre() + " Precio:" + producto.getPrecio());;
		}
	}

}
