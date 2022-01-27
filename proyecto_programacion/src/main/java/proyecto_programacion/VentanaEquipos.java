package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.UIManager;
import java.awt.SystemColor;

public class VentanaEquipos extends JFrame {
	
	private JPanel contentPane;												//Variables correspondientes a los elementos de la interfaz gráfica
	private JLabel lblEntrenadorBBDD;
	private JLabel lblEstadioBBDD;
	private JLabel lblPresiBBDD;
	private JLabel lblCreacionBBDD;

	/**
	 * Launch the application.
	 */
	public static void datosequipo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaEquipos frame = new VentanaEquipos();
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
	 */
	public VentanaEquipos() {
		setResizable(false);						//Que no se pueda redimensionar
		
		setAlwaysOnTop(true);						//Hacer que salga encima de todo
		
			Conexion conexion = new Conexion();
			Connection con = null;
			Statement st = null;
			ResultSet rs = null;

			con = conexion.conectar();

			try {
			st = con.createStatement();
			
			String nombre = "";						//Creamos las variables para guardar los datos de los equipos
			String entrenador = "";
			String presi = "";
			String estadio = "";
			String creacion = "";
			String desc = "";
			
			EleccionEquipo opcion = new EleccionEquipo();
		
			int id_e = opcion.getOpc();		//Guardamos el id del equipo que se ha seleccionado
			
			
			//Con este id hacemos una consulta que muestre todos los datos de ese equipo en concreto
			String query_jug1 = "SELECT * FROM equipos WHERE ID_E = "+id_e+"";
			rs = st.executeQuery(query_jug1);
			while(rs.next()) {
				nombre = rs.getString("NOMBRE");
				entrenador = rs.getString("ENTRENADOR");
				presi = rs.getString("PRESIDENTE");
				estadio = rs.getString("ESTADIO");
				creacion = rs.getString("CREACION");
				desc = rs.getString("DESC");
			}
			
			
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Características de los elementos gráficos
			setBounds(100, 100, 729, 520);
			contentPane = new JPanel();
			contentPane.setBackground(new Color(47, 79, 79));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JSeparator separator = new JSeparator();
			separator.setForeground(Color.WHITE);
			separator.setBackground(Color.WHITE);
			separator.setBounds(30, 315, 653, 2);
			contentPane.add(separator);
						
			JLabel lblEntrenador = new JLabel("Entrenador:");
			lblEntrenador.setForeground(UIManager.getColor("Button.light"));
			lblEntrenador.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 22));
			lblEntrenador.setBounds(45, 351, 114, 22);
			contentPane.add(lblEntrenador);
			
