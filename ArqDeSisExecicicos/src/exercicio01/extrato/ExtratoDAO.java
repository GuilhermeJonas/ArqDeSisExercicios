package exercicio01.extrato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ExtratoDAO {
	ArrayList<ExtratoTO> resultExtrato = new ArrayList<>();
	public ArrayList<ExtratoTO> carregarDados(Connection conn, int numConta, String data) throws SQLException{
		PreparedStatement stm = null;
		String query = "select id_movimento, tipo_movimento, valor, data_movimento from movimento where numero_conta = ? and data_movimento > ? order by data_movimento";
		try {
			stm = conn.prepareStatement(query);
			stm.setInt    (1, numConta);
			stm.setString (2, data);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ExtratoTO extrato = new ExtratoTO();
				extrato.setIdMovimento  (rs.getInt   (1));
				extrato.setTipoMovimento(rs.getInt   (2));
				extrato.setValor        (rs.getInt   (3));
				extrato.setData         (rs.getString(4));
				resultExtrato.add(extrato);
			}
		} catch (SQLException e) {
			throw e;
		}
		return resultExtrato;
	}
}
