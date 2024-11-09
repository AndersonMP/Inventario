package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class DetalleVenta {
	private int codDetVenta;
	private CabeceraVenta cabVenta;
	private Producto producto;
	private int cantidad;
	private BigDecimal precio_venta;
	private BigDecimal subTotal;
	private BigDecimal subTotalIva;

	public DetalleVenta() {
		super();
	}

	public DetalleVenta(int codDetVenta, CabeceraVenta cabVenta, Producto producto) {
		super();
		this.codDetVenta = codDetVenta;
		this.cabVenta = cabVenta;
		this.producto = producto;
	}

	public DetalleVenta(int codDetVenta, CabeceraVenta cabVenta) {
		super();
		this.codDetVenta = codDetVenta;
		this.cabVenta = cabVenta;
	}

	public DetalleVenta(int codDetVenta) {
		super();
		this.codDetVenta = codDetVenta;
	}

	public DetalleVenta(int codDetVenta, CabeceraVenta cabVenta, Producto producto, int cantidad,
			BigDecimal precio_venta, BigDecimal subTotal, BigDecimal subTotalIva) {
		super();
		this.codDetVenta = codDetVenta;
		this.cabVenta = cabVenta;
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio_venta = precio_venta;
		this.subTotal = subTotal;
		this.subTotalIva = subTotalIva;
	}

	public int getCodDetVenta() {
		return codDetVenta;
	}

	public void setCodDetVenta(int codDetVenta) {
		this.codDetVenta = codDetVenta;
	}

	public CabeceraVenta getCabVenta() {
		return cabVenta;
	}

	public void setCabVenta(CabeceraVenta cabVenta) {
		this.cabVenta = cabVenta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(BigDecimal precio_venta) {
		this.precio_venta = precio_venta;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public BigDecimal getSubTotalIva() {
		return subTotalIva;
	}

	public void setSubTotalIva(BigDecimal subTotalIva) {
		this.subTotalIva = subTotalIva;
	}

	@Override
	public String toString() {
		return "DetalleVenta [codDetVenta=" + codDetVenta + ", cabVenta=" + cabVenta + ", producto=" + producto
				+ ", cantidad=" + cantidad + ", precio_venta=" + precio_venta + ", subTotal=" + subTotal
				+ ", subTotalIva=" + subTotalIva + "]";
	}

}
