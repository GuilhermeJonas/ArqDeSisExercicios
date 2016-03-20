package model;

import java.sql.Connection;
import java.sql.SQLException;

import to.SaqueTO;

import dao.SaqueDAO;

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
			SaqueTO saqueTO = new SaqueTO(conn, tipoMovimento, valor, numConta, numAgencia, numBanco, data);
			saqueDAO.inserirMovimento(saqueTO);
			saqueTO.setIdMovimento(saqueDAO.consultaMovimento(saqueTO));
			saqueDAO.inserirSaque(conn, tipoMovimento, saqueTO.getIdMovimento());
		} catch (Exception e) {
			throw e;
		}
	}
	public void insertOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setConn(conn);
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(data);
			saqueTO.setQuantidade(quantidade);
			saqueDAO.insertOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
	}
	public void updateOperacao(Connection conn, int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setConn(conn);
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(data);
			saqueTO.setQuantidade(quantidade);
			saqueDAO.updateOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
	}
	public String selectOperacao(Connection conn, int tipoMovimento, String dataOpr) throws SQLException{
		String data = "";
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setConn(conn);
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(dataOpr);
			data = saqueDAO.selectOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
		return data;
	}
	public int selectQutddOperacao(Connection conn, int tipoMovimento, String data) throws SQLException{
		int quantidade = 0;
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(data);
			quantidade = saqueDAO.selectQutddOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
		return quantidade;
	}

}
