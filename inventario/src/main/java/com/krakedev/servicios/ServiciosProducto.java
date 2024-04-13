package com.krakedev.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.krakedev.entidades.Categoria;
import com.krakedev.entidades.Producto;

@Path("productos")

public class ServiciosProducto {
	@Path("insertar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void insetar(Producto producto) {
		System.out.println("Producto insertado: " + producto);
	}
	
	@Path("actualizar")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void actualizar(Producto producto) {
		System.out.println("Producto actualizado: " + producto);
	}
	
	@Path("consultar")
	@GET
	@Produces(MediaType.APPLICATION_JSON) // en que tipo de trama quiero que regrese
	public ArrayList<Producto> recuperarTodos() {
		ArrayList<Producto> productos = new ArrayList<Producto>();
		// crear tres productos
		Categoria cat = new Categoria(1, "Snacks");
		Producto p1 = new Producto("01A01", "Papitas", cat, 0.50, 4);
		Producto p2 = new Producto("01A02", "Doritos", cat, 0.75, 10);
		Producto p3 = new Producto("01A03", "DeTodito", cat, 1.00, 5);
		// agregar los productos al arrayList
		productos.add(p1);
		productos.add(p2);
		productos.add(p3);
		
		return productos;
	}
}
