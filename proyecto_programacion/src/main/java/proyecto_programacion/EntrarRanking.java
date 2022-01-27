package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.mysql.jdbc.PreparedStatement;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EntrarRanking extends JFrame {

	private JPanel contentPane;					//Variables correspondientes a los elementos de la interfaz gráfica
	private JTextField textField;
	
	static String nom;							//Variables para manejo de los datos de la BBDD
	static int score;
	
	public static int getScore() {				//Getters y setters
		return score;
	}

	public static void setScore(int score) {
		EntrarRanking.score = score;
	}

	
	public static String getNom() {
		return nom;
	}

	public static void setNom(String nom) {
		EntrarRanking.nom = nom;
	}

	
	/**
	 * Launch the application.
	 */
	public static void rankingjuego1() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntrarRanking frame = new EntrarRanking();
					frame.setLocationRelativeTo(null);					//Centrar en pantalla
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public EntrarRanking() {
		setResizable(false);								//Que no se pueda redimensionar
		
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Características de los elementos gráficos
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPregunta = new JLabel("¿Quieres introducir tu puntuación en el ránking?");
		lblPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblPregunta.setForeground(UIManager.getColor("Button.background"));
		lblPregunta.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblPregunta.setBounds(0, 48, 434, 39);
		contentPane.add(lblPregunta);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				if(textField.getText().length() >= 10) {				//Que no se puedan introducir más de 10 caracteres
					e.consume();
				}
			}
		});
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setColumns(10);
		textField.setBounds(229, 110, 147, 28);
		contentPane.add(textField);
		
		JLabel lblEscribeTuNombre = new JLabel("Escribe tu nombre:");
		lblEscribeTuNombre.setForeground(SystemColor.menu);
		lblEscribeTuNombre.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblEscribeTuNombre.setBounds(53, 110, 179, 33);
		contentPane.add(lblEscribeTuNombre);
		
		JButton btnSi = new JButton("ENTRAR");
		btnSi.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(textField.getText().isEmpty()) {	//Que salte un mensaje si se deja el campo vacío
					JFrame encima = new JFrame();	//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje de error
					encima.setAlwaysOnTop(true);
					JOptionPane.showMessageDialog(encima, "¡No puedes entrar en el ránking sin un nombre!");
				}
				else {
				Conexion conexion = new Conexion();
				Connection con = null;
				PreparedStatement ps = null;
				
				con = conexion.conectar();
				
				int codigo = Juegos.getCod_j1();	//Código sacado de la clase juegos que se incrementa en 1 del más mayor que haya en la BBDD
				nom = textField.getText();			//Nombre que se quiera introducir al ranking
				score = Juegos.getRonda();			//Puntuación obtenida en el juego
				
				try {
					//Query para entrar en el ranking en la BBDD
					String query2 = "INSERT INTO `proyectoprog`.`ranking` (`IDNICK`, `NICK`, `PUNTUACION`) VALUES ('"+codigo+"', '"+nom+"', '"+score+"')";
					
					ps = (PreparedStatement) con.prepareStatement(query2);
					
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				TransicionRanking.transicion();
			}	
			}
		});
		btnSi.setBounds(92, 184, 91, 32);
		contentPane.add(btnSi);
		
		JButton btnNo = new JButton("SALIR");
		btnNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNo.setBounds(232, 184, 91, 32);
		contentPane.add(btnNo);
	
	}
}