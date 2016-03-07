package exercicio01.saque.beans;


public class Agencia {
	private int numAgencia;
	private String endereco;


	public Agencia() {
		super();
	}
	public Agencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public int getNumAgencia() {
		return numAgencia;
	}
	public void setNumAgencia(int numAgencia) {
		this.numAgencia = numAgencia;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
