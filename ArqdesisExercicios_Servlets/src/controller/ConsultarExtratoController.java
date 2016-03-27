package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Extrato;

/**
 * Servlet implementation class ConsultarExtratoController
 */
@WebServlet("/consultar_extrato.do")
public class ConsultarExtratoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultarExtratoController() {
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
		
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Cliente Cadastrado</title></head><body>");
		out.println("<h3>Consultar Extrato</h3>");
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Id Movimento</th>");
		out.println("<th>Tipo Movimento</th>");
		out.println("<th>Valor</th>");
		out.println("<th>Data</th>");
		out.println("</tr>");
		
		for (Extrato ext : extrato.getExtrato()) {
			out.println("<tr>");
			out.println("<td>"+ext.getIdMovimento() +"</td>");
			out.println("<td>"+ext.getTipoMovimento() +"</td>");
			out.println("<td>"+ext.getValor() +"</td>");
			out.println("<td>"+ext.getData() +"</td>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body></html>");

	}

}
