package modelo;

import java.sql.*;
import controlador.Conexion;

public class UsuariosDAO {
	
	Conexion conx= new Conexion();
	Connection cnn= conx.Conexionbd();
	PreparedStatement ps;
	// usu es un metodo que me permite traer los datos del DTO
	
	public boolean insertar(UsuariosDTO usu){
		int registro;
		boolean dato=false;
		System.out.println(usu.getCedula_usuario());
		System.out.println(usu.getNombre_usuario());
		try {
			ps= cnn.prepareStatement("INSERT INTO Usuarios Values(?,?,?,?,?)");
			ps.setLong(1, usu.getCedula_usuario());
			ps.setString(2, usu.getNombre_usuario());
			ps.setString(3, usu.getEmail_usuario());
			ps.setString(4, usu.getUsuario());
			ps.setString(5, usu.getPassword());
			registro = ps.executeUpdate();
			if(registro>0) {
				dato=true;
			}			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}
}
