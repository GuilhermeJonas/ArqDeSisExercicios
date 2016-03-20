package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import to.SaqueTO;

import dao.SaqueDAO;
import factory.ConexaoBD;

public class SaqueDAOTest {
SaqueDAO dao;
SaqueTO  to;
ConexaoBD conn;
	@Before
	public void setUp() throws Exception {
		dao = new SaqueDAO();
		to = new SaqueTO(null, 0, 10.0, 99900, 4640, 341, "2015-11-30");
		conn = new ConexaoBD();
	}

	@Test
	public void test() {
		try {
			dao.inserirSaque(conn.obtemConexao(), 0, 1);
		} catch (SQLException e1) {
			fail("Falha ao obter conexão");
		}
		
		try {
			assertEquals(1, dao.consultaMovimento(to));
		} catch (SQLException e) {
			fail("Falha na conexão");
			e.printStackTrace();
		}
	}

}
