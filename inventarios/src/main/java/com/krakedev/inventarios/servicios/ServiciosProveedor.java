package com.krakedev.inventarios.servicios;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.krakedev.inventarios.bdd.ProveedorBDD;
import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;

@Path("proveedor")
public class ServiciosProveedor {
	@Path("buscar/{nombreParam}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obtenerClientes(@PathParam ("nombreParam") String nombre){
		ProveedorBDD prov = new ProveedorBDD();
		ArrayList<Proveedor> proveedores = null;
		try {
			proveedores = prov.buscar(nombre);
			return Response.ok(proveedores).build();
		} catch (KrakedevExceptions e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return Response.serverError().build();
		}
		
	}
}
