package com.krakedev.inventarios.entidades;

public class UnidadMedida {
	private String codUDM;
	private CategoriaUDM catUDM;
	private String descripcion;

	public UnidadMedida() {

	}

	public UnidadMedida(String codUDM, CategoriaUDM catUDM) {
		super();
		this.codUDM = codUDM;
		this.catUDM = catUDM;
	}

	public UnidadMedida(String codUDM) {
		super();
		this.codUDM = codUDM;
	}

	public UnidadMedida(String codUDM, CategoriaUDM catUDM, String descripcion) {
		super();
		this.codUDM = codUDM;
		this.catUDM = catUDM;
		this.descripcion = descripcion;
	}

	public String getCodUDM() {
		return codUDM;
	}

	public void setCodUDM(String codUDM) {
		this.codUDM = codUDM;
	}

	public CategoriaUDM getCatUDM() {
		return catUDM;
	}

	public void setCatUDM(CategoriaUDM catUDM) {
		this.catUDM = catUDM;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "UnidadMedida [codUDM=" + codUDM + ", catUDM=" + catUDM + ", descripcion=" + descripcion + "]";
	}

}
