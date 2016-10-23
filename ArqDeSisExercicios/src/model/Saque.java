package model;

import java.sql.SQLException;

import to.SaqueTO;

import dao.SaqueDAO;

public class Saque {
	private int tipoMovimento;
	private double valor;
	private SaqueDAO saqueDAO;
	private int numConta;
	private int numAgencia;
	private int numBanco;
	private String data;
	public Saque(int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) {
		super();
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.numConta = numConta;
		this.numAgencia = numAgencia;
		this.numBanco = numBanco;
		this.data = data;
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

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public int getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public int getNumBanco() {
		return numBanco;
	}
	public void setNumBanco(int numBanco) {
		this.numBanco = numBanco;
	}
	public void inserirSaque(int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) throws Exception{
		try {
			SaqueTO saqueTO = new SaqueTO(tipoMovimento, valor, numConta, numAgencia, numBanco, data);
			saqueDAO.inserirMovimento(saqueTO);
			saqueTO.setIdMovimento(saqueDAO.consultaMovimento(saqueTO));
			saqueDAO.inserirSaque(tipoMovimento, saqueTO.getIdMovimento());
		} catch (Exception e) {
			throw e;
		}
	}
	public void inserirSaque() throws Exception{
		try {
			SaqueTO saqueTO = new SaqueTO(tipoMovimento, valor, numConta, numAgencia, numBanco, data);
			saqueDAO.inserirMovimento(saqueTO);
			saqueTO.setIdMovimento(saqueDAO.consultaMovimento(saqueTO));
			saqueDAO.inserirSaque(tipoMovimento, saqueTO.getIdMovimento());
		} catch (Exception e) {
			throw e;
		}
	}
	public void insertOperacao(int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(data);
			saqueTO.setQuantidade(quantidade);
			saqueDAO.insertOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
	}
	public void updateOperacao(int tipoMovimento, String data, int quantidade) throws SQLException{
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(data);
			saqueTO.setQuantidade(quantidade);
			saqueDAO.updateOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
	}
	public String selectOperacao(int tipoMovimento, String dataOpr) throws SQLException{
		String data = "";
		try {
			SaqueTO saqueTO = new SaqueTO();
			saqueTO.setTipoMovimento(tipoMovimento);
			saqueTO.setData(dataOpr);
			data = saqueDAO.selectOperacao(saqueTO);
		} catch (Exception e) {
			throw e;
		}
		return data;
	}
	public int selectQutddOperacao(int tipoMovimento, String data) throws SQLException{
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
