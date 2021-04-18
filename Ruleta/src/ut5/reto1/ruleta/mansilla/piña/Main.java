package ut5.reto1.ruleta.mansilla.piña;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Scanner;

/**
 * Juego de la ruleta de la suerte
 * 
 * @author Ángel Mansilla y Carlos Piña
 */
public class Main {

	/**
	 * Ejecuta el juego con los jugadores y paneles a jugar seleccionados.
	 * 
	 * @param args the command line arguments
	 */
	public static void main(String[] args) throws AWTException {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		Jugadores jugadores = new Jugadores();
		Ruleta ruleta = new Ruleta();
		Paneles paneles = new Paneles();
		boolean panelCorrecto;
		boolean saldoDisponible;
		int numJugadores = numJugadores();
		int numPaneles = numPaneles();
		introducirJugadores(numJugadores, jugadores);
		jugadores.azarTurno();
		for (int i = 1; i <= numPaneles; i++) {
			limpiarpantalla();
			panelCorrecto = false;
			paneles.renovarPanel();
			Codec codec = new Codec(paneles.getPanel());
			codec.codificar('*');
			do {
				limpiarpantalla();
				System.out.printf("Panel número %d\n", i);
				mostrarDatos(codec, paneles , jugadores, numJugadores);
				System.out.println("Tira de la ruleta (pulsa enter)");
				teclado.nextLine();
				if(!eleccionRuleta(ruleta.tirarRuleta(), jugadores, codec)){
					System.out.println(codec.getPanelCod());
					System.out.println(paneles.getPista());
					do{
						saldoDisponible = true;
						switch (menuJugador()) {
							case 2:
								mostrarDatos(codec, paneles , jugadores, numJugadores);
								panelCorrecto=resolver(codec, jugadores);
								break;
							case 3: 
								mostrarDatos(codec, paneles , jugadores, numJugadores);
								saldoDisponible=comprarVocal(codec, jugadores);
								break;
						}
					}while(!saldoDisponible);
				}
			} while (!panelCorrecto);
			System.out.println("Acertaste el panel");
			jugadores.actualizarSaldoTotal();
		}
		System.out.println("Termino el juego");
	}
	/**
	 * Indica cuantos jugadores juegan la ruleta, teniendo que ser entre 2 y 6.
	 * 
	 * @return Devuleve el numero de jugadores
	 */
	public static int numJugadores() {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		int numJugadores=0;
		do {
			System.out.println("¿Cuantos jugadores van a jugar?(2-6)");
			try{
				numJugadores = Integer.parseInt(teclado.nextLine().trim());
			} catch (IllegalArgumentException excepcion){
				System.out.println("No introdujiste ningun valor");
			}
		} while (numJugadores < 2 || numJugadores > 6);
		return numJugadores;
	}

	/**
	 * Indica cuantos paneles se quieren jugar, teniendo para elegir entre 1 a 15 paneles.
	 * 
	 * @return Devuelve le número de paneles
	 */
	public static int numPaneles() {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		int numPaneles=0;
		do {
			System.out.println("¿Cuantos paneles vas a jugar?(1-15)");
			try{
			numPaneles = Integer.parseInt(teclado.nextLine().trim());
			} catch (IllegalArgumentException excepcion){
				System.out.println("No introdujiste ningun valor");
			}
		} while (numPaneles < 1 || numPaneles > 15);
		return numPaneles;
	}
	
	/**
	 * Añade los jugadores que van a jugar con sus nombres.
	 * 
	 * @param numJugadores El numero de jugadores que van a jugar la ruleta.
	 * @param jugadores Los jugadores que van a jugar.
	 */
	public static void introducirJugadores(int numJugadores, Jugadores jugadores) {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		String nombre;
		for (int i = 1; i <= numJugadores; i++) {
			do{
				System.out.printf("Introduce el nombre del jugador %d\n", i);
				nombre=teclado.nextLine().trim();
				if (nombre.isBlank()) {
					System.out.println("No introdujiste ningun nombre");
				}
			}while(nombre.isBlank());
			jugadores.añadirJugador(nombre);
		}
	}

