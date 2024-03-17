package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf1 = new Telefono("movi", "0987654321", 10);
		Telefono telf2 = new Telefono("claro", "0991234567", 20);
		Telefono telf3 = new Telefono("claro", "0986382734", 30);
		Telefono telf4 = new Telefono("claro", "0987123456", 40);
		AdminTelefono at = new AdminTelefono();
		int contClaro;
		contClaro = at.contarClaro(telf1, telf2, telf3, telf4);
		System.out.println("Teléfonos con operadora Claro: " + contClaro);
	}

}
