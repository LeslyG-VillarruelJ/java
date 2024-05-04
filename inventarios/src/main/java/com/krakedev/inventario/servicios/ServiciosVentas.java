package com.krakedev.inventario.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventario.bdd.VentasBDD;
import com.krakedev.inventario.entidades.Venta;
import com.krakedev.inventario.excepciones.KrakeDevException;

@Path("ventas")
public class ServiciosVentas {
	@Path("guardar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardar(Venta venta) {
		VentasBDD ventaBDD = new VentasBDD();
		try {
			ventaBDD.venta(venta);
			return Response.ok().build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
