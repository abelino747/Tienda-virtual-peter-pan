package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import modelo.ClientesDAO;
import modelo.ClientesDTO;
import modelo.UsuariosDAO;
import modelo.UsuariosDTO;
import modelo.VentasDAO;

/**
 * Servlet implementation class ServletReportes
 */
@WebServlet("/ServletReportes")
public class ServletReportes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletReportes() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		ClientesDAO clidao;

		// consulta general por fuera del if ya que se utilia js
		ArrayList<ClientesDTO> lista = new ArrayList<>();
		clidao = new ClientesDAO();
		lista = clidao.consultaVentasCliente();
		// gson comunica entre lenguajes en este caso java y js
		Gson general = new Gson();
		// out imprime en pantalla la lista
		out.print(general.toJson(lista));

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// metodo para imprimir en pantalla al enviar datos al js javax
		PrintWriter out = response.getWriter();

		ClientesDAO clidao;

		// consulta general por fuera del if ya que se utilia js
		ArrayList<ClientesDTO> lista = new ArrayList<>();
		clidao = new ClientesDAO();
		lista = clidao.consultageneral();
		// gson comunica entre lenguajes en este caso java y js
		Gson general = new Gson();
		// out imprime en pantalla la lista
		out.print(general.toJson(lista));

	}

}
