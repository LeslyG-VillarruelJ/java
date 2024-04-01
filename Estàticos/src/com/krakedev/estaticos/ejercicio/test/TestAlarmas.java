package com.krakedev.estaticos.ejercicio.test;

import java.util.ArrayList;

import com.krakedev.estaticos.ejercicio.entidades.Alarma;
import com.krakedev.estaticos.ejercicio.logica.AdminAlarmas;
import com.krakedev.estaticos.ejercicio.utils.DiasSemana;

public class TestAlarmas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Instancias varias alarmas
		Alarma a1 = new Alarma(DiasSemana.LUNES, 5, 45);
		Alarma a2 = new Alarma(DiasSemana.MIERCOLES, 5,0);
		Alarma a3 = new Alarma(DiasSemana.SABADO, 7, 30);
		Alarma a4 = new Alarma(DiasSemana.VIERNES, 6, 15);
		Alarma a5 = new Alarma(DiasSemana.DOMINGO, 8, 35);
		
		// recuperar la lista de alarmas
		AdminAlarmas admin = new AdminAlarmas();
		// agregar alarmas
		admin.agregarAlarma(a1);
		admin.agregarAlarma(a2);
		admin.agregarAlarma(a3);
		admin.agregarAlarma(a4);
		admin.agregarAlarma(a5);
		// obtener alarmas
		ArrayList<Alarma> alarmasActuales = admin.getAlarmas();
		// Imprimir Alarmas
		System.out.println(alarmasActuales);
	}

}
