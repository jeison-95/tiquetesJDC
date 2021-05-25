package model;

public class pasajero {
	private String Id_tiquete;
	private String Rutas;
	private String Fecha;
	private String Hora;
	private String Nom_estudiante;
	
	
	
	
	
	public pasajero(String id_tiqueteValue, String rutas, String fecha, String hora, String nom_estudiante) {
		super();
		Id_tiquete = id_tiqueteValue;
		Rutas = rutas;
		Fecha = fecha;
		Hora = hora;
		Nom_estudiante = nom_estudiante;
		
		
	
	}

	
	public String getId_tiquete() {
		return Id_tiquete;
	}




	public void setId_tiquete(String id_tiquete) {
		Id_tiquete = id_tiquete;
	}




	public String getRutas() {
		return Rutas;
	}




	public void setRutas(String rutas) {
		Rutas = rutas;
	}




	public String getFecha() {
		return Fecha;
	}




	public void setFecha(String fecha) {
		Fecha = fecha;
	}




	public String getHora() {
		return Hora;
	}




	public void setHora(String hora) {
		Hora = hora;
	}




	public String getNom_estudiante() {
		return Nom_estudiante;
	}




	public void setNom_estudiante(String nom_estudiante) {
		Nom_estudiante = nom_estudiante;
	}




	@Override
	public String toString() {
		
		return "tiquetes [Id_tiquetes=" + Id_tiquete + ", Rutas=" + Rutas + ", Fecha=" + Fecha + ", Hora="
				+ Hora + ", Nom_estudiante="+ Nom_estudiante + "]";
	}


}
