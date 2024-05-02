package com.krakedev.inventario.entidades;

public class CategoriaUnidadMedida {
	private String codigoUDM;
	private String nombre;
	
	public CategoriaUnidadMedida() {};
	public CategoriaUnidadMedida(String codigoUDM, String nombre) {
		super();
		this.codigoUDM = codigoUDM;
		this.nombre = nombre;
	}
	
	public String getCodigoUDM() {
		return codigoUDM;
	}
	public void setCodigoUDM(String codigoUDM) {
		this.codigoUDM = codigoUDM;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public String toString() {
		return "CategoriaUnidadMedida [codigoUDM=" + codigoUDM + ", nombre=" + nombre + "]";
	}
}
