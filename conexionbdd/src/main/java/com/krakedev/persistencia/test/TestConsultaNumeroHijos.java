package com.krakedev.persistencia.test;

import java.util.ArrayList;

import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;

public class TestConsultaNumeroHijos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ArrayList<Persona> personas = AdminPersonas.buscarPorNumeroHijos(4);
			System.out.println(personas);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
