package to;

import java.util.ArrayList;

public class ExtratoTO {
	private int idMovimento;
	private int tipoMovimento;
	private double valor;
	private String data;
	private ArrayList<ExtratoTO> extrato;
	public ExtratoTO(){
		this.extrato = new ArrayList<>();
	}

	public ExtratoTO(int idMovimento, int tipoMovimento, double valor, String data) {
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

	public ArrayList<ExtratoTO> getExtrato() {
		return extrato;
	}

	public void setExtrato(ArrayList<ExtratoTO> extrato) {
		this.extrato = extrato;
	}
	
}
