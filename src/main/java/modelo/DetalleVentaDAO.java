package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class DetalleVentaDAO {
	PreparedStatement ps=null;
	ResultSet res=null;
	Conexion con= new Conexion();
	Connection cnn=con.Conexionbd();

	
	public boolean Inserta_Cliente(DetalleVentaDTO det){

		boolean resultado=false;
		//ClienteDTO usu=null;
		try{
		//usu=  buscarcliente(u);
		//if(usu!=null) {
			
			
			ps =cnn.prepareStatement("Insert Into detalle_ventas(codigo_detalle_venta,codigo_venta,codigo_producto,cantidad_producto,valor_venta, iva_venta,total_venta)   value(?,?,?,?,?,?,?);");
															
			//ps =cnn.prepareStatement("Insert Into detalle_ventas(cantidad_producto,codigo_producto,codigo_venta,valor_venta,valor_iva, valor_total)   value(?,?,?,?,?,?);");
			ps.setLong(1, det.getCodigodetalleventa());
			ps.setLong(2, det.getCodigoventa());
			ps.setLong(3, det.getCodigoproducto());
			ps.setDouble(4, det.getCantidadproducto());
			ps.setDouble(5, det.getValoriva()); 
			ps.setDouble(6, det.getValorventa());
			ps.setDouble(7, det.getValortotal());
		resultado=ps.executeUpdate()>0;
		//}
		}catch(SQLException ex){
		 JOptionPane.showMessageDialog(null, "Error al Insertar" +ex);
		}
		return resultado;
		}  	
	
}
