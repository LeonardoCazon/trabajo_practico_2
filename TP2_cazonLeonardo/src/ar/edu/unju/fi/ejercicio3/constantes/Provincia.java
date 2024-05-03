package ar.edu.unju.fi.ejercicio3.constantes;

public enum Provincia {
	JUJUY(770881,53244),
	SALTA(1424397,155340),
	TUCUMAN(1694656,22592),
	CATAMARCA(415438,101486),
	LA_RIOJA(393531,91493),
	SANTIAGO_DEL_ESTERO(978313,136934);
	
	private double cantPobracion;
	private double sup;
	
	public double calcularDencidadPoblacional(Provincia p) {
		double resp=0;
		
		return resp=(double) (p.getCantPobracion() / p.getSup());
	}

	private Provincia() {
		// TODO Auto-generated constructor stub
	}
	
	private Provincia(int cantPobracion, double sup) {
		this.cantPobracion = cantPobracion;
		this.sup = sup;
	}

	

	public double getCantPobracion() {
		return cantPobracion;
	}

	public void setCantPobracion(double cantPobracion) {
		this.cantPobracion = cantPobracion;
	}

	public double getSup() {
		return sup;
	}

	public void setSup(double sup) {
		this.sup = sup;
	}

}
