package com.servicios;

import java.util.ArrayList;

public class Jugadores {
	private ArrayList<String> jugadores;

	public Jugadores() {
		jugadores = new ArrayList<String>();
	}
	
	public ArrayList<String> getJugadores() {
		return jugadores;
	}

	public void setJugadores(ArrayList<String> jugadores) {
		this.jugadores = jugadores;
	}
	
	public void jugar() {
		ArrayList<String> gamers = new ArrayList<String>();
		gamers.add("jugador 1");
		gamers.add("jugador 2");
		gamers.add("jugador 3");
		Juego juego = new Juego(gamers);
		juego.entregarCartas(5);
		for (int i = 0; i < gamers.size(); i++) {
            int total = juego.devolverTotal(i);
            System.out.println("Total del jugador " + (i + 1) + ": " + total);
        }

        String ganador = juego.determinarGanador(jugadores);
        System.out.println("El ganador es: " + ganador);
	}
}