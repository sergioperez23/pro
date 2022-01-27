package proyecto_programacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	
	private static final String controlador = "com.mysql.jdbc.Driver";			//Creamos las variables para conectarnos a nuestra BBDD
	private static final String url = "jdbc:mysql://localhost:3306/proyectoprog?useSSL=false";
	private static final String usuario = "root";
	private static final String clave = "root";
	
	static {
		try {
			Class.forName(controlador);
		}  catch (ClassNotFoundException e) {
			System.out.println("Error al conectar con la base de datos.");
			e.printStackTrace();
		}
	}
	
	public Connection conectar() {				//Creamos el método
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(url, usuario, clave);
		} catch (SQLException e) {
			System.out.println("Error en la conexión");
			e.printStackTrace();
		}	
		
		return conexion;
	}
	
	
}