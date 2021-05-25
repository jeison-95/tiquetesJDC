package controller;



import model.dao;

	import java.io.PrintWriter;
	import java.util.ArrayList;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;
	import model.tiquete;
	import org.apache.commons.logging.Log;
	import org.apache.commons.logging.LogFactory;
	import org.springframework.web.servlet.ModelAndView;
	import org.springframework.web.servlet.mvc.Controller;

	public class addTiquete implements Controller {
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
			boolean res = d.addtiquete(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
			if (res) {
				
			tiquete asig = new tiquete(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
			
			asig.setId_tiquete(id_tiquete);
			asig.setRutas(rutas);
			asig.setFecha(fecha);
			asig.setHora(hora);
			asig.setPuesto(puesto);
			asig.setNom_estudiante(nombre_est);
			asig.setApe_estudiante(apellido_est);
			asig.setDoc_estudiante(documento_est);
		    
			if (request.getSession().getAttribute("listaTiquete")!= null)
				
				TiqueteList = (ArrayList<tiquete>)request.getSession().getAttribute("listaTiquete");
			
			TiqueteList.add(asig);
			request.getSession().setAttribute("oper", "success");
			request.getSession().setAttribute("listaAsig",TiqueteList);
			PrintWriter out;
			out = response.getWriter();
			response.setContentType("text/html");
			out.println("<html>");
			out.println("<head><title>Respuesta adicionar Tiquete</title></head>");
			out.println("<body>");
			out.println("<h1>Tiquete adicionado exitosamente!</h1>");
			out.println("<a href=\"index.jsp\">Volver a la pagina inicial</a>");
			out.println("</body>");
			out.println("</html>");
			
			return null;
		}
		return null;
			
		}
}
