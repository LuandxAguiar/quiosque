package br.senai.sp.quiosquel.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	private static final String USER = "root";
	private static final String SENHA = "";
	
	public static Connection conectar() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/quiosque", USER, SENHA);
			return conexao;
		} catch (Exception e) {
			//jogando o erro para view. aparecer no navegador
			throw new RuntimeException(e);
		}
	}
}
