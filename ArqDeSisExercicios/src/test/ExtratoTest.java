package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Extrato;

import org.junit.Before;
import org.junit.Test;

public class ExtratoTest {

		Extrato extrato, copia;

	@Before
	public void setUp() throws Exception {
		extrato = new Extrato();

	}

	@Test
	public final void testCarregarDados() {
		try {
			extrato.carregarDados(99900, "2015-05-15");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertNotNull("Teste Extrato não nullo ", extrato);
	}

}
