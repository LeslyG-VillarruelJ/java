package com.krakedev.estaticos;

public class TestEstaticos {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// los metodos estaticos son parte de la clase
		// por lo que no tengo que instanciar el objeto
		// como la clase Math
		// Para invocar el mètodo es directamento desde la clase
		double numero = Math.random();
		System.out.println(numero);
		int radio = 10;
		double area = Math.PI * radio;
		System.out.println(area);
	}

}
