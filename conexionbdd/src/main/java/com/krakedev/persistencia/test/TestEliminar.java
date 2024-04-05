package com.krakedev.persistencia.test;

import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestEliminar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String cedula = "1753532013";
		try {
			AdminPersonas.eliminar(cedula);
		} catch (Exception e) {
			System.out.println("Error del sistema: " + e.getMessage());
		}
	}

}
