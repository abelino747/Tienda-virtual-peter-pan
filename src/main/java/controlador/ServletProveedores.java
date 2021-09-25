package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedoresDAO;
import modelo.ProveedoresDTO;


/**
 * Servlet implementation class ServletProveedores
 */
@WebServlet("/ServletProveedores")
public class ServletProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProveedores() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean certifica1;

		long nit_proveedor;
		String nombre_proveedor;
		String ciudad_proveedor;
		String direccion_proveedor;
		String telefono_proveedor;

		ProveedoresDTO proveedordto;
		ProveedoresDAO proveedordao;
		ProveedoresDTO consultaprov;

		if (request.getParameter("btnProveedor") != null) {

			nit_proveedor = Long.parseLong(request.getParameter("nit"));
			nombre_proveedor = request.getParameter("nombre");
			ciudad_proveedor = request.getParameter("ciudad");
			direccion_proveedor = request.getParameter("direccion");
			telefono_proveedor = request.getParameter("telefono");

			proveedordto = new ProveedoresDTO(nit_proveedor, nombre_proveedor, ciudad_proveedor, direccion_proveedor,
					telefono_proveedor);
			proveedordao = new ProveedoresDAO();

			certifica1 = proveedordao.insertar(proveedordto);

			if (certifica1) {

				JOptionPane.showMessageDialog(null, "El proveedor ha sido registrado");
				response.sendRedirect("proveedores.jsp");
			} else {
				JOptionPane.showMessageDialog(null, "Registrar Proveedores");
				response.sendRedirect("proveedores.jsp");
			}
		}

		// Consulta de Proveedores

		if (request.getParameter("btnprove") != null) {
		

			nit_proveedor = Long.parseLong(request.getParameter("nit1"));

			proveedordto = new ProveedoresDTO(nit_proveedor);
			proveedordao = new ProveedoresDAO();
			consultaprov = proveedordao.consultar(proveedordto);

			//nit_proveedor = consultaprov.getNit_proveedor();
			nombre_proveedor = consultaprov.getNombre_proveedor();
			ciudad_proveedor = consultaprov.getCiudad_proveedor();
			direccion_proveedor = consultaprov.getDireccion_proveedor();
			telefono_proveedor = consultaprov.getTelefono_proveedor();
			// las variables dentro del response en las "", se crean hay y se usan en el
			// ejercicio.jsp
			// ya que son las que viajan
			response.sendRedirect("proveedores.jsp?nit1=" + nit_proveedor + "&&nombre1=" + nombre_proveedor
					+ "&&ciudad1=" + ciudad_proveedor + "&&direccion1=" + direccion_proveedor + "&&telefono1="
					+ telefono_proveedor);

		}
		// actualizacion de proveedores
		
				if(request.getParameter("btnact") != null) {
					int dat;
					nit_proveedor=Long.parseLong(request.getParameter("nit1"));
					nombre_proveedor=request.getParameter("nombre1");
					ciudad_proveedor=request.getParameter("ciudad1");
					direccion_proveedor=request.getParameter("direccion1");
					telefono_proveedor=request.getParameter("telefono1");
					
					proveedordto = new ProveedoresDTO(nit_proveedor,nombre_proveedor,ciudad_proveedor,direccion_proveedor,telefono_proveedor);
					proveedordao = new ProveedoresDAO();
					 dat=proveedordao.actualizar(proveedordto);
					
					if (dat>0) {
						JOptionPane.showMessageDialog(null, "Proveedor Actualizado :) ...");
						
					} else {
						JOptionPane.showMessageDialog(null, "Proveedor NO Actualizado :( ...");
						
					}
					response.sendRedirect("proveedores.jsp");
				}

	}

}
