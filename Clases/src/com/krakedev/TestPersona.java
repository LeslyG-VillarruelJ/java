package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		// This is a commentary
		Persona person1; //Declared a variable of type
		person1 = new Persona(); // Instance the variable (object)
		Persona person2 = new Persona();
		//Accede to the attributes
		System.out.println("nombre: " + person1.nombre);
		System.out.println("edad: " + person1.edad);
		System.out.println("estatura: " + person1.estatura);
		// Modify the attributes
		person1.nombre = "Mario";
		person1.edad = 45;
		person1.estatura = 1.56;
		System.out.println("-------------------");
		//Accede to the attributes
		System.out.println("nombre: " + person1.nombre);
		System.out.println("edad: " + person1.edad);
		System.out.println("estatura: " + person1.estatura);
		
		person2.nombre = "Angelina";
		
		System.out.println("************");
		System.out.println("person1.nombre" + person1.nombre);
		System.out.println("person2.nombre" + person2.nombre);
	}

}