			JLabel lblPresidente = new JLabel("Presidente:");
			lblPresidente.setForeground(UIManager.getColor("Button.light"));
			lblPresidente.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 22));
			lblPresidente.setBounds(375, 351, 106, 22);
			contentPane.add(lblPresidente);
			
			JLabel lblEstadio = new JLabel("Estadio:");
			lblEstadio.setForeground(UIManager.getColor("Button.light"));
			lblEstadio.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 22));
			lblEstadio.setBounds(45, 410, 84, 22);
			contentPane.add(lblEstadio);
			
			JLabel lblCreacion = new JLabel("Año de creación:");
			lblCreacion.setForeground(UIManager.getColor("Button.light"));
			lblCreacion.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 22));
			lblCreacion.setBounds(375, 410, 160, 22);
			contentPane.add(lblCreacion);
			
			JLabel lblDescripciones = new JLabel("");
			lblDescripciones.setFont(new Font("Calisto MT", Font.BOLD, 18));
			lblDescripciones.setForeground(UIManager.getColor("Button.background"));
			lblDescripciones.setHorizontalAlignment(SwingConstants.TRAILING);
			lblDescripciones.setBounds(234, 104, 442, 171);
			contentPane.add(lblDescripciones);
			lblDescripciones.setText("<html>"+desc+"</html>");  //Ponemos etiquetas html para que se den los saltos de línea automáticamente
			
			lblEntrenadorBBDD = new JLabel("");
			lblEntrenadorBBDD.setHorizontalAlignment(SwingConstants.LEFT);
			lblEntrenadorBBDD.setFont(new Font("Calisto MT", Font.BOLD, 17));
			lblEntrenadorBBDD.setForeground(UIManager.getColor("Button.background"));
			lblEntrenadorBBDD.setBounds(169, 351, 196, 32);
			contentPane.add(lblEntrenadorBBDD);
			lblEntrenadorBBDD.setText(entrenador);
			
			lblEstadioBBDD = new JLabel("");
			lblEstadioBBDD.setHorizontalAlignment(SwingConstants.LEFT);
			lblEstadioBBDD.setFont(new Font("Calisto MT", Font.BOLD, 17));
			lblEstadioBBDD.setForeground(UIManager.getColor("Button.background"));
			lblEstadioBBDD.setBounds(128, 407, 237, 38);
			contentPane.add(lblEstadioBBDD);
			lblEstadioBBDD.setText(estadio);
			
			lblPresiBBDD = new JLabel("");
			lblPresiBBDD.setHorizontalAlignment(SwingConstants.LEFT);
			lblPresiBBDD.setFont(new Font("Calisto MT", Font.BOLD, 17));
			lblPresiBBDD.setForeground(UIManager.getColor("Button.background"));
			lblPresiBBDD.setBounds(491, 351, 222, 32);
			contentPane.add(lblPresiBBDD);
			lblPresiBBDD.setText(presi);
			
			lblCreacionBBDD = new JLabel("");
			lblCreacionBBDD.setHorizontalAlignment(SwingConstants.LEFT);
			lblCreacionBBDD.setFont(new Font("Calisto MT", Font.BOLD, 17));
			lblCreacionBBDD.setForeground(UIManager.getColor("Button.background"));
			lblCreacionBBDD.setBounds(545, 407, 168, 38);
			contentPane.add(lblCreacionBBDD);
			lblCreacionBBDD.setText(creacion);
			
			JLabel lblNombre = new JLabel("");
			lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
			lblNombre.setForeground(SystemColor.menu);
			lblNombre.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
			lblNombre.setBounds(0, 21, 723, 46);
			contentPane.add(lblNombre);
			lblNombre.setText(nombre);
			
			JSeparator separator_1 = new JSeparator();
			separator_1.setBounds(171, 65, 369, 2);
			contentPane.add(separator_1);
			
			/*
			 * Ejemplo de como sería para que se viera el escudo de cada equipo
			 * Habilitado para Athletic Club, Atlético de Madrid, F.C. Barcelona y Real Madrid
			 */
			JLabel lblFotoEquipo = new JLabel("");
			lblFotoEquipo.setBackground(new Color(47, 79, 79));
			lblFotoEquipo.setBounds(30, 97, 196, 189);
			if(id_e == 1) {
			ImageIcon ico = new ImageIcon(RankingJ1.class.getResource("/imagenes/ath.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoEquipo.getWidth(), lblFotoEquipo.getHeight(), Image.SCALE_SMOOTH));
			lblFotoEquipo.setIcon(img);
			}
			if(id_e == 2) {
			ImageIcon ico = new ImageIcon(RankingJ1.class.getResource("/imagenes/atm.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoEquipo.getWidth(), lblFotoEquipo.getHeight(), Image.SCALE_SMOOTH));
			lblFotoEquipo.setIcon(img);
			}
			if(id_e == 7) {
			ImageIcon ico = new ImageIcon(RankingJ1.class.getResource("/imagenes/fcb.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoEquipo.getWidth(), lblFotoEquipo.getHeight(), Image.SCALE_SMOOTH));
			lblFotoEquipo.setIcon(img);
			}
			if(id_e == 13) {
			ImageIcon ico = new ImageIcon(RankingJ1.class.getResource("/imagenes/rm.jpg"));
			ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFotoEquipo.getWidth(), lblFotoEquipo.getHeight(), Image.SCALE_SMOOTH));
			lblFotoEquipo.setIcon(img);
			}
			contentPane.add(lblFotoEquipo);
			
			}catch (SQLException e) {
				System.out.println("No se ha podido conectar con la base de datos");
			}
			
		

		}
	}