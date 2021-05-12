package supermarket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class TipoIVATest {
	
	public TipoIVATest() {
	}
	
	@Before
	public void setUp() {
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testValues() {
	}

	@Test
	public void testValueOf() {
	}

	@Test
	public void testToString() {
		assertEquals(TipoIVA.NORMAL.toString(),"normal - 21%");
		assertEquals(TipoIVA.REDUCIDO.toString(),"reducido - 10%");
		assertEquals(TipoIVA.SUPERREDUCIDO.toString(),"superreducido - 4%");
	}

	@Test
	public void testGetNombreIVA() {
		assertEquals(TipoIVA.SUPERREDUCIDO.getNombreIVA(),"superreducido");
		assertEquals(TipoIVA.REDUCIDO.getNombreIVA(),"reducido");
		assertEquals(TipoIVA.NORMAL.getNombreIVA(),"normal");
	}

	@Test
	public void testGetValorIVA() {
		assertEquals(TipoIVA.SUPERREDUCIDO.getValorIVA(),4);
		assertEquals(TipoIVA.REDUCIDO.getValorIVA(),10);
		assertEquals(TipoIVA.NORMAL.getValorIVA(),21);
	}
	
}
