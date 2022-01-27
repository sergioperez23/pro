package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class EleccionEquipo extends JFrame {

	private JPanel contentPane;					//Variable correspondiente al elemento de la interfaz gráfica
	
	static int opc;								//Variable para manejo de los datos de la BBDD
	

	public int getOpc() {
		return opc;
	}

	public void setOpc(int opc) {
		this.opc = opc;
	}

	
	/**
	 * Launch the application.
	 */
	public static void seleccion_de_equipo() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EleccionEquipo frame = new EleccionEquipo();
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
	public EleccionEquipo() {
		setResizable(false);				//Que no se pueda redimensionar
		
		setAlwaysOnTop(true);				//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);			//Características de los elementos gráficos
		setBounds(100, 100, 751, 488);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * A partir de aquí comienzan los botones, todos personalizados según el nombre del equipo y con la variable "opc" adecuada al
		 * id de cada uno en la base de datos
		 */
		JButton btnAthletic = new JButton("Athletic Club");			
		btnAthletic.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				opc = 1;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}

		});
		btnAthletic.setBounds(124, 88, 169, 23);
		contentPane.add(btnAthletic);
		
		JButton btnAtlticoDeMadrid = new JButton("Atlético de Madrid");
		btnAtlticoDeMadrid.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {	
				opc = 2;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}

		});
		btnAtlticoDeMadrid.setBounds(124, 122, 169, 23);
		contentPane.add(btnAtlticoDeMadrid);
		
		JButton btnOsasuna = new JButton("CA Osasuna");
		btnOsasuna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 3;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnOsasuna.setBounds(124, 156, 169, 23);
		contentPane.add(btnOsasuna);
		
		JButton btnCádizCF = new JButton("Cádiz CF");
		btnCádizCF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 4;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnCádizCF.setBounds(124, 190, 169, 23);
		contentPane.add(btnCádizCF);
		
		JButton btnAlavés = new JButton("Deportivo Alavés");
		btnAlavés.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 5;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnAlavés.setBounds(124, 224, 169, 23);
		contentPane.add(btnAlavés);
		
		JButton btnElche = new JButton("Eleche CF");
		btnElche.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 6;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnElche.setBounds(124, 258, 169, 23);
		contentPane.add(btnElche);
		
		JButton btnBarcelona = new JButton("FC Barcelona");
		btnBarcelona.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 7;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnBarcelona.setBounds(124, 292, 169, 23);
		contentPane.add(btnBarcelona);
		
		JButton btnGetafe = new JButton("Getafe CF");
		btnGetafe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 8;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnGetafe.setBounds(124, 326, 169, 23);
		contentPane.add(btnGetafe);
		
		JButton btnGranada = new JButton("Granada CF");
		btnGranada.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 9;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnGranada.setBounds(124, 360, 169, 23);
		contentPane.add(btnGranada);
		
		JButton btnLevante = new JButton("Levante UD");
		btnLevante.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 10;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnLevante.setBounds(124, 394, 169, 23);
		contentPane.add(btnLevante);
		
		JButton btnCelta = new JButton("Celta de Vigo");
		btnCelta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 11;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnCelta.setBounds(434, 88, 174, 23);
		contentPane.add(btnCelta);
		
		JButton btnBetis = new JButton("Real Betis");
		btnBetis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 12;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnBetis.setBounds(434, 122, 174, 23);
		contentPane.add(btnBetis);
		
		JButton btnMadrid = new JButton("Real Madrid");
		btnMadrid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 13;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnMadrid.setBounds(434, 156, 174, 23);
		contentPane.add(btnMadrid);
		
		JButton btnSociedad = new JButton("Real Sociedad");
		btnSociedad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 14;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnSociedad.setBounds(434, 190, 174, 23);
		contentPane.add(btnSociedad);
		
		JButton btnValladolid = new JButton("Real Valladolid");
		btnValladolid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 15;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnValladolid.setBounds(434, 224, 174, 23);
		contentPane.add(btnValladolid);
		
		JButton btnEibar = new JButton("SD Eibar");
		btnEibar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 16;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnEibar.setBounds(434, 258, 174, 23);
		contentPane.add(btnEibar);
		
		JButton btnHuesca = new JButton("SD Huesca");
		btnHuesca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 17;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnHuesca.setBounds(434, 292, 174, 23);
		contentPane.add(btnHuesca);
		
		JButton btnSevilla = new JButton("Sevilla FC");
		btnSevilla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 18;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnSevilla.setBounds(434, 326, 174, 23);
		contentPane.add(btnSevilla);
		
		JButton btnValencia = new JButton("Valencia CF");
		btnValencia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 19;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnValencia.setBounds(434, 360, 174, 23);
		contentPane.add(btnValencia);
		
		JButton btnVillarreal = new JButton("Villarreal CF");
		btnVillarreal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				opc = 20;
				
				VentanaEquipos datos = new VentanaEquipos();
				
				datos.datosequipo();
			}
		});
		btnVillarreal.setBounds(434, 394, 174, 23);
		contentPane.add(btnVillarreal);
		
		JLabel lblEleccion = new JLabel("ELIGE UN EQUIPO");				//Título y separador para que sea mas estético
		lblEleccion.setHorizontalAlignment(SwingConstants.CENTER);
		lblEleccion.setForeground(SystemColor.menu);
		lblEleccion.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblEleccion.setBounds(0, 11, 745, 46);
		contentPane.add(lblEleccion);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(104, 55, 523, 2);
		contentPane.add(separator_1);
	}
}
