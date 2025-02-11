package clases;

public class Instalacion extends Recurso {

	private String descrip;
	private boolean disponible;
	
	public Instalacion(String codR, Deporte deporte, int aforoMax, String descrip, boolean disponible) 
	{
		super(codR, deporte, aforoMax);
		this.descrip = descrip;
		this.disponible = disponible;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}

	@Override
	public String toString() {
		return "Instalacion [descrip=" + descrip + ", disponible=" + disponible + ", codR=" + codR + ", deporte="
				+ deporte + ", aforoMax=" + aforoMax + "]";
	}
}
