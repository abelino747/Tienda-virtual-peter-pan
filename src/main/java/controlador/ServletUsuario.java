package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class ServletUsuario
 */
@WebServlet("/ServletUsuario")
public class ServletUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean certifica;
		
		 long cedula_usuario;
		 String nombre_usuario;
		 String email_usuario;
		 String usuario;
		 String password;
		
		 UsuariosDTO usudto;
		 UsuariosDAO usudao;
		if (request.getParameter("btnus") !=null) {
			
			cedula_usuario = Long.parseLong(request.getParameter("ced"));
			nombre_usuario = request.getParameter("nom");
			email_usuario = request.getParameter("e");
			usuario = request.getParameter("us");
			password = request.getParameter("pas");
			System.out.println(cedula_usuario + " "+ nombre_usuario + " " + email_usuario + " "+ usuario + " "+ password );
			usudto = new UsuariosDTO(cedula_usuario, nombre_usuario, email_usuario, usuario, password);
			usudao = new UsuariosDAO();
			certifica = usudao.insertar(usudto);
			
			if(certifica) {
				
				JOptionPane.showMessageDialog(null,"El Usuario ha sido registrado");
				response.sendRedirect("Usuarios.jsp");
			}else {
				JOptionPane.showMessageDialog(null,"Registrar Usuario");
				response.sendRedirect("Usuarios.jsp");
			}
		}	
		
	}

}
