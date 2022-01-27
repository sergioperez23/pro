package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.GridBagLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import net.miginfocom.swing.MigLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSeparator;

public class BuscarJugadores extends JFrame {

	private JPanel contentPane;								//Variables correspondientes a los elementos de la interfaz gráfica
	private JTable table;
	private JScrollPane scrollPane;								
	DefaultTableModel model;
	private JTextField textBuscador;
	private JTextField textJugadorEscogido;
	private JLabel lblJugadorEscogido;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	
	static String jugador;									//Variables para manejo de los datos de la BBDD
	static String equipo;
	static String posicion;
	static String goles;
	static String asistencias;
	static String partidos_jug;
	static String partidos_tit;
	static String amarillas;
	static String rojas;
	static String dorsal;
	static String nacimiento;
	static String altura;
	static String peso;

	
	public static String getJugador() {									//Getters y setters para su utilización
		return jugador;
	}

	public static void setJugador(String jugador) {
		BuscarJugadores.jugador = jugador;
	}

	public static String getEquipo() {
		return equipo;
	}

	public static void setEquipo(String equipo) {
		BuscarJugadores.equipo = equipo;
	}

	public static String getPosicion() {
		return posicion;
	}

	public static void setPosicion(String posicion) {
		BuscarJugadores.posicion = posicion;
	}

	public static String getGoles() {
		return goles;
	}

	public static void setGoles(String goles) {
		BuscarJugadores.goles = goles;
	}

	public static String getAsistencias() {
		return asistencias;
	}

	public static void setAsistencias(String asistencias) {
		BuscarJugadores.asistencias = asistencias;
	}

	public static String getPartidos_jug() {
		return partidos_jug;
	}

	public static void setPartidos_jug(String partidos_jug) {
		BuscarJugadores.partidos_jug = partidos_jug;
	}

	public static String getPartidos_tit() {
		return partidos_tit;
	}

	public static void setPartidos_tit(String partidos_tit) {
		BuscarJugadores.partidos_tit = partidos_tit;
	}

	public static String getAmarillas() {
		return amarillas;
	}

	public static void setAmarillas(String amarillas) {
		BuscarJugadores.amarillas = amarillas;
	}

	public static String getRojas() {
		return rojas;
	}

	public static void setRojas(String rojas) {
		BuscarJugadores.rojas = rojas;
	}

	public static String getDorsal() {
		return dorsal;
	}

	public static void setDorsal(String dorsal) {
		BuscarJugadores.dorsal = dorsal;
	}

	public static String getNacimiento() {
		return nacimiento;
	}

	public static void setNacimiento(String nacimiento) {
		BuscarJugadores.nacimiento = nacimiento;
	}

	public static String getAltura() {
		return altura;
	}

	public static void setAltura(String altura) {
		BuscarJugadores.altura = altura;
	}

	public static String getPeso() {
		return peso;
	}

	public static void setPeso(String peso) {
		BuscarJugadores.peso = peso;
	}

	/**
	 * Launch the application.
	 */
	
	public static void jugadores() {		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BuscarJugadores frame = new BuscarJugadores();
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
	public BuscarJugadores() {
		setResizable(false);								//Que no se pueda redimensionar
		
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();

		try {		
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Características de los elementos gráficos
		setBounds(100, 100, 676, 551);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {				//Código para seleccionar al jugador con un click en la tabla
			@Override
			public void mouseClicked(MouseEvent evento) {
				
				int seleccion = table.rowAtPoint(evento.getPoint());
				textJugadorEscogido.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		st = con.createStatement();
		
		String sql = "SELECT * FROM jugadores ORDER BY EQUIPO ASC";

		model = new DefaultTableModel();				//Cremoa el modelo de la tabla
		
		model.addColumn("JUGADOR");						//Añadimos las columnas que queramos y decimos el nombre de la cabecera
		model.addColumn("EQUIPO");
		
		table.setModel(model);							//Insertamos nuestro modelo dentro del Jtable "table"
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 109, 315, 388);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(47, 79, 79)));
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(24, 144, 276, 113);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblBuscarJugador = new JLabel("Buscar jugador:");
		lblBuscarJugador.setForeground(new Color(192, 192, 192));
		lblBuscarJugador.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		lblBuscarJugador.setBounds(21, 11, 176, 39);
		panel.add(lblBuscarJugador);
		
		textBuscador = new JTextField();
		textBuscador.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textBuscador.setBounds(21, 61, 227, 30);
		panel.add(textBuscador);
		textBuscador.addKeyListener(new KeyAdapter() {				//Código para funcionamiento del buscador
			@Override
			public void keyReleased(KeyEvent e) {
				String buscar=textBuscador.getText();
				buscador(buscar);
			}
		});
		textBuscador.setColumns(10);
		
		panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(47, 79, 79)));
		panel_1.setBackground(new Color(47, 79, 79));
		panel_1.setBounds(24, 249, 276, 247);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblJugadorEscogido = new JLabel("Ver datos de:");
		lblJugadorEscogido.setForeground(new Color(192, 192, 192));
		lblJugadorEscogido.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		lblJugadorEscogido.setBounds(21, 49, 187, 30);
		panel_1.add(lblJugadorEscogido);
		
