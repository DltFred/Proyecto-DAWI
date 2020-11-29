package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import interfaces.UsuarioInterface;
import model.Usuario;
import utils.MySQLConexion;

public class GestionUsuario implements UsuarioInterface {

	@Override
	public int registrarUsuario(Usuario u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;

		try {
			con = MySQLConexion.getConexion();
			String sql = "INSERT INTO tb_usuario VALUES(?, ?, ?, ?, ?, ?, ?);";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getCodigo());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellido());
			pst.setString(4, u.getCorreo());
			pst.setString(5, u.getContraseña());
			pst.setString(6, u.getLocalizacion());
			pst.setInt(7, u.getTipo());
			rs = pst.executeUpdate();
			System.out.println("registra" + rs);
		} catch (Exception e) {
			System.out.println("Error al registrar : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;

	}

	@Override
	public Usuario validarAcceso(Usuario u) {
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet rs = null;
		Usuario user = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "sp_validarAcceso(?,?)";
			psm = con.prepareStatement(sql);
			psm.setString(1, u.getCorreo());
			psm.setString(2, u.getContraseña());
			rs = psm.executeQuery();
			while (rs.next()) {
				user = new Usuario();
				user.setCodigo(rs.getInt(1));
				user.setNombre(rs.getString(2));
				user.setApellido(rs.getString(3));
				user.setCorreo(rs.getString(4));
				user.setLocalizacion(rs.getString(6));
				user.setTipo(rs.getInt(7));
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}

		return user;
	}

	@Override
	public int actualizarUsuario(Usuario u) {
		int rs = 0;
		Connection con = null;
		PreparedStatement pst = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "update tb_usuario set nom_usu=?,ape_usu=?,email_usu=?,cont_usu=?,loca_usu=?,tipo_usu=? where id_usu=?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, u.getCodigo());
			pst.setString(2, u.getNombre());
			pst.setString(3, u.getApellido());
			pst.setString(4, u.getCorreo());
			pst.setString(5, u.getContraseña());
			pst.setString(6, u.getLocalizacion());
			pst.setInt(7, u.getTipo());
			rs = pst.executeUpdate();
		} catch (Exception e) {
			System.out.println("Error al actualizar el usuario: " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return rs;
	}

}
