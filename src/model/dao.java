package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DAO;

public class dao {

	public boolean addtiquete(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, 
			 String apellido_est, String documento_est) {
		DAO dao = new DAO();
		try {
		dao.guardarTiquete(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
		} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
		return true;
		}
		
		

     public List<tiquete> searchTiquet(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est) {
	DAO dao = new DAO();
	final List<tiquete> tiquetList = new ArrayList<>(); 
	try {
		tiquetList.addAll(dao.consultartiquete (id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est));
	} catch (Exception e) {
		e.printStackTrace();
	}
	return tiquetList ;
}

public tiquete ActualizarTiquete (String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, 
		 String apellido_est, String documento_est) {
	DAO dao = new DAO();
	tiquete tiqueteModificado = null;
	try {
		tiqueteModificado = dao.ActualizarTiquete(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return tiqueteModificado;
}

}
