package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

import model.tiquete;

import java.util.ArrayList;
import java.util.List;


public class DAO {
	
	private String maquina = "localhost";
	 private String usuario = "root";
	 private String clave = "lol12345";
	 private int puerto = 3306;
	 public static Connection conexion = null;

	 
	 public void guardarTiquete(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est,String apellido_est, String documento_est) throws SQLException, ClassNotFoundException{
			  Statement stmt= null;
			  
	String query = "insert into tiquetes (id_tiquete, rutas, fecha, hora, puesto, nombre_est, apellido_est, documento_est)"	+ " values('" + id_tiquete + "','" + rutas + "','" + fecha + "','" + hora + "','" + puesto + "','" + nombre_est + "','" + apellido_est +"','" + documento_est + "');";
	
	try{
		 Class.forName("com.mysql.jdbc.Driver");
		 Connection con = getConnection();
		 stmt = con.createStatement();
		 stmt.executeUpdate(query);
		 con.close();
		 }catch(SQLException sqlex){throw sqlex;}
	
		 }

	
	 
	 public List<tiquete> consultartiquete(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est)
				throws Exception {
			final List<tiquete> tiquetList = new ArrayList<>();
			try {
				Connection conexion = getConnection();
				PreparedStatement sentencia = prepareQuerytiqueteStatement(conexion, id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est);
				ResultSet rs = sentencia.executeQuery();
				while (rs.next()) {
					final String id_tiqueteValue = rs.getString("id_tiquete");
					final String rutasValue = rs.getString("rutas");
					final String fechaValue = rs.getString("fecha");
					final String horaValue = rs.getString("hora");
					final String puestoValue = rs.getString("puesto");
					final String nombre_estValue = rs.getString("nombre_est");
					final String apellido_estValue = rs.getString("apellido_est");
					final String documento_estValue = rs.getString("documento_est");
					final tiquete tiquet = new tiquete (id_tiqueteValue, rutasValue, fechaValue, horaValue, puestoValue,nombre_estValue,apellido_estValue,documento_estValue);
					tiquetList.add(tiquet);
				}
			} catch (Exception e) {
				throw e;
			}
			return tiquetList;
		}

	 public tiquete ActualizarTiquete(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, 
			 String apellido_est, String documento_est) throws SQLException, ClassNotFoundException{
			  Statement stmt= null;
			  String query = "update tiquetes set rutas='"+rutas+"',fecha='"+fecha+"', hora='"+hora+"', puesto='"+puesto+"', nombre_est ='"+nombre_est+"', apellido_est='"+apellido_est+"',documento_est='"+documento_est+"'+  where id_tiquete='"+id_tiquete+"');";
	        
			  try{
				  Class.forName("com.mysql.cj.jdbc.Driver");
				  Connection con = getConnection();	
				  stmt = con.createStatement();
				  stmt.executeUpdate(query);
				  con.close();
				  }catch(SQLException sqlex){throw sqlex;}
			return null;
			  
				  }

	
	

