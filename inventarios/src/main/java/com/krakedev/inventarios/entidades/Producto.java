package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;

public class Producto {
	private int codProducto;
	UnidadMedida codUDM;
	Categoria categoria;
	private String nombre;
	private BigDecimal precioVenta;
	private BigDecimal costo;
	private Boolean tieneIva;
	private int Stock;

	public Producto(int codProducto) {
		this.codProducto = codProducto;
	}

	public Producto(int codProducto, UnidadMedida codUDM, Categoria categoria, String nombre, BigDecimal precioVenta,
			BigDecimal costo, Boolean tieneIva, int stock) {
		super();
		this.codProducto = codProducto;
		this.codUDM = codUDM;
		this.categoria = categoria;
		this.nombre = nombre;
		this.precioVenta = precioVenta;
		this.costo = costo;
		this.tieneIva = tieneIva;
		Stock = stock;
	}

	public int getCodProducto() {
		return codProducto;
	}

	public void setCodProducto(int codProducto) {
		this.codProducto = codProducto;
	}

	public UnidadMedida getCodUDM() {
		return codUDM;
	}

	public void setCodUDM(UnidadMedida codUDM) {
		this.codUDM = codUDM;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal precioVenta) {
		this.precioVenta = precioVenta;
	}

	public BigDecimal getCosto() {
		return costo;
	}

	public void setCosto(BigDecimal costo) {
		this.costo = costo;
	}

	public Boolean getTieneIva() {
		return tieneIva;
	}

	public void setTieneIva(Boolean tieneIva) {
		this.tieneIva = tieneIva;
	}

	public int getStock() {
		return Stock;
	}

	public void setStock(int stock) {
		Stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [codProducto=" + codProducto + ", codUDM=" + codUDM + ", categoria=" + categoria + ", nombre="
				+ nombre + ", precioVenta=" + precioVenta + ", costo=" + costo + ", tieneIva=" + tieneIva + ", Stock="
				+ Stock + "]";
	}

}
