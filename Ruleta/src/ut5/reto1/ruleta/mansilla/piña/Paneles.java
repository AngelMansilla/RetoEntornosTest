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
		this.random= new Random();
		this.paneles = new HashMap<>();
		this.paneles.put("", "");
		this.paneles.put("", "");
		this.paneles.put("", "");
		this.paneles.put("", "");
		this.paneles.put("", "");
		this.paneles.put("", "");
	}

	public String getPanel() {
		return panel;
	}

	public String getPista() {
		return pista;
	}
	
	public boolean renovarPanel(){
		boolean vacio=this.paneles.isEmpty();
		if (!vacio) {
			int azar = random.nextInt(paneles.size());
			int cont=0;
			for (Map.Entry<String, String> entry : paneles.entrySet()) {
				if (cont==azar) {
					this.panel=entry.getKey();
					this.pista=entry.getValue();
					this.paneles.remove(this.panel);
				}
			}
		}
		return !vacio;
	}
	
}
