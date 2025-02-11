package clases;

import java.time.LocalDate;
import java.util.ArrayList;

public class Curso extends Recurso{

	private int nivel;
	private LocalDate fechInicioCur;
	private LocalDate fechFinCur;
	private double precioMensual;
	private ArrayList<Persona> PersoInscritas;
	
	public Curso( Deporte deporte, int aforoMax, int nivel, LocalDate fechInicioCur, LocalDate fechFinCur, double precioMensual, ArrayList<Persona> persoInscritas) 
	{
		super(deporte, aforoMax);
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

	public ArrayList<Persona> getPersoInscritas() {
		return PersoInscritas;
	}

	public void setPersoInscritas(ArrayList<Persona> persoInscritas) {
		PersoInscritas = persoInscritas;
	}

	@Override
	public String toString() {
		return "Curso [nivel=" + nivel + ", fechInicioCur=" + fechInicioCur + ", fechFinCur=" + fechFinCur
				+ ", precioMensual=" + precioMensual + ", PersoInscritas=" + PersoInscritas + ", codR=" + codR
				+ ", deporte=" + deporte + ", aforoMax=" + aforoMax + "]";
	}
	
	
	
	
	
	
	
	
}
