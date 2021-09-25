package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//import javax.swing.JOptionPane;

public class Conexion {
	
	Connection con;
	
	public Connection Conexionbd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost/TG", "root", "Drluky0311.");
				//con=DriverManager.getConnection("jdbc:mysql://localhost/TG", "root", "root");
				//JOptionPane.showMessageDialog(null, "...Conexion Realizada...");
				System.out.println( "...Conexion Realizada...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("... Conexiion fallida...");
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return con;}
	
}