	private PreparedStatement prepareQuerytiqueteStatement(Connection conexion, String id_tiquete, String rutas,
			String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est)throws Exception {
		
		
		PreparedStatement sentencia = conexion.prepareStatement(buildTiquetQuery(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est));
		
		int paramIndex = 1;
		if (hasParams(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est)) {
			
			if (id_tiquete != null && !id_tiquete.equals("")) {
				sentencia.setString(paramIndex, id_tiquete);
				paramIndex++;
			}
			if (rutas != null && !rutas.equals("")) {
				sentencia.setString(paramIndex, rutas);
				paramIndex++;
			}
			if (fecha != null && !fecha.equals("")) {
				sentencia.setString(paramIndex, fecha);
				paramIndex++;
			}
			if (hora != null && !hora.equals("")) {
				sentencia.setString(paramIndex, hora);
				paramIndex++;
			}
			if (puesto != null && !puesto.equals("")) {
				sentencia.setString(paramIndex, puesto);
			}
		    }
		    if (nombre_est != null && !nombre_est.equals("")) {
			sentencia.setString(paramIndex, nombre_est);
		    }
	
	        if (apellido_est != null && !apellido_est.equals("")) {
		    sentencia.setString(paramIndex, apellido_est);
	        }

            if (documento_est != null && !documento_est.equals("")) {
	        sentencia.setString(paramIndex, documento_est);
            }
		
		return sentencia;
	}
	private String buildTiquetQuery(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est) {
		final StringBuilder query = new StringBuilder("SELECT * FROM tiquetes");
		boolean hasParams = hasParams(id_tiquete, rutas, fecha, hora, puesto, nombre_est, apellido_est, documento_est);
		boolean hasPreviousParam = false;
		if (hasParams) {
			query.append(" WHERE ");
			if (id_tiquete != null && !id_tiquete.equals("")) {
				query.append(" id_tiquete = ? ");
				hasPreviousParam = true;
			}
			if (rutas != null && !rutas.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" rutas = ? ");
				hasPreviousParam = true;
			}
			if (fecha != null && !fecha.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" fecha = ? ");
				hasPreviousParam = true;
			}
			if (hora != null && !hora.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" hora = ? ");
				hasPreviousParam = true;
			}
			if (puesto != null && !puesto.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" puesto = ? ");
			}
			if (nombre_est != null && !nombre_est.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" nombre_est = ? ");
				hasPreviousParam = true;
			}
			if (apellido_est != null && !apellido_est.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" apellido_est = ? ");
				hasPreviousParam = true;
			}
			if (documento_est != null && !documento_est.equals("")) {
				if (hasPreviousParam) {
					query.append(" AND ");
				}
				query.append(" documento_est = ? ");
				hasPreviousParam = true;
			}
		}
		return query.toString();
	}
	private boolean hasParams(String id_tiquete, String rutas, String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est) {
		return (id_tiquete != null && !id_tiquete.equals("")) || (rutas != null && !rutas.equals(""))
				|| (fecha != null && !fecha.equals("")) || (hora != null && !hora.equals(""))
				|| (puesto != null && !puesto.equals("") || (nombre_est != null && !nombre_est.equals(""))
				|| (apellido_est != null && !apellido_est.equals(""))|| (documento_est != null && !documento_est.equals("")));
	}

	private boolean validateEditionParams( String rutas, String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est) {
		return (rutas != null && !rutas.equals("")) || (fecha != null && !fecha.equals(""))
				|| (hora != null && !hora.equals("")) || (puesto != null && !puesto.equals(""))
				|| (nombre_est != null && !nombre_est.equals("")) || (apellido_est != null && !apellido_est.equals(""))
				|| (documento_est != null && !documento_est.equals(""));
	}
	

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://" + this.maquina + ":" + this.puerto
				+ "/tiquetesjdc?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
				this.usuario, this.clave);
	}
	
	
	

	private PreparedStatement buildEditTiquetPreparedStatement(String id_tiquete, String rutas,
			String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est, Connection conexion) throws Exception {
		PreparedStatement sentencia = conexion.prepareStatement(buildEditTiquetQuery(id_tiquete, rutas, fecha, hora, puesto,nombre_est,apellido_est,documento_est));
		int paramIndex = 1;

		if (rutas != null && !rutas.equals("")) {
			sentencia.setString(paramIndex, rutas);
			paramIndex++;
		}
		if (fecha != null && !fecha.equals("")) {
			sentencia.setString(paramIndex, fecha);
			paramIndex++;
		}
		if (hora != null && !hora.equals("")) {
			sentencia.setString(paramIndex, hora);
			paramIndex++;
		}

		if (puesto != null && !puesto.equals("")) {
			sentencia.setString(paramIndex, puesto);
			paramIndex++;
		}
		if (nombre_est != null && !nombre_est.equals("")) {
			sentencia.setString(paramIndex, nombre_est);
			paramIndex++;
		}
		if (apellido_est != null && !apellido_est.equals("")) {
			sentencia.setString(paramIndex, apellido_est);
			paramIndex++;
		}
		if (documento_est != null && !documento_est.equals("")) {
			sentencia.setString(paramIndex, documento_est);
			paramIndex++;
		}

		sentencia.setString(paramIndex, id_tiquete);

		return sentencia;
	}

	
	private String buildEditTiquetQuery(String id_tiquete, String rutas,
			String fecha, String hora, String puesto, String nombre_est, String apellido_est, String documento_est) {
		StringBuilder editTiquetQuery = new StringBuilder("UPDATE tiquetes SET ");
		boolean hasPreviousParam = false;
		
		if (rutas != null && !rutas.equals("")) {
			editTiquetQuery.append(" rutas = ? ");
			hasPreviousParam = true;
		}
		if (fecha != null && !fecha.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");

			}
			editTiquetQuery.append("  fecha = ? ");
			hasPreviousParam = true;
		}
		if (hora != null && !hora.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");
			}
			editTiquetQuery.append("  hora = ? ");
			hasPreviousParam = true;
		}
		if (puesto != null && !puesto.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");
			}
			editTiquetQuery.append("  puesto = ? ");
		}
		if (nombre_est != null && !nombre_est.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");
			}
			editTiquetQuery.append("  nombre_est = ? ");
		}
		if (apellido_est != null && !apellido_est.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");
			}
			editTiquetQuery.append("  apellido_est = ? ");
		}
		if (documento_est != null && !documento_est.equals("")) {
			if (hasPreviousParam) {
				editTiquetQuery.append(" , ");
			}
			editTiquetQuery.append("  documento_est = ? ");
		}
		
		editTiquetQuery.append(" WHERE id_tiquete = ?");
		return editTiquetQuery.toString();
	}
	
}
	 		 
	 
    