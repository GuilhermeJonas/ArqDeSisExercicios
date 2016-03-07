package exercicio01.saque;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import exercicio01.saque.NotasDAO;

public class Notas{

	private int nota;
	private int quantidade;
	private NotasDAO relatorioDeNotasDAO;

	public Notas() {
		super();
		relatorioDeNotasDAO = new NotasDAO();
	}
	public void setNota(int nota) {
		this.nota = nota;
	}
	public int getNota() {
		return nota;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public ArrayList<Notas> carregarDados(Connection conn) throws SQLException{
		ArrayList<Notas> resultNotas = new ArrayList<>();
		try {
			relatorioDeNotasDAO = new NotasDAO();
			resultNotas = relatorioDeNotasDAO.carregarDados(conn);

		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return resultNotas;
	}
	public void atualizarNota(Connection conn, int qntdNota,int nota) throws SQLException{
		try {
			relatorioDeNotasDAO.atualizarNota(conn, qntdNota, nota);
		} catch (SQLException e) {
			throw e;
		}
	}


}
