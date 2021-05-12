/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author sarro
 */
public class CafeCapsulasTest {
	
	CafeCapsulas cafeCapsulasVacio;
	CafeCapsulas cafeCapsulasLleno;
	
	public CafeCapsulasTest() {
		
	}
	
	@Before
	public void setUp() {
		cafeCapsulasVacio = new CafeCapsulas();
		cafeCapsulasLleno = new CafeCapsulas(10, true, "nespresso");
	}
	
	@After
	public void tearDown() {
		
	}

	@Test
	public void testNumCapsulas() {
		assertEquals(cafeCapsulasVacio.numCapsulas, 0);
		assertEquals(cafeCapsulasLleno.getNumCapsulas(), 10);
		cafeCapsulasLleno.setNumCapsulas(30);
		assertEquals(cafeCapsulasLleno.getNumCapsulas(), 30);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumCapsulasException() {
		CafeCapsulas cafeCapsulasLleno2 = new CafeCapsulas(33, true, "nespresso");
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumCapsulasException2() {
		CafeCapsulas cafeCapsulasLleno2 = new CafeCapsulas(-4, true, "nespresso");
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumCapsulasException3() {
		CafeCapsulas cafeCapsulasLleno2 = new CafeCapsulas(7, true, "nespresso");
	}

	@Test
	public void testDuplo() {
		assertEquals(cafeCapsulasVacio.duplo, false);
		assertEquals(cafeCapsulasLleno.isDuplo(), true);
		cafeCapsulasLleno.setDuplo(false);
		assertEquals(cafeCapsulasLleno.isDuplo(), false);
	}

	@Test
	public void testMaquina() {
		assertEquals(cafeCapsulasVacio.maquina, MaquinaCapsulas.DESCONOCIDO);
		assertEquals(cafeCapsulasLleno.getMaquina(), MaquinaCapsulas.NESPRESSO);
		cafeCapsulasLleno.setMaquina("LAVAZZA");
		assertEquals(cafeCapsulasLleno.getMaquina(), MaquinaCapsulas.LAVAZZA);
		cafeCapsulasLleno.setMaquina("otro");
		assertEquals(cafeCapsulasLleno.getMaquina(), MaquinaCapsulas.DESCONOCIDO);
		cafeCapsulasLleno.setMaquina(null);
		assertEquals(cafeCapsulasLleno.getMaquina(), MaquinaCapsulas.DESCONOCIDO);
	}
}
