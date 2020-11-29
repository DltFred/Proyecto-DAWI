package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConexion {
	public static Connection getConexion() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/BD_VENTASPRODUCTOS2?useTimezone=true&serverTimezone=UTC";
			String usr = "root";
			String psw = "mysql";
			con = DriverManager.getConnection(url, usr, psw);
		} catch (ClassNotFoundException ex) {
			System.out.println("Error >> Driver no Instalado!!");
		} catch (SQLException ex) {
			System.out.println("Error >> de conexión con la BD");
		} catch (Exception ex) {
			System.out.println("Error >> general : " + ex.getMessage());
		}
		return con;
	}

	public static void closeConexion(Connection con) {

		try {
			con.close();// Sentencia para cerrar la conexión
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Problemas al cerrar la conexion");
		}
	}

}