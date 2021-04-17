package ut5.reto1.ruleta.mansilla.piña;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Paneles {
	private Map<String, String> paneles;
	private String panel;
	private String pista;
	private Random random;

	public Paneles() {
		this.random = new Random();
		this.paneles = new HashMap<>();
		this.paneles.put("Michael Jordan, Kobe Bryant y Lebron James", "Baloncesto");
		this.paneles.put("Tarta de tres chocolates", "Postre");
		this.paneles.put("Casa Stark, Casa Lannister y Casa Targaryen", "Juego de tronos");
		this.paneles.put("Bistec, Huevo frito, Patatas y ensalada", "Plato combinado");
		this.paneles.put("Independence Day, Bad Boys y Men in Black", "Will Smith");
		this.paneles.put("Taj Mahal, India", "Patrimonio de la humanidad");
		this.paneles.put("La Gran Muralla, China", "Patrimonio de la humanidad");
		this.paneles.put("Bulbasaur, Charmander y Squirtle", "Pokemon ");
		this.paneles.put("Francisco de Goya , Salvador Dalí y  Pablo Picasso", "Personajes ilustres españoles");
		this.paneles.put("Si el examen dura 90 minutos, te levantas en el 91", "Ibai");
		this.paneles.put("Nuestro nombre no importa, se nos conoce por nuestros actos", "Batman");
		this.paneles.put("La vida es como una caja de bombones. Nunca sabes lo que te va a tocar", "Forrest Gump ");
		this.paneles.put("Toy Story, Cars y Monstruos SA", "Pixar");
		this.paneles.put("Muhammad Ali, Mike Tyson y Rocky Marciano", "Boxeo");
		this.paneles.put("Gryffindor, Hufflepuff, Ravenclaw y Slytheryn", "Harry Potter");
	}

	public String getPanel() {
		return panel;
	}

	public String getPista() {
		return pista;
	}

	public void renovarPanel() {
		int azar = random.nextInt(paneles.size());
		int cont = 0;
		for (Map.Entry<String, String> entry : paneles.entrySet()) {
			if (cont == azar) {
				this.panel = entry.getKey();
				this.pista = entry.getValue();
				this.paneles.remove(this.panel);
				break;
			}
			cont++;
		}
	}

}
