package com.clearminds.componentes;

public class Producto {
	private String codigo;
	private String nombre;
	private double precio;
	
	public Producto(String codigo, String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public void incrementarPrecio(int porcentaje) {
		double incremento = this.precio * porcentaje / 100;
		this.precio += incremento;
	}
	
	public void disminuirPrecio(double descuento) {
		this.precio = this.precio - descuento;
	}
}
