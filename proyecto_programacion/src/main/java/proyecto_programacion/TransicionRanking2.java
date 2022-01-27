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

public class TransicionRanking2 extends JFrame {	//Mismo funcionamiento que "TransiciónRanking" pero para el juego y ranking 2

	private JPanel contentPane;
	private JTextField textField_7;
	static String nombre;
	private JLabel lblNombre;
	private JSeparator separator;
	private JLabel lblNewLabel;
	private JLabel lblquieresVerEl;

	public static String getNombre() {
		return nombre;
	}

	public static void setNombre(String nombre) {
		TransicionRanking.nombre = nombre;
	}


	/**
	 * Launch the application.
	 */
	public static void transicion2() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TransicionRanking2 frame = new TransicionRanking2();
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
	public TransicionRanking2() {
		setResizable(false);								//Que no se pueda redimensionar

		setAlwaysOnTop(true);								//Hacer que salga encima de todo

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		lblNombre.setText(EntrarRanking2.getNom());
		
		separator = new JSeparator();
		separator.setBounds(104, 65, 510, 2);
		contentPane.add(separator);
		
		lblNewLabel = new JLabel("Has entrado en el ránking de \"Entre Tres\" con una puntuación de");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setBounds(91, 149, 519, 23);
		contentPane.add(lblNewLabel);
		
		lblquieresVerEl = new JLabel("¿Quieres ver si estás en el top del ránking?");
		lblquieresVerEl.setHorizontalAlignment(SwingConstants.CENTER);
		lblquieresVerEl.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblquieresVerEl.setForeground(UIManager.getColor("Button.background"));
		lblquieresVerEl.setBounds(0, 204, 724, 46);
		contentPane.add(lblquieresVerEl);
		
		JButton btnNewButton = new JButton("SI");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RankingJ2.RankingEntreTres();
			}
		});
		btnNewButton.setBounds(204, 276, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNo = new JButton("NO");
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
		lblPuntos.setBounds(608, 149, 66, 23);
		contentPane.add(lblPuntos);
	
		lblPuntos.setText(String.valueOf(EntrarRanking2.getScore())); 	//String.valueOf para transformar la variable int a String
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(456, 148, 86, 20);
	}
}
