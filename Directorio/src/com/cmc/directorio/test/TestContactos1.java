package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestContactos1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Crear 2 contactos
		Contacto cont1 = new Contacto("Adrian", "Pérez", new Telefono("movi", "0987654321", 10), 9.50);
		Contacto cont2 = new Contacto("Jennifer", "Brown", new Telefono("claro", "0991234567", 20), 10.25);
		AdminContactos ac = new AdminContactos();
		Contacto c = ac.buscarMasPesado(cont1, cont2);
		// imprimir contacto
		if(c != null) {
			System.out.println("CONTACTO MÁS PESADO");
			System.out.println("Nombre: " + c.getNombre());
			System.out.println("Apellido: " + c.getApellido());
			System.out.println("Operadora: " + c.getTelefono().getOperadora());
			System.out.println("Número de teléfono: " + c.getTelefono().getNumero());
			System.out.println("Peso: " + c.getPeso());
		} else {
			System.out.println("Tienen el mismo peso");
		}
		// comparar operadoras
		boolean comparacion = ac.compararOperadoras(cont1, cont2);
		System.out.println("Las operadoras de los contactos son iguales: " + comparacion);
	}

}
