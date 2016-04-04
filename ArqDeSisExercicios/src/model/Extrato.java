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
	private ArrayList<Extrato> extrato;
	public Extrato(){
		this.extrato = new ArrayList<>();
	}

	public Extrato(int idMovimento, int tipoMovimento, double valor,String data) {
		this.idMovimento = idMovimento;
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.data = data;
		this.extrato = new ArrayList<>();
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

	public ArrayList<Extrato> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<Extrato> extrato) {
		this.extrato = extrato;
	}

	public void carregarDados(int numConta, String data) throws SQLException{
		ExtratoDAO extratoDAO = new ExtratoDAO();
		ArrayList<ExtratoTO> resultExtrato = new ArrayList<>();
		try {
			resultExtrato =extratoDAO.carregarDados(numConta, data);
			for (ExtratoTO extratoTO : resultExtrato) {
				Extrato ext = new Extrato();
				ext.setIdMovimento(extratoTO.getIdMovimento());
				ext.setTipoMovimento(extratoTO.getTipoMovimento());
				ext.setValor(extratoTO.getValor());
				ext.setData(extratoTO.getData());
				this.getExtrato().add(ext);
			}

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
