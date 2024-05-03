package ar.edu.unju.fi.ejercicio3.main;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio3.constantes.Provincia;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Provincia> list = Arrays.asList(Provincia.JUJUY,Provincia.SALTA,Provincia.TUCUMAN,Provincia.CATAMARCA,
											Provincia.LA_RIOJA,Provincia.SANTIAGO_DEL_ESTERO);
		int op=0;
		do {
			try {
				System.out.println("---MENU---");
				System.out.println("1)Mostrar las provincias ingresadas");
				System.out.println("2)Salir");
				
				op=sc.nextInt();
				
				if(op==1) {
					System.out.println("----Provincias----");
					for(Provincia p:list) {
						System.out.println("\n--Datos de "+ p+"--");
						System.out.println("Cantidad Poblacional:"+p.getCantPobracion());
						System.out.println("Superficie:"+p.getSup());
						System.out.println("Dencidad Poblacional:"+p.calcularDencidadPoblacional(p));
					}
				}
			} catch (Exception e) {
				System.out.println("ERROR:"+e);
			}
			System.out.println("\n---Precione ENTER para continuar---");
			sc.nextLine();
			sc.nextLine();
		}while(op != 2);
	}
}
