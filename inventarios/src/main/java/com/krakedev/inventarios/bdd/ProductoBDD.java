package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.krakedev.inventarios.entidades.Categoria;
import com.krakedev.inventarios.entidades.CategoriaUDM;
import com.krakedev.inventarios.entidades.Producto;
import com.krakedev.inventarios.entidades.UnidadMedida;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;
import com.krakedev.inventarios.utils.ConexionBDD;

public class ProductoBDD {
	public ArrayList<Producto> buscar(String cadena) throws KrakedevExceptions {
		ArrayList<Producto> productos = new ArrayList<Producto>();

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Producto producto = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"select prod.cod_prod as cod_producto,prod.cod_cat,prod.nombre as nombre_producto, cat.nombre as nombre_categoria, "
							+ "udm.cod_udm as cod_udm, udm.descripcion as descripcion_udm, prod.costo, prod.precio_venta, "
							+ "prod.tiene_iva, prod.stock " + "from producto as prod "
							+ "inner join unidad_medida as udm on prod.cod_udm = udm.cod_udm "
							+ "inner join categoria as cat on prod.cod_cat = cat.cod_cat "
							+ "where upper(prod.nombre) like ?;");
			ps.setString(1, "%" + cadena.toUpperCase() + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				int codProducto = rs.getInt("cod_producto");
				int codCategoria = rs.getInt("cod_cat");
				String nombreProducto = rs.getString("nombre_producto");
				String nombreCategoria = rs.getString("nombre_categoria");
				String codUDM = rs.getString("cod_udm");
				String descripcionUDM = rs.getString("descripcion_udm");
				BigDecimal costo = rs.getBigDecimal("costo");
				BigDecimal precioVenta = rs.getBigDecimal("precio_venta");
				boolean tieneIva = rs.getBoolean("tiene_iva");
				int stock = rs.getInt("stock");
				Categoria cat = new Categoria(codCategoria, nombreCategoria);
				CategoriaUDM catUDM = new CategoriaUDM(codUDM);
				UnidadMedida udm = new UnidadMedida(codUDM, catUDM, descripcionUDM);
				producto = new Producto(codProducto, udm, cat, nombreProducto, precioVenta, costo, tieneIva, stock);
				productos.add(producto);
			}

		} catch (KrakedevExceptions e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KrakedevExceptions("Error al consultar: " + e.getMessage());
		}

		return productos;
	}

	public Producto crear(Producto producto) throws KrakedevExceptions {
		Connection con = null;
		PreparedStatement ps = null;
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement(
					"insert into producto (cod_udm,cod_cat,nombre,precio_venta, costo,tiene_iva,stock) "
							+ "values (?,?,?,?,?,?,?);");

			ps.setString(1, producto.getCodUDM().getCodUDM());
			ps.setInt(2, producto.getCategoria().getCodigo());
			ps.setString(3, producto.getNombre());
			ps.setBigDecimal(4, producto.getPrecioVenta());
			ps.setBigDecimal(5, producto.getCosto());
			ps.setBoolean(6, producto.getTieneIva());
			ps.setInt(7, producto.getStock());

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
		return producto;
	}

}
