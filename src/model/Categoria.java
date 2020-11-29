package model;

public class Categoria {
	private int id_categoria;
	private String nom_categoria;

	// TO STRING
	@Override
	public String toString() {
		return "Categoria [id_categoria=" + id_categoria + ", nom_categoria=" + nom_categoria + "]";
	}

	// GETTERS & SETTERS
	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNom_categoria() {
		return nom_categoria;
	}

	public void setNom_categoria(String nom_categoria) {
		this.nom_categoria = nom_categoria;
	}

}
