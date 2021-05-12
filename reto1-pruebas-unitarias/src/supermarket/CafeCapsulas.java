package supermarket;

/**
 *
 * @author Ángel Mansilla y Carlos Piña
 */
public class CafeCapsulas {
	public int numCapsulas;
	public boolean duplo;
	public MaquinaCapsulas maquina;

	public CafeCapsulas() {
		this.numCapsulas = 0;
		this.duplo = false;
		this.maquina = MaquinaCapsulas.DESCONOCIDO;
	}

	public CafeCapsulas(int numCapsulas, boolean duplo, String maquina) {
		setNumCapsulas(numCapsulas);
		this.duplo = duplo;
		setMaquina(maquina);
	}

	public int getNumCapsulas() {
		return numCapsulas;
	}

	public void setNumCapsulas(int numCapsulas) {
		if (numCapsulas >= 8 && numCapsulas <=32) {
			this.numCapsulas = numCapsulas;
		}else{
			throw new IllegalArgumentException();
		}
	}

	public boolean isDuplo() {
		return duplo;
	}

	public void setDuplo(boolean duplo) {
		this.duplo = duplo;
	}

	public MaquinaCapsulas getMaquina() {
		return maquina;
	}

	public void setMaquina(String maquina) {
		this.maquina = MaquinaCapsulas.parseValue(maquina);
	}
}
