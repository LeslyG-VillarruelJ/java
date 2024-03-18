package com.clearminds.test;

import com.clearminds.componentes.Producto;
import com.clearminds.maquina.MaquinaDulces;

public class TestBuscarProductoNull {
	public static void main(String[] args) {
		MaquinaDulces maquina=new MaquinaDulces();
		maquina.configurarMaquina("A1", "A2", "B1", "B2");
		
		Producto producto=new Producto("KE34","Papitas",0.85);
		maquina.cargarProducto(producto, "B1", 4);
		
		Producto prod=maquina.buscarProductoEnCelda("A1");
		System.out.println("Producto encontrado:"+prod.getNombre());
		// El error de ejecucuion se dio en la linea 15 debido que al
		// momento de obtener el nombre del producto no es posible debido
		// a que el producto en la celda correspondiente no existe por lo 
		// que es un valor null y lo que esta realizando en código es:
		// null.getNombre() y eso no es posible arroja la excepcion
		
		
		
	}
}
