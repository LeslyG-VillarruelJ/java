package com.clearminds.componentes;

public class Celda {
	private String codigo;
	private Producto producto;
	private int stock;
	
	public Celda(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	public void ingresarProducto(Producto producto, int stock) {
		this.producto = producto;
		this.stock = stock;
	}
}
