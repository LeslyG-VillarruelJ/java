package com.krakedev.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.entidades.Cliente;
import com.krakedev.exceptiones.KrakeDevException;
import com.krakedev.persistencia.ClientesBDD;

@Path("customers")

public class ServicioClientes {
	@Path("m1")// URL con el que se llamara
	@GET // Metodo que utilizará
	public String saludar() {
		return "Hola mundo Rest Web Services";
	}
	
	@Path("mbuscar")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // en que tipo de trama quiero que regrese
	public Cliente buscar() {
		Cliente cliente = new Cliente("1753532041", "Lesly", 0);
		
		return cliente;
	}
	
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Cliente cliente) {
		System.out.println("Cliente insertado: " + cliente);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.insertar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("act")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Cliente cliente) {
		System.out.println("Cliente actualizado: " + cliente);
		ClientesBDD cli = new ClientesBDD();
		try {
			cli.actualizar(cliente);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("all")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		ClientesBDD cli = new ClientesBDD();
		ArrayList<Cliente> clientes = null;
		try {
			clientes = cli.recuperarTodos();
			return Response.ok(clientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorCedula/{cedulaParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorCedula(@PathParam("cedulaParam") String cedula){
		ClientesBDD cli = new ClientesBDD();
		Cliente cliente = null;
		System.out.println("Inngresa cedula: " + cedula);
		try {
			cliente = cli.recuperarPorPK(cedula);
			return Response.ok(cliente).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarPorNumeroHijos/{numerohijos}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarPorNumeroHijos(@PathParam("numerohijos") int numeroHijos){
		ClientesBDD cli = new ClientesBDD();
		ArrayList<Cliente> clientes = null;
		System.out.println("Inngresa numero hijos: " + numeroHijos);
		try {
			clientes = cli.recuperarPorNumeroHijos(numeroHijos);
			return Response.ok(clientes).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
