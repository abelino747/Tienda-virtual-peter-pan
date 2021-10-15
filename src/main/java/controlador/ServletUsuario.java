package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

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

		// Registro de Usuarios
		boolean certifica;
		 long cedula_usuario;
		 String nombre_usuario;
		 String email_usuario;
		 String usuario;
		 String password;
		
		 UsuariosDTO usudto;
		 UsuariosDAO usudao;
		 UsuariosDTO consultausu;
		 
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
		
		// Consulta de Usuarios
					
		if (request.getParameter("btncon")!=null) {
					
				cedula_usuario = Long.parseLong(request.getParameter("ced"));
				
				usudto = new  UsuariosDTO(cedula_usuario);
				usudao = new UsuariosDAO();
				consultausu= usudao.consultar(usudto);
				
				cedula_usuario=consultausu.getCedula_usuario();
				nombre_usuario=consultausu.getNombre_usuario();
				email_usuario=consultausu.getEmail_usuario();
				usuario=consultausu.getUsuario();
				password=consultausu.getPassword();
				// las varables dentro del response en las "", se crean hay y se usan en el ejercicio.jsp
				// ya que son las que viajan 
				response.sendRedirect("Usuarios.jsp?ced="+cedula_usuario+"&&nom="+nombre_usuario+
									  "&&e="+email_usuario+"&&us="+usuario+"&&pas="+password);
					
			}
		
		// actualizacion de usuario
		
		if(request.getParameter("btnact") != null) {
			int dat;
			 cedula_usuario=Long.parseLong(request.getParameter("ced"));
			 nombre_usuario=request.getParameter("nom");
			 email_usuario=request.getParameter("e");
			 usuario=request.getParameter("us");
			 password=request.getParameter("pas");
			
			 usudto = new UsuariosDTO(cedula_usuario,nombre_usuario,email_usuario,usuario,password);
			 usudao = new UsuariosDAO();
			 dat=usudao.actualizar(usudto);
			
			if (dat>0) {
				JOptionPane.showMessageDialog(null, "Usuario Actualizado...");
				
			} else {
				JOptionPane.showMessageDialog(null, "Usuario NO Actualizado...");
				
			}
			response.sendRedirect("Usuarios.jsp");
		}
		
		// eliminar usuario 
		
		if(request.getParameter("btneli") != null) {
			int dat;
			cedula_usuario=Long.parseLong(request.getParameter("ced"));
			usudto = new UsuariosDTO(cedula_usuario);
			usudao = new UsuariosDAO();
			dat= usudao.eliminar(usudto);
			if (dat>0) {
				JOptionPane.showMessageDialog(null,"El Dato se Elimino");
				
			} else {
				JOptionPane.showMessageDialog(null,"El Dato se Elimino");
				
			}
			response.sendRedirect("Usuarios.jsp");
		}
		
		//consulta general
		if(request.getParameter("repUsuarios") != null) {
			ArrayList<UsuariosDTO> lista=new ArrayList<>();
			usudao=new UsuariosDAO();
			lista= usudao.consultageneral();		
			Gson general=new Gson();
			// metodo para enviar datos al js javax
			PrintWriter out= response.getWriter();			
			out.print(general.toJson(lista));
			
		}
		
			
	}}
