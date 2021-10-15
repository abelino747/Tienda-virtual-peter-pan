package controlador;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.Part;
import javax.swing.JOptionPane;


import modelo.ProductosDAO;
import modelo.ProductosDTO;

/**
 * Servlet implementation class ServletProductos
 */
@WebServlet("/ServletProductos")
@MultipartConfig
public class ServletProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// entre las comillas va el nombre del input que esta en el jsb
		// la clase part maneja los archivos y reconoce url
		Part archivo= request.getPart("archivo");
		
		Long codigo_producto;
		String nombre_producto;
		Long nit_proveedor;
		Long precio_compra;
		Long iva_compra;	
		Long precio_venta;	
		ProductosDTO prodDTO, consultaDTO;
		ProductosDAO prodDAO;
		boolean certifica1;
		
		
		// ruta donde se va a guardar el archivo, el nombre del archivo se coloca o se puede pedir con un input
		// la que sigue ruta se usa cuando se activa desde mysql desde sam por eso se comenta 
		//String Url="C:\\Users\\ABELINO\\eclipse-workspace\\ejer10\\src\\main\\webapp\\documentos";
		// my sql desde windows
		
		String Url="C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/";
		// cargar es el nombre que se le dio en el jsp a agregar archivo
		if (request.getParameter("cargar")!= null) {
			try {
				InputStream file= archivo.getInputStream();
				File copia= new File(Url+"productos.csv");
				FileOutputStream escribir= new FileOutputStream(copia);
				int num=file.read();
				while (num !=-1) {
					escribir.write(num);
					num=file.read();
					
				}
				file.close();
				escribir.close();
				JOptionPane.showMessageDialog(null," Se cargo Correctamente el Archivo");
				
				boolean x;
				ProductosDAO prodao= new ProductosDAO();
				x=prodao.cargarProductos(Url+"productos.csv");
				if (x) {
					JOptionPane.showMessageDialog(null,"Datos cargados en la base de datos TG");
					response.sendRedirect("productos.jsp");
				} else {
					JOptionPane.showMessageDialog(null,"Error No Se Cargo Ningun Dato");
					response.sendRedirect("productos.jsp");
				} 
				
			} catch (Exception e) {
				// TODO: handle exception
				JOptionPane.showMessageDialog(null,"Error al cargar Archivo");
			}
			
			
		} 
		
		
		// Consulta de Productos
		if (request.getParameter("btncon")!=null) {
			JOptionPane.showMessageDialog(null,"Producto Consultado");
			 codigo_producto = Long.parseLong(request.getParameter("cod"));
			 prodDTO = new ProductosDTO(codigo_producto);
			 prodDAO = new ProductosDAO();
			 
			 
			 consultaDTO= prodDAO.consultar(prodDTO);
			
			 codigo_producto = consultaDTO.getCodigo_producto();
			 nombre_producto= consultaDTO.getNombre_producto();
			 nit_proveedor = consultaDTO.getNit_proveedor();
			 precio_compra = consultaDTO.getPrecio_compra();
			 iva_compra = consultaDTO.getIva_compra();	
			 precio_venta = consultaDTO.getPrecio_venta();	
		 
			 
			// las varables dentro del response en las "", se crean hay y se usan en el ejercicio.jsp
			// ya que son las que viajan 
			response.sendRedirect("productos.jsp?cod="+codigo_producto+"&&nom="+nombre_producto+
					"&&nit="+nit_proveedor+"&&precio_compra="+precio_compra+"&&iva_compra="+iva_compra+"&&precio_venta="+precio_venta);

		}
		
		// Actualizar  Productos
		if (request.getParameter("btnact")!=null) {		

			 codigo_producto = Long.parseLong(request.getParameter("cod"));
			 nombre_producto= request.getParameter("nom");
			 nit_proveedor = Long.parseLong(request.getParameter("nit"));
			 precio_compra = Long.parseLong(request.getParameter("precio_compra"));
			 iva_compra = Long.parseLong(request.getParameter("iva_compra"));
			 precio_venta = Long.parseLong(request.getParameter("precio_venta"));
			 
			 
			 prodDTO = new ProductosDTO(codigo_producto,nombre_producto,nit_proveedor, precio_compra, iva_compra, precio_venta);
			 prodDAO = new ProductosDAO();
			 
			 
			 certifica1 = prodDAO.actualizar(prodDTO);
			 
			if(certifica1) {
				
				JOptionPane.showMessageDialog(null,"El producto ha sido actualizado");
				response.sendRedirect("productos.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Productos");
				response.sendRedirect("productos.jsp");
			}

		}
		
	}		
	

}
