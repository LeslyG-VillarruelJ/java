package com.cmc.repaso.test;

import com.cmc.repaso.entidades.Validacion;

public class TestValidacion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Validacion validacion = new Validacion();
		boolean validar1 = validacion.validarMonto(4.3);
		boolean validar2 = validacion.validarMonto(-5.7);
	}

}
