<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="Favicon Peter Pan.ico">
    <link rel="stylesheet" href="css/EstilosMenu.css">
    
    
    <script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
	<script type="text/javascript" src="js/reportes.js"></script>
	
	<title>Reportes</title>
</head>
<body>

<main>
		<header id="contenedortitulo" class="headerclass">
			<h1>Modulo de Reportes</h1>
		</header>
		<form action="" method="">
			<input type="button" class="btngeneral"  id="btngeneral"name="repUsuarios" value="Reporte Usuarios">
			<input type="submit" name="repUsuarios" value="Reporte Clientes">
			<input type="submit" name="repUsuarios" value="Reporte Ventas por cliente">				
		</form>
		
		
		
			<table  id = "datos_en_tabla" class="datos_en_tabla" ></table>





	</main>

</body>
</html>