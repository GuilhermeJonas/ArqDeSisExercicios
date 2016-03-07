package exercicio01.saque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContaDAO {

	public double consultaSaldo(Connection conn, int numConta, int numAgencia, int numBanco) throws SQLException{
		double saldo = 0.0;
		PreparedStatement stm = null;
		String sqlSelect = new StringBuilder()
		.append("select saldo             ")
		.append("  from conta             ")
		.append(" where numero_conta = ?  ")
		.append("   and numero_agencia = ?")
		.append("   and numero_banco = ?  ").toString();

		try {
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, numConta);
			stm.setInt(2, numAgencia);
			stm.setInt(3, numBanco);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) saldo = rs.getDouble(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return saldo;

	}
	public void atualizarSaldo(Connection conn, double saldo, int numConta) throws SQLException{
		PreparedStatement stm = null;
		String sqlUpdate = new StringBuilder()
		.append("update conta set saldo = ? ")
		.append(" where numero_conta = ?    ").toString();
		try {
			stm = conn.prepareStatement(sqlUpdate);
			stm.setDouble(1, saldo);
			stm.setInt(2, numConta);
			stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	public boolean validarConta(Connection conn, int numConta, int numAgencia, int numBanco) throws SQLException{
		boolean conta = false;
		PreparedStatement stm = null;
		String sqlSelectConta = new StringBuilder()
		.append("select id_conta          ")
		.append("  from conta             ")
		.append(" where numero_conta = ?  ")
		.append("   and numero_agencia = ?")
		.append("   and numero_banco = ?  ").toString();

		try {
			stm = conn.prepareStatement(sqlSelectConta);
			stm.setInt(1, numConta);
			stm.setInt(2, numAgencia);
			stm.setInt(3, numBanco);

			conta = stm.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return conta;

	}
	public String getNomeCliente(Connection conn,int numConta, int numAgencia, int numBanco ) throws SQLException{
		String nome = "";
		PreparedStatement stm = null;
		String sqlSelectConta = new StringBuilder()
		.append("select nome                                    ")
		.append("  from cliente                                 ")
		.append(" where id_cliente in (select id_cliente        ")
		.append("                        from conta             ")
		.append("					    where numero_conta = ?  ")
		.append("                         and numero_agencia = ?")
		.append("                         and numero_banco = ?) ").toString();

		try {
			stm = conn.prepareStatement(sqlSelectConta);
			stm.setInt(1, numConta);
			stm.setInt(2, numAgencia);
			stm.setInt(3, numBanco);
			ResultSet rs = stm.executeQuery();
			if (rs.next()) nome = rs.getString(1);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw e;
		}
		return nome;
	}
	public void insereBloqueio(Connection conn, int conta) throws SQLException {
		PreparedStatement stm = null;
		String sqlUpdate = new StringBuilder()
		.append("update conta set bloqueado = true ")
		.append(" where numero_conta = ?    ").toString();
		try {
			stm = conn.prepareStatement(sqlUpdate);
			stm.setDouble(1, conta);
			stm.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}


}
