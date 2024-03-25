package com.entidades;

import java.util.ArrayList;

public class Naipe {
	private ArrayList<Numero> numerosPosibles;
	private ArrayList<Carta> cartas;

	public Naipe() {
		numerosPosibles = new ArrayList<Numero>();
		numerosPosibles.add(new Numero("A", 11));
		numerosPosibles.add(new Numero("2", 2));
		numerosPosibles.add(new Numero("3", 3));
		numerosPosibles.add(new Numero("4", 4));
		numerosPosibles.add(new Numero("5", 5));
		numerosPosibles.add(new Numero("6", 6));
		numerosPosibles.add(new Numero("7", 7));
		numerosPosibles.add(new Numero("8", 8));
		numerosPosibles.add(new Numero("9", 9));
		numerosPosibles.add(new Numero("10", 10));
		numerosPosibles.add(new Numero("J", 10));
		numerosPosibles.add(new Numero("Q", 10));
		numerosPosibles.add(new Numero("K", 10));

		cartas = new ArrayList<Carta>();
		Palos palos = new Palos(); // instanciamos para poder obtener los diferentes palos

		for (int i = 0; i < numerosPosibles.size(); i++) {
			cartas.add(new Carta(numerosPosibles.get(i), palos.getCorazonNegro()));
			cartas.add(new Carta(numerosPosibles.get(i), palos.getCorazonRojo()));
			cartas.add(new Carta(numerosPosibles.get(i), palos.getDiamante()));
			cartas.add(new Carta(numerosPosibles.get(i), palos.getTrebol()));
		}
	}

	public ArrayList<Carta> getCartas() {
		return cartas;
	}

	public ArrayList<Carta> barajar() {
		ArrayList<Carta> auxiliar = new ArrayList<Carta>();
		Carta elementoCarta;
		int aleatorio;
		
		for (int i = 1; i <= 100; i++) {
			aleatorio = Random.obtenerPosicion();
			elementoCarta = cartas.get(aleatorio);
			if (elementoCarta.getEstado().equals("N")) {
				auxiliar.add(elementoCarta);
				elementoCarta.setEstado("C");
			}
		}

		for (int i = 0; i < cartas.size(); i++) {
			elementoCarta = cartas.get(i);
			if(elementoCarta.getEstado().equals("N")) {
				auxiliar.add(elementoCarta);
				elementoCarta.setEstado("C");
			}
		}

		return auxiliar;
	}
}
