package com.servicios;

import java.util.ArrayList;

import com.entidades.Carta;
import com.entidades.Naipe;

public class Juego {
	private Naipe naipe;
	private ArrayList<ArrayList<Carta>> cartasJugadores;
	private ArrayList<Carta> naipeBarajado;

	public Juego() {
		naipe = new Naipe();
		naipeBarajado = naipe.barajar();
		cartasJugadores = new ArrayList<ArrayList<Carta>>();
		naipeBarajado = new ArrayList<Carta>();
	}

	public Juego(ArrayList<String> idJugadores) {
		ArrayList<Carta> cartasJugador;
		naipe = new Naipe();
		cartasJugadores = new ArrayList<ArrayList<Carta>>();
		naipeBarajado = naipe.barajar();
		for (int i = 0; i < idJugadores.size(); i++) {
			cartasJugador = new ArrayList<Carta>();
			cartasJugadores.add(cartasJugador);
		}
	}

	public ArrayList<ArrayList<Carta>> getCartasJugadores() {
		return cartasJugadores;
	}

	public void entregarCartas(int cartasPorJugador) {
		Carta elementoCarta;
		ArrayList<Carta> cartasArrayInterno;
		int tamanioArrayAnidado = cartasJugadores.size();
		int cartasARepartir = cartasPorJugador * tamanioArrayAnidado;
		for(int j=0;j<tamanioArrayAnidado;j++) {
			cartasArrayInterno = cartasJugadores.get(j);
			for (int i = j; i < cartasARepartir; i += tamanioArrayAnidado) {
				elementoCarta = naipeBarajado.get(i);
				cartasArrayInterno.add(elementoCarta);
			}
		}
		
	}

	public int devolverTotal(int posicion) {
		Carta carta;
		int suma = 0;
		ArrayList<Carta> cartasJugador = cartasJugadores.get(posicion);
		for (int i = 0; i < cartasJugador.size(); i++) {
			carta = cartasJugadores.get(posicion).get(i);
			suma = suma + carta.getNumero().getValor();
		}

		return suma;
	}
	
	public String determinarGanador(ArrayList<String> listaJugadores) {
		String idGanador = listaJugadores.get(0);
		int sumaGanador = devolverTotal(0);
		int elementoSuma;
		for(int i=1;i<cartasJugadores.size();i++) {
			elementoSuma = devolverTotal(i);
			if(elementoSuma > sumaGanador) {
				sumaGanador = elementoSuma;
				idGanador = listaJugadores.get(i);
			}
		}
		return idGanador;
	}
}
