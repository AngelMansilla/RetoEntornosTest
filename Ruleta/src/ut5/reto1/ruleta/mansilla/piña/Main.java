package ut5.reto1.ruleta.mansilla.piña;

import java.util.Scanner;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Main {

	/**
	 * @param args the command line arguments
	 */
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		Jugadores jugadores = new Jugadores();
		Ruleta ruleta = new Ruleta();
		Paneles paneles = new Paneles();
		boolean mismoPanel = true;
		int numJugadores = numJugadores();
		int numPaneles = numPaneles();
		introducirJugadores(numJugadores, jugadores);
		jugadores.azarTurno();
		for (int i = 1; i <= numPaneles; i++) {
			paneles.renovarPanel();
			Codec codec = new Codec(paneles.getPanel());
			codec.codificar('*');
			System.out.printf("Panel número %d\n", i);
			do {
				for (int j = 0; j < numJugadores; j++) {

					System.out.printf("Nombre: %s Saldo: %d SaldoTotal: %d\n", jugadores.getNombre(i), jugadores.getSaldo(i), jugadores.getSaldoTotal(i));
				}
				System.out.println(codec.getPanelCod());
				System.out.println(paneles.getPista());
				System.out.printf("Turno de: %s\n", jugadores.getNombre(jugadores.getTurno()));
				System.out.println("Tira de la ruleta (pulsa enter)");
				teclado.nextLine();
				eleccionRuleta(ruleta.tirarRuleta(), jugadores, codec);
			} while (mismoPanel);
			jugadores.actualizarSaldoTotal();
		}
		System.out.println("Termino el juego");

	}

	public static int numJugadores() {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		int numJugadores;
		do {
			System.out.println("¿Cuantos jugadores van a jugar?(2-6)");
			numJugadores = Integer.parseInt(teclado.nextLine());
		} while (numJugadores < 2 || numJugadores > 6);
		return numJugadores;
	}

	public static int numPaneles() {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		int numPaneles;
		do {
			System.out.println("¿Cuantos paneles vas a jugar?(1-10)");
			numPaneles = Integer.parseInt(teclado.nextLine());
		} while (numPaneles < 1 || numPaneles > 10);
		return numPaneles;
	}

	public static void introducirJugadores(int numJugadores, Jugadores jugadores) {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		for (int i = 1; i <= numJugadores; i++) {
			System.out.printf("Introduce el nombre del jugador %d\n", i);
			jugadores.añadirJugador(teclado.nextLine().trim());
		}
	}

	public static void eleccionRuleta(int premio, Jugadores jugadores, Codec codec) {
		switch (premio) {
			case -1:
				System.out.println("Has caido en quiebra tu saldo pasa a 0 y pierdes turno");
				jugadores.saldo0(jugadores.getTurno());
				jugadores.pasarTurno();
				break;
			case -2:
				System.out.println("Has caido en pierde turno");
				jugadores.pasarTurno();
				break;
			case -3:
				System.out.println("Has caido en tirar de nuevo");
				break;
			case -4:
				System.out.println("Has caido en regalo de vocal, elige una vocal entre las no dichas aún y vuelve a tirar");
				if (codec.acierto(jugadores.comprarVocal())) {
					System.out.printf("Acertaste %d vocales\n", codec.getConLetra());
				}
				break;
			default:
				System.out.printf("Has caido en %d €\n", premio);
				if (codec.acierto(jugadores.indicarConsonante())) {
					System.out.printf("Acertaste %d consonantes\n", codec.getConLetra());
					jugadores.sumarSaldo(jugadores.getTurno(), (premio*codec.getConLetra()));
				}else{
					System.out.println("Fallaste, perdiste el turno");
					jugadores.pasarTurno();
				}
		}
	}

}
