package interfaces;

import model.Usuario;

public interface UsuarioInterface {

	public int registrarUsuario(Usuario u);

	public Usuario validarAcceso(Usuario u);

	public int actualizarUsuario(Usuario u);

}
