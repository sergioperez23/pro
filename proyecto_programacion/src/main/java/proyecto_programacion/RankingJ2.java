package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import java.awt.SystemColor;
import javax.swing.JSeparator;
import javax.swing.UIManager;

public class RankingJ2 extends JFrame {		//Mismo funcionamiento que la clase RankingJ1, pero todo para el Ranking 2

	private JPanel contentPane;
	private JLabel lblFoto1;
	private JLabel lblFoto2;
	private JLabel lblFoto3;
	private JLabel lblRnkEntreTres;
	private JSeparator separator;
	private JLabel lbl5;
	private JLabel lblNombre1;
	private JLabel lblScore1;
	private JLabel lblNombre1_1;
	private JLabel lblScore1_1;
	private JLabel lblNombre1_2;
	private JLabel lblScore1_2;
	private JLabel lblNombre1_3;
	private JLabel lblScore1_3;
	private JLabel lblNombre1_4;
	private JLabel lblScore1_4;

	/**
	 * Launch the application.
	 */
	public static void RankingEntreTres() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RankingJ2 frame = new RankingJ2();
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
	public RankingJ2() {
		setResizable(false);
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();

		try {
		st = con.createStatement();
		
		String nom1 = "";
		String nom2 = "";
		String nom3 = "";
		String nom4 = "";
		String nom5 = "";
		String score1 = "";
		String score2 = "";
		String score3 = "";
		String score4 = "";
		String score5 = "";
		
		String puesto1 = "SELECT * FROM proyectoprog.ranking2 ORDER BY PUNTUACION DESC, NICK DESC LIMIT 0,1";
		rs = st.executeQuery(puesto1);
		while(rs.next()) {
			nom1 = rs.getString("NICK");
			score1 = rs.getString("PUNTUACION");
		}
		
		String puesto2 = "SELECT * FROM proyectoprog.ranking2 ORDER BY PUNTUACION DESC, NICK DESC LIMIT 1,1";
		rs = st.executeQuery(puesto2);
		while(rs.next()) {
			nom2 = rs.getString("NICK");
			score2 = rs.getString("PUNTUACION");
		}
		
		String puesto3 = "SELECT * FROM proyectoprog.ranking2 ORDER BY PUNTUACION DESC, NICK DESC LIMIT 2,1";
		rs = st.executeQuery(puesto3);
		while(rs.next()) {
			nom3 = rs.getString("NICK");
			score3 = rs.getString("PUNTUACION");
		}
		
		String puesto4 = "SELECT * FROM proyectoprog.ranking2 ORDER BY PUNTUACION DESC, NICK DESC LIMIT 3,1";
		rs = st.executeQuery(puesto4);
		while(rs.next()) {
			nom4 = rs.getString("NICK");
			score4 = rs.getString("PUNTUACION");
		}
		
		String puesto5 = "SELECT * FROM proyectoprog.ranking2 ORDER BY PUNTUACION DESC, NICK DESC LIMIT 4,1";
		rs = st.executeQuery(puesto5);
		while(rs.next()) {
			nom5 = rs.getString("NICK");
			score5 = rs.getString("PUNTUACION");
		}
		
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 724, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl4 = new JLabel("4º");
		lbl4.setForeground(Color.WHITE);
		lbl4.setHorizontalAlignment(SwingConstants.CENTER);
		lbl4.setFont(new Font("Magneto", Font.PLAIN, 36));
		lbl4.setBounds(294, 335, 135, 44);
		contentPane.add(lbl4);
		
		lblFoto1 = new JLabel("");		
		lblFoto1.setBounds(291, 83, 135, 125);
		ImageIcon ico = new ImageIcon(RankingJ1.class.getResource("/imagenes/ranking1.jpg"));
		ImageIcon img = new ImageIcon(ico.getImage().getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_SMOOTH));
		lblFoto1.setIcon(img);
		contentPane.add(lblFoto1);
		
		lblFoto2 = new JLabel("");
		lblFoto2.setBounds(77, 153, 135, 125);
		ImageIcon ico2 = new ImageIcon(RankingJ1.class.getResource("/imagenes/ranking2.jpg"));
		ImageIcon img2 = new ImageIcon(ico2.getImage().getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_SMOOTH));
		lblFoto2.setIcon(img2);
		contentPane.add(lblFoto2);
		
