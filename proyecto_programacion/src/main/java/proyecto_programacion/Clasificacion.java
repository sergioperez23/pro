package proyecto_programacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class Clasificacion extends JFrame {

	private JPanel contentPane;						//Variables correspondientes a los elementos de la interfaz gráfica
	private JTable table;
	DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void MostrarClasi() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Clasificacion frame = new Clasificacion();
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
	public Clasificacion() {
		setResizable(false);								//Que no se pueda redimensionar
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();

		try {
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 846, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();									//Se crea la tabla y su modelo
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		model = new DefaultTableModel();
		
		model.addColumn("POSICIÓN");							//Añadimos las columnas que habrá con sus cabeceras
		model.addColumn("EQUIPO");
		model.addColumn("PUNTOS");
		model.addColumn("PARTIDOS");
		model.addColumn("VICTORIAS");
		model.addColumn("EMPATES");
		model.addColumn("DERROTAS");
		model.addColumn("GF");
		model.addColumn("GC");
		model.addColumn("DG");
		
		table.setModel(model);
		
		String[] dato = new String[10];
		
		st = con.createStatement();
		
		String sql = "SELECT * FROM clasificacion";
		
		st = con.createStatement();
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {									//Introducimos los datos de la BBDD en cada columna
			dato[0] = rs.getString("POSICION");
			dato[1] = rs.getString("NOMBRE");
			dato[2] = rs.getString("PUNTOS");
			dato[3] = rs.getString("PARTIDOS");
			dato[4] = rs.getString("VICTORIAS");
			dato[5] = rs.getString("EMPATES");
			dato[6] = rs.getString("DERROTAS");
			dato[7] = rs.getString("GF");
			dato[8] = rs.getString("GC");
			dato[9] = rs.getString("DG");
			model.addRow(dato);
		}
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 89, 734, 344);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);		
		
		JLabel lblClasificacinLaLiga = new JLabel("CLASIFICACIÓN LA LIGA 2020/2021");
		lblClasificacinLaLiga.setHorizontalAlignment(SwingConstants.CENTER);
		lblClasificacinLaLiga.setForeground(SystemColor.menu);
		lblClasificacinLaLiga.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblClasificacinLaLiga.setBounds(0, 23, 840, 46);
		contentPane.add(lblClasificacinLaLiga);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(21, 67, 787, 2);
		contentPane.add(separator);
		
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
