package ut5.reto1.ruleta.mansilla.piña;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

/**
 * Jugadores del juego
 * @author Ángel Mansilla y Carlos Piña
 */
public class Jugadores {

	private List<String> nombre;
	private List<Integer> saldo;
	private List<Integer> saldoTotal;
	private Random random;
	private int turno;
	private Scanner teclado;

	/**
	 * Constructor
	 */
	public Jugadores() {
		this.nombre = new ArrayList<>();
		this.saldo = new ArrayList<>();
		this.saldoTotal = new ArrayList<>();
		this.teclado = new Scanner(System.in, "ISO-8859-1");
		this.turno = 0;
		this.random = new Random();
	}

	/**
	 * Devuelve el nombre de un jugador concreto
	 * @param i La posiciond el jugador
	 * @return nombre
	 */
	public String getNombre(int i) {
		return nombre.get(i);
	}
	/**
	 * Devuelve el saldo de un jugador concreto
	 * @param i La posiciond el jugador
	 * @return saldo
	 */
	public Integer getSaldo(int i) {
		return saldo.get(i);
	}

	/**
	 * Devuelve le saldo todal de un jguador concreto
	 * @param i La posiciond el jugador
	 * @return el saldo total
	 */
	public Integer getSaldoTotal(int i) {
		return saldoTotal.get(i);
	}
	/**
	 * Deuvele el turno
	 * @return turno
	 */
	public Integer getTurno() {
		return turno;
	}
	
	/**
	 * Añade un jugador con su nombre
	 * @param nombre El nombre del jugador
	 */
	public void añadirJugador(String nombre) {
		this.nombre.add(nombre);
		this.saldo.add(0);
		this.saldoTotal.add(0);
	}
	/**
	 * Suma el premio al saldo actual del jugador que es su turno
	 * @param premio el premio optenido 
	 */
	public void sumarSaldo(int premio) {
		this.saldo.set(this.turno, (this.saldo.get(this.turno)+premio));
	}
	/**
	 * Ppone el saldo a 0 del jugador que es su turno
	 */
	public void saldo0() {
		this.saldo.set(this.turno, 0);
	}

	/**
	 * Actualiza el saldo todal de todos los jugadores pasando el saldo que tienen al saldo total
	 */
	public void actualizarSaldoTotal() {
		for (int i = 0; i < this.saldoTotal.size(); i++) {
			this.saldoTotal.set(i, (this.saldo.get(i) + this.saldoTotal.get(i)));
			this.saldo.set(i, 0);
		}
	}

	/**
	 * Indica una consonante comprobando que no es una vocal
	 * @return Consonante escrita por el jugador
	 */
	public char indicarConsonante() {
		char consonante='a'; //Inicializo como una vocal para si salta el exception que repita el bucle
		System.out.println("Escribe una consonante");
		do{	
			try{
				consonante = this.teclado.nextLine().toLowerCase().charAt(0);
			} catch (StringIndexOutOfBoundsException excepcion){
				System.out.println("No introdujiste ningun valor");
			}
			if (ifVocal(consonante)) {
				System.out.println("Introduce una consonante");
			}
		}while(ifVocal(consonante));
		return consonante;
	}

	/**
	 * Indica una vocal comprobando que es una vocal
	 * @return Vocal escrita por el jugador
	 */
	public char indicarVocal() {
		char vocal='b'; //Inicializo como una consonante para si salta el exception que repita el bucle
		System.out.println("Escribe una vocal");
		do{	
			try{
				vocal=this.teclado.nextLine().toLowerCase().charAt(0);
			} catch (StringIndexOutOfBoundsException excepcion){
				System.out.println("No introdujiste ningun valor");
			}
			if (!ifVocal(vocal)) {
				System.out.println("Introduce una vocal");
			}
		}while(!ifVocal(vocal));
		return vocal;
	}
	
	/**
	 * Comprueba si es una vocal
	 * @param letra letra a comprobar
	 * @return Si es vocal
	 */
	public boolean ifVocal(char letra){
		return (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u' || letra == 'á' || letra == 'é' || letra == 'í' || letra == 'ó' || letra == 'ú');
	}
	/**
	 * Indica la solución del panel
	 * @return solución propuesta del panel
	 */
	public String resolverPanel() {
		System.out.println("Escribe el panel");
		return this.teclado.nextLine();
	}

	/**
	 * Selecciona al azar el turno de un jugador
	 */
	public void azarTurno() {
		this.turno = this.random.nextInt(this.nombre.size());
	}
	/**
	 * Pasa el turno al siguiente jugador
	 */
	public void pasarTurno() {
		if (this.turno == (this.nombre.size()-1)) {
			this.turno = 0;
		}else{
			this.turno++;
		}
	}
}
