package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContacto1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi", "0987654321", 10);
		Contacto c = new Contacto("Lesly", "Villarruel", telf, 9.50);
		// Imprimir los valores del contacto
		System.out.println("CONTACTO");
		System.out.println("Nombre: " + c.getNombre());
		System.out.println("Apellido: " + c.getApellido());
		System.out.println("Operadora: " + c.getTelefono().getOperadora());
		System.out.println("Número de teléfono: " + c.getTelefono().getNumero());
		System.out.println("Peso: " + c.getPeso());
	}

}
