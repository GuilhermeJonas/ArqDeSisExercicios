package model;

import java.sql.SQLException;

import dao.LoginDAO;

public class Login {
	private String banco, agencia, conta, senha, nome;
	
	public Login(String banco, String agencia, String conta, String senha){
		this.banco = banco;
		this.agencia = agencia;
		this.conta = conta;
		this.senha = senha;
	}
	
	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getConta() {
		return conta;
	}

	public void setConta(String conta) {
		this.conta = conta;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	public void setNome() throws SQLException{
		LoginDAO dao = new LoginDAO();
		nome = dao.getNome(conta, agencia);
	}
	public String getNome(){
		return nome;
	}
}
