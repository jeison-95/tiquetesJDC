package controller;

import model.dao;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;
import model.tiquete;

public class modifyTiquete implements Controller {

	private dao d;

	private ArrayList<tiquete> TiqueteList = new ArrayList<tiquete>();
	private PrintWriter out = null;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		d = new dao();

		String id_tiquete = request.getParameter("Asig_tiquete");
		String rutas = request.getParameter("Asig_ruta");
		String fecha = request.getParameter("Asig_fecha");
		String hora = request.getParameter("Asig_hora");
		String puesto = request.getParameter("Asig_puesto");
		String nombre_est = request.getParameter("Asig_nombre");
		String apellido_est = request.getParameter("Asig_apellido");
		String documento_est = request.getParameter("Asig_documento");

	
			if (request.getSession().getAttribute("listaAsig") != null) {
				TiqueteList = (ArrayList<tiquete>) request.getSession().getAttribute("listaAsig");
				for (tiquete asig : TiqueteList) {
					if (asig.getId_tiquete() == id_tiquete) {

						request.getSession().setAttribute(rutas,"asig_ruta");
						

					}
				}
			

			PrintWriter out;
			out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Actualizar tiquete</title>");
			out.println("<title>Actualizar tiquete</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Resultados!</h1>");
			out.println("<div class=container mt-4 col-lg-4>");
			out.println("<div class=card border-info>");
			out.println("<div class=\"card-header bg-info\">");
			out.println("<h4>Modificar tiquete</h4>");
			out.println("</div>");
			out.println("<div class=\"card-body\">");
			out.println(" <form action=\"modifyTiquete\" method=\"post\">");
			out.println(" <label>ID TIQUETE</label>");
			out.println(
					"<input type=\"text\" name=\"Asig_tiquete\" placeholder=\"<%=Id_tiquete%>\" class=\"form-control\" />");
			out.println("<label>RUTAS</label>");
			out.println(
					" <input type=\"text\" name=\"Asig_ruta\" placeholder=\"<%=Rutas%>\" class=\"form-control\" />");
			out.println("<label>FECHA</label>");
			out.println(
					"<input type=\"text\" name=\"Asig_fecha\" placeholder=\"<%=Fecha%>\" class=\"form-control\" />");
			out.println(" <label>HORA</label>");
			out.println("<input type=\"text\" name=\"Asig_hora\" placeholder=\"<%=Hora%>\" class=\"form-control\" />");
			out.println("  <label>PUESTO</label>");
			out.println(
					" <input type=\"text\" name=\"Asig_puesto\" placeholder=\"<%=Puesto%>\" class=\"form-control\" />");
			out.println(" <label>NOMBRE ESTUDIANTE</label>");
			out.println(
					" <input type=\"text\" name=\"Asig_nombre\" placeholder=\"<%=Nom_estudiante%>\" class=\"form-control\" />");
			out.println(" <label>APELLIDOS ESTUDIANTE</label>");
			out.println(
					" <input type=\"text\" name=\"Asig_apellido\" placeholder=\"<%=Ape_estudiante%>\" class=\"form-control\" />");
			out.println(" <label>DOCUMENTO ESTUDIANTE</label>");
			out.println(
					"  <input type=\"text\" name=\"Asig_documento\" placeholder=\"<%=Doc_Estudiante%>\" class=\"form-control\" />");

			out.println("  <input type=\"submit\" value=\"Enviar\" class=\"btn btn-success\"/>");
			out.println(" <input type=\"submit\" value=\"Modificar\" class=\"btn btn-success\"/>");

			out.println(" <a href=\"menuCrud.jsp\" class=\"btn btn-primary\">Regresar</a>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			for (tiquete tique : TiqueteList) {

				out.println("<tr>");
				out.println("<td>" + tique.getId_tiquete() + "</td>");
				out.println("<td>" + tique.getRutas() + "</td>");
				out.println("<td>" + tique.getFecha() + "</td>");
				out.println("<td>" + tique.getHora() + "</td>");
				out.println("<td>" + tique.getPuesto() + "</td>");
				out.println("<td>" + tique.getNom_estudiante() + "</td>");
				out.println("<td>" + tique.getApe_estudiante() + "</td>");
				out.println("<td>" + tique.getDoc_estudiante() + "</td>");
				out.println("</tr>");

			}
			out.println("</table>");
			out.println("<h2><a href=\"ModificarTiquete.jsp\"> Validar Actualizacion de tiquete!</h2>");
			out.println("</body></html>");

		} else {

			PrintWriter out;
			out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Respuesta de actualizacion del tiquete</title></head>");
			out.println("<body>");
			out.println("<h1>Tiquete App</h1>");
			out.println("<h2>El codigo del tiquete no existe!</h2>");
			out.println("<a href=\"ModificarTiquete.jsp\">Volver a Ingresar datos</a>");
			out.println("</body>");
			out.println("</html>");
			return null;
		}

		return null;
	}

}
