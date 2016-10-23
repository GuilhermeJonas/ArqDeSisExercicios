package command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Extrato;
import to.ExtratoTO;

public class ExtratoController implements Command {
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{

		request.setCharacterEncoding("UTF-8");
		String pNumConta = request.getParameter("numConta");
		String pData = request.getParameter("data");
		int numConta;

		try {
			numConta = Integer.parseInt(pNumConta);
		} catch (NumberFormatException e) {
			numConta = 0;
			e.printStackTrace();
		}

		Extrato extrato = new Extrato();
		ArrayList<ExtratoTO> lista = null;
		HttpSession session = request.getSession();

		try {
			lista = extrato.carregarDados(numConta, pData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		session.setAttribute("lista", lista);

		RequestDispatcher view = request.getRequestDispatcher("extrato.jsp");
		view.forward(request, response);

	}

}
