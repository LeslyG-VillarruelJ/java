package com.cmc.directorio.test;

import com.cmc.directorio.entidades.Telefono;

public class TestTelefono {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Telefono telf = new Telefono("movi", "0994123412", 10);
		// Imprimir datos
		System.out.println("Operadora: " + telf.getOperadora());
		System.out.println("Número: " + telf.getNumero());
		System.out.println("Código: " + telf.getCodigo());
	}

}
