package test;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import to.ExtratoTO;
import dao.ExtratoDAO;

public class ExtratoDAOTest {

	ExtratoDAO dao;
	ArrayList<ExtratoTO> to;


	@Before
	public void setUp() throws Exception {
		dao = new ExtratoDAO();
		to = new ArrayList<>();
		ExtratoTO extrato1 = new ExtratoTO(1, 0, 10.0, "2015-05-15");
		ExtratoTO extrato2 = new ExtratoTO(2, 1,  5.0, "2015-09-17");
		ExtratoTO extrato3 = new ExtratoTO(3, 1, 50.0, "2015-09-18");
		ExtratoTO extrato4 = new ExtratoTO(4, 1, 50.0, "2015-10-28");
		ExtratoTO extrato5 = new ExtratoTO(5, 1, 25.0, "2015-11-30");
		ExtratoTO extrato6 = new ExtratoTO(6, 1, 25.0, "2015-12-21");
		to.add(extrato1);
		to.add(extrato2);
		to.add(extrato3);
		to.add(extrato4);
		to.add(extrato5);
		to.add(extrato6);
	}

	@Test
	public final void testCarregarDados() {
		ArrayList <ExtratoTO> fixtures = new ArrayList<>();

		try {
			fixtures = dao.carregarDados(99900, "2015-05-14");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals("Arrays not the same length", to.size(), fixtures.size());
		for (int i = 0; i < to.size(); i++){
			assertEquals("Teste ",to.get(i).getIdMovimento(), fixtures.get(i).getIdMovimento());
		}


	}

}
