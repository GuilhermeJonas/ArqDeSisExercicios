package exercicio01.saque;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exercicio01.saque.Notas;

public class NotasDAO {
	ArrayList<Notas> resultNotas = new ArrayList<>();
	public ArrayList<Notas> carregarDados(Connection conn) throws SQLException{
		PreparedStatement stm = null;
		String query = "select * from dispenser";
		try {
			stm = conn.prepareStatement(query);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				Notas extrairRelatorioDeNotas = new Notas();
				extrairRelatorioDeNotas.setNota      (rs.getInt   (1));
				extrairRelatorioDeNotas.setQuantidade(rs.getInt   (2));
				resultNotas.add(extrairRelatorioDeNotas);
			}
		} catch (SQLException e) {
			throw e;
		}
		return resultNotas;
	}
	public void atualizarNota(Connection conn,int qntdNota, int nota) throws SQLException{
		PreparedStatement stm = null;
		String queryUpdate = "update dispenser set quantidade_nota =? where nota = ?";
		try {
			stm = conn.prepareStatement(queryUpdate);
			stm.setInt(1, qntdNota);
			stm.setInt(2, nota);
			stm.executeUpdate();

		} catch (Exception e) {
			throw e;
		}

	}
}
