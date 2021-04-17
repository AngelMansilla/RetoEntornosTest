package ut5.reto1.ruleta.mansilla.piña;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Jugadores {

	private List<String> nombre;
	private List<Integer> saldo;
	private List<Integer> saldoTotal;
	private Random random;
	private int turno;
	private Scanner teclado;

	public Jugadores() {
		this.nombre = new ArrayList<>();
		this.saldo = new ArrayList<>();
		this.saldoTotal = new ArrayList<>();
		this.teclado = new Scanner(System.in, "ISO-8859-1");
		this.turno = 0;
		this.random = new Random();
	}

	public String getNombre(int i) {
		return nombre.get(i);
	}

	public Integer getSaldo(int i) {
		return saldo.get(i);
	}

	public Integer getSaldoTotal(int i) {
		return saldoTotal.get(i);
	}

	public Integer getTurno() {
		return turno;
	}

	public void añadirJugador(String nombre) {
		this.nombre.add(nombre);
		this.saldo.add(0);
		this.saldoTotal.add(0);
	}

	public void sumarSaldo(int id, int saldo) {
		this.saldo.add(id, (this.saldo.get(id)+saldo));
	}

	public void saldo0(int i) {
		this.saldo.add(i, 0);
	}

	public void actualizarSaldoTotal() {
		for (int i = 0; i < this.saldoTotal.size(); i++) {
			this.saldoTotal.add(i, (this.saldo.get(i) + this.saldoTotal.get(i)));
			this.saldo.add(i, 0);
		}
	}

	public char indicarConsonante() {
		Pattern pat = Pattern.compile("^([bB-df-hj-np-tv-z-ñÑ]+)$");
		Matcher mat = null;
		char consonante;
		String cadena;
		do{	
			cadena=this.teclado.nextLine();
			consonante=cadena.charAt(0);
			mat = pat.matcher(cadena);
			if (!mat.matches()) {
				System.out.println("Introduce una consonante");
			}
		}while(!mat.matches());
		return consonante;
	}

	public char comprarVocal() {
		Pattern pat = Pattern.compile("^([aeiouAEIOUáéíóúÁÉÍÓÚ]+)$");
		Matcher mat = null;
		char vocal;
		String cadena;
		do{
			cadena=this.teclado.nextLine();
			vocal=cadena.charAt(0);
			mat = pat.matcher(cadena);
			if (!mat.matches()) {
				System.out.println("Introduce una vocal");
			}
		}while(!mat.matches());
		return vocal;
	}

	public String resolverPanel() {
		return this.teclado.nextLine();
	}

	public void azarTurno() {
		this.turno = this.random.nextInt(this.nombre.size());
	}

	public void pasarTurno() {
		this.turno = (this.turno == this.nombre.size() - 1) ? 0 : turno++;
	}
}
