package com.krakedev.persistencia.test;

import java.util.Date;

import com.krakedev.persistencia.entidades.EstadoCivil;
import com.krakedev.persistencia.entidades.Persona;
import com.krakedev.persistencia.servicios.AdminPersonas;
import com.krakedev.persistencia.utils.Convertidor;

public class TestAdminPersonas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EstadoCivil ec = new EstadoCivil("U", "Unión Libre");
		Persona p = new Persona("1753532045", "Lesly", "Villarruel", ec);
		try {
			Date fechaNac = Convertidor.convertirADate("2020/12/23");
			p.setFechaNacimiento(fechaNac);
			Date horaNac = Convertidor.convertirAHora("09:23");
			p.setHoraNacimiento(horaNac);
			AdminPersonas.insertar(p);
		} catch (Exception e) {
			System.out.println("Error en el sistema: " + e.getMessage());
		}
	}

}
