package action;

import java.util.ArrayList;

//import org.apache.struts2.convention.annotation.ParentPackage;

import com.opensymphony.xwork2.ActionSupport;

import mantenimiento.GestionCategoria;
import mantenimiento.GestionProducto;
import model.Categoria;
import model.Producto;

//@ParentPackage(value = "dawi")
public class ActionProducto extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// LISTADO DE PRODUCTO
	private ArrayList<Producto> lstProductos;

	public String listado() {
		lstProductos = new GestionProducto().listarProductos();
		return "ok";
	}

	// LISTADO DE COMBO CATEGORIA
	private ArrayList<Categoria> lstCategorias;

	public String llenaComboCat() {
		lstCategorias = new GestionCategoria().listarCategorias();
		return "ok";
	}

	// LISTADO PARA EL AUTOCOMPLETAR
	private String term;

	private ArrayList<Producto> lstFiltrado;

	public String filtraProducto() {
		lstFiltrado = new GestionProducto().filtrarProductos(term);
		return "ok";
	}

	// CRUD
	private Producto p;
	private String btn;

	public String crud() {
		int ok = 0;
		switch (btn) {
		case "Registrar":
			ok = new GestionProducto().registrarProducto(p);
			break;
		case "Actualizar":
			ok = new GestionProducto().actualizarProducto(p);
			break;
		case "Eliminar":
			ok = new GestionProducto().eliminarProducto(p);
			break;
		}
		if (ok == 0) {
			addActionError("Error al " + btn);
		} else {
			addActionMessage("Proceso " + btn + " finalizado");
		}
		return "ok";
	}

	// GET/SET lstCategorias
	public ArrayList<Categoria> getLstCategorias() {
		return lstCategorias;
	}

	public void setLstCategorias(ArrayList<Categoria> lstCategorias) {
		this.lstCategorias = lstCategorias;
	}

	// GET/SET crud
	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public Producto getP() {
		return p;
	}

	public void setP(Producto p) {
		this.p = p;
	}

	// GET/SET lstProductos
	public ArrayList<Producto> getLstProductos() {
		return lstProductos;
	}

	public void setLstProductos(ArrayList<Producto> lstProductos) {
		this.lstProductos = lstProductos;
	}

	// GET/SET lstFiltrado
	public String getTerm() {
		return term;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public ArrayList<Producto> getLstFiltrado() {
		return lstFiltrado;
	}

	public void setLstFiltrado(ArrayList<Producto> lstFiltrado) {
		this.lstFiltrado = lstFiltrado;
	}

}
