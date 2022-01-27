package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class NuevoJugador extends JFrame {

	private JPanel contentPane;						//Variables correspondientes a los elementos de la interfaz gráfica
	private JTextField txtNombre;
	private JTextField textPosicion;
	private JTextField textAltura;
	private JTextField textPeso;
	private JTextField textDorsal;
	private JTextField textNac;

	/**
	 * Launch the application.
	 */
	public static void fichaje() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoJugador frame = new NuevoJugador();
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
	public NuevoJugador() {
		setResizable(false);								//Que no se pueda redimensionar
		
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Características de los elementos gráficos
		setBounds(100, 100, 743, 654);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNuevoFichaje = new JLabel("NUEVO FICHAJE");
		lblNuevoFichaje.setHorizontalAlignment(SwingConstants.CENTER);
		lblNuevoFichaje.setForeground(SystemColor.menu);
		lblNuevoFichaje.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblNuevoFichaje.setBounds(0, 21, 727, 46);
		contentPane.add(lblNuevoFichaje);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 65, 519, 2);
		contentPane.add(separator);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.GRAY);
		lblNombre.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblNombre.setBounds(101, 124, 93, 22);
		contentPane.add(lblNombre);
		
		JLabel lblPosicin = new JLabel("Posición:");
		lblPosicin.setForeground(Color.GRAY);
		lblPosicin.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblPosicin.setBounds(101, 193, 93, 22);
		contentPane.add(lblPosicin);
		
		JLabel lblAltura = new JLabel("Altura:");
		lblAltura.setForeground(Color.GRAY);
		lblAltura.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblAltura.setBounds(101, 267, 93, 22);
		contentPane.add(lblAltura);
		
		JLabel lblNacimiento = new JLabel("Nacimiento:");
		lblNacimiento.setForeground(Color.GRAY);
		lblNacimiento.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblNacimiento.setBounds(406, 124, 117, 22);
		contentPane.add(lblNacimiento);
		
		JLabel lblDorsal = new JLabel("Dorsal:");
		lblDorsal.setForeground(Color.GRAY);
		lblDorsal.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblDorsal.setBounds(406, 193, 93, 22);
		contentPane.add(lblDorsal);
		
		JLabel lblPeso = new JLabel("Peso:");
		lblPeso.setForeground(Color.GRAY);
		lblPeso.setFont(new Font("Gill Sans MT", Font.BOLD, 18));
		lblPeso.setBounds(406, 267, 93, 22);
		contentPane.add(lblPeso);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(txtNombre.getText().length() >= 15) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		txtNombre.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		txtNombre.setBounds(195, 121, 86, 27);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		textPosicion = new JTextField();
		textPosicion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textPosicion.getText().length() >= 15) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		textPosicion.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textPosicion.setColumns(10);
		textPosicion.setBounds(195, 190, 86, 27);
		contentPane.add(textPosicion);
		
		textAltura = new JTextField();
		textAltura.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textAltura.getText().length() >= 4) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		textAltura.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textAltura.setColumns(10);
		textAltura.setBounds(176, 264, 86, 27);
		contentPane.add(textAltura);
		
		textPeso = new JTextField();
		textPeso.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textPeso.getText().length() >= 3) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		textPeso.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textPeso.setColumns(10);
		textPeso.setBounds(470, 262, 86, 27);
		contentPane.add(textPeso);
		
		textDorsal = new JTextField();
		textDorsal.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textDorsal.getText().length() >= 2) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		textDorsal.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textDorsal.setColumns(10);
		textDorsal.setBounds(483, 190, 86, 27);
		contentPane.add(textDorsal);
		
		textNac = new JTextField();
		textNac.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textNac.getText().length() >= 10) {				//Límite de caracteres
					e.consume();
				}
			}
		});
		textNac.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		textNac.setColumns(10);
		textNac.setBounds(523, 121, 86, 27);
		contentPane.add(textNac);
		
		JButton btnAthletic = new JButton("Athletic Club");
		btnAthletic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				//Mensaje de error por si se deja algún campo vacío
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error encima de los demás
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
						
						/*
						 * Mismo funcionamiento que para los rankings, cogemos el id mayor del momento y le sumaremos 1
						 * para aplicar este al nuevo jugador
						 */
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						//Cogemos todos los datos introducidos del nuevo jugador
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							//Query donde introducimos todos los nuevos datos en la BBDD
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Athletic Club', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							//Mensaje de jugador introducido
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);					//Que se cierre la ventana tras introducirlo
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}			

			}	
		});
		btnAthletic.setBounds(21, 431, 142, 23);
		contentPane.add(btnAthletic);
		
		/*
		 * Funcionamiento del resto de botones igual al primero, solo cambiando el nombre de cada uno
		 */
		JButton btnAtlticoDeMadrid = new JButton("Atlético de Madrid");
		btnAtlticoDeMadrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Atlético de Madrid', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnAtlticoDeMadrid.setBounds(21, 465, 142, 23);
		contentPane.add(btnAtlticoDeMadrid);
		
		JButton btnOsasuna = new JButton("CA Osasuna");
		btnOsasuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'CA Osasuna', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnOsasuna.setBounds(21, 499, 142, 23);
		contentPane.add(btnOsasuna);
		
		JButton btnCádizCF = new JButton("Cádiz CF");
		btnCádizCF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Cádiz CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnCádizCF.setBounds(21, 533, 142, 23);
		contentPane.add(btnCádizCF);
		
		JButton btnAlavés = new JButton("Deportivo Alavés");
		btnAlavés.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Deportivo Alavés', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnAlavés.setBounds(21, 567, 142, 23);
		contentPane.add(btnAlavés);
		
		JButton btnElcheCf = new JButton("Elche CF");
		btnElcheCf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Elche CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnElcheCf.setBounds(204, 431, 142, 23);
		contentPane.add(btnElcheCf);
		
		JButton btnBarcelona = new JButton("FC Barcelona");
		btnBarcelona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'FC Barcelona', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnBarcelona.setBounds(204, 465, 142, 23);
		contentPane.add(btnBarcelona);
		
		JButton btnGetafe = new JButton("Getafe CF");
		btnGetafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Getafe CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnGetafe.setBounds(204, 499, 142, 23);
		contentPane.add(btnGetafe);
		
		JButton btnGranada = new JButton("Granada CF");
		btnGranada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Granada CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnGranada.setBounds(204, 533, 142, 23);
		contentPane.add(btnGranada);
		
		JButton btnLevante = new JButton("Levante UD");
		btnLevante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Levante UD', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnLevante.setBounds(204, 567, 142, 23);
		contentPane.add(btnLevante);
		
		JButton btnCelta = new JButton("Celta de Vigo");
		btnCelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Celta de Vigo', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnCelta.setBounds(384, 431, 142, 23);
		contentPane.add(btnCelta);
		
		JButton btnBetis = new JButton("Real Betis");
		btnBetis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Real Betis', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnBetis.setBounds(384, 465, 142, 23);
		contentPane.add(btnBetis);
		
		JButton btnMadrid = new JButton("Real Madrid");
		btnMadrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Real Madrid', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnMadrid.setBounds(384, 499, 142, 23);
		contentPane.add(btnMadrid);
		
		JButton btnSociedad = new JButton("Real Sociedad");
		btnSociedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Real Sociedad', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnSociedad.setBounds(384, 533, 142, 23);
		contentPane.add(btnSociedad);
		
		JButton btnValladolid = new JButton("Real Valladolid");
		btnValladolid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Real Valladolid', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnValladolid.setBounds(384, 567, 142, 23);
		contentPane.add(btnValladolid);
		
		JButton btnEibar = new JButton("SD Eibar");
		btnEibar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'SD Eibar', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnEibar.setBounds(564, 431, 142, 23);
		contentPane.add(btnEibar);
		
		JButton btnHuesca = new JButton("SD Huesca");
		btnHuesca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'SD Huesca', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnHuesca.setBounds(564, 465, 142, 23);
		contentPane.add(btnHuesca);
		
		JButton btnSevilla = new JButton("Sevilla FC");
		btnSevilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Sevilla FC', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnSevilla.setBounds(564, 499, 142, 23);
		contentPane.add(btnSevilla);
		
		JButton btnValencia = new JButton("Valencia CF");
		btnValencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Valencia CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnValencia.setBounds(564, 533, 142, 23);
		contentPane.add(btnValencia);
		
		JButton btnVillarreal = new JButton("Villarreal CF");
		btnVillarreal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtNombre.getText().isEmpty() || textPosicion.getText().isEmpty() || textAltura.getText().isEmpty() || textPeso.getText().isEmpty() || textDorsal.getText().isEmpty() || textNac.getText().isEmpty()) {
					JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes introducir un nuevo jugador con campos vacíos!");
				}
				else {
					Conexion conexion = new Conexion();
					Connection con = null;
					PreparedStatement ps = null;
					Statement st = null;
					ResultSet rs = null;
					
					con = conexion.conectar();
					
					try {
					
						int codigo = 0;
						
						String id_jug = "SELECT IDJUGADOR FROM jugadores WHERE IDJUGADOR = (SELECT MAX(IDJUGADOR) FROM jugadores)";
						
						st = con.createStatement();	
						
						rs = st.executeQuery(id_jug);
						
						while(rs.next()) {	
							codigo = rs.getInt("IDJUGADOR") + 1;
						}
						
						String nom = txtNombre.getText();
						String pos = textPosicion.getText();
						String alt = textAltura.getText();
						String pes = textPeso.getText();
						String dor = textDorsal.getText();
						String nac = textNac.getText();
						
						try {
							String nj = "INSERT INTO `proyectoprog`.`jugadores` (`IDJUGADOR`, `JUGADOR`, `EQUIPO`, `POSICION`, `ALTURA`, `PESO`, `NACIMIENTO`, `DORSAL`) VALUES ('"+codigo+"', '"+nom+"', 'Villarreal CF', '"+pos+"', '"+alt+"', '"+pes+"', '"+nac+"', '"+dor+"')";
							
							ps = (PreparedStatement) con.prepareStatement(nj);
							
							ps.executeUpdate();
							
							JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
							encima.setAlwaysOnTop(true);
							JOptionPane.showMessageDialog(encima, "¡Jugador introducido!");
							
							System.exit(0);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}	
						
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					
				}

			}	
		});
		btnVillarreal.setBounds(564, 567, 142, 23);
		contentPane.add(btnVillarreal);
		
		JLabel lblSeleccionaElEquipo = new JLabel("Selecciona el equipo del fichaje tras rellenar sus datos");
		lblSeleccionaElEquipo.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeleccionaElEquipo.setForeground(SystemColor.menu);
		lblSeleccionaElEquipo.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblSeleccionaElEquipo.setBounds(0, 359, 724, 46);
		contentPane.add(lblSeleccionaElEquipo);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 346, 707, 2);
		contentPane.add(separator_1);
	}
}
