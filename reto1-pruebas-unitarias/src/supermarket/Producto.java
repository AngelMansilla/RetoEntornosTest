package supermarket;
/**
 *
 * @author Angel Mansilla y Carlos Piña
 */
public class Producto {
	protected long codBarras;
	protected String nombre;
	protected String descripcion;
	protected Categoria categoria;
	protected int numPasillo;
	protected int numEstanteria;
	protected double precio;
	protected TipoIVA tipoIVA;

	public Producto() {
		this.codBarras = 0;
		this.nombre = "";
		this.descripcion = "";
		this.categoria = Categoria.DESCONOCIDO;
		this.numPasillo = 0;
		this.numEstanteria = 0;
		this.precio = 0;
		this.tipoIVA = TipoIVA.NORMAL;
	}

	public Producto(long codBarras, String nombre, String descripcion, String categoria, int numPasillo, int numEstanteria, double precio, TipoIVA tipoIVA){
		setCodBarras(codBarras);
		setNombre(nombre);
		setDescripcion(descripcion);
		setCategoria(categoria);
		setNumPasillo(numPasillo);
		setNumEstanteria(numEstanteria);
		setPrecio(precio);
		this.tipoIVA = tipoIVA;
	}

	public long getCodBarras() {
		return codBarras;
	}

	public void setCodBarras(long codBarras){
		if (codBarras >= 0) {
			this.codBarras = codBarras;
		}else{
			throw new IllegalArgumentException();
		}
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		if (nombre != null && !nombre.isEmpty()) {
			this.nombre = nombre;
		}else{
			throw new IllegalArgumentException();
		}
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		if (descripcion == null) {
			this.descripcion = "";
		}else{
			this.descripcion = descripcion;
		}
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = Categoria.parseValue(categoria);
	}

	public int getNumPasillo() {
		return numPasillo;
	}

	public void setNumPasillo(int numPasillo) {
		if (numPasillo<=0) {
			throw new IllegalArgumentException();
		}else{
			this.numPasillo = numPasillo;
		}
	}

	public int getNumEstanteria() {
		return numEstanteria;
	}

	public void setNumEstanteria(int numEstanteria) {
		if (numEstanteria<=0) {
			throw new IllegalArgumentException();
		}else{
			this.numEstanteria = numEstanteria;
		}
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		if (precio<=0) {
			throw new IllegalArgumentException();
		}else{
			this.precio = precio;
		}
	}

	public TipoIVA getTipoIVA() {
		return tipoIVA;
	}

	public void setTipoIVA(TipoIVA tipoIVA) {
		this.tipoIVA = tipoIVA;
	}
	
	
}
