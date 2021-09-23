<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=, initial-scale=1.0">
	<title>Panaderia Peter Paan</title>
	<link rel="stylesheet" href="css/estilos.css">
	<link rel="shortcut icon" href="favicon.ico?" type="image/x-icon" />
	<link rel = "preconnect" href = "https://fonts.googleapis.com">
	<link rel = "preconnect" href = "https://fonts.gstatic.com" crossorigin>
	<link href = "https: //fonts.googleapis.com/css2?" rel ="stylesheet">
</head>
<body>

    <main>
        <nav class="contenedor">
            <header><h2>Panadería Peter Paan</h2></header>    
        </nav>    
    </main>
        <nav class="formulario" >
            <div class="form">
                <h1> Bienvenidos al Rincón de los Sabores </h1>
                <img src="imagenes/login.jpg" alt="imagen Usuario" class="img" id="img">
                <h3>Inicio de Sesión </h3>
                <form action="ServletLogin" method="post">
                    <input type="text" name="usuario" placeholder="Usuario">
                    <input type="password" name="password" placeholder="Contraseña">
                    <input class="chek" type="checkbox" id="chek">
                    <label for="chek">Guardar Contraseña</label>
                    <a href="#" class="rec" id="rec">Recuperar Contraseña</a>
                    <input class="boton" type="submit" name="btnlog" value="Enviar">
                </form>  
            </div>
        </nav>


</body>
</html>