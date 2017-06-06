package servlets;

import interaccionArchivos.FileProcesser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bdd.InteraccionBase;

/**
 * Servlet implementation class BuscarCliente
 */
@WebServlet("/Clientes_Buscar")
public class BuscarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BuscarCliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		FileProcesser fp = FileProcesser.getInstance();
		PrintWriter writer = response.getWriter();
		String text = fp
				.processFile("C:\\Paulo 2\\UPB\\Semestre V\\Proyecto Ingenieria de Software\\SEGIP\\escoger.php");
		writer.print(text);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		InteraccionBase db = InteraccionBase.getInstance();
		String cliente = db.buscarCliente(id);
		PrintWriter writer = response.getWriter();
		writer.write(cliente);
	}

}
