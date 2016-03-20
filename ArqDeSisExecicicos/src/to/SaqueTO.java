package to;

import java.sql.Connection;

public class SaqueTO {
	private int tipoMovimento;
	private double valor;
	private int id_movimento;
	private int numConta;
	private Connection conn;
	private int numAgencia;
	private int numBanco;
	private int quantidade;
	private String data;
	public SaqueTO(){}
	public SaqueTO(Connection conn, int tipoMovimento, double valor, int numConta, int numAgencia, int numBanco, String data) {
		this.setConn(conn);
		this.tipoMovimento = tipoMovimento;
		this.valor = valor;
		this.setNumConta(numConta);
		this.setNumAgencia(numAgencia);
		this.setNumBanco(numBanco);
		this.setData(data);
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
	public int getIdMovimento() {
		return id_movimento;
	}
	public void setIdMovimento(int id_movimento) {
		this.id_movimento = id_movimento;
	}
	public int getNumConta() {
		return numConta;
	}
	public void setNumConta(int numConta) {
		this.numConta = numConta;
	}
	public Connection getConn() {
		return conn;
	}
	public void setConn(Connection conn) {
		this.conn = conn;
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
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}


}
