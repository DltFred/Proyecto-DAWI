package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.TiendaInterface;
import model.Tienda;
import utils.MySQLConexion;

public class GestionTienda implements TiendaInterface {

	@Override
	public ArrayList<Tienda> listarTiendas() {
		ArrayList<Tienda> lista = null;
		// PLANTILLA
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_tienda";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			lista = new ArrayList<Tienda>();
			while (rs.next()) {
				Tienda t = new Tienda();
				t.setCodigo(rs.getString(1));
				t.setNombre(rs.getString(2));
				t.setRuc(rs.getString(3));
				t.setDireccion(rs.getString(4));
				t.setTelefono(rs.getString(5));
				t.setUbicacion(rs.getString(6));
				lista.add(t);
			}
		} catch (Exception e) {
			System.out.println("Error en listarTiendas : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

	@Override
	public int registrarTienda(Tienda t) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO tb_tienda VALUES(?, ?, ?, ?, ?, ?)";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getCodigo());
			pst.setString(2, t.getNombre());
			pst.setString(3, t.getRuc());
			pst.setString(4, t.getDireccion());
			pst.setString(5, t.getTelefono());
			pst.setString(6, t.getUbicacion());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al registrarTienda : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

	@Override
	public int actualizarTienda(Tienda t) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "UPDATE tb_tienda SET nom_tien=?, ruc_tien=?, dir_tien=?, telf_tien=?, ubi_tien=? WHERE id_tien=?";
			pst = con.prepareStatement(sql);
			pst.setString(1, t.getNombre());
			pst.setString(2, t.getRuc());
			pst.setString(3, t.getDireccion());
			pst.setString(4, t.getTelefono());
			pst.setString(5, t.getUbicacion());
			pst.setString(6, t.getCodigo());
			rs = pst.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error al actualizar Tienda: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

}
