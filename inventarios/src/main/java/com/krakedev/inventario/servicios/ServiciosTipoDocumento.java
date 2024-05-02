package com.krakedev.inventario.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventario.bdd.TipoDocumentoBDD;
import com.krakedev.inventario.entidades.TipoDocumento;
import com.krakedev.inventario.excepciones.KrakeDevException;

@Path("tiposdocumento")
public class ServiciosTipoDocumento {
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response recuperar(){
		TipoDocumentoBDD tipo = new TipoDocumentoBDD();
		ArrayList<TipoDocumento> documentos = null;
		try {
			documentos = tipo.recuperar();
			return Response.ok(documentos).build();
		} catch (KrakeDevException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
}
