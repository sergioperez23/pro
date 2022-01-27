package proyecto_programacion;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.jdbc.PreparedStatement;

public class Juegos {

	static int ronda;					//Variable para guardar la ronda y puntuación
	static int cod_j1;					//Variable para obtener la id que iría si se quiere entrar en el ranking
	
	public static int getRonda() {		//Getters y setters
		return ronda;
	}


	public static void setRonda(int ronda) {
		Juegos.ronda = ronda;
	}


	public static int getCod_j1() {
		return cod_j1;
	}


	public static void setCod_j1(int cod_j1) {
		Juegos.cod_j1 = cod_j1;
	}


	/*JUEGO ADIVINA QUIEN*******************************************************************************************************/
	public static void AdivinaQuien() {
		
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		PreparedStatement ps = null;
		
		con = conexion.conectar();
		
		try {
			
			Scanner teclado = new Scanner(System.in);
			
			st = con.createStatement();
			
			boolean respuesta = true;							//Boolean para salir del bucle al fallar la respuesta

			ronda = 0;										//Número de ronda en la que se está
			
			do {
				int numrandom = (int) Math.floor(Math.random()*6+1);				//Número random para la pregunta del 1 al 6
				
				int jug1 = (int) Math.floor(Math.random()*49+1);				//Jugadores seleccionados con números random
				int jug2 = 0;

				do {
					jug2 = (int) Math.floor(Math.random()*49+1);				//Que no haya posibilidad de que se repitan jugadores
				}while(jug1 == jug2);
				
				ronda++;														//Por cada acierto sumamos 1 a ronda
				System.out.println(" ");
				System.out.println("Estás en la ronda " + ronda);				//Decimos la ronda en la que se encuentra
				
										/*PREGUNTA NÚMERO 1**************************************************/					
				if (numrandom == 1)	{												
					System.out.println("¿Quién ha metido más goles? ¡Elije la respuesta correcta!");
					
					/*
					 * Seleccionamos los nombres de los jugadores que han tocado y mostramos por pantalla las opciones
					 */
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					String nombre1 = "";
					while(rs.next()) {
						nombre1 = rs.getString("JUGADOR");
						System.out.println("a) " + nombre1);
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					String nombre2 = "";
					while(rs.next()) {
						nombre2 = rs.getString("JUGADOR");
						System.out.println("b) " + nombre2);
					}
					
					int goles1=0, goles2=0;
					
					/*
					 * Seleccionamos los datos necesarios para la pregunta en concreto
					 */
					String query_jug1_goles = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug1;
					rs = st.executeQuery(query_jug1_goles);
					while(rs.next()) {
						goles1 = rs.getInt("GOLES");
					}
					
					String query_jug2_goles = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug2;
					rs = st.executeQuery(query_jug2_goles);
					while(rs.next()) {
						goles2 = rs.getInt("GOLES");
					}
	
					/*
					 * Ifs según la respuesta sea un jugador, el otro, o que valiesen ambos al estar empatados
					 */
					if (goles1 > goles2) {
						
						char eleccionjuego1;
						
						do{	//Bucle para poder responder solo "a" o "b"
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! "+nombre1+" ha marcado "+goles1+" goles y "+nombre2+" ha marcado "+goles2+" goles. Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;			//Si se falla, damos false a la variable y saldrá del bucle
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (goles2 > goles1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! "+nombre2+" ha marcado "+goles2+" goles y "+nombre1+" ha marcado "+goles1+" goles. Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Has tenido suerte, ¡han marcado los mismos goles!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
					}
				
				}
														/*PREGUNTA NÚMERO 2**************************************************/
														//Mismo funcionamiento pregunta 1			
				else if (numrandom == 2) {																
					System.out.println("¿Quién tiene más amarillas? ¡Responde correctamente!");
					
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					while(rs.next()) {
						System.out.println("a) " + rs.getString("JUGADOR"));
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					while(rs.next()) {
						System.out.println("b) " + rs.getString("JUGADOR"));
					}
					
					int amarillas1=0, amarillas2=0;
					
					String query_jug1_amarillas = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug1;
					rs = st.executeQuery(query_jug1_amarillas);
					while(rs.next()) {
						amarillas1 = rs.getInt("AMARILLAS");
					}
					
					String query_jug2_amarillas = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug2;
					rs = st.executeQuery(query_jug2_amarillas);
					while(rs.next()) {
						amarillas2 = rs.getInt("AMARILLAS");
					}
	
				
					if (amarillas1 > amarillas2) {
						
						char eleccionjuego1;
						
						do{
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (amarillas2 > amarillas1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya casualidad, ¡tienen las mismas amarillas!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
				}
															/*PREGUNTA NÚMERO 3**************************************************/
															//Mismo funcionamiento pregunta 1	
				else if (numrandom == 3) {														
					System.out.println("¿Quién ha dado más asistencias?");
					
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					while(rs.next()) {
						System.out.println("a) " + rs.getString("JUGADOR"));
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					while(rs.next()) {
						System.out.println("b) " + rs.getString("JUGADOR"));
					}
					
					int asistencias1=0, asistencias2=0;
					
					String query_jug1_goles = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug1;
					rs = st.executeQuery(query_jug1_goles);
					while(rs.next()) {
						asistencias1 = rs.getInt("ASISTENCIAS");
					}
					
					String query_jug2_goles = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug2;
					rs = st.executeQuery(query_jug2_goles);
					while(rs.next()) {
						asistencias2 = rs.getInt("ASISTENCIAS");
					}
	
				
					if (asistencias1 > asistencias2) {
						
						char eleccionjuego1;
						
						do{
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (asistencias2 > asistencias1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Estos dos jugadores han dado las mismas asistencias, ¡siguiente ronda!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
					}
					
				}
															/*PREGUNTA NÚMERO 4**************************************************/
															//Mismo funcionamiento pregunta 1	
				else if (numrandom == 4) {													
					System.out.println("¿Quién es más mayor de los dos jugadores?");
					
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					while(rs.next()) {
						System.out.println("a) " + rs.getString("JUGADOR"));
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					while(rs.next()) {
						System.out.println("b) " + rs.getString("JUGADOR"));
					}
					
					int nacimiento1=0, nacimiento2=0;
					
					String query_jug1_nacimiento = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1_nacimiento);
					while(rs.next()) {
						nacimiento1 = rs.getInt("NACIMIENTO");
					}
					
					String query_jug2_goles = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2_goles);
					while(rs.next()) {
						nacimiento2 = rs.getInt("NACIMIENTO");
					}
	
				
					if (nacimiento1 < nacimiento2) {
						
						char eleccionjuego1;
						
						do{
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (nacimiento2 < nacimiento1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Los dos jugadores tienen la misma edad, ¡pasas de ronda!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
					}
					
				}
															/*PREGUNTA NÚMERO 5**************************************************/
															//Mismo funcionamiento pregunta 1	
				else if (numrandom == 5) {																
					System.out.println("¿Quién ha jugado más minutos?");
					
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					while(rs.next()) {
						System.out.println("a) " + rs.getString("JUGADOR"));
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					while(rs.next()) {
						System.out.println("b) " + rs.getString("JUGADOR"));
					}
					
					int minutos1=0, minutos2=0;
					
					String query_jug1_minutos = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug1;
					rs = st.executeQuery(query_jug1_minutos);
					while(rs.next()) {
						minutos1 = rs.getInt("MINUTOS");
					}
					
					String query_jug2_minutos = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug2;
					rs = st.executeQuery(query_jug2_minutos);
					while(rs.next()) {
						minutos2 = rs.getInt("MINUTOS");
					}
	
				
					if (minutos1 > minutos2) {
						
						char eleccionjuego1;
						
						do{
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (minutos2 > minutos1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Sé que parece mentira... ¡Pero ambos jugadores han jugado los mismos minutos!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
					}
					
				}

																		/*PREGUNTA NÚMERO 6**************************************************/
																		//Mismo funcionamiento pregunta 1		
				else if (numrandom == 6) {								
					System.out.println("¿Quién pesa más?");
					
					String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1);
					while(rs.next()) {
						System.out.println("a) " + rs.getString("JUGADOR"));
					}
					
					String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2);
					while(rs.next()) {
						System.out.println("b) " + rs.getString("JUGADOR"));
					}
					
					int peso1=0, peso2=0;
					
					String query_jug1_peso = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
					rs = st.executeQuery(query_jug1_peso);
					while(rs.next()) {
						peso1 = rs.getInt("PESO");
					}
					
					String query_jug2_peso = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
					rs = st.executeQuery(query_jug2_peso);
					while(rs.next()) {
						peso2 = rs.getInt("PESO");
					}
	
				
					if (peso1 > peso2) {
						
						char eleccionjuego1;
						
						do{
							
							eleccionjuego1 = teclado.next().charAt(0);
									 
							if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
							
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
	
					}
					else if (peso2 > peso1) {
						
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B') {
								System.out.println("¡Respuesta correcta! Sigues jugando.");
							}
							else if (eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Vaya, has fallado.");
								respuesta = false;
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
						
					}
					else {
						char eleccionjuego1;
						
						do {
							eleccionjuego1 = teclado.next().charAt(0);
							if (eleccionjuego1 == 'b' || eleccionjuego1 == 'B' || eleccionjuego1 == 'a' || eleccionjuego1 == 'A') {
								System.out.println("Ambos jugadores pesan los mismos Kg, ¡siguiente ronda!");
							}
							else {
								System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
							}
						}while(eleccionjuego1 != 'A' && eleccionjuego1 != 'a' && eleccionjuego1 != 'B' && eleccionjuego1 != 'b');
					}
					
				}
				
			}while(respuesta);
			
			ronda = ronda - 1;			//Restamos 1 a ronda ya que esa sería la puntuación que ha hecho el jugador
			
			System.out.println("Has acertado "+ ronda +" veces");			//Decimos sus aciertps
						
			/*
			 * Consulta para seleccionar el código máximo actual en este juego
			 */
			String id_ranking = "SELECT IDNICK FROM ranking WHERE IDNICK = (SELECT MAX(IDNICK) FROM ranking)";
			
			rs = st.executeQuery(id_ranking);
			
			while(rs.next()) {			//Sumamos 1 al mayor código del momento y lo introducimos en la variable
				cod_j1 = rs.getInt("IDNICK") + 1;
			}
			
			EntrarRanking.rankingjuego1();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		


	}
	
	
	/*JUEGO NÚMERO 2, ENTRE TRES***********************************************************************************************/
	public static void EntreTres() {

		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		con = conexion.conectar();
		
		try {
			Scanner teclado = new Scanner(System.in);	//Scanner	
						
			st = con.createStatement();					
						
			boolean respuesta = true;					//Boolean para salir del bucle al fallar la respuesta
			
			ronda = 0;					//Entero para indicar la ronda en la que nos encontramos, también servirá para saber los aciertos
		
			do {
				
				int jug1 = (int) Math.floor(Math.random()*49+1);				//Jugadores seleccionados con números random
				int jug2 = 0;
															
															//Utilizamos bucles do while para que los jugadores no se puedan repetir
				do {										
					jug2 = (int) Math.floor(Math.random()*49+1);
				}while(jug1 == jug2);
				
				int jug3 = 0;
				
				do {
					jug3 = (int) Math.floor(Math.random()*49+1);
				}while(jug1 == jug3 || jug2 == jug3);
				
				ronda++;				//Mismo funcionamiento que juego uno, decimos ronda y seleccionamos jugadores
				System.out.println(" ");
				System.out.println("Estás en la ronda " + ronda);
				
				String query_jug1 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug1;
				rs = st.executeQuery(query_jug1);
				String nombrejug1 = "";
				while(rs.next()) {
					nombrejug1 = rs.getString("JUGADOR");
				}
				
				String query_jug2 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug2;
				rs = st.executeQuery(query_jug2);
				String nombrejug2 = "";
				while(rs.next()) {
					nombrejug2 = rs.getString("JUGADOR");
				}
				
				String query_jug3 = "SELECT * FROM jugadores WHERE IDJUGADOR = "+ jug3;
				rs = st.executeQuery(query_jug3);
				String nombrejug3 = "";
				while(rs.next()) {
					nombrejug3 = rs.getString("JUGADOR");
				}
				
				/*
				 * Número random del 1 al 3 para randomizar cual será la respuesta correcta 
				 */
				int jugador_random_seleccionado = (int) Math.floor(Math.random()*3+1);	
				
				/*
				 * Si es 1 la respuesta correcta saldrá en la "a"
				 * Si es 2 la respuesta correcta saldrá en la "b"
				 * Si es 3 la respuesta correcta saldrá en la "c"
				 */
				if (jugador_random_seleccionado == 1) {		
					
					/*
					 * COgemos los datos de la base de datos
					 */
					String query_statsjug1 = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug1;		
					rs = st.executeQuery(query_statsjug1);
					int golesjug1 = 0;
					int asistenciasjug1 = 0;
					int amarillasjug1 = 0;
					int minutosjug1 = 0;
						while(rs.next()) {
							golesjug1 = rs.getInt("GOLES");
							asistenciasjug1 = rs.getInt("ASISTENCIAS");
							amarillasjug1 = rs.getInt("AMARILLAS");
							minutosjug1 = rs.getInt("MINUTOS");
						}
						
						//Hacemos la pregunta con los datos antes cogidos
						System.out.println("El jugador oculto ha marcado "+golesjug1+" goles, ha dado "+asistenciasjug1+" asistencias, le han sacado "+amarillasjug1+" amarillas y ha jugado un total de "+minutosjug1+" minutos.");

						//Opciones posibles 
					System.out.println("La respuesta correcta es uno de estos jugadores: ");		
							System.out.println("a) " + nombrejug1);
							System.out.println("b) " + nombrejug2);
							System.out.println("c) " + nombrejug3);	
					
					char eleccionjuego2;
					
					//Si responde "a" pasa ronda, si no es así falla y sale del bucle con el boolean
					do {
						eleccionjuego2 = teclado.next().charAt(0);
						
						if (eleccionjuego2 == 'a' || eleccionjuego2 == 'A') {
							System.out.println("¡Respuesta correcta! Sigues jugando.");
						}
						else if (eleccionjuego2 == 'b' || eleccionjuego2 == 'B' || eleccionjuego2 == 'c' || eleccionjuego2 == 'C') {
							System.out.println("Vaya, has fallado.");
							respuesta = false;
						}
						else {
							System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
						}
					}while(eleccionjuego2 != 'A' && eleccionjuego2 != 'a' && eleccionjuego2 != 'B' && eleccionjuego2 != 'b' && eleccionjuego2 != 'C' && eleccionjuego2 != 'c');
					
				}
				
				//Caso 2, la respuesta será la "b", mismo funcionamiento caso 1
				else if (jugador_random_seleccionado == 2) {
					
					String query_statsjug2 = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug2;		
					rs = st.executeQuery(query_statsjug2);
					int golesjug2 = 0;
					int asistenciasjug2 = 0;
					int amarillasjug2 = 0;
					int minutosjug2 = 0;
						while(rs.next()) {
							golesjug2 = rs.getInt("GOLES");
							asistenciasjug2 = rs.getInt("ASISTENCIAS");
							amarillasjug2 = rs.getInt("AMARILLAS");
							minutosjug2 = rs.getInt("MINUTOS");
						}
						
						System.out.println("El jugador oculto ha marcado "+golesjug2+" goles, ha dado "+asistenciasjug2+" asistencias, le han sacado "+amarillasjug2+" amarillas y ha jugado un total de "+minutosjug2+" minutos.");
					
					System.out.println("La respuesta correcta es uno de estos jugadores: ");
							System.out.println("a) " + nombrejug1);
							System.out.println("b) " + nombrejug2);
							System.out.println("c) " + nombrejug3);	
					
					char eleccionjuego2;
					do {
						eleccionjuego2 = teclado.next().charAt(0);
						if (eleccionjuego2 == 'b' || eleccionjuego2 == 'B') {
							System.out.println("¡Respuesta correcta! Sigues jugando.");
						}
						else if (eleccionjuego2 == 'a' || eleccionjuego2 == 'A' || eleccionjuego2 == 'c' || eleccionjuego2 == 'C') {
							System.out.println("Vaya, has fallado.");
							respuesta = false;
						}
						else {
							System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
						}
					}while(eleccionjuego2 != 'A' && eleccionjuego2 != 'a' && eleccionjuego2 != 'B' && eleccionjuego2 != 'b' && eleccionjuego2 != 'C' && eleccionjuego2 != 'c');
					
				}
				
				//Caso 3, la respuesta será la "c", mismo funcionamiento caso 1
				else {
					
					String query_statsjug3 = "SELECT * FROM estadisticas WHERE IDJUG = "+ jug3;		
					rs = st.executeQuery(query_statsjug3);
					int golesjug3 = 0;
					int asistenciasjug3 = 0;
					int amarillasjug3 = 0;
					int minutosjug3 = 0;
						while(rs.next()) {
							golesjug3 = rs.getInt("GOLES");
							asistenciasjug3 = rs.getInt("ASISTENCIAS");
							amarillasjug3 = rs.getInt("AMARILLAS");
							minutosjug3 = rs.getInt("MINUTOS");
						}
						
					System.out.println("El jugador oculto ha marcado "+golesjug3+" goles, ha dado "+asistenciasjug3+" asistencias, le han sacado "+amarillasjug3+" amarillas y ha jugado un total de "+minutosjug3+" minutos.");	//Esto está hecho para que la respuesta no siempre sea la 'a)' y vaya variando de que jugador se cogen las stats
					
					System.out.println("La respuesta correcta es uno de estos jugadores: ");		
					System.out.println("a) " + nombrejug1);
					System.out.println("b) " + nombrejug2);
					System.out.println("c) " + nombrejug3);		

					
					char eleccionjuego2;
					do {
						eleccionjuego2 = teclado.next().charAt(0);
						if (eleccionjuego2 == 'c' || eleccionjuego2 == 'C') {
							System.out.println("¡Respuesta correcta! Sigues jugando.");
						}
						else if (eleccionjuego2 == 'b' || eleccionjuego2 == 'B' || eleccionjuego2 == 'a' || eleccionjuego2 == 'A') {
							System.out.println("Vaya, has fallado.");
							respuesta = false;
						}
						else {
							System.out.println("Eso no es una respuesta posible... Por favor elige entre A, B o C.");
						}
					}while(eleccionjuego2 != 'A' && eleccionjuego2 != 'a' && eleccionjuego2 != 'B' && eleccionjuego2 != 'b' && eleccionjuego2 != 'C' && eleccionjuego2 != 'c');
					
				}
			}while(respuesta);
			
			/*
			 * Mismo funcionamiento del juego 1, pero todo respecto al otro ranking
			 */
			ronda = ronda - 1;
			
			System.out.println("Has acertado "+ ronda +" veces");
			
			cod_j1=0;
			
			String id_ranking = "SELECT IDNICK FROM ranking2 WHERE IDNICK = (SELECT MAX(IDNICK) FROM ranking2)";
			
			rs = st.executeQuery(id_ranking);
			
			while(rs.next()) {	
				cod_j1 = rs.getInt("IDNICK") + 1;
			}
			
			EntrarRanking2.rankingjuego2();
						
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}