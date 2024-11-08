package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.TipoDocumentoBDD;
import com.krakedev.inventarios.entidades.TipoDocumento;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;

@Path("tipodocumento")
public class ServiciosTipoDocumento {
	@Path("recuperar")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(){
		TipoDocumentoBDD tp = new TipoDocumentoBDD();
		ArrayList<TipoDocumento> tipoDocumentos = null;
		try {
			tipoDocumentos = tp.recuperar();
			return Response.ok(tipoDocumentos).build();
		} catch (KrakedevExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
