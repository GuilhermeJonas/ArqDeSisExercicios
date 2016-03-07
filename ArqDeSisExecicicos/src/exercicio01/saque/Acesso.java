package exercicio01.saque;

import exercicio01.saque.beans.Agencia;
import exercicio01.saque.beans.Banco;
import exercicio01.saque.beans.Conta;
import exercicio01.saque.AcessoDAO;

public class Acesso {

	private AcessoDAO acessoDAO;
	private boolean flagCodigo;
	public Acesso() {
		acessoDAO = new AcessoDAO();
	}
	public Acesso(String numConta, String senha, int numBanco, int numAgencia){
		acessoDAO = new AcessoDAO();

	}
	public boolean validarAcesso(Conta conta, Agencia agencia, Banco banco){
		flagCodigo = false;
		acessoDAO.geraMatriz();
	    flagCodigo = AcessoDAO.buscaBinaria(acessoDAO.getContaesenha(), Integer.parseInt(conta.getNumConta()), Integer.parseInt(conta.getSenha() ));
	    return flagCodigo;

	}


}
