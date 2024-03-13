package com.krakedev.test;

import com.krakedev.Fecha;

public class TestFecha {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fecha fecha1 = new Fecha();
		/* Sin encapsulamiento
		fecha1.anio = 2;
		fecha1.mes = 20;
		fecha1.dia = 30;
		
		System.out.println(fecha1.anio);*/
		
		fecha1.setAnio(2000);
		fecha1.setMes(12);
		fecha1.setDia(12);
		
		System.out.println(fecha1.getAnio());
	}

}
