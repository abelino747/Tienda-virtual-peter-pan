<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="es">
	<head>
	    <meta charset="UTF-8">
	    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	    <meta name="viewport" content="width=, initial-scale=1.0">
		<title>Login Peter Pan</title>
		<link rel="stylesheet" href="css/estilos.css">
		<link rel="shortcut icon" href="Favicon Peter Pan.ico">
	</head>
<body>    
	<%	
	// las variables que viajan por el servlet se colocan en nuevas variables que se muestran
	// en el input o donde se quieran mostrar como una tabla aparte con value
		String cedula= request.getParameter("ced");
		String nombre=request.getParameter("nom");
		String email=request.getParameter("e");
		String usuario=request.getParameter("us");
		String contra=request.getParameter("pas");		
	%>
    <main>
	    <nav class="login" >
	            <div class="formulario">
	                <h1>Bienvenido a la Panaderia </h1>
	                <h2>Peter Pan</h2>
	                <img src="imagenes/icono_usuario.png" alt="imagen Usuario" class="ima">
	                <h2>Inicio de Sesión </h2>
	                <form action="ServletLogin" method="POST">
	                    <p>Usuario</p>
	                    <input type="text" name="usuario" placeholder="Usario">
	                    <p>Contraseña</p>
	                    <input  type="password" name="password" placeholder="contraseña">
	                    <button type="submit" class="chek" type="button" >Iniciar Sesión </button>
	                    <a href="#">Recuperar Contraseña</a>
	                </form>  
	            </div>
	        </nav>
    </main>
</body>
</html>