package exercicio01.saque;

import exercicio01.saque.LogDAO;

public class Log
{
	public Log(){

	}

	public void gravarLog(String texto){
		LogDAO logDAO = new LogDAO();
		logDAO.gravarLog(texto);
	}
}
