package com.krakedev.evaluacion;

import java.util.ArrayList;

public class Contacto {
	private String cedula;
	private String nombre;
	private String apellido;
	private Direccion direccion;
	private ArrayList<Telefono> telefonos;
	
	public Contacto(String cedula, String nombre, String apellido) {
		telefonos = new ArrayList<Telefono>();
		this.cedula = cedula;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public ArrayList<Telefono> getTelefonos() {
		return telefonos;
	}
	public void setTelefonos(ArrayList<Telefono> telefonos) {
		this.telefonos = telefonos;
	}
	
	public void imprimir() {
		System.out.println("Información del contacto");
		System.out.println("Cédula: " + cedula);
		System.out.println("Nombre: " + nombre + " " + apellido);
		if(direccion != null) {
			System.out.println("Direccion:");
			System.out.println("  Calle Principal: " + direccion.getCallePrincipal());
			System.out.println("  Calle Secundaria: " + direccion.getCalleSecundaria());
		} else {
			System.out.println("No tiene asociada una dirección");
		}
	}
	
	public void agregarTelefono(Telefono telf) {
		telefonos.add(telf);
	}
	
	public void mostrarTelefonos() {
		Telefono elementoTelefono;
		System.out.println("Teléfonos con estado 'C':");
		for(int i=0;i<telefonos.size();i++) {
			elementoTelefono = telefonos.get(i);
			if(elementoTelefono.getEstado().equals("C")) {
				System.out.println("Número: " + elementoTelefono.getNumero() + ", Tipo: " + elementoTelefono.getTipo());
			}
		}
	}
	
	public ArrayList<Telefono> recuperarIncorrectos(){
		ArrayList<Telefono> incorrectos = new ArrayList<Telefono>();
		Telefono elementoTelefono;
		for(int i=0;i<telefonos.size();i++) {
			elementoTelefono = telefonos.get(i);
			if(elementoTelefono.getEstado().equals("E")) {
				incorrectos.add(elementoTelefono);
			}
		}
		return incorrectos;
	}
}
