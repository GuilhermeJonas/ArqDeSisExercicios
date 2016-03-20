package test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import to.ExtratoTO;

public class ExtratoTOTest {
	ExtratoTO to ;
	private static final double DELTA = 1e-15;
	@Before
	public void setUp() throws Exception {
		to = new ExtratoTO();
		to.setIdMovimento(1);
		to.setTipoMovimento(2);
		to.setValor(10.0);
		to.setData("14-03-2016");
	}

	@Test
	public void testGets() {
		assertEquals("getIdMovimento", to.getIdMovimento(), 1);
		assertEquals("getTipoMovimento", to.getTipoMovimento(), 2);
		assertEquals("", to.getValor(), 10.0, DELTA);
		assertEquals("getData", to.getData(), "14-03-2016");
	}

	@Test
	public void testEquals(){
		ExtratoTO copia = new ExtratoTO();
		copia.setIdMovimento(to.getIdMovimento());
		copia.setTipoMovimento(to.getTipoMovimento());
		copia.setValor(to.getValor());
		copia.setData(to.getData());
		assertEquals("teste to igual a copia", to.getIdMovimento(), copia.getIdMovimento());
		assertEquals("teste to igual a copia", to.getTipoMovimento(), copia.getTipoMovimento());
		assertEquals("teste to igual a copia", to.getValor(), copia.getValor(),DELTA);
		assertEquals("teste to igual a copia", to.getData(), copia.getData());
	}

}
