package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProductoBDD;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;

@Path("producto")
public class ServiciosProducto {
	@Path("buscar/{nombreParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerProductos(@PathParam("nombreParam") String nombre) {
		ProductoBDD prodBDD = new ProductoBDD();
		ArrayList<Producto> productos = null;
		try {
			productos = prodBDD.buscar(nombre);
			return Response.ok(productos).build();
		} catch (KrakedevExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}

	}

	@Path("crear")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Producto producto) {
		ProductoBDD prodBDD = new ProductoBDD();
		try {
			prodBDD.crear(producto);
			return Response.ok().build();
		} catch (KrakedevExceptions e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}

}
