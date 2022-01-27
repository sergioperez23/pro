package proyecto_programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import javax.swing.JTextField;

public class Principal {

	public static void main(String[] args) {

		int opc = 0;			//Variable para elegir en el switch
		
		//Mensaje de bienvenida
		System.out.println("¡Bienvenido a mi aplicación! En ella podrás consultar datos de equipos y sus jugadores"
				+ ", entretenerte con juegos e incluso introducir tus propios jugadores.");
		System.out.println("");
		
		do {			//Bucle do while para salir del switch
			
						//Opciones del switch
			System.out.println("1. Ver clasificación de la liga.");
			System.out.println("2. Ver datos de equipos");
			System.out.println("3. Ver datos y estadísticas de jugadores.");
			System.out.println("4. Jugar a Adivina Quién.");
			System.out.println("5. Ver ranking del Adivina Quién.");
			System.out.println("6. Jugar a Entre Tres.");
			System.out.println("7. Ver ranking del Entre Tres.");
			System.out.println("8. Introducir nuevo jugador.");
			System.out.println("9. Borrar jugadores introducidos.");
			System.out.println("0. Salir de la aplicación.");

			Scanner teclado = new Scanner(System.in);
			opc = teclado.nextInt();
			teclado.nextLine();
			
			switch (opc) {
			case 1:				
					Clasificacion.MostrarClasi();				//Llamada a métodos
				break;

			case 2:
					EleccionEquipo.seleccion_de_equipo();
				break;

			case 3:
					BuscarJugadores.jugadores();
				break;
				
			case 4:
					Juegos.AdivinaQuien();
				break;

			case 5:
					RankingJ1.RankingAdivinaQuien();	
				break;
				
			case 6:				
					Juegos.EntreTres();	
				break;
				
			case 7:
					RankingJ2.RankingEntreTres();
				break;
				
			case 8:
					NuevoJugador.fichaje();
				break;
				
			case 9:
					ResetJugadores.reset();
				break;

			case 0:
					System.out.println("¡Gracias por usar nuestra app!");
				break;
				
			default:
				System.out.println("¡Eso no es ninguna opción!");
			}

		} while (opc != 0);
		
		
		
	}

}
