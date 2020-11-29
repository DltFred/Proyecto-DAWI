package model;

public class Usuario {

	private int codigo, tipo;
	private String nombre, apellido, correo, contrase�a, localizacion;

	// TO STRING
	@Override
	public String toString() {
		return "Usuario [codigo=" + codigo + ", tipo=" + tipo + ", nombre=" + nombre + ", apellido=" + apellido
				+ ", correo=" + correo + ", contrase�a=" + contrase�a + ", localizacion=" + localizacion + "]";
	}

	// GETTERS & SETTERS
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrase�a() {
		return contrase�a;
	}

	public void setContrase�a(String contrase�a) {
		this.contrase�a = contrase�a;
	}

	public String getLocalizacion() {
		return localizacion;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}

}
