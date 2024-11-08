package com.krakedev.inventarios.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Proveedor;
import com.krakedev.inventarios.entidades.TipoDocumento;
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
			ps = con.prepareStatement(
					"select identificador,tipo_documento, descripcion, nombre,telefono,correo,direccion "
							+ "from proveedor as pv, tipo_documento as td " + "where pv.tipo_documento = td.codigo "
							+ "and upper (nombre) like ?;");
			ps.setString(1, "%" + cadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				String identificador = rs.getString("identificador");
				String codigoTipoDocumento = rs.getString("tipo_documento");
				String descripcionTipoDocumento = rs.getString("descripcion");
				String nombre = rs.getString("nombre");
				String telefono = rs.getString("telefono");
				String correo = rs.getString("correo");
				String direccion = rs.getString("direccion");
				TipoDocumento td = new TipoDocumento(codigoTipoDocumento, descripcionTipoDocumento);

				proveedor = new Proveedor(identificador, td, nombre, telefono, correo, direccion);
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

	public Proveedor crear(Proveedor proveedor) throws KrakedevExceptions {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into proveedor (identificador, tipo_documento, nombre, telefono, correo,direccion) "
							+ "values (?,?,?,?,?,?)");
			
			ps.setString(1, proveedor.getIdentificador());
			ps.setString(2, proveedor.getTipoDocumento().getCodigo());
			ps.setString(3, proveedor.getNombre());
			ps.setString(4, proveedor.getTelefono());
			ps.setString(5, proveedor.getCorreo());
			ps.setString(6, proveedor.getDireccion());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevExceptions("Error al insertar proveedor");
		} catch (KrakedevExceptions e) {
			throw e;
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new KrakedevExceptions("Error al insertar: " + e.getMessage());
			}
		}
		return proveedor;
	}
}
