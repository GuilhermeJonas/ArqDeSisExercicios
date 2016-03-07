package exercicio01.saque;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConexaoBD{
	private ResourceBundle bundle;


	// -----------------------------------------------------------

	// Carrega driver JDBC



	static{

		try{
			Class.forName("com.mysql.jdbc.Driver");


		}catch (ClassNotFoundException e){
			throw new RuntimeException(e);

		}
	}
	// Obt�m conex�o com o banco de dados
	public Connection obtemConexao() throws SQLException{

		return DriverManager.getConnection("jdbc:mysql://localhost/caixaeletronico?user=alunos&password=alunos");

	}

}