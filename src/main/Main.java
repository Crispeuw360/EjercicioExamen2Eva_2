package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import clases.*;
import utilidades.Utilidades;

public class Main {
	
	public static int menu() {
		System.out.println("0. Salir");
		System.out.println("1. Añadir entrenador.");
		System.out.println("2. Cambiar nombre de un equipo.");
		System.out.println("3. Mostrar todos los datos.");
		System.out.println("4. Borrar un integrante.");
		System.out.println("5. Eliminar equipo.");
		System.out.println("6. Añadir equipo.");
		System.out.println("7. Mostrar mayores goleadores.");
		// Pueden haber más opciones
		return Utilidades.leerInt(0, 7);
	}
	/*public static void fillDataLiga(File liga) {
		ObjectOutputStream oos;

		Recurso r1 = new Curso(1, "LaLiga");
		Recurso r2 = new Liga(2, "Premier League");
		Recurso r3 = new Liga(3, "Bundesliga");

		try {
			oos = new ObjectOutputStream(new FileOutputStream(liga));
			oos.writeObject(r1);
			oos.writeObject(r2);
			oos.writeObject(r3);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}*/

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fichRecurso = new File("recursos.dat");
		int opcion;

		/*if (!fichRecurso.exists()) {
			fillDataLiga(liga);
		}*/
		
		do {
			opcion = menu();
			switch (opcion) {

			case 1:
				
				break;

			case 2:
				
				break;

			case 3:
				
				break;

			case 4:
				
				break;

			case 5:
				System.out.println("\nHasta luego!");
				break;
			}
		} while (opcion != 0);
	}
	}


