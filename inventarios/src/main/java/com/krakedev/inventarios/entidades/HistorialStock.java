package com.krakedev.inventarios.entidades;

import java.sql.Timestamp;

public class HistorialStock {
	private int codHistorial;
	private Producto codProducto;
	private Timestamp fecha;
	private String referencia;
	private int cantidad;

	public HistorialStock() {
		super();
	}

	public HistorialStock(int codHistorial, Producto codProducto) {
		super();
		this.codHistorial = codHistorial;
		this.codProducto = codProducto;
	}

	public HistorialStock(int codHistorial) {
		super();
		this.codHistorial = codHistorial;
	}

	public HistorialStock(Producto codProducto, String referencia) {
		super();
		this.codProducto = codProducto;
		this.referencia = referencia;
	}
	public HistorialStock(String referencia) {
		super();
		this.referencia = referencia;
	}

	public HistorialStock(int codHistorial, Producto codProducto, Timestamp fecha, String referencia, int cantidad) {
		super();
		this.codHistorial = codHistorial;
		this.codProducto = codProducto;
		this.fecha = fecha;
		this.referencia = referencia;
		this.cantidad = cantidad;
	}

	public int getCodHistorial() {
		return codHistorial;
	}

	public void setCodHistorial(int codHistorial) {
		this.codHistorial = codHistorial;
	}

	public Producto getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(Producto codProducto) {
		this.codProducto = codProducto;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "HistorialStock [codHistorial=" + codHistorial + ", codProducto=" + codProducto + ", fecha=" + fecha
				+ ", referencia=" + referencia + ", cantidad=" + cantidad + "]";
	}

}
