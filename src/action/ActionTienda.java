package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

import mantenimiento.GestionTienda;
import model.Tienda;

public class ActionTienda extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// LISTADO DE TIENDAS
	private ArrayList<Tienda> lstTiendas;

	public String listado() {
		lstTiendas = new GestionTienda().listarTiendas();
		return "ok";
	}

	// CRUD
	private Tienda t;
	private String btn;

	public String crud() {
		int ok = 0;
		switch (btn) {
		case "Registrar":
			ok = new GestionTienda().registrarTienda(t);
			break;
		case "Actualizar":
			ok = new GestionTienda().actualizarTienda(t);
			break;
		}
		if (ok == 0) {
			addActionError("Error al " + btn);
		} else {
			addActionMessage("Proceso " + btn + " finalizado");
		}
		return "ok";
	}

	// GET/SET lstTiendas
	public ArrayList<Tienda> getLstTiendas() {
		return lstTiendas;
	}

	public void setLstTiendas(ArrayList<Tienda> lstTiendas) {
		this.lstTiendas = lstTiendas;
	}

	// GET/SET crud
	public Tienda getT() {
		return t;
	}

	public void setT(Tienda t) {
		this.t = t;
	}

	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

}
