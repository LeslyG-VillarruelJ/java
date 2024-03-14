package com.cmc.repaso.entidades;

public class Producto {
	private String nombre;
	private double precio;
	
	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
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
		if(precio > 0) {
			this.precio = precio;
		} else {
			this.precio = precio * (-1);
		}
	}
	
	public double calcularPrecioPromo(double porcentajeDescuento) {
		double descuento = precio * (porcentajeDescuento / 100);
		double precioPromo = precio - descuento;
		return precioPromo;
	}
	
	
}
