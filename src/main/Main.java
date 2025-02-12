package main;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

import clases.*;
import excepcion.*;
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
		
		Recurso r1 = new Curso(Deporte.ATLETISMO,250,1,LocalDate.of(2026, 1, 12),LocalDate.of(2027, 1, 12),200,personas1);
		
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
		boolean error = false, disponible,correcto=false;
		Deporte deporte = null;
		
		do {
			error = false;
			try {
				System.out.println("¿El Recurso es NATACION, YOGA, o de ATLETISMO?");
				setEntrenador = Utilidades.introducirCadena().toUpperCase();
				switch (setEntrenador) {
				case "NATACION":
					deporte = Deporte.NATACION;
					break;

				case "YOGA":
					deporte = Deporte.YOGA;
					break;

				case "ATLETISMO":
					deporte = Deporte.ATLETISMO;
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

				do {
					System.out.println("Fin de curso:");
					fechaFin = Utilidades.leerFechaDMA();
					if(fechaFin.isBefore(fechaFin))
					{
						correcto=false;
						System.out.println("La fecha debe ser mayor al de inicio");
					}else
					{
						correcto=true;
					}
				} while (!correcto);
				System.out.println("Precio Mensual: ");
				precioMensual = Utilidades.leerInt();

				ArrayList<Persona> personas = new ArrayList<>();

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
	public static boolean comprobarCurso(File fichRecurso, String codC) {
		boolean finArchivo = false, esta=false;
		ObjectInputStream ois=null;

		try {	
			ois=new ObjectInputStream(new FileInputStream(fichRecurso));

			while (!finArchivo) {
				try{
					Object obj = ois.readObject();
	                if (obj instanceof Curso) {
	                    Curso aux = (Curso) obj;
	                    if (aux.getCodR().equalsIgnoreCase(codC)) {
	                        esta = true;
	                    }
	                }
				} catch (EOFException e) {
					// Fin del archivo alcanzado
					finArchivo = true;
				}
			}
			ois.close();	 

		}catch(Exception e) {
			System.out.println("Fatal error");
			e.printStackTrace();
		}
		try {
	        if (ois != null) ois.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }


		return esta;
	}
	
	public static void introducirPersonaEnCurso(File fichRecurso) {
	    File aux = new File("fichAux.dat");
	    ObjectInputStream ois = null;
	    ObjectOutputStream oos = null;
	    boolean finArchivo = false, esta = false, existe = false;
	    String codC, dni, nombre;

	    System.out.println("Introduce el codigo Del curso:");
	    codC = Utilidades.introducirCadena();
	    esta = comprobarCurso(fichRecurso, codC);

	    if (esta) {
	        try {
	            ois = new ObjectInputStream(new FileInputStream(fichRecurso));
	            oos = new ObjectOutputStream(new FileOutputStream(aux));

	            while (!finArchivo) {
	                try {
	                    Object obj = ois.readObject();
	                    if (obj instanceof Curso) {
	                        Curso aux1 = (Curso) obj;

	                        if (aux1.getCodR().equalsIgnoreCase(codC)) {
	                            System.out.println(aux1.toString());
	                            if (aux1.getFechInicioCur().isAfter(LocalDate.now())) {
	                                System.out.println("Introduce el dni de la persona");
	                                dni = Utilidades.introducirCadena();
	                                System.out.println("Introduce el nombre de la persona");
	                                nombre = Utilidades.introducirCadena();
	                                Persona p = new Persona(dni, nombre);
	                                aux1.getPersoInscritas().add(p);
	                                System.out.println("aaaaaaaaaaaaa");
	                                existe = true;
	                            } else {
	                                System.out.println("El periodo De Introduccion ha acabado");
	                            }
	                        }
	                        oos.writeObject(aux1);  // Escribimos el objeto de nuevo
	                    }
	                } catch (ClassNotFoundException e) {
	                    e.printStackTrace();
	                } catch (EOFException e) {
	                    finArchivo = true;  // Fin del archivo alcanzado
	                }
	            }

	            // Verificación y renombrado del archivo
	            if (existe) {
	                if (fichRecurso.delete()) {
	                    aux.renameTo(fichRecurso);
	                    System.out.println("\nSe ha Escrito correctamente.");
	                }
	            } else {
	                aux.delete();
	                System.out.println("\nNo se ha encontrado ningun Recurso con ese Codigo.");
	            }

	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (ois != null) ois.close();
	                if (oos != null) oos.close();
	            } catch (IOException e) {
	                e.printStackTrace();
	            }
	        }

	    } else {
	        System.out.println("No existe este codigo");
	    }
	}
	public static void mostrarCursosDisponibles(File fichRecurso)
	{
		ObjectInputStream ois;
	    boolean hayCursosDisponibles = false,finArchivo = false;
	    int plazasTotales = 0,plazasDisponibles=0;
	    Deporte deporteSeleccionado;
	    String deporteStr;
	    ArrayList<Curso> listaCursos = new ArrayList<>();
	    

	    
	    try {
	    	System.out.println("Introduce el deporte:");
	        deporteStr = Utilidades.introducirCadena().toUpperCase();

	        
	        try {
	            deporteSeleccionado = Deporte.valueOf(deporteStr);
	        } catch (IllegalArgumentException e) {
	            throw new DeporteNoValidoException("Error: '" + deporteStr + "' no es un deporte válido.");
	        }
	        ois = new ObjectInputStream(new FileInputStream(fichRecurso));
	        
			while (!finArchivo) {
				try {
					Object obj = ois.readObject();
					if (obj instanceof Curso) {
					    Curso curso = (Curso) obj; // Ahora sí, casteo seguro
					    listaCursos.add(curso);
					}
				} catch (EOFException e) {
					finArchivo = true; 
				}
			}

			ois.close();

			ListIterator<Curso> iterador = listaCursos.listIterator();
	        System.out.println("\nPara " + deporteSeleccionado + " tienes plazas disponibles en los siguientes cursos:");
	        System.out.printf("%-10s %-10s %-10s %-20s\n", "CÓDIGO", "NIVEL", "AFORO", "PLAZAS DISPONIBLES");
	        
	        while (iterador.hasNext()) {
	            Curso curso = iterador.next();
	            
	            if (curso.getDeporte() == deporteSeleccionado) {
	                plazasDisponibles = curso.getAforoMax() - curso.getPersoInscritas().size();

	                if (plazasDisponibles > 0) {
	                    System.out.printf("%-10s %-10d %-10d %-20d\n",curso.getCodR(), curso.getNivel(), curso.getAforoMax(), plazasDisponibles);
	                    plazasTotales = plazasTotales+plazasDisponibles;
	                    hayCursosDisponibles = true;
	                }
	            }
	        }
	        if (hayCursosDisponibles) {
	            System.out.println("\nTotal número de plazas disponibles: " + plazasTotales);
	        } else {
	            System.out.println("No se han encontrado cursos con plazas disponibles para este deporte.");
	        }

		} catch (FileNotFoundException e) {
			System.out.println("Error: No se encontró el fichero.");
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		} catch (DeporteNoValidoException e) {
	        System.out.println(e.getMessage());
	    }
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
				introducirPersonaEnCurso(fichRecurso);
				break;

			case 3:
				mostrarCursosDisponibles(fichRecurso);
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


