package ar.edu.unju.fi.ejercicio1.model;

public class Producto {
	private String codigo;
	private String descripcion;
	private double precio;
	private OrigenFabr origenFabr;
	private Categoria categoria;
	
	
	
	public Producto() {
	}
	
	public Producto(String codigo, String descripcion, double precio, OrigenFabr origenFabr, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precio = precio;
		this.origenFabr = origenFabr;
		this.categoria = categoria;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public OrigenFabr getOrigenFabr() {
		return origenFabr;
	}
	public void setOrigenFabr(OrigenFabr origenFabr) {
		this.origenFabr = origenFabr;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
	
}
