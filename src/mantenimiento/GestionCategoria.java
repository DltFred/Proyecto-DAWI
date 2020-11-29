package mantenimiento;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import interfaces.CategoriaInterface;
import model.Categoria;
import utils.MySQLConexion;

public class GestionCategoria implements CategoriaInterface {

	@Override
	public ArrayList<Categoria> listarCategorias() {
		ArrayList<Categoria> lista = null;
		// PLANTILLA
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		try {
			con = MySQLConexion.getConexion();
			String sql = "SELECT * FROM tb_categoria";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();
			lista = new ArrayList<Categoria>();
			while (rs.next()) {
				Categoria c = new Categoria();
				c.setId_categoria(rs.getInt(1));
				c.setNom_categoria(rs.getString(2));
				lista.add(c);
			}
		} catch (Exception e) {
			System.out.println("Error en listarCategorias : " + e.getMessage());
		} finally {
			MySQLConexion.closeConexion(con);
		}
		return lista;
	}

}
