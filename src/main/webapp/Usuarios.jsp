
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Usuario</title>
</head>
<body>

	<form action="ServletUsuario" method="post">
	
	<input  type="number" name="ced" required placeholder="Cedula"   oninvalid="this.setCustomValidity('Cedula Requerido    ')">
	<input  type="text"   name="nom" required placeholder="Nombre"   oninvalid="this.setCustomValidity('Nombre Requerido    ')">
	<input  type="email"  name="e"   required placeholder="E-mail"   oninvalid="this.setCustomValidity('E-mail Requerido    ')">
	<input  type="text"   name="us"  required placeholder="Usuario"  oninvalid="this.setCustomValidity('Usuario Requerido   ')">
	<input  type="text"   name="pas" required placeholder="Password" oninvalid="this.setCustomValidity('Contraseña Requerida')">
	<button type="submit" name="btnus">Registrar</button>

	
	</form>


</body>
</html>