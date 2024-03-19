package com.clearminds.maquina;

import java.util.ArrayList;

import com.clearminds.componentes.Celda;
import com.clearminds.componentes.Producto;

public class MaquinaDulces {
	private ArrayList<Celda> celdas;
	private double saldo;
	
	public MaquinaDulces() {
		celdas = new ArrayList<Celda>();
	}

	public ArrayList<Celda> getCeldas() {
		return celdas;
	}

	public void setCeldas(ArrayList<Celda> celdas) {
		this.celdas = celdas;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public void agregarCelda(Celda celda) {
		celdas.add(celda);
	}
	
	public void mostrarConfiguracion() {
		Celda celda;
		for(int i=0;i<celdas.size();i++) {
			celda = celdas.get(i);
			System.out.println("Celda" + i + ":" + celda.getCodigo());
		}
	}
	
	public Celda buscarCelda(String codCelda) {
		Celda celdaEncontrada = null;
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda = celdas.get(i);
			if(codCelda.equals(elementoCelda.getCodigo())) {
				celdaEncontrada = elementoCelda;
			}
		}
		return celdaEncontrada;
	}
	
	public void cargarProducto(Producto producto, String codCelda, int stock) {
		Celda celdaEncontrada = buscarCelda(codCelda);
		if(celdaEncontrada != null) {
			celdaEncontrada.ingresarProducto(producto, stock);
			
		}
	}
	
	public void mostrarProductos() {
		Celda elementoCelda;
		for(int i=0;i<celdas.size();i++) {
			elementoCelda = celdas.get(i);
			if(elementoCelda.getProducto() != null) {
				System.out.println("Celda:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock() + " Producto:" + elementoCelda.getProducto().getNombre() + " Precio:" + elementoCelda.getProducto().getPrecio());
			} else {
				System.out.println("Celda:" + elementoCelda.getCodigo() + " Stock:" + elementoCelda.getStock() + " Sin Producto asignado");
			}
		}
		System.out.println("Saldo: " + saldo);
	}
	
	public Producto buscarProductoEnCelda(String codCelda) {
		Celda celdaEncontrada;
		Producto productoEnCelda = null;
		Producto elementoProducto;
		for(int i=0;i<celdas.size();i++) {
			celdaEncontrada = celdas.get(i);
			if(codCelda.equals(celdaEncontrada.getCodigo())){
				elementoProducto = celdaEncontrada.getProducto();
				if(elementoProducto != null) {
					productoEnCelda = elementoProducto;
				}
			}
		}
		return productoEnCelda;
	}
	
	public double consultarPrecio(String codCelda) {
		Celda celda;
		double precioProducto = 0.0;
		for(int i=0;i<celdas.size();i++) {
			celda = celdas.get(i);
			if(codCelda.equals(celda.getCodigo())) {
				precioProducto = celda.getProducto().getPrecio();
			}
		}
		return precioProducto;
	}
	
	public Celda buscarCeldaProducto(String codProducto) {
		Celda celdaProducto = null;
		Producto producto;
		for(int i=0;i<celdas.size();i++) {
			producto = celdas.get(i).getProducto();
			if(producto != null) {
				if(codProducto.equals(producto.getCodigo())) {
					celdaProducto = celdas.get(i);
				}
			}
		}
		return celdaProducto;
	}
	
	public void incrementarProductos(String codProducto, int stock) {
		Celda celdaEncontrada = buscarCeldaProducto(codProducto);
		int stockCelda;
		if(celdaEncontrada != null) {
			stockCelda = celdaEncontrada.getStock() + stock;
			celdaEncontrada.setStock(stockCelda);
		}
	}
	
	public void vender(String codCelda) {
		Celda celda = buscarCelda(codCelda);
		Producto producto;
		double precio;
		if(celda != null) {
			producto = celda.getProducto();
			if(producto != null) {
				precio = producto.getPrecio();
				saldo = saldo + precio;
				celda.setStock(celda.getStock() - 1);
			}
		}
	}
	
	public double venderConCambio(String codCelda, double valorIngresado) {
		Celda celda = buscarCelda(codCelda);
		Producto producto;
		double precio;
		double vuelto = 0.0;
		if(celda != null) {
			producto = celda.getProducto();
			if(producto != null) {
				precio = producto.getPrecio();
				saldo = saldo + precio;
				celda.setStock(celda.getStock() - 1);
				vuelto = valorIngresado - precio;
			}
		}
		return vuelto;
	}
	
	public ArrayList<Producto> buscarMenores(double limite){
		ArrayList<Producto> productosMenores = new ArrayList<Producto>();
		Producto producto;
		for(int i=0;i<celdas.size();i++) {
			producto = celdas.get(i).getProducto();
			if(producto != null) {
				if(producto.getPrecio() <= limite) {
					productosMenores.add(producto);
				}
			}
		}
		return productosMenores;
	}
}
