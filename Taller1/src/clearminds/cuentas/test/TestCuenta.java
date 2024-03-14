package clearminds.cuentas.test;

import clearminds.cuentas.Cuenta;

public class TestCuenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Crear el objeto Cuenta y lo referencia cuenta1
		Cuenta cuenta1 = new Cuenta("03476");
		// Crear el objeto Cuenta y lo referencia con cuenta2
		Cuenta cuenta2 = new Cuenta("03476", "C", 98);
		// Crear el ojeto Cuenta y lo referencio con cuenta3
		Cuenta cuenta3 = new Cuenta("03476");
		// Crear una cuenta4
		Cuenta cuenta4 = new Cuenta("0987");
		// Crear una cuenta5
		Cuenta cuenta5 = new Cuenta("0557", "C", 10);
		// Crear cuenta6
		Cuenta cuenta6 = new Cuenta("0666");
		// Coloco un valor de saldo en la cuenta1
		cuenta1.setSaldo(675);
		//Modifico el tipo de cuenta
		cuenta3.setTipo("C");
		//Imprimo cuenta1, cuenta2, cuenta3
		System.out.println("------Valores iniciales------");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		//Modifico los valores de las 3 cuentas
		cuenta1.setSaldo(444);
		cuenta3.setSaldo(567);
		cuenta2.setTipo("D");
		//Imprimo los nuevos valores
		System.out.println("------Valores modificados------");
		cuenta1.imprimir();
		cuenta2.imprimir();
		cuenta3.imprimir();
		//Modificar valores de cuenta4
		cuenta4.setSaldo(10);
		// Imprimir los valores de cuenta4, cuenta5 y cuenta6
		System.out.println("-----Impresión on mi estilo-----");
		cuenta4.imprimirConMiEstilo();
		cuenta5.imprimirConMiEstilo();
		cuenta6.imprimirConMiEstilo();
	}

}
