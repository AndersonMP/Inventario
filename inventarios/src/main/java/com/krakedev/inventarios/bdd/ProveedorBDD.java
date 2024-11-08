package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProveedorBDD {
	public ArrayList<Proveedor> buscar(String cadena) throws KrakedevExceptions {
		ArrayList<Proveedor> proveedores = new ArrayList<Proveedor>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Proveedor proveedor = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("select identificador, tipo_documento, nombre, telefono, correo, direccion "
					+ "from proveedor " + "where upper(nombre) like ?");
			ps.setString(1, "%" + cadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String identificador = rs.getString("identificador");
				String tipoDocumento = rs.getString("tipo_documento");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");

				proveedor = new Proveedor(identificador, tipoDocumento, nombre, telefono, correo, direccion);
				proveedores.add(proveedor);
			}

		} catch (KrakedevExceptions e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExceptions("Error al consultar: " + e.getMessage());
		}

		return proveedores;
	}
}
