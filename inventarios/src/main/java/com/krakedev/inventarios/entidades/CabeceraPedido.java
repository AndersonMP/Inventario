package com.krakedev.inventarios.entidades;

import java.util.ArrayList;
import java.util.Date;

public class CabeceraPedido {
	private int codCabPedido;
	private Proveedor codProveedor;
	private Date fecha;
	private EstadoPedido estado;
	private ArrayList<DetallePedido> detalles;

	public CabeceraPedido() {

	}

	public CabeceraPedido(int codCabPedido, Proveedor codProveedor, EstadoPedido estado) {
		super();
		this.codCabPedido = codCabPedido;
		this.codProveedor = codProveedor;
		this.estado = estado;
	}

	public CabeceraPedido(int codCabPedido, Proveedor codProveedor) {
		super();
		this.codCabPedido = codCabPedido;
		this.codProveedor = codProveedor;
	}

	public CabeceraPedido(int codCabPedido) {
		super();
		this.codCabPedido = codCabPedido;
	}

	public CabeceraPedido(int codCabPedido, Proveedor codProveedor, Date fecha, EstadoPedido estado,
			ArrayList<DetallePedido> detalles) {
		super();
		this.codCabPedido = codCabPedido;
		this.codProveedor = codProveedor;
		this.fecha = fecha;
		this.estado = estado;
		this.detalles = detalles;
	}

	public int getCodCabPedido() {
		return codCabPedido;
	}

	public void setCodCabPedido(int codCabPedido) {
		this.codCabPedido = codCabPedido;
	}

	public ArrayList<DetallePedido> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetallePedido> detalles) {
		this.detalles = detalles;
	}

	public Proveedor getCodProveedor() {
		return codProveedor;
	}

	public void setCodProveedor(Proveedor codProveedor) {
		this.codProveedor = codProveedor;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "CabeceraPedido [codCabPedido=" + codCabPedido + ", codProveedor=" + codProveedor + ", fecha=" + fecha
				+ ", estado=" + estado + "]";
	}

}
