package modelo;

import java.sql.*;
import controlador.Conexion;

 // data access object
public class ClientesDAO {
	
	Conexion conx= new Conexion();
	Connection cnn= conx.Conexionbd();
	PreparedStatement ps;
	
	
	public boolean insertar(ClientesDTO clien){
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato=false;

		try {
			ps= cnn.prepareStatement("INSERT INTO clientes Values(?,?,?,?,?)");
			ps.setLong(1, clien.getCedula_cliente());
			ps.setString(2, clien.getNombre_cliente());
			ps.setString(3, clien.getDireccion_cliente());
			ps.setString(4, clien.getEmail_cliente());
			ps.setString(5, clien.getTelefono_cliente());
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
