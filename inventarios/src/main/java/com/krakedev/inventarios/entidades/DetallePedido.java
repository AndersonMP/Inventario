package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetallePedido {
	private int codDetPedido;
	private CabeceraPedido cabeceraPedido;
	private Producto codProducto;
	private int cantidadSolicitada;
	private BigDecimal sub_total;
	private int cantidadRecibida;

	public DetallePedido() {
		super();
	}

	public DetallePedido(int codDetPedido, CabeceraPedido cabeceraPedido, Producto codProducto) {
		super();
		this.codDetPedido = codDetPedido;
		this.cabeceraPedido = cabeceraPedido;
		this.codProducto = codProducto;
	}

	public DetallePedido(int codDetPedido, CabeceraPedido cabeceraPedido) {
		super();
		this.codDetPedido = codDetPedido;
		this.cabeceraPedido = cabeceraPedido;
	}

	public DetallePedido(int codDetPedido) {
		super();
		this.codDetPedido = codDetPedido;
	}

	public DetallePedido(int codDetPedido, CabeceraPedido cabeceraPedido, Producto codProducto, int cantidadSolicitada,
			BigDecimal sub_total, int cantidadRecibida) {
		super();
		this.codDetPedido = codDetPedido;
		this.cabeceraPedido = cabeceraPedido;
		this.codProducto = codProducto;
		this.cantidadSolicitada = cantidadSolicitada;
		this.sub_total = sub_total;
		this.cantidadRecibida = cantidadRecibida;
	}

	public int getCodDetPedido() {
		return codDetPedido;
	}

	public void setCodDetPedido(int codDetPedido) {
		this.codDetPedido = codDetPedido;
	}

	public CabeceraPedido getCabeceraPedido() {
		return cabeceraPedido;
	}

	public void setCabeceraPedido(CabeceraPedido cabeceraPedido) {
		this.cabeceraPedido = cabeceraPedido;
	}

	public Producto getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Producto codProducto) {
		this.codProducto = codProducto;
	}

	public int getCantidadSolicitada() {
		return cantidadSolicitada;
	}

	public void setCantidadSolicitada(int cantidadSolicitada) {
		this.cantidadSolicitada = cantidadSolicitada;
	}

	public BigDecimal getSub_total() {
		return sub_total;
	}

	public void setSub_total(BigDecimal sub_total) {
		this.sub_total = sub_total;
	}

	public int getCantidadRecibida() {
		return cantidadRecibida;
	}

	public void setCantidadRecibida(int cantidadRecibida) {
		this.cantidadRecibida = cantidadRecibida;
	}

	@Override
	public String toString() {
		return "DetallePedido [codDetPedido=" + codDetPedido + ", cabeceraPedido=" + cabeceraPedido + ", codProducto="
				+ codProducto + ", cantidadSolicitada=" + cantidadSolicitada + ", sub_total=" + sub_total
				+ ", cantidadRecibida=" + cantidadRecibida + "]";
	}

}
