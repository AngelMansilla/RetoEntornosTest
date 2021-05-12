package supermarket;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public enum MaquinaCapsulas {
	NESPRESSO("Nespresso"),
	DOLCE_GUSTO("Dolce Gusto"),
	TASSIMO("Tassimo"),
	LAVAZZA("Lavazza"),
	SENSEO("Senseo"),
	DESCONOCIDO("Desconocido");

	
	private String nombreMaquina;

	MaquinaCapsulas(String machine) {
	    this.nombreMaquina = machine;
	}

	@Override
	public String toString() {
	    return this.nombreMaquina;
	}

	public static final MaquinaCapsulas parseValue(String valor) {
	    try {
		valor = valor.trim();
		for (MaquinaCapsulas mc : MaquinaCapsulas.values()) {
		    if (mc.nombreMaquina.equalsIgnoreCase(valor)) {
			return mc;
		    }
		}
		return MaquinaCapsulas.DESCONOCIDO;
	    } catch (Exception ex) {
		return MaquinaCapsulas.DESCONOCIDO;
	    }
	}
}
