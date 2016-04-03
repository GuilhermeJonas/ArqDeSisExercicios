package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import to.SaqueTO;

public class SaqueTOTest {
SaqueTO to, novo;
private static final double DELTA = 1e-15;
	@Before
	public void setUp() throws Exception {
		to = new SaqueTO();
		to.setData("20-03-2016");
		to.setIdMovimento(1);
		to.setNumAgencia(4640);
		to.setNumBanco(341);
		to.setNumConta(99900);
		to.setQuantidade(1);
		to.setTipoMovimento(0);
		to.setValor(10.0);
	}

	@Test
	public void getsTest() {
		assertEquals("Connection", null);
		assertEquals("Data", "20-03-2016", to.getData());
		assertEquals("Id Movimento",1, to.getIdMovimento());
		assertEquals("Agencia", 4640, to.getNumAgencia());
		assertEquals("Banco", 341, to.getNumBanco());
		assertEquals("Conta", 99900, to.getNumConta());
		assertEquals("Quantidade", 1, to.getQuantidade());
		assertEquals("Tipo",0, to.getTipoMovimento());
		assertEquals("Valor", 10.0, to.getValor(), DELTA);
	}
	public void setsTest(){
		novo = new SaqueTO();
		novo.setData(to.getData());
		novo.setIdMovimento(to.getIdMovimento());
		novo.setNumAgencia(to.getNumAgencia());
		novo.setNumBanco(to.getNumBanco());
		novo.setNumConta(to.getNumConta());
		novo.setQuantidade(to.getQuantidade());
		novo.setTipoMovimento(to.getTipoMovimento());
		novo.setValor(to.getValor());
		
		assertEquals("Data",        to.getData(),          novo.getData());
		assertEquals("Id Movimento",to.getIdMovimento(),   novo.getIdMovimento());
		assertEquals("Agencia",     to.getNumAgencia(),    novo.getNumAgencia());
		assertEquals("Banco",       to.getNumBanco(),      novo.getNumBanco());
		assertEquals("Conta",       to.getNumConta(),      novo.getNumConta());
		assertEquals("Quantidade",  to.getQuantidade(),    novo.getQuantidade());
		assertEquals("Tipo",        to.getTipoMovimento(), novo.getTipoMovimento());
		assertEquals("Valor",       to.getValor(),         novo.getValor(),  DELTA);
	}

}
