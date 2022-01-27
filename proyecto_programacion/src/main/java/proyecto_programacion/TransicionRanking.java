package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransicionRanking extends JFrame {

	private JPanel contentPane;					//Variables correspondientes a los elementos de la interfaz gráfica
	private JTextField textField_7;
	private JLabel lblNombre;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblquieresVerEl;

	static String nombre;						//Variable para manejo de los datos de la BBDD
	
	public static String getNombre() {			//Getter y setter
		return nombre;
	}

	public static void setNombre(String nombre) {
		TransicionRanking.nombre = nombre;
	}


	/**
	 * Launch the application.
	 */
	public static void transicion() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransicionRanking frame = new TransicionRanking();
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
	public TransicionRanking() {
		setResizable(false);								//Que no se pueda redimensionar

		setAlwaysOnTop(true);								//Hacer que salga encima de todo

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Características de los elementos gráficos
		setBounds(100, 100, 740, 379);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNombre = new JLabel("");
		lblNombre.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre.setForeground(SystemColor.menu);
		lblNombre.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblNombre.setBounds(0, 21, 724, 46);
		contentPane.add(lblNombre);
		
		lblNombre.setText(EntrarRanking.getNom());
		
		separator = new JSeparator();
		separator.setBounds(104, 65, 510, 2);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("Has entrado en el ránking de \"Adivina Quién\" con una puntuación de");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setBounds(73, 149, 537, 23);
		contentPane.add(lblNewLabel);
		
		lblquieresVerEl = new JLabel("¿Quieres ver si estás en el top del ránking?");
		lblquieresVerEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblquieresVerEl.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblquieresVerEl.setForeground(UIManager.getColor("Button.background"));
		lblquieresVerEl.setBounds(0, 204, 724, 46);
		contentPane.add(lblquieresVerEl);
		
		JButton btnNewButton = new JButton("SI");		//Botón "si" que llama al método del ranking para poder verlo
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingJ1.RankingAdivinaQuien();
			}
		});
		btnNewButton.setBounds(204, 276, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNo = new JButton("NO");				//Botón "no" que simplemente cierra la ventana
		btnNo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNo.setBounds(426, 276, 89, 23);
		contentPane.add(btnNo);
		
		JLabel lblPuntos = new JLabel("");
		lblPuntos.setForeground(SystemColor.menu);
		lblPuntos.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblPuntos.setBounds(616, 149, 66, 23);
		contentPane.add(lblPuntos);
	
		lblPuntos.setText(String.valueOf(EntrarRanking.getScore())); 	//String.valueOf para transformar la variable int a String
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(456, 148, 86, 20);
	}
}
