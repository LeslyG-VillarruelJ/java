package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestPersona {

	public static void main(String[] args) {
		EstadoCivil ec = new EstadoCivil("S", "Soltero");
		Persona p = new Persona("1711524908", "Frank", "Villarruel", ec);
		try {
			Date fechaNac = Convertidor.convertirADate("2020/12/23");
			p.setFechaNacimiento(fechaNac);
			Date horaNac = Convertidor.convertirAHora("09:23");
			p.setHoraNacimiento(horaNac);
			
			// Insertar una persona
			AdminPersonas.insertar(p);
			
			// Actualizar persona
			p.setEstatura(1.85);
			p.setNumeroHijos(1);
			AdminPersonas.actualizar(p);
			
			// Eliminar persona
			AdminPersonas.eliminar("1753532041");
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}

	}

}
