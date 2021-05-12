package supermarket;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class ProductoTest {
	
	Producto productoVacio;
	Producto producto;
	
	public ProductoTest() {
	}
	
	@Before
	public void setUp() {
		productoVacio = new Producto();
		producto = new Producto(123453243, "Cafe con leche", "Cafe poco amargo", "Cafés", 3, 4, 1, TipoIVA.NORMAL);
	}
	
	@After
	public void tearDown() {
	}

	@Test
	public void testCodBarras() {
		assertEquals(productoVacio.codBarras, 0);
		assertEquals(producto.getCodBarras(), 123453243);
		productoVacio.setCodBarras(1);
		assertEquals(productoVacio.getCodBarras(), 1);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testCodBarrasException() {
		productoVacio.setCodBarras(-1);
	}
	@Test
	(expected = IllegalArgumentException.class)
	public void testCodBarrasException2() {
		Producto producto2 = new Producto(-4, null, "Cafe poco amargo", "Cafés", 3, 4, 1, TipoIVA.NORMAL);
	}
	

	@Test
	public void testNombre() {
		assertEquals(productoVacio.nombre, "");
		assertEquals(producto.getNombre(), "Cafe con leche");
		productoVacio.setNombre("Cafe con caramelo");
		assertEquals(productoVacio.getNombre(), "Cafe con caramelo");
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNombreException(){
		productoVacio.setNombre(null);
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testNombreException2(){
		productoVacio.setNombre("");
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNombreException3(){
		Producto producto2 = new Producto(123453244, null, "Cafe poco amargo", "Cafés", 3, 4, 1, TipoIVA.NORMAL);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNombreException4(){
		Producto producto2 = new Producto(123453244, "", "Cafe poco amargo", "Cafés", 3, 4, 1, TipoIVA.NORMAL);
	}
	
	@Test
	public void testDescripcion() {
		assertEquals(productoVacio.descripcion, "");
		assertEquals(producto.getDescripcion(), "Cafe poco amargo");
		productoVacio.setDescripcion("Cafe con caramelo");
		assertEquals(productoVacio.getDescripcion(), "Cafe con caramelo");
		productoVacio.setDescripcion("");
		assertEquals(productoVacio.getDescripcion(), "");
		productoVacio.setDescripcion(null);
		assertEquals(productoVacio.getDescripcion(), "");
		Producto producto2 = new Producto(123453244, "Cafe con leche", null, "Cafés", 3, 4, 1, TipoIVA.NORMAL);
		assertEquals(producto2.getDescripcion(), "");
	}
	
	@Test
	public void testCategoria() {
		assertEquals(productoVacio.categoria, Categoria.DESCONOCIDO);
		assertEquals(producto.getCategoria(), Categoria.CAFÉS);
		productoVacio.setCategoria("FRESCOS");
		assertEquals(productoVacio.getCategoria(), Categoria.FRESCOS);
		productoVacio.setCategoria("FRUTAS");
		assertEquals(productoVacio.getCategoria(), Categoria.DESCONOCIDO);
		productoVacio.setCategoria(null);
		assertEquals(productoVacio.getCategoria(), Categoria.DESCONOCIDO);
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", null, 3, 4, 1, TipoIVA.NORMAL);
		assertEquals(productoVacio.getCategoria(), Categoria.DESCONOCIDO);
		Producto producto3 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "fruta", 3, 4, 1, TipoIVA.NORMAL);
		assertEquals(productoVacio.getCategoria(), Categoria.DESCONOCIDO);
	}

	@Test
	public void testNumPasillo() {
		assertEquals(productoVacio.numPasillo, 0);
		assertEquals(producto.getNumPasillo(), 3);
		productoVacio.setNumPasillo(5);
		assertEquals(productoVacio.getNumPasillo(), 5);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumPasilloException(){
		productoVacio.setNumPasillo(0);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumPasilloException2(){
		productoVacio.setNumPasillo(-1);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumPasilloException3(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", 0, 4, 1, TipoIVA.NORMAL);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumPasilloException4(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", -1, 4, 1, TipoIVA.NORMAL);
	}
	
	@Test
	public void testNumEstanteria() {
		assertEquals(productoVacio.numEstanteria, 0);
		assertEquals(producto.getNumEstanteria(), 4);
		productoVacio.setNumEstanteria(5);
		assertEquals(productoVacio.getNumEstanteria(), 5);
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testNumEstanteriaException(){
		productoVacio.setNumEstanteria(0);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumEstanteriaException2(){
		productoVacio.setNumEstanteria(-1);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumEstanteriaException3(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", 3, 0, 1, TipoIVA.NORMAL);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testNumEstanteriaException4(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", 3, -1, 1, TipoIVA.NORMAL);
	}

	@Test
	public void testPrecio() {
		assertEquals(productoVacio.precio, 0, 0.001);
		assertEquals(producto.getPrecio(), 1, 0.001);
		productoVacio.setPrecio(0.1);
		assertEquals(productoVacio.getPrecio(), 0.1, 0.001);
	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testPrecioException(){
		productoVacio.setPrecio(0);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testPrecioException2(){
		productoVacio.setPrecio(-1);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testPrecioException3(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", 3, 4, 0, TipoIVA.NORMAL);
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testPrecioException4(){
		Producto producto2 = new Producto(123453244, "Cafe con leche", "Cafe poco amargo", "Cafés", 3, 4, -1, TipoIVA.NORMAL);
	}
	
	@Test
	public void testTipoIVA() {
		assertEquals(productoVacio.tipoIVA, TipoIVA.NORMAL);
		assertEquals(producto.getTipoIVA(), TipoIVA.NORMAL);
		productoVacio.setTipoIVA(TipoIVA.REDUCIDO);
		assertEquals(productoVacio.getTipoIVA(), TipoIVA.REDUCIDO);
	}
}
