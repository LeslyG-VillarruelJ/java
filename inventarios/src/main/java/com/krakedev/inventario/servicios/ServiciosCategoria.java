package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventario.bdd.CategoriaBDD;
import com.krakedev.inventario.entidades.Categoria;
import com.krakedev.inventario.excepciones.KrakeDevException;

@Path("categorias")
public class ServiciosCategoria {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Categoria categoria) {
		CategoriaBDD cat = new CategoriaBDD();
		try {
			cat.insertar(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Categoria categoria) {
		CategoriaBDD cat = new CategoriaBDD();
		try {
			cat.actualizar(categoria);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("mostrar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrar() {
		CategoriaBDD cat = new CategoriaBDD();
		try {
			ArrayList<Categoria> categorias = cat.mostrar();
			return Response.ok(categorias).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
