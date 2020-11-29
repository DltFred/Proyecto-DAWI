package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.ProductoInterface;
import model.Producto;
import utils.MySQLConexion;

public class GestionProducto implements ProductoInterface {

	@Override
	public ArrayList<Producto> listarProductos() {
		ArrayList<Producto> lista = null;
		// PLANTILLA
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_producto";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			lista = new ArrayList<Producto>();
			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigo(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setIdCategoria(rs.getInt(4));
				p.setMarca(rs.getString(5));
				p.setContenidoNeto(rs.getString(6));
				p.setPrecio(rs.getDouble(7));
				p.setIdTienda(rs.getString(8));
				p.setStock(rs.getInt(9));
				lista.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error en listarProductos : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public int registrarProducto(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO tb_producto VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getDescripcion());
			pst.setInt(4, p.getIdCategoria());
			pst.setString(5, p.getMarca());
			pst.setString(6, p.getContenidoNeto());
			pst.setDouble(7, p.getPrecio());
			pst.setString(8, p.getIdTienda());
			pst.setInt(9, p.getStock());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizarProducto(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE tb_producto SET nom_prod=?, desc_prod=?, id_cat=?, marc_prod=?, con_net_prod=?, pre_prod=?, "
					+ "id_tien=?, stk_prod=? WHERE id_prod=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodigo());
			pst.setString(2, p.getNombre());
			pst.setString(3, p.getDescripcion());
			pst.setInt(4, p.getIdCategoria());
			pst.setString(5, p.getMarca());
			pst.setString(6, p.getContenidoNeto());
			pst.setDouble(7, p.getPrecio());
			pst.setString(8, p.getIdTienda());
			pst.setInt(9, p.getStock());

			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al actualizar producto: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int eliminarProducto(Producto p) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "DELETE FROM tb_producto WHERE id_prod = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, p.getCodigo());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al eliminar " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public ArrayList<Producto> filtrarProductos(String term) {
		ArrayList<Producto> lista = null;
		// PLANTILLA
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_producto WHERE id_prod=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, term);
			rs = pst.executeQuery();
			lista = new ArrayList<Producto>();
			while (rs.next()) {
				Producto p = new Producto();
				p.setCodigo(rs.getString(1));
				p.setNombre(rs.getString(2));
				p.setDescripcion(rs.getString(3));
				p.setIdCategoria(rs.getInt(4));
				p.setMarca(rs.getString(5));
				p.setContenidoNeto(rs.getString(6));
				p.setPrecio(rs.getDouble(7));
				p.setIdTienda(rs.getString(8));
				p.setStock(rs.getInt(9));
				lista.add(p);
			}
		} catch (Exception e) {
			System.out.println("Error en filtrarProductos : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
