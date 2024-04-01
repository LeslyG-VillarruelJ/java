package com.krakedev.estaticos;

public class TestUtilitarios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Con un metodo estático no es necesario instanciar el objeto
		 * Utilitarios util = new Utilitarios();
		util.validarRango(10);*/
		boolean resultado = Utilitarios.validarRango(10);
		System.out.println(resultado);
	}

}
