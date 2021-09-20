package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection conx;
	
	public Connection Conexionbd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				conx=DriverManager.getConnection("jdbc:mysql://localhost/TG", "root", "toor");
				JOptionPane.showMessageDialog(null, "...Conexion Realizada...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return conx;}
	
}
