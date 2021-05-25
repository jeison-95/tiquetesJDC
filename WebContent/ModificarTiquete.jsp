
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tiquetes JDC</title>
        
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
       
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
        <%@ page import ="model.tiquete" %>
</head>
<body>

<%
 	String Id_tiquete = (String)request.getSession().getAttribute("Asig_tiquete");
 	String Rutas = (String)request.getSession().getAttribute("Asig_ruta");
 	String Fecha = (String)request.getSession().getAttribute("Asig_fecha");
 	String Hora = (String)request.getSession().getAttribute("Asig_hora");
 	String Puesto = (String)request.getSession().getAttribute("Asig_puesto");
 	String Nom_estudiante = (String)request.getSession().getAttribute("Asig_nombre");
 	String Ape_estudiante = (String)request.getSession().getAttribute("Asig_apellido");
 	String Doc_Estudiante = (String)request.getSession().getAttribute("Asig_documento");
 
 	System.out.print("Asig_ruta");
 	
 %>


   <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                    <h4>Modificar tiquete</h4>
                </div>
                <div class="card-body">
                    <form action="modifyTiquete" method="post">
                        <label>ID TIQUETE</label>
                        <input type="text" name="Asig_tiquete" placeholder="<%=Id_tiquete%>" class="form-control" />
                        <label>RUTAS</label>
                        <input type="text" name="Asig_ruta" placeholder="<%=Rutas%>" class="form-control" />
                        <label>FECHA</label>
                        <input type="text" name="Asig_fecha" placeholder="<%=Fecha%>" class="form-control" />
                        <label>HORA</label>
                        <input type="text" name="Asig_hora" placeholder="<%=Hora%>" class="form-control" />
                        <label>PUESTO</label>
                        <input type="text" name="Asig_puesto" placeholder="<%=Puesto%>" class="form-control" />
                        <label>NOMBRE ESTUDIANTE</label>
                        <input type="text" name="Asig_nombre" placeholder="<%=Nom_estudiante%>" class="form-control" />
                        <label>APELLIDOS ESTUDIANTE</label>
                        <input type="text" name="Asig_apellido" placeholder="<%=Ape_estudiante%>" class="form-control" />
                        <label>DOCUMENTO ESTUDIANTE</label>
                        <input type="text" name="Asig_documento" placeholder="<%=Doc_Estudiante%>" class="form-control" />
                        
                        <input type="submit" value="Enviar" class="btn btn-success"/>
                         <input type="submit" value="Modificar" class="btn btn-success"/>
                   
                        <a href="menuCrud.jsp" class="btn btn-primary">Regresar</a>
                    </form>
                </div>
            </div>
        </div>
</body>
</html>