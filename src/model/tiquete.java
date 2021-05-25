package model;

public class tiquete {
		
		private String Id_tiquete;
		private String Rutas;
		private String Fecha;
		private String Hora;
		private String Puesto;
		private String Nom_estudiante;
		private String Ape_estudiante;
		private String Doc_estudiante;
		
		
		
		
		public tiquete(String id_tiqueteValue, String rutas, String fecha, String hora, String puestoValue, String nom_estudiante, String ape_estudiante, String documento_estValue) {
			super();
			Id_tiquete = id_tiqueteValue;
			Rutas = rutas;
			Fecha = fecha;
			Hora = hora;
			Puesto = puestoValue;
			Nom_estudiante = nom_estudiante;
			Ape_estudiante = ape_estudiante;
			Doc_estudiante = documento_estValue;
			
			
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

		public String getPuesto() {
			return Puesto;
		}

		public void setPuesto(String puesto) {
			Puesto = puesto;
		}

		public String getNom_estudiante() {
			return Nom_estudiante;
		}

		public void setNom_estudiante(String nom_estudiante) {
			Nom_estudiante = nom_estudiante;
		}

		public String getApe_estudiante() {
			return Ape_estudiante;
		}

		public void setApe_estudiante(String ape_estudiante) {
			Ape_estudiante = ape_estudiante;
		}

		public String getDoc_estudiante() {
			return Doc_estudiante;
		}

		public void setDoc_estudiante(String doc_estudiante) {
			Doc_estudiante = doc_estudiante;
		}

		@Override
		public String toString() {
			
			return "tiquetes [Id_tiquetes=" + Id_tiquete + ", Rutas=" + Rutas + ", Fecha=" + Fecha + ", Hora="
					+ Hora + ", Puesto=" + Puesto + ", Nom_estudiante="+ Nom_estudiante + ", Ape_estudiante=" 
					+ Ape_estudiante + ", Doc_estudiante="+ Doc_estudiante +"]";
		}

	}
