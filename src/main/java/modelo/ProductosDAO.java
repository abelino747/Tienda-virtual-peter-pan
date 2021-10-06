package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class ProductosDAO {
	Conexion conx = new Conexion();
	Connection cnn = conx.Conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProductosDTO produc = null;
	
	public boolean cargarProductos(String Url) {
		boolean dato = false;
		JOptionPane.showMessageDialog(null, "en DAO "+Url);

		try {
			ps = cnn.prepareStatement("load data infile '"+Url+"' into table productos fields terminated by';'lines terminated by '\r\n';");
			dato = ps.executeUpdate()>0;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error en DAO "+e);
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dato;
	}
	
	
	public ProductosDTO consultar(ProductosDTO prod) {
		try {
			ps= cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			//cambie el int por long por que en dto es del tipo long
			ps.setLong(1, prod.getCodigo_producto());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				
				produc=new ProductosDTO(rs.getLong(1),rs.getString(2),rs.getLong(3),
						                   rs.getLong(4),rs.getLong(5),rs.getLong(6));	
			}else{
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return produc;
		
		
	}
	
	public boolean actualizar(ProductosDTO prod) {
		// clien es un metodo que me permite traer los datos del DTO
		int registro;
		boolean dato = false;

		try {
			ps= cnn.prepareStatement("UPDATE productos SET nombre_producto=?,nit_proveedor=?,precio_compra=?,iva_Compra=?,precio_Venta=? WHERE codigo_producto=?");
			
			ps.setString(1, prod.getNombre_producto());
			ps.setLong(2, prod.getNit_proveedor());
			ps.setLong(3, prod.getPrecio_compra());
			ps.setLong(4, prod.getIva_compra());
			ps.setLong(5, prod.getPrecio_venta());
			ps.setLong(6, prod.getCodigo_producto());
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
	

}
