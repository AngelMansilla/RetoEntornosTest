package ut5.reto1.ruleta.mansilla.piña;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class Codec {
	private String panel;
	private String panelCod;

	public Codec(String panel) {
		this.panel = panel;
	}

	public String getPanel() {
		return panel;
	}

	public String getPanelCod() {
		return panelCod;
	}
	/**
	 * Ciframos el panel cambiando las letras por el caracter seleccionado para
	 * cifrarlo.
	 *
	 * @param caracter El caracter al que vamos a cambiar
	 */
	public void codificar(char caracter){
		StringBuilder str = new StringBuilder(this.panel);
		String aux = "" + caracter;//Creamos el String para poder utilizara el .replace
		int longitud = this.panel.length();
		for (int i = 0; i < longitud; i++) {
			if (this.panel.charAt(i) != ' ') {
				str.replace(i, i + 1, aux);
			}
		}
		this.panelCod=str.toString();
	}
	
	public boolean acierto(char letra){
		StringBuilder str = new StringBuilder(this.panelCod);
		boolean correcto=false;
		String aux;
		for (int i = 0; i < this.panel.length(); i++) {
			aux = "";
			if (this.panel.toLowerCase().charAt(i) == letra
				|| this.panel.toUpperCase().charAt(i) == letra) {
				aux += this.panel.charAt(i);
				str.replace(i, i + 1, aux);
				correcto = true;
			}
		}
		this.panelCod=str.toString();
		return correcto;
	}
	
	public boolean comprobarPanel(String solucion){
		return this.panel.equalsIgnoreCase(solucion);
	}
}
