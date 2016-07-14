package to;

public class LoginTO {
	private String banco, agencia, conta, senha,nome;
	
	public LoginTO(){
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
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
}
