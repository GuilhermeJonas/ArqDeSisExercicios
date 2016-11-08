package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Extrato;
import to.ExtratoTO;
import util.JSonFacade;

@WebServlet("/extrato")
public class ServicoConsultarExtrato extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*
	 * configurar a request e a response para todos os métodos
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		super.service(request, response);
	}
	/*
	 * listar Extrato
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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

		PrintWriter out = response.getWriter();

		try {
			lista = extrato.carregarDados(numConta, pData);
			out.println(JSonFacade.listToJSon(lista));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			out.println(JSonFacade.errorToJSon(e));
			response.sendError(99, "Erro no Extrato!");
		}
	}
}
