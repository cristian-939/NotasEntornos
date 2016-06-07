package modelo;

import controlador.Controlador;
import vista.Inicio;
import vista.Ventanas;

public class Main {

	public static void main(String[] args) {
		// Creo los objetos ventana
		Controlador controlador = new Controlador();
		Modelo modelo = new Modelo();

		Inicio frameInicio = new Inicio();
		Ventanas frameVentanas = new Ventanas();
		
		// comunicamos nuestras ventanas!!
		// modelo conoce a vistas...
		modelo.setInicio(frameInicio);
		modelo.setVentanas(frameVentanas);

	
		// vistas conoce a controlador y modelo
		frameInicio.setControlador(controlador);
		frameInicio.setModelo(modelo);
		frameVentanas.setControlador(controlador);
		frameVentanas.setModelo(modelo);
		
		
		// controlador conoce a modelo y a vista
		controlador.setModelo(modelo);
		controlador.setInicio(frameInicio);
		controlador.setVentanas(frameVentanas);

		
		// Arranco la primera ventana
		frameInicio.setVisible(true);
		frameInicio.setLocationRelativeTo(null);// esto la centra
		frameVentanas.setLocationRelativeTo(null);
		frameVentanas.pack();//esto ajusta al contenido

	}

}
