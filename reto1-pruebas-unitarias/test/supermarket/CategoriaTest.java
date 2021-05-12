package supermarket;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class CategoriaTest {
	
	
	public CategoriaTest() {
		
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
	public void testParseValue() {
		assertEquals(Categoria.parseValue("Congelados"), Categoria.CONGELADOS);
		assertEquals(Categoria.parseValue("Frutas"), Categoria.DESCONOCIDO);
		assertEquals(Categoria.parseValue(null), Categoria.DESCONOCIDO);
	}

	@Test
	public void testToString() {
		assertEquals(Categoria.CAFÉS.toString(), "Cafés");
		assertEquals(Categoria.CACAOS_SOLUBLES.toString(), "Cacaos Solubles");
	}
	
}
