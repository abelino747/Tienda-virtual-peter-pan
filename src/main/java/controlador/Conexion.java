package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	
	Connection con;
	
	public Connection Conexionbd() {
		try {
			// para conectar con mysql workbench
			Class.forName("com.mysql.cj.jdbc.Driver");	
			// para conectar con mariadb
			Class.forName("org.mariadb.jdbc.Driver");
			try {
				//con=DriverManager.getConnection("jdbc:mysql://localhost/TG", "root", "Drluky0311.");
				con=DriverManager.getConnection("jdbc:mysql://localhost/TG", "root", "toor");
				
				
												
				//con=DriverManager.getConnection("jdbc:mariadb://tiendagenericagrupo43-10-32.czo3ixoe3xoe.us-east-1.rds.amazonaws.com/peter_pan", "admin", "123456789");				
				
				
				
				//JOptionPane.showMessageDialog(null, "...Conexion Realizada...");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Sin Conexion error:" +e);
		}	
		return con;}
	
}







