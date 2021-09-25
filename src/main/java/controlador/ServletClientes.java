package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ClientesDAO;
import modelo.ClientesDTO;



/**
 * Servlet implementation class ServletClientes
 */
@WebServlet("/ServletClientes")
public class ServletClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletClientes() {
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
		
		 long cedula_cliente;
		 String nombre_cliente;
		 String direccion_cliente;
		 String email_cliente;
		 String telefono_cliente;
		 
		 ClientesDTO cliendto;
		 ClientesDAO cliendao;
		 ClientesDTO consulcliente;
		if (request.getParameter("btncli") !=null) {
			
			
			cedula_cliente = Long.parseLong(request.getParameter("ced"));
			nombre_cliente = request.getParameter("nom");
			direccion_cliente = request.getParameter("dir");
			email_cliente = request.getParameter("ema");
			telefono_cliente = request.getParameter("tel");
			//System.out.println(cedula_usuario + " "+ nombre_usuario + " " + email_usuario + " "+ usuario + " "+ password );
			cliendto = new ClientesDTO(cedula_cliente, nombre_cliente, direccion_cliente, email_cliente, telefono_cliente);
			cliendao = new ClientesDAO();
			certifica1 = cliendao.insertar(cliendto);
			
			if(certifica1) {
				
				JOptionPane.showMessageDialog(null,"El Cliente ha sido registrado");
				response.sendRedirect("clientes.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Clientes");
				response.sendRedirect("clientes.jsp");
			}
			
		}
		
		
		// Consulta de Clientes
		if (request.getParameter("btncon")!=null) {

			cedula_cliente = Long.parseLong(request.getParameter("ced"));

			cliendto = new ClientesDTO(cedula_cliente);
			cliendao = new ClientesDAO();
			consulcliente= cliendao.consultar(cliendto);

			cedula_cliente= consulcliente.getCedula_cliente();
			nombre_cliente= consulcliente.getNombre_cliente();
			direccion_cliente=consulcliente.getDireccion_cliente();
			email_cliente= consulcliente.getEmail_cliente();
			telefono_cliente=consulcliente.getTelefono_cliente();

			// las varables dentro del response en las "", se crean hay y se usan en el ejercicio.jsp
			// ya que son las que viajan 
			response.sendRedirect("clientes.jsp?ced="+cedula_cliente+"&&nom="+nombre_cliente+
					"&&dir="+direccion_cliente+"&&ema="+email_cliente+"&&tel="+telefono_cliente);

		}
		
		if(request.getParameter("btnact") != null) {
			
			cedula_cliente = Long.parseLong(request.getParameter("ced"));
			nombre_cliente = request.getParameter("nom");
			direccion_cliente = request.getParameter("dir");
			email_cliente = request.getParameter("ema");
			telefono_cliente = request.getParameter("tel");
			
			//System.out.println(cedula_usuario + " "+ nombre_usuario + " " + email_usuario + " "+ usuario + " "+ password );
			cliendto = new ClientesDTO(cedula_cliente, nombre_cliente, direccion_cliente, email_cliente, telefono_cliente);
			cliendao = new ClientesDAO();
			certifica1 = cliendao.actualizar(cliendto);
			
			if(certifica1) {
				
				JOptionPane.showMessageDialog(null,"El Cliente ha sido actualizado");
				response.sendRedirect("clientes.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Clientes");
				response.sendRedirect("clientes.jsp");
			}
			
		}
		//Eliminar Clientes
		if(request.getParameter("btnEli") != null) {
			
			cedula_cliente = Long.parseLong(request.getParameter("ced"));
			
			cliendto = new ClientesDTO(cedula_cliente);
			cliendao = new ClientesDAO();
			certifica1 = cliendao.eliminar(cliendto);
			
			if(certifica1) {
				
				JOptionPane.showMessageDialog(null,"El Cliente ha sido eliminado");
				response.sendRedirect("clientes.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Clientes");
				response.sendRedirect("clientes.jsp");
			}
			
		}

	}

}
