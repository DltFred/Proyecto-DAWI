package interfaces;

import java.util.ArrayList;

import model.Tienda;

public interface TiendaInterface {

	public ArrayList<Tienda> listarTiendas();

	public int registrarTienda(Tienda t);

	public int actualizarTienda(Tienda t);

}
