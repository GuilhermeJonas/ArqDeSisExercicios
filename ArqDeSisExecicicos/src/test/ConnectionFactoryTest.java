package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.sql.SQLException;

import org.junit.Test;

import factory.ConexaoBD;

public class ConnectionFactoryTest {

	@Test
	public final void testObtemConexao() {
		try {
			assertNotNull("testa se a conexao nao e nula", ConexaoBD.obtemConexao());
		} catch (SQLException e) {
			e.printStackTrace();
			fail("gerou SQLException");
		}
	}

}
