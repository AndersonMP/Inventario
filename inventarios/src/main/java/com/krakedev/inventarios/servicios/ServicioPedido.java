package com.krakedev.inventarios.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.PedidoBDD;
import com.krakedev.inventarios.entidades.CabeceraPedido;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;

@Path("pedido")
public class ServicioPedido {
	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(CabeceraPedido cabPedido) {
		PedidoBDD pedBDD = new PedidoBDD();
		try {
			pedBDD.crear(cabPedido);
			return Response.ok().build();
		} catch (KrakedevExceptions e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
