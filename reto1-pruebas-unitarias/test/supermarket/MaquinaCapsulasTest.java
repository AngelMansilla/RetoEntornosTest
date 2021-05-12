package supermarket;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class MaquinaCapsulasTest {
	
	public MaquinaCapsulasTest() {
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
		assertEquals(MaquinaCapsulas.NESPRESSO.toString(), "Nespresso");
		assertEquals(MaquinaCapsulas.SENSEO.toString(), "Senseo");
	}

	@Test
	public void testParseValue() {
		assertEquals(MaquinaCapsulas.parseValue("Tassimo"), MaquinaCapsulas.TASSIMO);
		assertEquals(MaquinaCapsulas.parseValue("Dolce Gusto"), MaquinaCapsulas.DOLCE_GUSTO);
		assertEquals(MaquinaCapsulas.parseValue("Fruta"), MaquinaCapsulas.DESCONOCIDO);
		assertEquals(MaquinaCapsulas.parseValue(null), MaquinaCapsulas.DESCONOCIDO);
	}
	
}
