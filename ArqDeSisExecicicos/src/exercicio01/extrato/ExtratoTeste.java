package exercicio01.extrato;

import java.sql.Connection;
import java.sql.SQLException;


public class ExtratoTeste {
	public static void main(String[] args) {
		Connection conn = null;
		Extrato extrato = new Extrato();
		int numConta = 99900;
		String data = "2015-05-14";
		ConexaoBD bd = new ConexaoBD();
		try {
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
			extrato.carregarDados(conn,numConta, data);

		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
				System.out.println(extrato.getExtrato().toString());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
