package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controlador.Conexion;

public class ProveedoresDAO {
	
	Conexion conx= new Conexion();
	Connection cnn= conx.Conexionbd();
	PreparedStatement ps;
	
	
	public boolean insertar(ProveedoresDTO proveedor){
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato=false;
		
		try {
			ps= cnn.prepareStatement("INSERT INTO proveedores (nit_proveedor, nombre_proveedor, ciudad_proveedor, direccion_proveedor, telefono_proveedor) Values(?,?,?,?,?)");
			ps.setLong(1, proveedor.getNit_proveedor());
			ps.setString(2, proveedor.getNombre_proveedor());
			ps.setString(3, proveedor.getCiudad_proveedor());
			ps.setString(4, proveedor.getDireccion_proveedor());
			ps.setString(5, proveedor.getTelefono_proveedor());
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
