package ut5.reto1.ruleta.mansilla.piña;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Jugadores {
	private	List<String> nombre;
	private	List<Integer> saldo;
	private	List<Integer> saldoTotal;
	private Scanner teclado;

	public Jugadores() {
		this.nombre = new ArrayList<>();
		this.saldo = new ArrayList<>();
		this.saldoTotal = new ArrayList<>();
		this.teclado = new Scanner(System.in, "ISO-8859-1");
	}

	public List<String> getNombre() {
		return nombre;
	}

	public List<Integer> getSaldo() {
		return saldo;
	}

	public List<Integer> getSaldoTotal() {
		return saldoTotal;
	}

	public void añadirJugador(String nombre){
		this.nombre.add(nombre);
		this.saldo.add(0);
		this.saldoTotal.add(0);
	}

	public void modificarSaldo(int id, int saldo){
		this.saldo.add(id, saldo);
	}
	
	public void resetSaldo(){
		for (int i = 0; i < this.saldo.size(); i++) {
			this.saldo.add(i, 0);
		}
	}
	
	public void saldo0(int i){
		this.saldo.add(i, 0);
	}
	
	public void actualizarSaldoTotal(){
		for (int i = 0; i < this.saldoTotal.size(); i++) {
			this.saldoTotal.add(i, (this.saldo.get(i)+this.saldoTotal.get(i)));
		}
	}
	
	public char indicarConsonante(){
		return this.teclado.nextLine().charAt(0);
	}
	
	public char comprarLetra(){
		return this.teclado.nextLine().charAt(0);
	}
	
	public String resolverPanel(){
		return this.teclado.nextLine();
	}	
}
