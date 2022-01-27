package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JSeparator;

public class DatosJugador extends JFrame {

	private JPanel contentPane;						//Variables correspondientes a los elementos de la interfaz gráfica
	private JLabel lblNombre;
	private JSeparator separator_nombre;
	private JLabel lblPartidosJugados;
	private JLabel lblPartidosTitular;
	private JLabel lblAsistencias;
	private JLabel lblGoles;
	private JLabel lblAmarillas;
	private JLabel lblRojas;
	private JLabel lblPosicion;
	private JLabel lblEquipo;
	private JLabel lblNacimiento;
	private JLabel lblDorsal;
	private JLabel lblPeso;
	private JLabel lblAltura;
	private JLabel lblFotoJugador;
	private JSeparator separator_jugador;
	private JLabel lblEquipo_1;
	private JLabel lblPosicion_1;
	private JLabel lblPartidosJugados_1;
	private JLabel lblPartidosTitular_1;
	private JLabel lblGoles_1;
	private JLabel lblAsistencias_1;
	private JLabel lblAmarillas_1;
	private JLabel lblRojas_1;
	private JLabel lblPeso_1;
	private JLabel lblAltura_1;
	private JLabel lblNacimiento_1;
	private JLabel lblDorsal_1;
	
	private static int jugador;					//Variable de datos que sacaremos de la BBDD

