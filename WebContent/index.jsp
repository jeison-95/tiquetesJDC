<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title> Formulario </title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</head>
<body>
   
	
	 <div class="container mt-4 col-lg-4">
            <div class="card border-info">
                <div class="card-header bg-info">
                <h1>  LOGIN JDC </h1>
	     
                   
                </div>
                <div class="card-body">
                   <form action = " AuthServlet " method = "post" >
                        <label>USUARIO</label>
                        <input type="text" name="usuario"  class="form-control" />
                        <label>CONTRASEÑA</label>
                        <input type="text" name="password"  class="form-control" />
                       
                        <a href ="menuCrud.jsp"> <input type="submit" values="Enviar"> </a>
                        
                    </form>
                </div>
            </div>
        </div>
	
		<script type="text/javascript">
			
		</script>
</body>
</html>