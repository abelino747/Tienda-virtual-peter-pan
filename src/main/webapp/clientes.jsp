<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Clientes</title>
</head>
<body>
	<form action="ServletClientes" method="post">
	
		<input type="text" name="ced" placeholder="Cédula">
		<input type="text" name="nom" placeholder="Nombre">
		<input type="text" name="dir" placeholder="Dirección">
		<input type="text" name="ema" placeholder="E-mail">
		<input type="text" name="tel" placeholder="Teléfono">
		<button type="submit" name="btncli">enviar</button>
	</form>

</body>
</html>