	/**
	 * Launch the application.
	 */
	public static void stats_jugador() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DatosJugador frame = new DatosJugador();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);					//Centrar en pantalla
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public DatosJugador() throws SQLException {
		
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();
		
		try {
		st = con.createStatement();
		setResizable(false);								//Que no se pueda redimensionar
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);						//Características de los distintos elementos gráficos
		setBounds(100, 100, 815, 626);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(SystemColor.menu);
		lblNombre.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblNombre.setBounds(0, 36, 809, 48);
		contentPane.add(lblNombre);
		String nom_jug = BuscarJugadores.getJugador();
		lblNombre.setText(nom_jug);
		
		separator_nombre = new JSeparator();
		separator_nombre.setBounds(37, 79, 729, 2);
		contentPane.add(separator_nombre);
		
		lblPartidosJugados = new JLabel("Partidos jugados:");
		lblPartidosJugados.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblPartidosJugados.setForeground(new Color(128, 128, 128));
		lblPartidosJugados.setBounds(381, 266, 119, 14);
		contentPane.add(lblPartidosJugados);

		
		lblPartidosTitular = new JLabel("Partidos titular:");
		lblPartidosTitular.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblPartidosTitular.setForeground(new Color(128, 128, 128));
		lblPartidosTitular.setBounds(598, 265, 115, 14);
		contentPane.add(lblPartidosTitular);

		
		lblAsistencias = new JLabel("Asistencias:");
		lblAsistencias.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblAsistencias.setForeground(new Color(128, 128, 128));
		lblAsistencias.setBounds(598, 387, 86, 14);
		contentPane.add(lblAsistencias);

		
		lblGoles = new JLabel("Goles:");
		lblGoles.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblGoles.setForeground(new Color(128, 128, 128));
		lblGoles.setBounds(381, 387, 46, 14);
		contentPane.add(lblGoles);
		
		
		lblAmarillas = new JLabel("Tarjetas amarillas:");
		lblAmarillas.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblAmarillas.setForeground(new Color(128, 128, 128));
		lblAmarillas.setBounds(381, 513, 129, 14);
		contentPane.add(lblAmarillas);
		
		lblRojas = new JLabel("Tarjetas rojas:");
		lblRojas.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblRojas.setForeground(new Color(128, 128, 128));
		lblRojas.setBounds(598, 512, 105, 14);
		contentPane.add(lblRojas);
		
		lblPosicion = new JLabel("Posición:");
		lblPosicion.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblPosicion.setForeground(new Color(128, 128, 128));
		lblPosicion.setBounds(598, 154, 65, 14);
		contentPane.add(lblPosicion);
		
		lblEquipo = new JLabel("Equipo:");
		lblEquipo.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblEquipo.setForeground(new Color(128, 128, 128));
		lblEquipo.setBounds(381, 155, 59, 14);
		contentPane.add(lblEquipo);
		
		lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblNacimiento.setForeground(new Color(128, 128, 128));
		lblNacimiento.setBounds(61, 454, 96, 14);
		contentPane.add(lblNacimiento);
		
		lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblDorsal.setForeground(new Color(128, 128, 128));
		lblDorsal.setBounds(243, 454, 46, 14);
		contentPane.add(lblDorsal);
		
		lblPeso = new JLabel("Peso:");
		lblPeso.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblPeso.setForeground(new Color(128, 128, 128));
		lblPeso.setBounds(243, 512, 46, 14);
		contentPane.add(lblPeso);
		
		lblAltura = new JLabel("Altura:");
		lblAltura.setFont(new Font("Gill Sans MT", Font.BOLD, 14));
		lblAltura.setForeground(new Color(128, 128, 128));
		lblAltura.setBounds(61, 512, 46, 14);
		contentPane.add(lblAltura);
		
		separator_jugador = new JSeparator();
		separator_jugador.setBounds(72, 432, 230, 2);
		contentPane.add(separator_jugador);
		
		lblEquipo_1 = new JLabel("");
		lblEquipo_1.setForeground(Color.WHITE);
		lblEquipo_1.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblEquipo_1.setBounds(434, 149, 157, 24);
		contentPane.add(lblEquipo_1);
		String equi = BuscarJugadores.getEquipo();
		lblEquipo_1.setText(equi);
		
		lblPosicion_1 = new JLabel("");
		lblPosicion_1.setForeground(Color.WHITE);
		lblPosicion_1.setFont(new Font("Gill Sans MT", Font.BOLD, 16));
		lblPosicion_1.setBounds(663, 150, 124, 23);
		contentPane.add(lblPosicion_1);
		String posi = BuscarJugadores.getPosicion();
		lblPosicion_1.setText(posi);
		
		
		lblPartidosJugados_1 = new JLabel("");
		lblPartidosJugados_1.setForeground(Color.WHITE);
		lblPartidosJugados_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblPartidosJugados_1.setBounds(501, 260, 59, 25);
		contentPane.add(lblPartidosJugados_1);
		String par_j = BuscarJugadores.getPartidos_jug();
		lblPartidosJugados_1.setText(par_j);
		
		lblPartidosTitular_1 = new JLabel("");
		lblPartidosTitular_1.setForeground(Color.WHITE);
		lblPartidosTitular_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblPartidosTitular_1.setBounds(708, 260, 37, 25);
		contentPane.add(lblPartidosTitular_1);
		String par_t = BuscarJugadores.getPartidos_tit();
		lblPartidosTitular_1.setText(par_t);
		
		lblGoles_1 = new JLabel("");
		lblGoles_1.setForeground(Color.WHITE);
		lblGoles_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblGoles_1.setBounds(434, 381, 46, 25);
		contentPane.add(lblGoles_1);
		String gol = BuscarJugadores.getGoles();
		lblGoles_1.setText(gol);
		
		lblAsistencias_1 = new JLabel("");
		lblAsistencias_1.setForeground(Color.WHITE);
		lblAsistencias_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblAsistencias_1.setBounds(686, 381, 86, 25);
		contentPane.add(lblAsistencias_1);
		String asis = BuscarJugadores.getAsistencias();
		lblAsistencias_1.setText(asis);
		
		lblAmarillas_1 = new JLabel("");
		lblAmarillas_1.setForeground(Color.WHITE);
		lblAmarillas_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblAmarillas_1.setBounds(511, 507, 59, 23);
		contentPane.add(lblAmarillas_1);
		String ama = BuscarJugadores.getAmarillas();
		lblAmarillas_1.setText(ama);
		
		lblRojas_1 = new JLabel("");
		lblRojas_1.setForeground(Color.WHITE);
		lblRojas_1.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblRojas_1.setBounds(700, 507, 59, 23);
		contentPane.add(lblRojas_1);
		String roj = BuscarJugadores.getRojas();
		lblRojas_1.setText(roj);
		
		lblPeso_1 = new JLabel("");
		lblPeso_1.setForeground(Color.WHITE);
		lblPeso_1.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		lblPeso_1.setBounds(286, 510, 46, 20);
		contentPane.add(lblPeso_1);
		String pes = BuscarJugadores.getPeso();
		lblPeso_1.setText(pes);
		
		lblAltura_1 = new JLabel("");
		lblAltura_1.setForeground(Color.WHITE);
		lblAltura_1.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		lblAltura_1.setBounds(112, 510, 46, 20);
		contentPane.add(lblAltura_1);
		String alt = BuscarJugadores.getAltura();
		lblAltura_1.setText(alt);
		
		lblNacimiento_1 = new JLabel("");
		lblNacimiento_1.setForeground(Color.WHITE);
		lblNacimiento_1.setFont(new Font("Gill Sans MT", Font.BOLD, 15));
		lblNacimiento_1.setBounds(145, 451, 96, 20);
		contentPane.add(lblNacimiento_1);
		String nac = BuscarJugadores.getNacimiento();
		lblNacimiento_1.setText(nac);
		
		lblDorsal_1 = new JLabel("");
		lblDorsal_1.setForeground(Color.WHITE);
		lblDorsal_1.setFont(new Font("Gill Sans MT", Font.BOLD, 17));
		lblDorsal_1.setBounds(296, 451, 46, 20);
		contentPane.add(lblDorsal_1);
		String dor = BuscarJugadores.getDorsal();
		lblDorsal_1.setText(dor);
		
		/*
		 * Query para obtener la id del jugador que haya sido seleccionado anteriormente
		 */
		String queryjugador = "SELECT IDJUGADOR FROM jugadores WHERE JUGADOR LIKE '"+lblNombre.getText()+"'";
		
		rs = st.executeQuery(queryjugador);
		while(rs.next()) {
			jugador = rs.getInt("IDJUGADOR");
		}	

		lblFotoJugador = new JLabel("");
		lblFotoJugador.setBounds(72, 138, 230, 276);
		/*
		 * Foto personalizada según cual sea el jugador seleccionado (3 ejemplos)
		 * Habilitado para Lionel Messi, Karim Benzema y Gerard Moreno
		 */
		if(jugador == 47) {
			ImageIcon ico = new ImageIcon(DatosJugador.class.getResource("/imagenes/messi.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(), Image.SCALE_SMOOTH));
			lblFotoJugador.setIcon(img);
			}
		else if(jugador == 48) {
			ImageIcon ico = new ImageIcon(DatosJugador.class.getResource("/imagenes/benzema.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(), Image.SCALE_SMOOTH));
			lblFotoJugador.setIcon(img);
			}
		else if(jugador == 49) {
			ImageIcon ico = new ImageIcon(DatosJugador.class.getResource("/imagenes/gmoreno.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(), Image.SCALE_SMOOTH));
			lblFotoJugador.setIcon(img);
			}
		/*
		 * Foto predeterminada para el resto de jugadores
		 */
		else {
			ImageIcon ico = new ImageIcon(DatosJugador.class.getResource("/imagenes/silueta_jugador.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoJugador.getWidth(), lblFotoJugador.getHeight(), Image.SCALE_SMOOTH));
			lblFotoJugador.setIcon(img);
		}
		contentPane.add(lblFotoJugador);

		}catch (SQLException e) {
			System.out.println("No se ha podido conectar con la base de datos");
		}
	}
}
