package ut5.reto1.ruleta.mansilla.piña;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Ruleta {
	private Random random;
	private Map<Integer, Double> premios;

	/**
	 * Se guardan los premios de la ruleta (premio,probabilidad), esta debe ser en total un 100% de probabilidad
	 * Caso de -1 sera la Quiebra
	 * Caso de -2 sera perder el turno
	 * Caso de -3 sera volver a tirar
	 * Caso de -4 sera Una vocal de regalo
	 */
	public Ruleta() {
		this.random = new Random();
		this.premios = new HashMap<>();
		this.premios.put(-1,7.5);
		this.premios.put(-2,7.5);
		this.premios.put(0,10.0);
		this.premios.put(25,25.0);
		this.premios.put(50,15.0); 
		this.premios.put(75,10.0);
		this.premios.put(100,5.0);
		this.premios.put(150,3.75);
		this.premios.put(200,3.75);
		this.premios.put(-3,7.5);
		this.premios.put(-4,5.0);
	}
	
	public int tirarRuleta(){
		int probabilidadAnterior=0;
		double azar = random.nextDouble()*100+1;
		int premio=0;
		for (Map.Entry<Integer, Double> entry : this.premios.entrySet()) {
			probabilidadAnterior += entry.getValue();
			if (azar <= probabilidadAnterior) {
				premio = entry.getKey();
				break;
			}
		}
		return premio;
	}
}
