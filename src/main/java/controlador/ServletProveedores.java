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
		 boolean certifica1;
		 
		 long nit_proveedor;
		 String nombre_proveedor;
		 String ciudad_proveedor;
		 String direccion_proveedor;
		 String telefono_proveedor;
		 
		 ProveedoresDTO proveedordto;
		 ProveedoresDAO proveedordao;

		if (request.getParameter("btnProveedor") !=null) {			
			
			nit_proveedor = Long.parseLong(request.getParameter("nit"));
			nombre_proveedor = request.getParameter("nombre");
			ciudad_proveedor = request.getParameter("ciudad");
			direccion_proveedor = request.getParameter("direccion");
			telefono_proveedor = request.getParameter("telefono");
			
			proveedordto = new ProveedoresDTO(nit_proveedor, nombre_proveedor, ciudad_proveedor, direccion_proveedor, telefono_proveedor);
			proveedordao = new ProveedoresDAO();
			
			certifica1 = proveedordao.insertar(proveedordto);
			
			if(certifica1) {
				
				JOptionPane.showMessageDialog(null,"El proveedor ha sido registrado");
				response.sendRedirect("proveedores.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Proveedores");
				response.sendRedirect("proveedores.jsp");
			}
			

		}
		
		

	}

}
