package ar.edu.unju.fi.ejercicio6.main;

import ar.edu.unju.fi.ejercicio6.interfaces.funcionales.Converter;
import ar.edu.unju.fi.ejercicio6.model.FelinoDomestico;
import ar.edu.unju.fi.ejercicio6.model.FelinoSalvaje;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//part 1
		FelinoDomestico gato = new FelinoDomestico("Garfield", (byte) 45, 12f);
		Converter<FelinoDomestico, FelinoSalvaje> converter = x -> new FelinoSalvaje(x.getNombre(),
				x.getEdad(), x.getPeso());
		FelinoSalvaje felino1 = converter.convert(gato);
		converter.mostrarObjeto(felino1);
		
	    //part2
		
		FelinoSalvaje gato2 = new FelinoSalvaje("Tanner",(byte) 20, 186f);   

		boolean noVacio= Converter.isNotNull(gato2);
		if(noVacio) {
			Converter<FelinoSalvaje, FelinoDomestico> converter2 = x-> new FelinoDomestico(x.getNombre(),
					x.getEdad(), x.getPeso());
			FelinoDomestico domestic2 = converter2.convert(gato2);
			converter2.mostrarObjeto(domestic2);
		}
		else {
			System.out.println("El registro de gato 2 esta vacio");
		}
		
		
	}

}
