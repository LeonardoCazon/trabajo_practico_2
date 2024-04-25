package ar.edu.unju.fi.ejercicio1.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio1.model.Categoria;
import ar.edu.unju.fi.ejercicio1.model.OrigenFabr;
import ar.edu.unju.fi.ejercicio1.model.Producto;

public class Main {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		List<Producto> list = new ArrayList<>();
		Producto p = new Producto();
		
		int op=0;
		do {
			op=menu(op);
			
			switch(op){
			case 1:
				p=crearProd();
				if(p!=null) {
					list.add(p);	
				}
				break;
			case 2:
				mostrarProd(list);
				break;
			case 3:
				modifProd(list);
				break;
			}
			System.out.println("PRECIONE ENTER PARA CONTINUAR");
			sc.nextLine();
			
			
		}while(op!=4);
	}
	
	static private int menu(int op) {
		Scanner sc = new Scanner (System.in);
		
		try {
			System.out.println("----MENU----");
			System.out.println("1)Crear Producto");
			System.out.println("2)Mostrar Producto");
			System.out.println("3)Modificar Producto");
			System.out.println("4)salir");
			
			op = sc.nextInt();
			if(op < 1 || op > 4 ) {
				System.out.println("se debe ingresar una opcion del menu");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:Se debe ingresar un numero entero");
		}

		return op;
	}
	
	static private Producto crearProd() {
		Scanner sc = new Scanner(System.in);
		Producto p =new Producto();
		try {

			System.out.println("--INGRESE DATOS DEL PRODUCTO--");
			System.out.println("Ingrese el codigo:");
			p.setCodigo(sc.nextLine());
			System.out.println("Ingrese la descripcion");
			p.setDescripcion(sc.nextLine());
			System.out.println("Ingrese precio unitario");
			p.setPrecio(sc.nextDouble());
			//submenu ingresa los datos a orig. fabr. y categoria de la forma solicitada en el punto
			p=subMenu(p);
			
			System.out.println("El producto fue cargado correctamente");
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ERROR:NO SE PUDO INGRESAR LOS DATOS CORRECTAMENTE");
			p=null;
		}
		return p;
	}
	
	static private Producto subMenu(Producto p) {
		Scanner sc = new Scanner(System.in);
		int op = 0;
		
		//primer submenu
		System.out.println("----Origen de fabricacion----");
		System.out.println("1-Argentina");
		System.out.println("2-China");
		System.out.println("3-Brasil");
		System.out.println("4-Uruguay");
		System.out.println("Elija una opcion:");
		
		try {
			op=sc.nextInt();
			
			switch(op) {
			case 1:
				p.setOrigenFabr(OrigenFabr.ARGENTINA);
				break;
			case 2:
				p.setOrigenFabr(OrigenFabr.CHINA);
				break;
			case 3:
				p.setOrigenFabr(OrigenFabr.BRASIL);
				break;
			case 4:
				p.setOrigenFabr(OrigenFabr.URUGUAY);
				break;
			default:
				p.setOrigenFabr(null);
				System.out.println("Opcion ingresada no valida(se guardara como null el campo solicitado)");	
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			p.setOrigenFabr(null);
			System.out.println("Opcion ingresada no valida(se guardara como null el campo solicitado)");		
		}
		
		
		//segundo submenu
		System.out.println("----Categoria----");
		System.out.println("1-Telefonia");
		System.out.println("2-Informatica");
		System.out.println("3-Electro Hogar");
		System.out.println("4-Herramientas");
		System.out.println("Elija una opcion:");
		
		try {
			op=sc.nextInt();
			
			switch(op) {
			case 1:
				p.setCategoria(Categoria.TELEFONIA);
				break;
			case 2:
				p.setCategoria(Categoria.INFORMATICA);
				break;
			case 3:
				p.setCategoria(Categoria.ELECTROHOGAR);
				break;
			case 4:
				p.setCategoria(Categoria.HERRAMIENTAS);
				break;
			default:
				p.setOrigenFabr(null);
				System.out.println("Opcion ingresada no valida(se guardara como null el campo solicitado)");	
			}
		} catch (Exception e) {
			// TODO: handle exception
			p.setOrigenFabr(null);
			System.out.println("Opcion ingresada no valida(se guardara como null el campo solicitado)");
		}
		return p;
	}

	static private void mostrarProd(List<Producto> list) {
		int n=1;
		
		if(list.size()==0) {
			System.out.println("---Lista de Productos Vacia---");
		}
		else {
			System.out.println("----Lista de Productos----");
			for(Producto l: list) {
				
				System.out.println("\n--Producto N°[" + n + "]--");
				System.out.println("Codigo:" + l.getCodigo());
				System.out.println("Descripcion:" + l.getDescripcion());
				System.out.println("Precio:" + l.getPrecio());
				System.out.println("Origen de Fabrica:" + l.getOrigenFabr());
				System.out.println("Categoria:" + l.getCategoria());			
			}
		}
	}
	
	static private void modifProd(List<Producto> list) {
		Scanner sc = new Scanner (System.in);
		Producto aux = new Producto();
		
		if(list.size()==0) {
			System.out.println("--La lista esta vacia--");
		}
		else {
			System.out.println("\n---Modificacion de producto---");
			System.out.println("ingrese el codigo del paquete a modificar:");
			String codbusc = sc.nextLine();
			
			for(Producto l: list) {
				if(codbusc.equals(l.getCodigo())) {
					try {
						
						System.out.println("--Modificacion del Producto :"+codbusc+"--");
						System.out.println("Ingrese la nueva descripcion del producto:");
						l.setDescripcion(sc.nextLine());
						System.out.println("Ingrese el nuevo precio del producto:");
						l.setPrecio(sc.nextDouble());
						aux= subMenu(aux);
						l.setOrigenFabr(aux.getOrigenFabr());
						l.setCategoria(aux.getCategoria());
						
						
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("ERROR:no se pudo modificar los datos");
					}
					
						
				}
				
				
				
			}
			
			
			
		}
		
		
	}
	
	
}





