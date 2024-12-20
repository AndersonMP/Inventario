package com.krakedev.inventarios.entidades;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;

public class CabeceraVenta {

	private int codCabVenta;
	private Timestamp fecha;
	private BigDecimal totalSinIva;
	private BigDecimal iva;
	private BigDecimal total;
	private ArrayList<DetalleVenta> detalles;

	public CabeceraVenta() {
		super();
	}

	public CabeceraVenta(int codCabVenta, Timestamp fecha, BigDecimal totalSinIva, BigDecimal iva, BigDecimal total,
			ArrayList<DetalleVenta> detalles) {
		super();
		this.codCabVenta = codCabVenta;
		this.fecha = fecha;
		this.totalSinIva = totalSinIva;
		this.iva = iva;
		this.total = total;
		this.detalles = detalles;
	}

	public int getCodCabVenta() {
		return codCabVenta;
	}

	public void setCodCabVenta(int codCabVenta) {
		this.codCabVenta = codCabVenta;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotalSinIva() {
		return totalSinIva;
	}

	public void setTotalSinIva(BigDecimal totalSinIva) {
		this.totalSinIva = totalSinIva;
	}

	public BigDecimal getIva() {
		return iva;
	}

	public void setIva(BigDecimal iva) {
		this.iva = iva;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public ArrayList<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(ArrayList<DetalleVenta> detalles) {
		this.detalles = detalles;
	}

	@Override
	public String toString() {
		return "CabeceraVenta [codCabVenta=" + codCabVenta + ", fecha=" + fecha + ", totalSinIva=" + totalSinIva
				+ ", iva=" + iva + ", total=" + total + ", detalles=" + detalles + "]";
	}

}
