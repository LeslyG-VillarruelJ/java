package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminContactos;
import com.cmc.directorio.entidades.Contacto;
import com.cmc.directorio.entidades.Telefono;

public class TestActivos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Contacto cont = new Contacto("Adrian", "Pérez", new Telefono("movi", "0987654321", 10), 9.50);
		AdminContactos ac = new AdminContactos();
		System.out.println("CONTACTO");
		System.out.println("Nombre: " + cont.getNombre());
		System.out.println("Apellido: " + cont.getApellido());
		System.out.println("Operadora: " + cont.getTelefono().getOperadora());
		System.out.println("Número de teléfono: " + cont.getTelefono().getNumero());
		System.out.println("Tiene WhatsApp: " + cont.getTelefono().isTieneWhatsapp());
		System.out.println("Peso: " + cont.getPeso());
		// es activo
		ac.activarUsuario(cont);
		System.out.println("------------------------------------");
		System.out.println("Nombre: " + cont.getNombre());
		System.out.println("Apellido: " + cont.getApellido());
		System.out.println("Operadora: " + cont.getTelefono().getOperadora());
		System.out.println("Número de teléfono: " + cont.getTelefono().getNumero());
		System.out.println("Tiene WhatsApp: " + cont.getTelefono().isTieneWhatsapp());
		System.out.println("Esta activado: " + cont.isActivo());
		System.out.println("Peso: " + cont.getPeso());
	}

}
