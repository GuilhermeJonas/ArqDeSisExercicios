package command;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Extrato;
import model.Login;
import to.ExtratoTO;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/logar.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
		request.setCharacterEncoding("UTF-8");
		String pNumConta = request.getParameter("numConta");
		String pNumAgencia = request.getParameter("numAgencia");
		String pNumBanco = request.getParameter("numBanco");
		String pSenha = request.getParameter("senha");
		String nome = "";

		Login login = new Login(pNumBanco, pNumAgencia, pNumConta, pSenha);
		HttpSession session = request.getSession();

		try {
			login.setNome();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		nome = login.getNome();
		session.setAttribute("nome", nome);
		
		RequestDispatcher view = request.getRequestDispatcher("menuUser.jsp");
		view.forward(request, response);

	}

}
