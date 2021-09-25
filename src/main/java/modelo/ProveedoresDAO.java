package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controlador.Conexion;

public class ProveedoresDAO {

	Conexion conx = new Conexion();
	Connection cnn = conx.Conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProveedoresDTO proveedordto= null;

	public boolean insertar(ProveedoresDTO proveedor) {
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato = false;

		try {
			ps = cnn.prepareStatement(
					"INSERT INTO proveedores (nit_proveedor, nombre_proveedor, ciudad_proveedor, direccion_proveedor, telefono_proveedor) Values(?,?,?,?,?)");
			ps.setLong(1, proveedor.getNit_proveedor());
			ps.setString(2, proveedor.getNombre_proveedor());
			ps.setString(3, proveedor.getCiudad_proveedor());
			ps.setString(4, proveedor.getDireccion_proveedor());
			ps.setString(5, proveedor.getTelefono_proveedor());
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

	public ProveedoresDTO consultar(ProveedoresDTO nit) {
		try {
			ps = cnn.prepareStatement("SELECT * FROM proveedores WHERE nit_proveedor=?");
			// cambie el int por long por que en dto es del tipo long
			ps.setLong(1, nit.getNit_proveedor());
			rs = ps.executeQuery();

			if (rs.next()) {

				proveedordto = new ProveedoresDTO(rs.getLong(1), rs.getString(2), 
						                          rs.getString(3), rs.getString(4), rs.getString(5));
			} else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return proveedordto;

	}
	//actualizar
	
			public int actualizar(ProveedoresDTO proveedor) {
				int x=0;
				try {
					
					ps= cnn.prepareStatement("UPDATE proveedores SET nombre_proveedor=?,ciudad_proveedor=?,direccion_proveedor=?,telefono_proveedor=? WHERE nit_proveedor=?");
					ps.setString(1, proveedor.getNombre_proveedor());
					ps.setString(2, proveedor.getCiudad_proveedor());
					ps.setString(3, proveedor.getDireccion_proveedor());
					ps.setString(4, proveedor.getTelefono_proveedor());
					// siempre se coloca al final el dato por el cual se consulta para actualizar
					ps.setLong(5, proveedor.getNit_proveedor());
					x=ps.executeUpdate();
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return x;
				
				
			}
}
