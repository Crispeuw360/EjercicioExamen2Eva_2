package clases;

import java.io.Serializable;

public class Recurso implements Serializable {
	private static final long serialVersionUID = 2238672422280829810L;
	protected String codR;
	protected Deporte deporte;
	protected int aforoMax;
	private static int contador =1;
	
	public Recurso( Deporte deporte, int aforoMax) 
	{
		this.codR = generarCodigo(deporte);
		this.deporte = deporte;
		this.aforoMax = aforoMax;
	}

	public String getCodR() {
		return codR;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public int getAforoMax() {
		return aforoMax;
	}

	public void setAforoMax(int aforoMax) {
		this.aforoMax = aforoMax;
	}

	@Override
	public String toString() {
		return "Recurso [codR=" + codR + ", deporte=" + deporte + ", aforoMax=" + aforoMax + "]";
	}
	
	private String generarCodigo(Deporte deporte) {
        
		String primerasLetras = deporte.name().substring(0, 2).toUpperCase();
        
        
        return primerasLetras + String.format("%03d", contador++);
    }
}
