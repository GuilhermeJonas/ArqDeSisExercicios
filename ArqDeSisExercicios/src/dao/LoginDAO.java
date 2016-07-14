package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import factory.ConexaoBD;
import to.ExtratoTO;
import to.LoginTO;

public class LoginDAO {
	@SuppressWarnings("static-access")
	private String idCliente, nome;
	public void carregarNome() throws SQLException{
		PreparedStatement stm = null;
		Connection conn = null;
		ConexaoBD bd = new ConexaoBD();
		String query = "select nome from cliente where id_cliente ="+idCliente;
		try {
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stm = conn.prepareStatement(query);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				nome = rs.getString(1);
			}
		} catch (SQLException e) {
			throw e;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void carregarDados(String conta, String agencia) throws SQLException{
		PreparedStatement stm = null;
		Connection conn = null;
		ConexaoBD bd = new ConexaoBD();
		String query = "select id_cliente from conta where numero_agencia = ? and numero_conta= ?";
		try {
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stm = conn.prepareStatement(query);
			stm.setString (1, agencia);
			stm.setString (2, conta);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			if (rs.next()) {
				idCliente = rs.getString(1);
			}
		} catch (SQLException e) {
			throw e;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public LoginTO geraTO(){
		LoginTO to = new LoginTO();
		to.setNome(nome);
		return to;
	}
	public String getNome(String conta, String agencia) throws SQLException{
		this.carregarDados(conta, agencia);
		this.carregarNome();
		return nome;
	}
}
