package action;

import com.opensymphony.xwork2.ActionSupport;

import mantenimiento.GestionUsuario;
import model.Usuario;

public class ActionUsuario extends ActionSupport {
	private static final long serialVersionUID = 1L;

	// CRUD
	private Usuario u, user;
	private String btn;

	public String crud() {
		String ok = "";
		switch (btn) {
		case "Registrar":
			new GestionUsuario().registrarUsuario(u);
			ok = "registered";
			break;
		case "Validar":
			setUser(new GestionUsuario().validarAcceso(u));
			ok = "logged";
			break;
		case "Actualizar":
			new GestionUsuario().actualizarUsuario(u);
			ok = "update";
			break;
		}
		if (ok == "") {
			addActionError("Error al " + btn);
		} else {
			addActionMessage("Proceso " + btn + " finalizado");
		}
		return ok;
	}

	// GET/SET crud
	public Usuario getU() {
		return u;
	}

	public void setU(Usuario u) {
		this.u = u;
	}

	public String getBtn() {
		return btn;
	}

	public void setBtn(String btn) {
		this.btn = btn;
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
