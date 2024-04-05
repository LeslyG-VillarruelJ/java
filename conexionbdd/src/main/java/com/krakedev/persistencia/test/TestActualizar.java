package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestActualizar {

	public static void main(String[] args) {
		EstadoCivil ec = new EstadoCivil("C", "Casado");
		Persona p = new Persona("1712345675", "Andrea", "Pereira", ec);
		
		try {
			Date fechaNac = Convertidor.convertirADate("2020/12/23");
			p.setFechaNacimiento(fechaNac);
			Date horaNac = Convertidor.convertirAHora("09:23");
			p.setHoraNacimiento(horaNac);
			AdminPersonas.actualizar(p);
		} catch (Exception e) {
			System.out.println("Error del sistema: " + e.getMessage());
		}
		
	}

}
