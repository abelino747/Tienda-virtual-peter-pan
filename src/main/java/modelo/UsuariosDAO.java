package modelo;

import java.sql.*;
import controlador.Conexion;

public class UsuariosDAO {
	
	Conexion conx= new Conexion();
	Connection cnn= conx.Conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	UsuariosDTO usuariodto= null;
	
	public boolean insertar(UsuariosDTO usu){
		// usu es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato=false;
		//System.out.println(usu.getCedula_usuario());
		//System.out.println(usu.getNombre_usuario());
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
	
	
	// consultar
	
		public UsuariosDTO consultar(UsuariosDTO cedus) {
			try {
				ps= cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
				//cambie el int por long por que en dto es del tipo long
				ps.setLong(1, cedus.getCedula_usuario());
				rs=ps.executeQuery();
				
				if(rs.next()) {
					
					usuariodto=new UsuariosDTO(rs.getLong(1),rs.getString(2),rs.getString(3),
							                   rs.getString(4),rs.getString(5));	
				}else{
					return null;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return usuariodto;
			
			
		}
	
}
