package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

import clases.*;
import utilidades.MyObjectOutputStream;
import utilidades.Utilidades;

public class Main {
	
	public static int menu() {
		System.out.println("1. Introducir un nuevo recurso.");
		System.out.println("2. Inscribir una persona en un curso concreto.");
		System.out.println("3. Mostrar los cursos disponibles.");
		System.out.println("4. Mostrar una lista con los diferentes deportes");
		System.out.println("5. Salir");
		// Pueden haber más opciones
		return Utilidades.leerInt(1, 5);
	}
	public static void fillRecursos(File fichRecurso) {
		ObjectOutputStream oos;

		ArrayList<Persona> personas1 = new ArrayList<>();
		Persona p1 = new Persona("QWEQDQQD2", "Igor");
		personas1.add(p1);
		
		Recurso r1 = new Curso(Deporte.ATLETISMO,250,1,LocalDate.of(2005, 1, 12),LocalDate.of(2022, 1, 12),200,personas1);
		
		Recurso r3 = new Instalacion(Deporte.YOGA,25,"Yoga para Alumnos",true);

		try {
			oos = new ObjectOutputStream(new FileOutputStream(fichRecurso));
			oos.writeObject(r1);
			oos.writeObject(r3);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void IntroducirNuevoRecurso(File fichRecurso)
	{
		String respuesta,respuesta2  ,setEntrenador,descrip;
		int aforoMax,nivel,precioMensual;
		LocalDate fechaInicio,fechaFin;
		MyObjectOutputStream moos;
		boolean error = false, disponible;
		Deporte deporte = null;
		
		do {
			error = false;
			try {
				System.out.println("¿El Recurso es NATACION, YOGA, o de ATLETISMO?");
				setEntrenador = Utilidades.introducirCadena().toUpperCase();
				switch (setEntrenador) {
				case "NATACION":
					deporte = deporte.NATACION;
					break;

				case "YOGA":
					deporte = deporte.YOGA;
					break;

				case "ATLETISMO":
					deporte = deporte.ATLETISMO;
					break;

				default:
					throw new IllegalArgumentException("El tipo introducido es invalido.");
				}
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
				error = true;
			}
		} while (error);
		try {
			moos = new MyObjectOutputStream(new FileOutputStream(fichRecurso, true));

			System.out.println("\n¿Introduce el aforo Maximo?");
			aforoMax = Utilidades.leerInt(0, 10000);

			System.out.println("\n¿Que quieres añadir un curso o Instalacion?");
			respuesta = Utilidades.introducirCadena("curso", "Instalacion");

			if (respuesta.equalsIgnoreCase("Instalacion")) {
				System.out.println("Introduce una descripcion");
				descrip = Utilidades.introducirCadena();
				System.out.println("Esta dispoonible");
				respuesta2 = Utilidades.introducirCadena("si", "no");
				if (respuesta2.equalsIgnoreCase("si")) {
					disponible = true;
				} else {
					disponible = false;
				}
				Instalacion aux = new Instalacion(deporte, aforoMax, descrip, disponible);
				moos.writeObject(aux);
			} else {
				System.out.println("\nNivel ");
				nivel = Utilidades.leerInt();

				System.out.println("Inicio de curso: ");
				fechaInicio = Utilidades.leerFechaDMA();

				System.out.println("Fin de curso:");
				fechaFin = Utilidades.leerFechaDMA();

				System.out.println("Precio Mensual: ");
				precioMensual = Utilidades.leerInt();

				ArrayList<Persona> personas = new ArrayList<>();

				System.out.println("\n¿Introducir otro jugador?");
				respuesta = Utilidades.introducirCadena("si", "no");

				Curso aux = new Curso(deporte, aforoMax, nivel, fechaInicio, fechaFin, precioMensual, personas);
				moos.writeObject(aux);
			}

			moos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("\nCurso creado con exito");

		System.out.println("\nVolviendo al menu...\n");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File fichRecurso = new File("recursos.dat");
		int opcion;

		if (!fichRecurso.exists()) {
			fillRecursos(fichRecurso);
		}
		
		do {
			opcion = menu();
			switch (opcion) {

			case 1:
				IntroducirNuevoRecurso(fichRecurso);
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
		} while (opcion != 5);
	}
	}


