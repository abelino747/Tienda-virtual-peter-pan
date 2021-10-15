package controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.UsuariosDAO;
import modelo.UsuariosDTO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletLogin() {
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

		String u, c;
		u = request.getParameter("usuario");
		c = request.getParameter("password");
		/*
		if (u.equals("admininicial") && c.equals("admin123456")) {
			JOptionPane.showMessageDialog(null, "Datos Correctos, BIENVENIDO");
			response.sendRedirect("menu.jsp?dat=" + u);
		} else {
			JOptionPane.showMessageDialog(null, "Datos Incorrectos, Intenta Denuevo ");
			response.sendRedirect("index.jsp");
		}
		*/

		HttpSession sesion = request.getSession();
		if (request.getParameter("btn") != null) {

			UsuariosDTO usdto;
			u = request.getParameter("usuario");
			c = request.getParameter("password");
			UsuariosDTO lo = new UsuariosDTO(u, c);
			UsuariosDAO lodao = new UsuariosDAO();
			usdto = lodao.login(lo);
			sesion.setAttribute("llevadat", u);

			if (usdto.getUsuario().equals(u) && usdto.getPassword().equals(c)) {
				//JOptionPane.showMessageDialog(null, "Datos correctos");
				String uss = usdto.getNombre_usuario();
				//JOptionPane.showMessageDialog(null, uss);
				// sesion.setAttribute("vsusuario",lo.getUsuario());

				sesion.setAttribute("llevadato", uss);
				sesion.setAttribute("vs", usdto);
				request.getRequestDispatcher("menu.jsp").forward(request, response);

			}
		} else {
			JOptionPane.showMessageDialog(null, "Datos incorrectos");
			response.sendRedirect("index.jsp");
		}

	}

}
