package ar.edu.unju.fi.ejercicio4.model;

import java.time.LocalDate;
import java.time.Period;

import ar.edu.unju.fi.ejercicio4.constantes.Posicion;

public class Jugador {
	private String nombre;
	private String apellido;
	private LocalDate fechNac;
	private String nacionalidad;
	private double estatura;
	private double peso;
	private Posicion posicion;

	public int calcularEdad() {
		int edad;
	
		LocalDate hoy = LocalDate.now();
		Period periodo = Period.between(fechNac, hoy);
		edad= periodo.getYears();
		
		return edad;
	   }
	
	
	

	@Override
	public String toString() {
		return "\n--Datos del jugador " + nombre + " " + apellido + "--"+"\nFecha de nacimiento:" + fechNac + "\nnacionalidad:"
				+ nacionalidad + "\nEstatura:" + estatura + "\nPeso:" + peso + "\nPosicion:" + posicion;
	}




	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public LocalDate getFechNac() {
		return fechNac;
	}

	public void setFechNac(LocalDate fechNac) {
		this.fechNac = fechNac;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public double getEstatura() {
		return estatura;
	}

	public void setEstatura(double estatura) {
		this.estatura = estatura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Posicion getPosicion() {
		return posicion;
	}

	public void setPosicion(Posicion posicion) {
		this.posicion = posicion;
	}

	public Jugador(String nombre, String apellido, LocalDate fechNac, String nacionalidad, double estatura, double peso,
			Posicion posicion) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechNac = fechNac;
		this.nacionalidad = nacionalidad;
		this.estatura = estatura;
		this.peso = peso;
		this.posicion = posicion;
	}

	public Jugador() {
		// TODO Auto-generated constructor stub
	}
}