	/**
	 * Según la eleccion de la ruleta se realiza la quiebra, el perder turno, regalo vocal o decir consonante segun el premio tocado.
	 * 
	 * @param premio El premio que toco en la ruleta.
	 * @param jugadores Los jugadores que juegan
	 * @param codec El panel codificado
	 * @return Si el jugador perdio el turno.
	 */
	public static boolean eleccionRuleta(int premio, Jugadores jugadores, Codec codec) {
		boolean perdioTurno=false;
		switch (premio) {
			case -1:
				System.out.println("Has caido en quiebra tu saldo pasa a 0 y pierdes turno");
				jugadores.saldo0();
				jugadores.pasarTurno();
				perdioTurno=true;
				break;
			case -2:
				System.out.println("Has caido en pierde turno");
				jugadores.pasarTurno();
				perdioTurno=true;
				break;
			case -3:
				System.out.println("Has caido en tirar de nuevo");
				break;
			case -4:
				System.out.println("Has caido en regalo de vocal");
				if (codec.vocalesDichas()) {
					System.out.println("Pero no quedan vocales que decir");
				}else{
					System.out.println("Elige una vocal entre las no dichas aún y vuelve a tirar");
					if (codec.acierto(jugadores.indicarVocal())) {
						System.out.printf("Acertaste %d vocales\n", codec.getContLetra());
					}
				}
				break;
			default:
				System.out.printf("Has caido en %d €\n", premio);
				if (codec.acierto(jugadores.indicarConsonante())) {
					System.out.printf("Acertaste %d consonantes\n", codec.getContLetra());
					jugadores.sumarSaldo(premio*codec.getContLetra());
				}else{
					System.out.println("Fallaste, perdiste el turno");
					jugadores.pasarTurno();
					perdioTurno=true;
				}
		}
		return perdioTurno;
	}
	
	/**
	 * Comprobar si el panel es la resolucion propuesta por el jugador.
	 * 
	 * @param codec El panel codificado
	 * @param jugadores Los jugadores que juegan
	 * @return Si acerto el panel
	 */
	public static boolean resolver(Codec codec, Jugadores jugadores){
		return codec.comprobarPanel(jugadores.resolverPanel());
	}
	/**
	 * Comprar la vocal que el jugador elija comprobando que este tenga saldo disponible y quitandole los 50 de su saldo.
	 * 
	 * @param codec El panel codificado
	 * @param jugadores Los jugadores que juegan
	 * @return Si tiene saldo disponible para comprar
	 */
	public static boolean comprarVocal(Codec codec, Jugadores jugadores){
		boolean saldoDisponible=(jugadores.getSaldo(jugadores.getTurno())>=50);
		if (saldoDisponible) {
			jugadores.sumarSaldo(-50);
			if (!codec.acierto(jugadores.indicarVocal())) {
				jugadores.pasarTurno();
			}
		}
		return saldoDisponible;
	}
	/**
	 * Menu de las opciones que teiene el jugador despues de acertar una consonante.
	 * 
	 * @return La opción elegida.
	 */
	public static int menuJugador(){
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		int op;
		do{
			System.out.println("1 - Volver a tirar");
			System.out.println("2 - Resolver el panel");
			System.out.println("3 - Comprar vocal");
			op=Integer.parseInt(teclado.nextLine());
		}while(op<1 || op>3);
		return op;
	}
	
	/**
	 * Muestra el panel codificado su pista y turno del jugador
	 * @param codec Codificacion del panel
	 * @param paneles Paneles disponibles
	 * @param jugadores Jugadores que juegan
	 * @param numJugadores Numero de jugadores que juegan
	 */
	public static void mostrarDatos(Codec codec, Paneles paneles, Jugadores jugadores, int numJugadores) throws AWTException {
		for (int j = 0; j < numJugadores; j++) {
			System.out.printf("Nombre: %s Saldo: %d SaldoTotal: %d\n", jugadores.getNombre(j), jugadores.getSaldo(j), jugadores.getSaldoTotal(j));
		}
		System.out.println(codec.getPanelCod());
		System.out.println(paneles.getPista());
		System.out.printf("Turno de: %s\n", jugadores.getNombre(jugadores.getTurno()));
	}
	
	/**
	 * Limpia la pantalla despues de 1 segundo, usando la combinacion de teclas control+L
	 * 
	 * @throws AWTException 
	 */
	public static void limpiarpantalla() throws AWTException {
		Robot robot = new Robot();
		robot.delay(1000);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_L);
		robot.keyRelease(KeyEvent.VK_CONTROL);
	}
}