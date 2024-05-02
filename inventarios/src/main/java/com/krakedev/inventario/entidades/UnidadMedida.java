package com.krakedev.inventario.entidades;

public class UnidadMedida {
	private String nombre;
	private String descripcion;
	private CategoriaUnidadMedida categoriaUDM;
	
	public UnidadMedida() {};
	public UnidadMedida(String nombre, String descripcion, CategoriaUnidadMedida categoriaUDM) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.categoriaUDM = categoriaUDM;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public CategoriaUnidadMedida getCategoriaUDM() {
		return categoriaUDM;
	}
	public void setCategoriaUDM(CategoriaUnidadMedida categoriaUDM) {
		this.categoriaUDM = categoriaUDM;
	}
	
	@Override
	public String toString() {
		return "UnidadMedida [nombre=" + nombre + ", descripcion=" + descripcion + ", categoriaUDM=" + categoriaUDM
				+ "]";
	}
}
