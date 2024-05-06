package ar.edu.unju.fi.ejercicio4.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;
import ar.edu.unju.fi.ejercicio4.model.Jugador;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Jugador> list = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		int op =0;
		do {
			
			try {
				op=menu();
				
				switch(op) {
				case 1:
					System.out.println("--Crear Jugador--");
					list.add(crearJugador());
					System.out.println("--Jugador creado correctamente--");
					break;
				case 2:
					mostrar(list);
					break;
				case 3:
					if(list.size()==0) {
						System.out.println("--La lista esta vacia--");
					}
					else {
						modificarPosicion(list);
					}
					break;
				case 4:
					if(list.size()==0) {
						System.out.println("--La lista esta vacia--");
					}
					else {
						eliminarJugador(list);
					}
				}
			} catch (Exception e) {
				System.out.println("--Se predujo un error en el programa:"+e+"--");
			}
			
			System.out.println("----PRECIONE ENTER PARA CONTINUAR----");
			sc.nextLine();
			
		}while(op!=5);
		
		sc.close();
	}
	
	private static int menu() {
		Scanner sc = new Scanner(System.in);
		int op;
		
		System.out.println("----MENU----");
		System.out.println("1)Alta de jugador");
		System.out.println("2)Mostrar todos los jugadores");
		System.out.println("3)Modificar la pocicion de un jugador");
		System.out.println("4)Eliminar un jugador");
		System.out.println("5)Salir");
		
		op=sc.nextInt();
		return op;
	}

	private static Jugador crearJugador() {
	    Scanner sc=new Scanner(System.in);
		Jugador j=new Jugador();
	    
		System.out.print("Ingrese nombre: ");
		j.setNombre(sc.nextLine());
		
	    System.out.print("Ingrese apellido: ");
	    j.setApellido(sc.nextLine());
	    
	    System.out.print("Ingrese fecha de nacimiento (YYYY-MM-DD): ");
	    LocalDate fechaNacimiento = LocalDate.parse(sc.nextLine());
	    j.setFechNac(fechaNacimiento);
	    
	    System.out.print("Ingrese nacionalidad: ");
	    j.setNacionalidad(sc.nextLine());
	    
	    System.out.print("Ingrese estatura: ");
	    j.setEstatura(sc.nextDouble());
	    sc.nextLine();
	    
	    System.out.print("Ingrese peso: ");
	    j.setPeso(sc.nextDouble());
	    sc.nextLine();
	    
	    System.out.print("Ingrese posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
	    Posicion posicion = Posicion.valueOf(sc.nextLine().toUpperCase());
	    j.setPosicion(posicion);
	    
	    return j;
	   }

	private static void mostrar(ArrayList<Jugador> list) { 
		 if(list.size()==0) {
			 System.out.println("--La lista esta vacia--");
		 }
		 else {
			 System.out.println("--Datos de todos los jugadores--");
			 for (Jugador jugador : list) {  
				 System.out.println(jugador);
			 }
		 }
	 }
	
	private static void modificarPosicion(ArrayList<Jugador> list) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("--Modificar pocicion--");
		System.out.print("Ingrese el nombre:");
		String nombrebusc = sc.nextLine();
	    
		System.out.print("Ingrese el apellido:");
		String apellidobusc = sc.nextLine();
	    
		Iterator<Jugador> iterator = list.iterator();
		boolean encontrado = false;
	    
		while (iterator.hasNext()) {
			Jugador jugador = iterator.next();
			if (jugador.getNombre().equals(nombrebusc) && jugador.getApellido().equals(apellidobusc)) {
				System.out.print("Ingrese la nueva posición (DELANTERO, MEDIO, DEFENSA, ARQUERO): ");
				Posicion nuevaPosicion = Posicion.valueOf(sc.nextLine().toUpperCase());
				jugador.setPosicion(nuevaPosicion);
				encontrado = true;
				break;
			}
		}
		if (!encontrado) {
			System.out.println("--No se encontro el jugador--");
		}
	}
	
	private static void eliminarJugador(ArrayList<Jugador> list) {
	    Scanner sc =new Scanner(System.in);
		
	    System.out.println("--Eliminar a un Jugador--");
		System.out.print("Ingrese el nombre:");
		String nombrebusc = sc.nextLine();
	    
		System.out.print("Ingrese el apellido:");
		String apellido = sc.nextLine();
	    
		Iterator<Jugador> iterator = list.iterator();
		boolean encontrado = false;
	    
		while (iterator.hasNext()) {
	    
			Jugador jugador = iterator.next();
	        
			if (jugador.getNombre().equals(nombrebusc) && jugador.getApellido().equals(apellido)) {
				iterator.remove();
				encontrado = true;
				break;
			}
		}
	    
		if (!encontrado) {
			System.out.println("--No se encontró un jugador buscado--");
		} else {
			System.out.println("--Jugador eliminado correctamente--");
		}
	}

	
}
