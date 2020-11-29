package model;

public class Boleta {

	private String id_boleta;
	private String estado;
	private String fecha;
	private int usuario;

	public String getId_boleta() {
		return id_boleta;
	}

	public void setId_boleta(String id_boleta) {
		this.id_boleta = id_boleta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	@Override
	public String toString() {
		return "Boleta [id_boleta=" + id_boleta + ", estado=" + estado + ", fecha=" + fecha + ", usuario=" + usuario
				+ "]";
	}

}