package com.krakedev.inventario.servicios;

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

import com.krakedev.inventario.bdd.ProductoBDD;
import com.krakedev.inventario.entidades.Producto;
import com.krakedev.inventario.excepciones.KrakeDevException;

@Path("productos")
public class ServiciosProducto {
	@Path("buscar/{sub}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("sub") String subcadena) {
		ProductoBDD prod = new ProductoBDD();
		try {
			ArrayList<Producto> productos = prod.buscar(subcadena);
			return Response.ok(productos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Producto producto) {
		ProductoBDD prod = new ProductoBDD();
		try {
			prod.insertar(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response actualizar(Producto producto) {
		ProductoBDD prod = new ProductoBDD();
		try {
			prod.actualizar(producto);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscarProducto/{cod}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscarProducto(@PathParam("cod") int codigo) {
		ProductoBDD prod = new ProductoBDD();
		try {
			Producto producto = prod.buscarProducto(codigo);
			return Response.ok(producto).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
