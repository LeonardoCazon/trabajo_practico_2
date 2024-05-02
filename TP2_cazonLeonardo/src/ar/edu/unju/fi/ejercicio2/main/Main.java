package ar.edu.unju.fi.ejercicio2.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio2.constantes.Mes;
import ar.edu.unju.fi.ejercicio2.model.Efemeride;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc =new Scanner(System.in);
		ArrayList<Efemeride> list =new ArrayList<>();
		int op=0;
		do {
			try {
				op=menu(op);
				
				switch(op) {
				case 1:
					list.add(crearEfemeride());
					break;
				case 2:
					mostrar(list);
					break;
				case 3:
					if(list.size()==0) {
						System.out.println("---La lista esta vacia--");
					}
					else {
						int i=eliminarEfemeride(list);
						if(i==-1) {
							System.out.println("--Codigo no encontrado--");
						}
						else {
							list.remove(i);
							System.out.println("--La efemeride fue eliminada correctamente--");
						}
					}
					break;
				case 4:
					modifEfemeride(list);
					break;
				}
				
				
			} catch (Exception e) {
				System.out.println("SE PRODUJO UN ERROR EN EL MENU");
			}
			
			System.out.println("---Precione ENTER para continuar---");
			sc.nextLine();
		}while(op != 5);
		
		sc.close();	
	}

	static private int menu(int op) {
		Scanner sc =new Scanner(System.in);
		
		
		System.out.println("----MENU----");
		System.out.println("1)Crear una efemeride");
		System.out.println("2)Mostrar efemerides");
		System.out.println("3)Eliminar efemeride");
		System.out.println("4)Modificar efemeride");
		System.out.println("5)salir");
		
		op=sc.nextInt();
		
		return op;
	}
	
	static private Efemeride crearEfemeride() {
		Scanner sc =new Scanner(System.in);
		Efemeride ef = new Efemeride();
		
		try {
			System.out.println("---Crear Efemeride---");
			System.out.println("Ingrese el codigo:");
			ef.setCodigo(sc.nextLine());
			System.out.println("Ingrese el N° del mes(1-12):");
			ef.setMes(Mes.values()[(sc.nextInt()-1)]);
			System.out.println("Ingrese el dia:");
			ef.setDia(sc.nextInt());
			System.out.println("Ingrese el detalle");
			sc.nextLine();
			ef.setDetalle(sc.nextLine());

			
		} catch (Exception e) {
			System.out.println("--ERROR AL CREAR EFEMERIDE--");
			System.out.println("ERROR:" + e);
		}
		return ef;
	}
	
	static private void mostrar(ArrayList<Efemeride> list) {
		for(Efemeride e :list) {
			if(list.size() == 0) {
				System.out.println("--La lista esta vacia--");
			}
			else {
				System.out.println("--Lista de Efemerides--");
				System.out.println("Codigo:"+e.getCodigo());
				System.out.println("Fecha:"+e.getDia()+"/"+e.getMes()+"/"+Calendar.getInstance().get(Calendar.YEAR));
				System.out.println("Detalle:"+e.getDetalle());
			}
			
			
		}
		
	}
	
	static private int eliminarEfemeride(ArrayList<Efemeride> list) {
		Scanner sc =new Scanner(System.in);

		System.out.println("---Eliminar Efemeride---");
		System.out.println("Ingrese el codigo de efemeride a eliminar:");
		
		String busc=sc.nextLine();
		int i=0;
		for(Efemeride e:list) {
			if(e.getCodigo().equals(busc)) {
				return i;
			}
			i++;
		}
		
		return -1;
	}
	
	static private void modifEfemeride(ArrayList<Efemeride> list) {
		Scanner sc=new Scanner(System.in);
		
		String busc;
		if(list.size()==0) {
			System.out.println("--La lista esta vacia--");
		}
		else {
			System.out.println("--Modificar efemeride--");
			System.out.println("ingrese codigo de efemeride:");
			busc=sc.nextLine();
			for(Efemeride e:list) {
				if(e.getCodigo().equals(busc)) {
					System.out.println("--Modificar efemeride codigo:"+e.getCodigo()+"--");
					
					System.out.println("Ingrese el codigo:");
					e.setCodigo(sc.nextLine());
					System.out.println("Ingrese el N° del mes(1-12):");
					e.setMes(Mes.values()[(sc.nextInt()-1)]);
					System.out.println("Ingrese el dia:");
					e.setDia(sc.nextInt());
					System.out.println("Ingrese el detalle");
					sc.nextLine();
					e.setDetalle(sc.nextLine());
				}	
			}
		}
	}
}
