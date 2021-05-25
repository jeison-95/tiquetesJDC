package controller;
import model.dao;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import model.tiquete;

	public class consultTiquet implements Controller {
		private dao d;
		private ArrayList<tiquete> TiqueteList = new ArrayList<tiquete>();

		
		
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
			String documento_est =request.getParameter("Asig_documento");
			
			TiqueteList = (ArrayList<tiquete>) d.searchTiquet(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
		
			if (TiqueteList.size()>0){
			    
				PrintWriter out;
				out = response.getWriter();
				response.setContentType("text/html");
				out.println("<html>");
				out.println("<head><title>Consulta de tiquete</title>");
				out.println("<title>Consulta de tiquete</title>"); 
				out.println("</head>");
				out.println("<body>");
				out.println("<h1>Resultados!</h1>");
				out.println("<table cellspacing=\"3\" cellpadding=\"3\" border=\"1\" >");
				out.println("<tr>");
				out.println("<th>id_tiquete</th>");
				out.println("<th>rutas</th>");
				out.println("<th>fecha</th>");
				out.println("<th>hora</th>");
				out.println("<th>puesto</th>");
				out.println("<th>nombre_est</th>");
				out.println("<th>apellido_est</th>");
				out.println("<th>documento_est</th>");
				out.println("</tr>");
				for(tiquete tique: TiqueteList) {
					
					out.println("<tr>");
					out.println("<td>"+tique.getId_tiquete()+"</td>");
					out.println("<td>"+tique.getRutas()+"</td>");
					out.println("<td>"+tique.getFecha()+"</td>");
					out.println("<td>"+tique.getHora()+"</td>");
					out.println("<td>"+tique.getPuesto()+"</td>");
					out.println("<td>"+tique.getNom_estudiante()+"</td>");
					out.println("<td>"+tique.getApe_estudiante()+"</td>");
					out.println("<td>"+tique.getDoc_estudiante()+"</td>");
					out.println("</tr>");
					
				}
				out.println("</table>");
				out.println("<h2><a href=\"menuCrud.jsp\"> Volver a la página Menu!</h2>");
				out.println("</body></html>");
			
				
				
		
			}else {
					
						PrintWriter out;
						out=response.getWriter();
				 		response.setContentType("text/html");
						out.println("<html>");
						out.println("<head><title>Respuesta consultar tiquete</title></head>");
						out.println("<body>");
						out.println("<h1>Tiquete App</h1>");
						out.println("<h2>El codigo del tiquete no existe!</h2>");
						out.println("<a href=\"consultarTiquete.jsp\">Volver a Ingresar datos</a>");
						out.println("</body>");
						out.println("</html>");
						return null;
					}
				
			
		return null;	
	}
}
