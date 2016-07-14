package command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Saque;
import to.SaqueTO;

public class SaqueController implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		// TODO Auto-generated method stub
		String pBanco = request.getParameter("banco");
		String pAgencia = request.getParameter("agencia");
		String pConta = request.getParameter("conta");
		String pValor = request.getParameter("valor");
		String pData = request.getParameter("data");
		double valor;
		int agencia,conta, banco;
		try{
			valor = Double.parseDouble(pValor);
		}catch(Exception e ){
			valor = 0.0;
		}
		try{
			agencia = Integer.parseInt(pAgencia);
		}catch(Exception e ){
			agencia = 0;
		}
		try{
			conta = Integer.parseInt(pConta);
		}catch(Exception e ){
			conta = 0;
		}
		try{
			banco = Integer.parseInt(pBanco);
		}catch(Exception e ){
			banco = 0;
		}

		Saque saque = new Saque(0, valor);
		HttpSession session = request.getSession();
		
			try {
				saque.inserirSaque(0, valor, conta, agencia, banco, pData);
			} catch (Exception e) {
				e.printStackTrace();
			}
			SaqueTO to = new SaqueTO(0, valor, conta, agencia, banco, pData);
			session.setAttribute("saque", to);
			RequestDispatcher view = request.getRequestDispatcher("Saque.jsp");
			view.forward(request, response);
		
		
	}

}
