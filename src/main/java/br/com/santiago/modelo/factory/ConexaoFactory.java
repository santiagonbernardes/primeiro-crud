package br.com.santiago.modelo.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	private static String url = "jdbc:postgresql://localhost:5432/primeirocrud";
	private static String usuario = "postgres";
	private static String senha = "123456";

	public Connection getConexao() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection(url, usuario, senha);
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e.getMessage());
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
