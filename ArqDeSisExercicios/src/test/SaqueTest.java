package test;

import static org.junit.Assert.*;

import java.sql.SQLException;

import model.Saque;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import factory.ConexaoBD;

public class SaqueTest {
	ConexaoBD conn;
	Saque saque = null;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() throws Exception {
		saque = new Saque(0, 10.0,0,0,0,"");
	}

	@Test
	public void getsTest() {
		assertEquals("Tipo",  0   , saque.getTipoMovimento());
		assertEquals("Valor", 10.0, saque.getValor(), DELTA);
	}
	@Test
	public void inserirTest(){
		conn = new ConexaoBD();
		try {
			saque.inserirSaque(0, 10.0, 99900, 4640, 341, "20-03-2016");
		} catch (Exception e) {
			fail("Falha inserir saque");
		}
	}

	@Test
	public void qtdTest(){
		try {
			assertNotNull("Não nulo para qtd de operações no banco", saque.selectQutddOperacao(0, "20-03-2016"));
		} catch (SQLException e) {
			fail("falha no metodo qtd operação");
		}
	}
	@Test
	public void inserirOperacaoTest(){
		try {
			saque.insertOperacao(0, "20-03-2016", 1);
		} catch (SQLException e) {
			fail("falha no metodo inserir operação");
		}
	}
	@Test
	public void updateOperacaoTest(){
		try {
			saque.updateOperacao(0, "20-03-2016", 1);
		} catch (SQLException e) {
			fail("falha no metodo atualizar operação");
		}
	}
	@Test
	public void selectOperacaoEQtd(){
		try {
			assertNotNull(saque.selectOperacao(0, "20-03-2016"));
		} catch (SQLException e) {
			fail("falha no metodo selecionar operação");
		}
		try {
			assertNotNull(saque.selectQutddOperacao(0, "20-03-2016"));
		} catch (SQLException e) {
			fail("falha no metodo selecionar quantidade de  operações");
		}
	}
}
