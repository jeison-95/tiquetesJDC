package controller;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.dao;
import model.tiquete;

public class ConsultarModify implements Controller{
	private dao d;
	private ArrayList<tiquete> TiqueteList = new ArrayList<tiquete>();


	
	
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {	
		d = new dao();
		
		String id_tiquete = request.getParameter("Asig_tiquete");
		String rutas = request.getParameter("Asig_ruta");
		String fecha = request.getParameter("Asig_fecha");
		String hora = request.getParameter("Asig_hora");
		String puesto = request.getParameter("Asig_puesto");
		String nombre_est = request.getParameter("Asig_nombre");
		String apellido_est = request.getParameter("Asig_apellido");
		String documento_est =request.getParameter("Asig_documento");
		
		TiqueteList = (ArrayList<tiquete>) d.searchTiquet(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
	
		
		if (TiqueteList.size() > 0) {
		    
			for (tiquete tique : TiqueteList) {
			

			PrintWriter out;
			out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Actualizar tiquete</title>");
			out.println("<title>Actualizar tiquete</title>");
			out.println("<link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css\" integrity=\"sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk\" crossorigin=\"anonymous\">");
			out.println(" <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js\" integrity=\"sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI\" crossorigin=\"anonymous\"></script>");
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
			out.println("<input type=\"text\" name=\"Asig_tiquete\" value =" + tique.getId_tiquete() +" class=\"form-control\" />");
			out.println("<label>RUTAS</label>");
			out.println(" <input type=\"text\" name=\"Asig_ruta\"  value = " + tique.getRutas() +" class=\"form-control\" />");
			out.println("<label>FECHA</label>");
			out.println("<input type=\"text\" name=\"Asig_fecha\" value = " + tique.getFecha() + " class=\"form-control\" />");
			out.println(" <label>HORA</label>");
			out.println("<input type=\"text\" name=\"Asig_hora\" value = " + tique.getHora()+ " class=\"form-control\" />");
			out.println("  <label>PUESTO</label>");
			out.println(" <input type=\"text\" name=\"Asig_puesto\"  value = " + tique.getPuesto() + " class=\"form-control\" />");
			out.println(" <label>NOMBRE ESTUDIANTE</label>");
			out.println(" <input type=\"text\" name=\"Asig_nombre\"   value = " + tique.getNom_estudiante() + " class=\"form-control\" />");
			out.println(" <label>APELLIDOS ESTUDIANTE</label>");
			out.println(" <input type=\"text\" name=\"Asig_apellido\"  value = " + tique.getApe_estudiante() + " class=\"form-control\" />");
			out.println(" <label>DOCUMENTO ESTUDIANTE</label>");
			out.println("  <input type=\"text\" name=\"Asig_documento\" value = " + tique.getDoc_estudiante() +" class=\"form-control\" />");

			out.println("  <input type=\"submit\" value=\"Enviar\" class=\"btn btn-success\"/>");
			out.println(" <input type=\"submit\" value=\"Modificar\" class=\"btn btn-success\"/>");

			out.println(" <a href=\"menuCrud.jsp\" class=\"btn btn-primary\">Regresar</a>");
			out.println("</form>");
			out.println("</div>");
			out.println("</div>");
			out.println("</div>");

			
			out.println("</table>");
			out.println("<h2><a href=\"ModificarTiquete.jsp\"> Validar Actualizacion de tiquete!</h2>");
			out.println("</body></html>");
			}
						
		} else {
				
					PrintWriter out;
					out=response.getWriter();
			 		response.setContentType("text/html");
					out.println("<html>");
					out.println("<head><title>Respuesta consultar tiquete</title></head>");
					out.println("<body>");
					out.println("<h1>Tiquete App</h1>");
					out.println("<h2>El codigo del tiquete no existe - prueba!</h2>");
					out.println("<a href=\"consultarTiquete.jsp\">Volver a Ingresar datos</a>");
					out.println("</body>");
					out.println("</html>");
					return null;
		}
		return null;
			
		
	//return new ModelAndView("ModificarTiquete.jsp");
	
}

}  
