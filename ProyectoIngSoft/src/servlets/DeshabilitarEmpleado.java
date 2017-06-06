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
 * Servlet implementation class DeshabilitarEmpleado
 */
@WebServlet("/Empleados_Deshabilitar")
public class DeshabilitarEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public DeshabilitarEmpleado() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		FileProcesser fp = FileProcesser.getInstance();
		PrintWriter writer = response.getWriter();
		String text = fp
				.processFile("C:\\Paulo 2\\UPB\\Semestre V\\Proyecto Ingenieria de Software\\SEGIP\\deshabilitarEmpleado.php");
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
		db.deshabilitarEmpleado(id);
		response.sendRedirect("http://localhost:8081/ProyectoIngSoft/Empleados_Deshabilitar");
	}

}
