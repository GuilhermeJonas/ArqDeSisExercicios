package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import factory.ConexaoBD;

import to.*;

public class ExtratoDAO {
	ArrayList<ExtratoTO> resultExtrato = new ArrayList<>();
	@SuppressWarnings("static-access")
	public ArrayList<ExtratoTO> carregarDados(int numConta, String data) throws SQLException{
		PreparedStatement stm = null;
		Connection conn = null;
		ConexaoBD bd = new ConexaoBD();
		String query = "select id_movimento, tipo_movimento, valor, data_movimento from movimento where numero_conta = ? and data_movimento >= ? order by data_movimento";
		try {
			conn = bd.obtemConexao();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			stm = conn.prepareStatement(query);
			stm.setInt    (1, numConta);
			stm.setString (2, data);
			stm.execute();
			ResultSet rs = stm.executeQuery();
			while (rs.next()) {
				ExtratoTO  to = new ExtratoTO();
				to.setIdMovimento  (rs.getInt   (1));
				to.setTipoMovimento(rs.getInt   (2));
				to.setValor        (rs.getInt   (3));
				to.setData         (rs.getString(4));
				resultExtrato.add(to);
			}
		} catch (SQLException e) {
			throw e;
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultExtrato;
	}
}
