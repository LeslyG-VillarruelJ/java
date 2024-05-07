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

import com.krakedev.inventario.bdd.PedidosBDD;
import com.krakedev.inventario.entidades.Pedido;
import com.krakedev.inventario.excepciones.KrakeDevException;

@Path("pedidos")
public class ServiciosPedidos {
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response insertar(Pedido pedido) {
		PedidosBDD pedBDD = new PedidosBDD();
		try {
			pedBDD.insertar(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("recibir")
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response recibir(Pedido pedido) {
		PedidosBDD pedBDD = new PedidosBDD();
		try {
			pedBDD.recibirPedido(pedido);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("mostrar/{codigo}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response mostrarPorProveedor(@PathParam("codigo") String codigoProveedor) {
		PedidosBDD pedBDD = new PedidosBDD();
		try {
			ArrayList<Pedido> pedidos = pedBDD.mostrarPorProveedor(codigoProveedor);
			return Response.ok(pedidos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
