package exercicio01.saque.beans;

import java.sql.Connection;
import java.sql.SQLException;

import exercicio01.saque.Acesso;
import exercicio01.saque.ContaDAO;

public class Conta {
	private String numConta;
	private String senha;
	private double saldo;
	private ContaDAO contaDAO;
	private Banco banco;
	private Agencia agencia;
	private Acesso acesso;
	private String nome;
	private int contador;

	public Conta() {
		super();
		this.contaDAO = new ContaDAO();
	}
	public Conta(String numConta, String senha, int numAgencia, int numBanco) {
		super();
		this.numConta = numConta;
		this.senha = senha;
		this.agencia = new Agencia(numAgencia);
		this.banco = new Banco(numBanco);
		this.acesso = new Acesso();
		this.contaDAO = new ContaDAO();

	}
	public String getNumConta() {
		return numConta;
	}
	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void incrementaContador(){
		contador++;
	}
	public int getContador(){
		return contador;
	}
	public Banco getBanco() {
		return banco;
	}
	public void setBanco(Banco banco) {
		this.banco = banco;
	}
	public Agencia getAgencia() {
		return agencia;
	}
	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}
	public Acesso getAcesso() {
		return acesso;
	}
	public void setAcesso(Acesso acesso) {
		this.acesso = acesso;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double consultaSaldo(Connection conn, int numConta, int numAgencia, int numBanco) throws Exception{
		try {
			this.saldo = contaDAO.consultaSaldo(conn, numConta, numAgencia, numBanco);
		} catch (Exception e) {
			throw e;
		}
		return saldo;
	}
	public void atualizarSaldo(Connection conn, double saldo, int numConta) throws Exception{
		try {
			contaDAO.atualizarSaldo(conn, saldo, numConta);
		} catch (Exception e) {
			throw e;
		}

	}
	public boolean validarConta(Connection conn, int numConta, int numAgencia, int numBanco) throws Exception{
		boolean contaValida = false;
		try {
			 contaValida =contaDAO.validarConta(conn, numConta, numAgencia, numBanco);
		} catch (Exception e) {
			throw e;
		}
		return contaValida;
	}
	public void setNomeCliente(Connection conn,int numConta, int numAgencia, int numBanco) throws Exception{
		try {
			this.nome = contaDAO.getNomeCliente(conn, numConta, numAgencia, numBanco);
		} catch (Exception e) {
			throw e;
		}
	}
	public void inserirBloqueio(Connection conn, int conta)throws SQLException{
		try{
			contaDAO.insereBloqueio(conn,conta);
		}catch(Exception e){
			throw e;
		}
	}
	public void zeraContador() {
		contador = 0;
	}


}
