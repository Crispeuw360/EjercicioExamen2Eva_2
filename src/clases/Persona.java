package clases;

import java.io.Serializable;

public class Persona implements Serializable 
{
	private static final long serialVersionUID = 511317939376793708L;
	private String dni;
	private String nombre;
	
	public Persona(String dni, String nombre) 
	{
		this.dni = dni;
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Persona [dni=" + dni + ", nombre=" + nombre + "]";
	}
	
	
}
