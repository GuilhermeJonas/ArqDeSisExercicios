package exercicio01.saque;

import java.sql.Connection;
import java.sql.SQLException;

import exercicio01.saque.SaqueDAO;

public class Saque {
	private int tipoMovimento;
	private double valor;
	private SaqueDAO saqueDAO;
	public Saque(int tipoMovimento, double valor) {
		super();
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.saqueDAO = new SaqueDAO();
	}
	public int getTipoMovimento() {
		return tipoMovimento;
	}
	public void setTipoMovimento(int tipoMovimento) {
		this.tipoMovimento = tipoMovimento;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public void inserirSaque(Connection conn, int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) throws Exception{
		try {
			saqueDAO.inserirMovimento(conn, tipoMovimento, valor, numConta, numAgencia, numBanco, data);
			int id_movimento = saqueDAO.consultaMovimento(conn,valor, numConta, numAgencia, numBanco);
			saqueDAO.inserirSaque(conn, tipoMovimento, id_movimento);
		} catch (Exception e) {
			throw e;
		}
	}
	public void insertOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			saqueDAO.insertOperacao(conn, tipoMovimento, data, quantidade);
		} catch (Exception e) {
			throw e;
		}
	}
	public void updateOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			saqueDAO.updateOperacao(conn, tipoMovimento, data, quantidade);
		} catch (Exception e) {
			throw e;
		}
	}
	public String selectOperacao(Connection conn, int tipoMovimento, String dataOpr) throws SQLException{
		String data = "";
		try {
			data = saqueDAO.selectOperacao(conn, tipoMovimento, dataOpr);
		} catch (Exception e) {
			throw e;
		}
		return data;
	}
	public int selectQutddOperacao(Connection conn, int tipoMovimento, String data) throws SQLException{
		int quantidade = 0;
		try {
			quantidade = saqueDAO.selectQutddOperacao(conn, tipoMovimento, data);
		} catch (Exception e) {
			throw e;
		}
		return quantidade;
	}

}
