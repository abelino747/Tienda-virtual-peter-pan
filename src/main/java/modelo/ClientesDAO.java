package modelo;

import java.sql.*;
import controlador.Conexion;

// data access object
public class ClientesDAO {

	Conexion conx = new Conexion();
	Connection cnn = conx.Conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ClientesDTO clientesdto = null;

	public boolean insertar(ClientesDTO clien) {
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato = false;

		try {
			ps = cnn.prepareStatement("INSERT INTO clientes Values(?,?,?,?,?)");
			ps.setLong(1, clien.getCedula_cliente());
			ps.setString(2, clien.getNombre_cliente());
			ps.setString(3, clien.getDireccion_cliente());
			ps.setString(4, clien.getEmail_cliente());
			ps.setString(5, clien.getTelefono_cliente());
			registro = ps.executeUpdate();
			if (registro > 0) {
				dato = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}

	
	public boolean actualizar(ClientesDTO clien) {
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato = false;

		try {
			ps= cnn.prepareStatement("UPDATE clientes SET nombre_cliente=?,direccion_cliente=?,email_cliente=?,telefono_cliente=? WHERE cedula_cliente=?");
			
			ps.setString(1, clien.getNombre_cliente());
			ps.setString(2, clien.getDireccion_cliente());
			ps.setString(3, clien.getEmail_cliente());
			ps.setString(4, clien.getTelefono_cliente());
			ps.setLong(5, clien.getCedula_cliente());
			registro = ps.executeUpdate();
					
			
			if (registro > 0) {
				dato = true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}
	// consultar
	public ClientesDTO consultar(ClientesDTO cedula_cliente) {
	
		try {
			ps= cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			//cambie el int por long por que en dto es del tipo long
			ps.setLong(1, cedula_cliente.getCedula_cliente());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				clientesdto=new ClientesDTO(rs.getLong(1),rs.getString(2),rs.getString(3),
		                   rs.getString(4),rs.getString(5));					
							
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientesdto;
		
	}

}
