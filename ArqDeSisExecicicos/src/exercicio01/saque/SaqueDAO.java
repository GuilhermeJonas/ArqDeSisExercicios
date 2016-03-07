package exercicio01.saque;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SaqueDAO {
	public void inserirMovimento(Connection conn, int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) throws SQLException{
		PreparedStatement stm = null;
		String sqlInsert = new StringBuilder()
		.append("insert into movimento values(0,?,?,?,?,?,?)").toString();

		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, tipoMovimento);
			stm.setDouble(2, valor);
			stm.setInt(3, numConta);
			stm.setInt(4, numAgencia);
			stm.setInt(5, numBanco);
			stm.setDate(6, Date.valueOf(data));
			stm.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public int consultaMovimento(Connection conn,double valor,int numConta, int numAgencia, int numBanco) throws SQLException{
		int idMovimento = 0;
		PreparedStatement stm = null;
		String sqlSelect = new StringBuilder()
		.append("select max(id_movimento) ")
		.append("  from movimento         ")
		.append(" where numero_conta = ?  ")
		.append("   and numero_agencia = ?")
		.append("   and numero_banco = ?  ")
		.append("   and valor = ?         ").toString();

		try {
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, numConta);
			stm.setInt(2, numAgencia);
			stm.setInt(3, numBanco);
			stm.setDouble(4, valor);

			ResultSet rs = stm.executeQuery();
			if (rs.next()) idMovimento = rs.getInt(1);

		} catch (SQLException e) {
			throw e;
		}
		return idMovimento;

	}
	public void inserirSaque(Connection conn, int tipoMovimento, int id_movimento) throws SQLException{
		PreparedStatement stm = null;
		String sqlInsert = new StringBuilder()
		.append("insert into saque values(?,?)").toString();

		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, tipoMovimento);
			stm.setInt(2, id_movimento);
			stm.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public void insertOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		PreparedStatement stm = null;
		String sqlInsert = new StringBuilder()
		.append("insert into operacao values(?,?,?)").toString();

		try {
			stm = conn.prepareStatement(sqlInsert);
			stm.setInt(1, tipoMovimento);
			stm.setDate(2, Date.valueOf(data));
			stm.setInt(3, quantidade);
			stm.execute();

		} catch (SQLException e) {
			throw e;
		}
	}
	public void updateOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		PreparedStatement stm = null;
		String sqlUpdate = new StringBuilder()
		.append("update operacao set quantidade_operacao= ? " +
				"  where tipo_movimento= ?                  " +
				"    and data_operacao= ?                   ").toString();

		try {
			stm = conn.prepareStatement(sqlUpdate);
			stm.setInt(1, quantidade);
			stm.setInt(2,  tipoMovimento);
			stm.setDate(3, Date.valueOf(data));
			stm.execute();

		} catch (SQLException e) {
			throw e;
		}
	}
	public String selectOperacao(Connection conn, int tipoMovimento, String data) throws SQLException{
		PreparedStatement stm = null;
		String dataResult="";
		String sqlSelect = new StringBuilder()
		.append("select data_operacao     " +
				"  from operacao          " +
				"  where tipo_movimento= ?" +
				"    and data_operacao= ? ").toString();
		try {
			stm = conn.prepareStatement(sqlSelect);
			stm.setInt(1, tipoMovimento);
			stm.setDate(2, Date.valueOf(data));
			ResultSet rs = stm.executeQuery();
			if (rs.next()) dataResult = String.valueOf(rs.getDate(1));


		} catch (SQLException e) {
			throw e;
		}
		return dataResult;
	}
	public int selectQutddOperacao(Connection conn, int tipoMovimento, String data) throws SQLException{
		PreparedStatement stm = null;
		int quantidade=0;
		String sqlSelectOpr = new StringBuilder()
		.append("select quantidade_operacao     " +
				"  from operacao          " +
				"  where tipo_movimento= ?" +
				"    and data_operacao= ? ").toString();
		try {
			stm = conn.prepareStatement(sqlSelectOpr);
			stm.setInt(1, tipoMovimento);
			stm.setDate(2, Date.valueOf(data));
			ResultSet rs = stm.executeQuery();
			if (rs.next()) quantidade = rs.getInt(1);


		} catch (SQLException e) {
			throw e;
		}
		return quantidade;
	}

}
