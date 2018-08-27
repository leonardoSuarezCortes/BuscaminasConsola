
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Buscaminas {

   
    public static void main(String[] args) throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	boolean corriendo = true;
	boolean corriendo2 = true;
	boolean corriendo3 = true;
	boolean lenguaje = true;
	boolean partidaMenu = true;
	int dimensiones = 0;
	int dimensiones2 = 0;
	int numeroMinas = 0;
	System.out.println("Digite enter para continuar.....");

	while (corriendo3) {
	   
	    String idioma = br.readLine();
	    EscribirRecord gestorGuardado = new EscribirRecord();
	    String fileName = "Victorias.txt";
	    String nombre;

	    // Solicitud del nombre de usuario para el record
	    System.out.println("Por favor, introduce tu nombre");
	
	    
	    
	    nombre = br.readLine();
	    do {
		
		    while (corriendo) {
			corriendo2 = true;
			System.out.println("a) Empezar partida");
		

			String linea = br.readLine();

			do {
			    // Tableros por defecto o personalizado
			    if (linea.equals("a")) {
				System.out
					.println("Introduzca las dimensiones del tablero y la cantidad de minas\na) introduce tus propios valores\n");
				String lineaPartida = br.readLine();
				do {
				
				    
					System.out
						.println("Introduzca las dimensiones del lado 1 (Hasta 100)");
					dimensiones = (Integer.parseInt(br
						.readLine()));
					if (dimensiones > 100) {
					    System.err
						    .println("Error. Máximo 100, por favor\n");
					    break;
					}
					
				
				System.out
				.println("Introduzca las dimensiones del lado 2 (Hasta 100)");
				
					dimensiones2 = (Integer.parseInt(br
						.readLine())); 
					if (dimensiones2 > 100) {
					    System.err
						    .println("Error. Máximo 100, por favor\n");
					    break;
					}
					System.out
						.println("Introduzca el número de minas");
					numeroMinas = (Integer.parseInt(br
						.readLine()));
					if (numeroMinas >= dimensiones
						* dimensiones2) {
					    System.err
						    .println("Error. Todas las casillas serán minas, la victoria es imposible\n");
					    break;
					    
					}
					long inicioJuego = System.nanoTime();
					TableroJuego juego = new TableroJuego(
						dimensiones, dimensiones2,
						numeroMinas);
					long tiempoJuego = System.nanoTime()
						- inicioJuego;
					if (TableroJuego.record) {
					    gestorGuardado.gestionarGuardado(
						    tiempoJuego, fileName,
						    nombre);
					}
				    
				    if (lineaPartida.equals("e")) {
					// Volver al menú principal
					partidaMenu = false;
					corriendo2 = false;
				    }
				    partidaMenu = false;
				} while (partidaMenu);

			    }
			   
				
			  
			    System.out
			    
					.println("Introduce el nombre de usuario");
				nombre = br.readLine();
				corriendo2 = false;
			    
			    if (linea.equals("d")) {
				// Salir del programa
				corriendo3 = false;
				lenguaje = false;
				corriendo = false;
				corriendo2 = false;
			    }

			    // Error en la selección, pausa y regreso al menú
			    
			} while (corriendo2);

		    }
		
		
		
		// Error en la selección, pausa y regreso al menú
			 } while (lenguaje == true);
	}
    }
}
