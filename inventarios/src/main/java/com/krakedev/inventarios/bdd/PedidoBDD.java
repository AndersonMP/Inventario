package com.krakedev.inventarios.bdd;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.krakedev.inventarios.entidades.CabeceraPedido;
import com.krakedev.inventarios.entidades.DetallePedido;
import com.krakedev.inventarios.excepciones.KrakedevExceptions;
import com.krakedev.inventarios.utils.ConexionBDD;

public class PedidoBDD {
	public void crear(CabeceraPedido cabPedido) throws KrakedevExceptions {
		Connection con = null;
		PreparedStatement ps = null;
		PreparedStatement psDet = null;
		ResultSet rsClave = null;
		Date fechaActual = new Date();
		int codigoCabecera = 0;
		java.sql.Date fechaSQL = new java.sql.Date(fechaActual.getTime());
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("insert into cabecera_pedido (proveedor,fecha, estado) " + "values (?,?,?)",
					Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, cabPedido.getCodProveedor().getIdentificador());
			ps.setDate(2, fechaSQL);
			ps.setString(3, "S");

			ps.executeUpdate();
			rsClave = ps.getGeneratedKeys();

			if (rsClave.next()) {
				codigoCabecera = rsClave.getInt(1);
			}

			ArrayList<DetallePedido> detallesPedido = cabPedido.getDetalles();
			DetallePedido det;
			for (int i = 0; i < detallesPedido.size(); i++) {
				det = detallesPedido.get(i);
				psDet = con.prepareStatement(
						"insert into detalle_pedido (cabecera_pedido,producto,cantidad_solicitada,sub_total,cantidad_recibida) "
								+ "values (?,?,?,?,?)");
				psDet.setInt(1, codigoCabecera);
				psDet.setInt(2, det.getCodProducto().getCodProducto());
				psDet.setInt(3, det.getCantidadSolicitada());
				BigDecimal pv = det.getCodProducto().getPrecioVenta();
				BigDecimal cs = new BigDecimal(det.getCantidadSolicitada());
				BigDecimal subTotal = pv.multiply(cs);
				psDet.setBigDecimal(4, subTotal);
				psDet.setInt(5, 0);

				psDet.executeUpdate();
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new KrakedevExceptions("Error al insertar pedido");
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
	}
}
