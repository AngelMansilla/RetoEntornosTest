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
		boolean panelCorrecto=false;
		int numJugadores = numJugadores();
		int numPaneles = numPaneles();
		boolean saldoDisponible;
		introducirJugadores(numJugadores, jugadores);
		jugadores.azarTurno();
		for (int i = 1; i <= numPaneles; i++) {
			paneles.renovarPanel();
			Codec codec = new Codec(paneles.getPanel());
			codec.codificar('*');
			System.out.printf("Panel número %d\n", i);
			do {
				for (int j = 0; j < numJugadores; j++) {
					System.out.printf("Nombre: %s Saldo: %d SaldoTotal: %d\n", jugadores.getNombre(j), jugadores.getSaldo(j), jugadores.getSaldoTotal(j));
				}
				System.out.println(codec.getPanelCod());
				System.out.println(paneles.getPista());
				System.out.printf("Turno de: %s\n", jugadores.getNombre(jugadores.getTurno()));
				System.out.println("Tira de la ruleta (pulsa enter)");
				teclado.nextLine();
				if(!eleccionRuleta(ruleta.tirarRuleta(), jugadores, codec)){
					System.out.println(codec.getPanelCod());
					System.out.println(paneles.getPista());
					do{
						saldoDisponible = true;
						switch (menuJugador()) {
							case 2:
								System.out.println(codec.getPanelCod());
								System.out.println(paneles.getPista());
								panelCorrecto=resolver(codec, jugadores);
								break;
							case 3: 
								saldoDisponible=comprarVocal(codec, jugadores);
								break;
						}
					}while(!saldoDisponible);
				}
			} while (!panelCorrecto);
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
			System.out.println("¿Cuantos paneles vas a jugar?(1-15)");
			numPaneles = Integer.parseInt(teclado.nextLine());
		} while (numPaneles < 1 || numPaneles > 15);
		return numPaneles;
	}

	public static void introducirJugadores(int numJugadores, Jugadores jugadores) {
		Scanner teclado = new Scanner(System.in, "ISO-8859-1");
		for (int i = 1; i <= numJugadores; i++) {
			System.out.printf("Introduce el nombre del jugador %d\n", i);
			jugadores.añadirJugador(teclado.nextLine().trim());
		}
	}

	public static boolean eleccionRuleta(int premio, Jugadores jugadores, Codec codec) {
		boolean perdioTurno=false;
		switch (premio) {
			case -1:
				System.out.println("Has caido en quiebra tu saldo pasa a 0 y pierdes turno");
				jugadores.saldo0(jugadores.getTurno());
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
					jugadores.sumarSaldo(jugadores.getTurno(), (premio*codec.getContLetra()));
				}else{
					System.out.println("Fallaste, perdiste el turno");
					jugadores.pasarTurno();
					perdioTurno=true;
				}
		}
		return perdioTurno;
	}
	
	public static boolean resolver(Codec codec, Jugadores jugadores){
		return codec.comprobarPanel(jugadores.resolverPanel());
	}
	
	public static boolean comprarVocal(Codec codec, Jugadores jugadores){
		boolean saldoDisponible=(jugadores.getSaldo(jugadores.getTurno())>=50);
		if (saldoDisponible) {
			jugadores.sumarSaldo(jugadores.getTurno(), -50);
			if (!codec.acierto(jugadores.indicarVocal())) {
				jugadores.pasarTurno();
			}
		}
		return saldoDisponible;
	}
	
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
}
