package interfaces;

import java.util.ArrayList;

import model.Producto;

public interface ProductoInterface {

	public ArrayList<Producto> listarProductos();

	public int registrarProducto(Producto p);

	public int actualizarProducto(Producto p);

	public int eliminarProducto(Producto p);

	public ArrayList<Producto> filtrarProductos(String term);

}