		JButton btnMostrarDatos = new JButton("Mostrar estadísticas");
		btnMostrarDatos.setBackground(UIManager.getColor("Button.background"));
		btnMostrarDatos.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnMostrarDatos.setBounds(43, 143, 187, 46);
		panel_1.add(btnMostrarDatos);
		
		textJugadorEscogido = new JTextField();
		textJugadorEscogido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textJugadorEscogido.setBounds(21, 90, 227, 30);
		panel_1.add(textJugadorEscogido);
		textJugadorEscogido.setColumns(10);
		
		lblNewLabel = new JLabel("BUSCADOR DE JUGADORES");
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 670, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 55, 467, 2);
		contentPane.add(separator);
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jugador = textJugadorEscogido.getText();
				
				Conexion conexion = new Conexion();
				Connection con = null;
				Statement st = null;
				ResultSet rs = null;

				con = conexion.conectar();
				
				/*
				 * A continuación hacemos las consultas y recolección de datos que mostraremos en la ventana de Datos de jugador
				 */
				String sql2 = "SELECT * FROM estadisticas WHERE IDJUG = (SELECT IDJUGADOR FROM jugadores WHERE JUGADOR LIKE "+'"'+jugador+'"'+")";
				
				try {
					st = con.prepareStatement(sql2);
					rs=st.executeQuery(sql2);
					
					while(rs.next()) {
						goles = rs.getString("GOLES");
						asistencias = rs.getString("ASISTENCIAS");
						partidos_jug = rs.getString("PARTIDOSJUG");
						partidos_tit = rs.getString("PARTIDOSTIT");
						amarillas = rs.getString("AMARILLAS");
						rojas = rs.getString("ROJAS");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				String sql3 = "SELECT * FROM jugadores WHERE IDJUGADOR = (SELECT IDJUGADOR FROM jugadores WHERE JUGADOR LIKE "+'"'+jugador+'"'+")";
				
				try {
					st = con.prepareStatement(sql3);
					rs=st.executeQuery(sql3);
					
					while(rs.next()) {
						equipo = rs.getString("EQUIPO");
						posicion = rs.getString("POSICION");
						nacimiento = rs.getString("NACIMIENTO");
						dorsal = rs.getString("DORSAL");
						altura = rs.getString("ALTURA");
						peso = rs.getString("PESO");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				DatosJugador.stats_jugador();
			}
		});
		
		String[] dato = new String[2];
		
		st = con.createStatement();
		
		rs = st.executeQuery(sql);
		
		/*
		* Añadimos al modelo de la tabla que queremos que vaya en cada columna, en este caso el nombre y el equipo de cada jugador
		*/
		while(rs.next()) {
			dato[0] = rs.getString("JUGADOR");
			dato[1] = rs.getString("EQUIPO");
			model.addRow(dato);
		}
		
		}catch (SQLException e) {
			
			System.out.println("No se ha podido conectar con la base de datos");
		}
		
	}
			/*
			 * Subprograma para el buscador automático
			 */
	public void buscador(String texto) {
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();
		try {
			String [] cabecera = {"JUGADOR", "EQUIPO"};
			String sql = "SELECT * FROM jugadores WHERE JUGADOR LIKE "+'"'+"%"+texto+"%"+'"';
			System.out.println(sql);
			model = new DefaultTableModel(null,cabecera);
			st = con.prepareStatement(sql);
			rs=st.executeQuery(sql);
			String fila [] = new String [2];
			while(rs.next()) {
				fila [0] = rs.getString("JUGADOR");
				fila [1] = rs.getString("EQUIPO");
				model.addRow(fila);
			}
			table.setModel(model);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
