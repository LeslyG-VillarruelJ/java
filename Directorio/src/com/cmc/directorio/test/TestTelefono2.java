package com.cmc.directorio.test;

import com.cmc.directorio.entidades.AdminTelefono;
import com.cmc.directorio.entidades.Telefono;

public class TestTelefono2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi", "098234234", 20);
		AdminTelefono at = new AdminTelefono();
		// Invocar el metodo activarMensajeria
		at.activarMensajeria(telf);
		// imprimir valores
		System.out.println("Operadora: " + telf.getOperadora());
		System.out.println("Número: " + telf.getNumero());
		System.out.println("Código: " + telf.getCodigo());
		System.out.println("Tiene WhatsApp: " + telf.isTieneWhatsapp());
	}

}
