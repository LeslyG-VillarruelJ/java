package com.cmc.evaluacion.servicios;

import java.util.ArrayList;

import com.cmc.evaluacion.entidades.CalculadoraAmortizacion;
import com.cmc.evaluacion.entidades.Cliente;
import com.cmc.evaluacion.entidades.Prestamo;

public class Banco {
	private ArrayList<Prestamo> prestamos;
	private ArrayList<Cliente> clientes;

	public Banco() {
		prestamos = new ArrayList<Prestamo>();
		clientes = new ArrayList<Cliente>();
	}

	public ArrayList<Prestamo> getPrestamos() {
		return prestamos;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public Cliente buscarCliente(String cedula) {
		Cliente elementoCliente = null;
		String cedulaCliente;
		for (int i = 0; i < clientes.size(); i++) {
			cedulaCliente = clientes.get(i).getCedula();
			if (cedula.equals(cedulaCliente)) {
				elementoCliente = clientes.get(i);
			}
		}
		return elementoCliente;
	}

	public void registrarCliente(Cliente cliente) {
		// verificar si el ciente ya no esta registrado
		Cliente registroCliente = buscarCliente(cliente.getCedula());
		if (registroCliente != null && clientes.size() != 0) {
			System.out.println("Cliente ya existe :" + cliente.getCedula());
		} else {
			clientes.add(cliente);
			System.out.print("Cliente registrado : " + cliente.getNombre() + " " + cliente.getApellido() + " | ");
		}
	}

	public void asignarPrestamo(String cedula, Prestamo prestamo) {
		// verificar si el ciente ya no esta registrado
		Cliente cliente = buscarCliente(cedula);
		if (cliente != null) {
			CalculadoraAmortizacion.generarTabla(prestamo);
			prestamo.setCliente(cliente);
			prestamos.add(prestamo);
		} else {
			System.out.println("No es cliente del banco");
		}
	}

	public ArrayList<Prestamo> buscarPrestamos(String cedula) {
		ArrayList<Prestamo> prestamosCliente = new ArrayList<Prestamo>();
		for (int i = 0; i < prestamos.size(); i++) {
			if (cedula.equals(prestamos.get(i).getCliente().getCedula())) {
				prestamosCliente.add(prestamos.get(i));
			}
		}
		return prestamosCliente;
	}
}