		lblFoto3 = new JLabel("");
		lblFoto3.setBounds(498, 153, 135, 125);
		ImageIcon ico3 = new ImageIcon(RankingJ1.class.getResource("/imagenes/ranking3.jpg"));
		ImageIcon img3 = new ImageIcon(ico3.getImage().getScaledInstance(lblFoto1.getWidth(), lblFoto1.getHeight(), Image.SCALE_SMOOTH));
		lblFoto3.setIcon(img3);
		contentPane.add(lblFoto3);
		
		lblRnkEntreTres = new JLabel("RANKING \"ENTRE TRES\"");
		lblRnkEntreTres.setHorizontalAlignment(SwingConstants.CENTER);
		lblRnkEntreTres.setForeground(SystemColor.menu);
		lblRnkEntreTres.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblRnkEntreTres.setBounds(0, 26, 718, 46);
		contentPane.add(lblRnkEntreTres);
		
		separator = new JSeparator();
		separator.setBounds(104, 70, 501, 2);
		contentPane.add(separator);
		
		lbl5 = new JLabel("5º");
		lbl5.setForeground(Color.WHITE);
		lbl5.setHorizontalAlignment(SwingConstants.CENTER);
		lbl5.setFont(new Font("Magneto", Font.PLAIN, 36));
		lbl5.setBounds(273, 475, 173, 44);
		contentPane.add(lbl5);
		
		lblNombre1 = new JLabel("");
		lblNombre1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNombre1.setForeground(UIManager.getColor("Button.background"));
		lblNombre1.setBounds(273, 207, 173, 28);
		contentPane.add(lblNombre1);
		lblNombre1.setText(nom1); 
		
		lblScore1 = new JLabel("");
		lblScore1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1.setForeground(Color.LIGHT_GRAY);
		lblScore1.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblScore1.setBounds(272, 231, 173, 28);
		contentPane.add(lblScore1);
		lblScore1.setText(score1); 
		
		lblNombre1_1 = new JLabel("");
		lblNombre1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1_1.setForeground(SystemColor.menu);
		lblNombre1_1.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNombre1_1.setBounds(58, 285, 173, 28);
		contentPane.add(lblNombre1_1);
		lblNombre1_1.setText(nom2); 
		
		lblScore1_1 = new JLabel("");
		lblScore1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1_1.setForeground(Color.LIGHT_GRAY);
		lblScore1_1.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblScore1_1.setBounds(58, 307, 173, 28);
		contentPane.add(lblScore1_1);
		lblScore1_1.setText(score2); 
		
		lblNombre1_2 = new JLabel("");
		lblNombre1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1_2.setForeground(SystemColor.menu);
		lblNombre1_2.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNombre1_2.setBounds(477, 285, 173, 28);
		contentPane.add(lblNombre1_2);
		lblNombre1_2.setText(nom3); 
		
		lblScore1_2 = new JLabel("");
		lblScore1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1_2.setForeground(Color.LIGHT_GRAY);
		lblScore1_2.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblScore1_2.setBounds(477, 307, 173, 28);
		contentPane.add(lblScore1_2);
		lblScore1_2.setText(score3); 
		
		lblNombre1_3 = new JLabel("");
		lblNombre1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1_3.setForeground(SystemColor.menu);
		lblNombre1_3.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNombre1_3.setBounds(273, 369, 177, 34);
		contentPane.add(lblNombre1_3);
		lblNombre1_3.setText(nom4); 
		
		lblScore1_3 = new JLabel("");
		lblScore1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1_3.setForeground(SystemColor.menu);
		lblScore1_3.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblScore1_3.setBounds(273, 394, 177, 34);
		contentPane.add(lblScore1_3);
		lblScore1_3.setText(score4); 
		
		lblNombre1_4 = new JLabel("");
		lblNombre1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNombre1_4.setForeground(SystemColor.menu);
		lblNombre1_4.setFont(new Font("Yu Gothic", Font.BOLD, 18));
		lblNombre1_4.setBounds(273, 510, 172, 28);
		contentPane.add(lblNombre1_4);
		lblNombre1_4.setText(nom5); 
		
		lblScore1_4 = new JLabel("");
		lblScore1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore1_4.setForeground(SystemColor.menu);
		lblScore1_4.setFont(new Font("Yu Gothic", Font.BOLD, 20));
		lblScore1_4.setBounds(273, 534, 173, 28);
		contentPane.add(lblScore1_4);
		lblScore1_4.setText(score5); 

		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
