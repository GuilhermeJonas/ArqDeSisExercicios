package exercicio01.saque.beans;

import java.util.ArrayList;
import java.util.List;

public class Banco {
	private String nomeBanco;
	private int numBanco;
	private List<Banco> bancos;


	public Banco() {
		super();
		bancos = new ArrayList<Banco>();
	}
	public Banco(int numBanco) {
		this.numBanco = numBanco;
		this.bancos = new ArrayList<Banco>();
	}
	public String getNomeBanco() {
		return nomeBanco;
	}
	public void setNomeBanco(String nomeBanco) {
		this.nomeBanco = nomeBanco;
	}
	public int getNumBanco() {
		return numBanco;
	}
	public void setNumBanco(int numBanco) {
		this.numBanco = numBanco;
	}
	public List<Banco> getBancos() {
		return bancos;
	}
	public void instanceBancos(){
		bancos = new ArrayList<Banco>();
	}
	public void setBancos(List<Banco> bancos) {
		this.bancos = bancos;
	}

}
