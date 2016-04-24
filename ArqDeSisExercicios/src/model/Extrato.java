package model;

import java.sql.SQLException;
import java.util.ArrayList;

import to.ExtratoTO;
import dao.ExtratoDAO;
public class Extrato {
	private int idMovimento;
	private int tipoMovimento;
	private double valor;
	private String data;
	public Extrato(){}

	public Extrato(int idMovimento, int tipoMovimento, double valor,String data) {
		this.idMovimento = idMovimento;
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.data = data;
	}
	public int getIdMovimento() {
		return idMovimento;
	}
	public void setIdMovimento(int idMovimento) {
		this.idMovimento = idMovimento;
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

	public ArrayList<ExtratoTO> carregarDados(int numConta, String data) throws SQLException{
		ExtratoDAO extratoDAO = new ExtratoDAO();
		
		try {
			return extratoDAO.carregarDados(numConta, data);
	
		} catch (Exception e) {
			throw e;
		}

	}

	@Override
	public String toString() {
		return "\nExtrato [idMovimento=" + idMovimento + ", tipoMovimento="
				+ tipoMovimento + ", valor=" + valor + ", data=" + data + "]";
	}

}
