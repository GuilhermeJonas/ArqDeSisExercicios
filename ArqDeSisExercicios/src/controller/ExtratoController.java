package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Extrato;
import to.ExtratoTO;

/**
 * Servlet implementation class ConsultarExtratoController
 */
@WebServlet("/consultar_extrato.do")
public class ExtratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExtratoController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pNumConta = request.getParameter("numConta");
		String pData = request.getParameter("data");
	//	String pAcao = request.getParameter("acao");
		int numConta;

		try {
			numConta = Integer.parseInt(pNumConta);
		} catch (NumberFormatException e) {
			numConta = 0;
			e.printStackTrace();
		}

		Extrato extrato = new Extrato();

		try {
			extrato.carregarDados(numConta, pData);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};

		ExtratoTO extratoTO = new ExtratoTO();
		for (Extrato ext : extrato.getExtrato()) {
			ExtratoTO to = new ExtratoTO();
			to.setIdMovimento(ext.getIdMovimento());
			to.setTipoMovimento(ext.getTipoMovimento());
			to.setValor(ext.getValor());
			to.setData(ext.getData());
			extratoTO.getExtrato().add(to);
		}
		request.setAttribute("lista", extratoTO);
		RequestDispatcher view = request.getRequestDispatcher("extrato.jsp");
		view.forward(request, response);

	}

}
