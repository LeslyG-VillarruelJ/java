package com.krakedev;

public class TestPersona {

	public static void main(String[] args) {
		// This is a commentary
		Persona person1; //Declared a variable of type
		person1 = new Persona(); // Instance the variable (object)
		Persona person2 = new Persona();
		//Accede to the attributes
		System.out.println("nombre: " + person1.getNombre());
		System.out.println("edad: " + person1.getEdad());
		System.out.println("estatura: " + person1.getEstatura());
		// Modify the attributes
		person1.setNombre("Mario");
		person1.setEdad(45);
		person1.setEstatura(1.56);
		System.out.println("-------------------");
		//Accede to the attributes
		System.out.println("nombre: " + person1.getNombre());
		System.out.println("edad: " + person1.getEdad());
		System.out.println("estatura: " + person1.getEstatura());
		
		person2.setNombre("Angelina");
		
		System.out.println("************");
		System.out.println("person1.nombre" + person1.getNombre());
		System.out.println("person2.nombre" + person2.getNombre());
	}

}
