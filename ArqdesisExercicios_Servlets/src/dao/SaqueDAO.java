package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import factory.ConexaoBD;
import to.SaqueTO;

public class SaqueDAO {
	public void inserirMovimento(SaqueTO saqueTO) throws SQLException{
		String sqlInsert = new StringBuilder()
		.append("insert into movimento values(0,?,?,?,?,?,?)").toString();
		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt   (1, saqueTO.getTipoMovimento());
			stm.setDouble(2, saqueTO.getValor());
			stm.setInt   (3, saqueTO.getNumConta());
			stm.setInt   (4, saqueTO.getNumAgencia());
			stm.setInt   (5, saqueTO.getNumBanco());
			stm.setDate  (6, Date.valueOf(saqueTO.getData()));
			stm.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public int consultaMovimento(SaqueTO saqueTO) throws SQLException{
		int idMovimento = 0;
		String sqlSelect = new StringBuilder()
		.append("select max(id_movimento) ")
		.append("  from movimento         ")
		.append(" where numero_conta = ?  ")
		.append("   and numero_agencia = ?")
		.append("   and numero_banco = ?  ")
		.append("   and valor = ?         ").toString();

		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt   (1, saqueTO.getNumConta());
			stm.setInt   (2, saqueTO.getNumAgencia());
			stm.setInt   (3, saqueTO.getNumBanco());
			stm.setDouble(4, saqueTO.getValor());

			ResultSet rs = stm.executeQuery();
			if (rs.next()) idMovimento = rs.getInt(1);

		} catch (SQLException e) {
			throw e;
		}
		return idMovimento;

	}
	public void inserirSaque(int tipoMovimento, int id_movimento) throws SQLException{
		String sqlInsert = new StringBuilder()
		.append("insert into saque values(?,?)").toString();

		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt(1, tipoMovimento);
			stm.setInt(2, id_movimento);
			stm.execute();
		} catch (SQLException e) {
			throw e;
		}
	}
	public void insertOperacao(SaqueTO saqueTO) throws SQLException{
		String sqlInsert = new StringBuilder()
		.append("insert into operacao values(?,?,?)").toString();

		try (Connection conn = ConexaoBD.obtemConexao();
			 PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			stm.setInt (1, saqueTO.getTipoMovimento());
			stm.setDate(2, Date.valueOf(saqueTO.getData()));
			stm.setInt (3, saqueTO.getQuantidade());
			stm.execute();

		} catch (SQLException e) {
			throw e;
		}
	}
	public void updateOperacao(SaqueTO saqueTO) throws SQLException{
		String sqlUpdate = new StringBuilder()
		.append("update operacao set quantidade_operacao= ? " +
				"  where tipo_movimento= ?                  " +
				"    and data_operacao= ?                   ").toString();

		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			stm.setInt (1, saqueTO.getQuantidade());
			stm.setInt (2,  saqueTO.getTipoMovimento());
			stm.setDate(3, Date.valueOf(saqueTO.getData()));
			stm.execute();

		} catch (SQLException e) {
			throw e;
		}
	}
	public String selectOperacao(SaqueTO saqueTO) throws SQLException{
		String dataResult="";
		String sqlSelect = new StringBuilder()
		.append("select data_operacao     " +
				"  from operacao          " +
				"  where tipo_movimento= ?" +
				"    and data_operacao= ? ").toString();
		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt (1, saqueTO.getTipoMovimento());
			stm.setDate(2, Date.valueOf(saqueTO.getData()));
			ResultSet rs = stm.executeQuery();
			if (rs.next()) dataResult = String.valueOf(rs.getDate(1));


		} catch (SQLException e) {
			throw e;
		}
		return dataResult;
	}
	public int selectQutddOperacao(SaqueTO saqueTO) throws SQLException{
		int quantidade=0;
		String sqlSelectOpr = new StringBuilder()
		.append("select quantidade_operacao     " +
				"  from operacao          " +
				"  where tipo_movimento= ?" +
				"    and data_operacao= ? ").toString();
		try (Connection conn = ConexaoBD.obtemConexao();
			PreparedStatement stm = conn.prepareStatement(sqlSelectOpr);) {
			stm.setInt (1, saqueTO.getTipoMovimento());
			stm.setDate(2, Date.valueOf(saqueTO.getData()));
			ResultSet rs = stm.executeQuery();
			if (rs.next()) quantidade = rs.getInt(1);


		} catch (SQLException e) {
			throw e;
		}
		return quantidade;
	}

}
