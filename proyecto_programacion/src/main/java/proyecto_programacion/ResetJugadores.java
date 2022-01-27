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
import com.mysql.jdbc.PreparedStatement;

import javax.swing.BoxLayout;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

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
import java.awt.SystemColor;

public class ResetJugadores extends JFrame {				/*ARREGLADO, se puede eliminar todos o de uno en uno***********************/

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
	
	static String jugador;									//Variable para manejo de los datos de la BBDD

	
	public static String getJugador() {						//Getter y setter
		return jugador;
	}

	public static void setJugador(String jugador) {
		ResetJugadores.jugador = jugador;
	}

	/**
	 * Launch the application.
	 */
	
	public static void reset() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ResetJugadores frame = new ResetJugadores();
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
	public ResetJugadores() {
		setResizable(false);								//Que no se pueda redimensionar
		
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();

		try {		
		setAlwaysOnTop(true);								//Hacer que salga encima de todo
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		//Características de los elementos gráficos
		setBounds(100, 100, 676, 607);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(47, 79, 79));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/*
		 * Funcionamiento de la tabla y el buscador igual al de la clase "BuscarJugadores", pero solo aparecerán los introducidos
		 * por ti mismo
		 */
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {			
			@Override
			public void mouseClicked(MouseEvent evento) {
				
				int seleccion = table.rowAtPoint(evento.getPoint());
				textJugadorEscogido.setText(String.valueOf(table.getValueAt(seleccion, 0)));
				
			}
		});
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		st = con.createStatement();
		
		String sql = "SELECT * FROM jugadores WHERE IDJUGADOR > 49 ORDER BY EQUIPO ASC";

		model = new DefaultTableModel();
		
		model.addColumn("JUGADOR");
		model.addColumn("EQUIPO");
		
		table.setModel(model);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(310, 109, 315, 276);
		contentPane.add(scrollPane);
		scrollPane.setViewportView(table);
		
		panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(47, 79, 79)));
		panel.setBackground(new Color(47, 79, 79));
		panel.setBounds(24, 109, 276, 113);
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
		textBuscador.addKeyListener(new KeyAdapter() {
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
		panel_1.setBounds(24, 208, 276, 177);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblJugadorEscogido = new JLabel("Jugador que borrarás:");
		lblJugadorEscogido.setForeground(new Color(192, 192, 192));
		lblJugadorEscogido.setFont(new Font("Tw Cen MT Condensed", Font.BOLD, 25));
		lblJugadorEscogido.setBounds(20, 24, 209, 30);
		panel_1.add(lblJugadorEscogido);
		
		JButton btnMostrarDatos = new JButton("Eliminar jugador");
		btnMostrarDatos.setBackground(UIManager.getColor("Button.background"));
		btnMostrarDatos.setFont(new Font("Sitka Text", Font.PLAIN, 15));
		btnMostrarDatos.setBounds(42, 118, 187, 46);
		panel_1.add(btnMostrarDatos);
		
		textJugadorEscogido = new JTextField();
		textJugadorEscogido.setFont(new Font("Tahoma", Font.PLAIN, 17));
		textJugadorEscogido.setBounds(20, 65, 227, 30);
		panel_1.add(textJugadorEscogido);
		textJugadorEscogido.setColumns(10);
		
		lblNewLabel = new JLabel("ELIMINAR FICHAJES");
		lblNewLabel.setForeground(UIManager.getColor("Button.background"));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD | Font.ITALIC, 29));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 11, 670, 46);
		contentPane.add(lblNewLabel);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(101, 55, 467, 2);
		contentPane.add(separator);
		
		JLabel lblquieresBorrarTodos = new JLabel("Pulsa aquí si quieres borrar TODOS los fichajes realizados");
		lblquieresBorrarTodos.setHorizontalAlignment(SwingConstants.CENTER);
		lblquieresBorrarTodos.setForeground(SystemColor.menu);
		lblquieresBorrarTodos.setFont(new Font("Yu Gothic", Font.BOLD, 16));
		lblquieresBorrarTodos.setBounds(0, 453, 647, 39);
		contentPane.add(lblquieresBorrarTodos);
		
		JButton btnNewButton = new JButton("CONFIRMAR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Conexion conexion = new Conexion();
				Connection con = null;
				PreparedStatement ps = null;
				
				con = conexion.conectar();
				
				/*
				 * Como los jugadores reales introducidos por mi son 48, a partir de ahí serán los demás
				 * Con el botón confirmar se eliminar todos los que tengan desde la id 50 (en este caso) en adelante
				 */
				try {		
					String eliminar = "DELETE FROM jugadores WHERE IDJUGADOR > 49";
					
					ps = (PreparedStatement) con.prepareStatement(eliminar);
					
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje
				encima.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(encima, "¡Fichajes borrados!");
				
				System.exit(0);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(177, 503, 301, 39);
		contentPane.add(btnNewButton);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(24, 440, 616, 2);
		contentPane.add(separator_1);
		btnMostrarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				jugador = textJugadorEscogido.getText();			//Cogemos el nombre del jugador y lo guardamos en la variable
				
				Conexion conexion = new Conexion();
				Connection con = null;
				PreparedStatement ps = null;
				
				con = conexion.conectar();

				try {
					
					//Eliminamos solo el jugador que ha sido seleccionado
					String eliminar = "DELETE FROM jugadores WHERE JUGADOR LIKE "+'"'+jugador+'"';					
					ps = (PreparedStatement) con.prepareStatement(eliminar);
					
					ps.executeUpdate();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JFrame encima = new JFrame();		//Se crea este JFrame para poder aplicar el setAlwaysOnTop y que se vea el mensaje
				encima.setAlwaysOnTop(true);
				JOptionPane.showMessageDialog(encima, "¡Fichajes borrados!");
				
				System.exit(0);
				
			}
		});
		
		//Mismo funcionamiento que en "BuscarJugadores"
		String[] dato = new String[2];
		
		st = con.createStatement();
		
		rs = st.executeQuery(sql);
		
		while(rs.next()) {
			dato[0] = rs.getString("JUGADOR");
			dato[1] = rs.getString("EQUIPO");
			model.addRow(dato);
		}
		
		}catch (SQLException e) {
			
			System.out.println("No se ha podido conectar con la base de datos");
		}
		
	}
	
	public void buscador(String texto) {
		Conexion conexion = new Conexion();
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		con = conexion.conectar();
		try {
			String [] cabecera = {"JUGADOR", "EQUIPO"};
			String sql = "SELECT * FROM jugadores WHERE JUGADOR LIKE "+'"'+"%"+texto+"%"+'"'+" AND IDJUGADOR > 49";
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