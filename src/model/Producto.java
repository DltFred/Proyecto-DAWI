package model;

public class Producto {
	private String codigo, nombre, descripcion, marca, contenidoNeto, idTienda;
	private double precio;
	private int idCategoria, stock;

	// TO STRING
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + ", marca=" + marca
				+ ", contenidoNeto=" + contenidoNeto + ", idTienda=" + idTienda + ", precio=" + precio
				+ ", idCategoria=" + idCategoria + ", stock=" + stock + "]";
	}

	// GETTERS & SETTERS
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getContenidoNeto() {
		return contenidoNeto;
	}

	public void setContenidoNeto(String contenidoNeto) {
		this.contenidoNeto = contenidoNeto;
	}

	public String getIdTienda() {
		return idTienda;
	}

	public void setIdTienda(String idTienda) {
		this.idTienda = idTienda;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
