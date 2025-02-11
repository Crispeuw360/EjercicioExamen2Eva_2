package clases;

import java.time.LocalDate;
import java.util.ListIterator;

public class Curso extends Recurso{

	private int nivel;
	private LocalDate fechInicioCur;
	private LocalDate fechFinCur;
	private double precioMensual;
	private ListIterator PersoInscritas;
	
	public Curso(String codR, Deporte deporte, int aforoMax, int nivel, LocalDate fechInicioCur, LocalDate fechFinCur, double precioMensual, ListIterator persoInscritas) 
	{
		super(codR, deporte, aforoMax);
		this.nivel = nivel;
		this.fechInicioCur = fechInicioCur;
		this.fechFinCur = fechFinCur;
		this.precioMensual = precioMensual;
		PersoInscritas = persoInscritas;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public LocalDate getFechInicioCur() {
		return fechInicioCur;
	}

	public void setFechInicioCur(LocalDate fechInicioCur) {
		this.fechInicioCur = fechInicioCur;
	}

	public LocalDate getFechFinCur() {
		return fechFinCur;
	}

	public void setFechFinCur(LocalDate fechFinCur) {
		this.fechFinCur = fechFinCur;
	}

	public double getPrecioMensual() {
		return precioMensual;
	}

	public void setPrecioMensual(double precioMensual) {
		this.precioMensual = precioMensual;
	}

	public ListIterator getPersoInscritas() {
		return PersoInscritas;
	}

	public void setPersoInscritas(ListIterator persoInscritas) {
		PersoInscritas = persoInscritas;
	}

	@Override
	public String toString() {
		return "Curso [nivel=" + nivel + ", fechInicioCur=" + fechInicioCur + ", fechFinCur=" + fechFinCur
				+ ", precioMensual=" + precioMensual + ", PersoInscritas=" + PersoInscritas + ", codR=" + codR
				+ ", deporte=" + deporte + ", aforoMax=" + aforoMax + "]";
	}
	
	
	
	
	
	
	
	
}
