
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Clientes</title>
</head>
<body>
	<%	
	// las variables que viajan por el servlet se colocan en nuevas variables que se muestran
	// en el input o donde se quieran mostrar como una tabla aparte con value
		String cedula=request.getParameter("ced");
		String nombre=request.getParameter("nom");
		String direccion=request.getParameter("dir");
		String email=request.getParameter("ema");
		String telefono=request.getParameter("tel");		
	
	%>

		<form action="ServletClientes" method="POST">
		<input type="text" name="ced" value="<%=cedula%>"    placeholder="Cedula">
		<input type="text" name="nom" value="<%=nombre%>"    placeholder="Nombre">
		<input type="text" name="dir" value="<%=direccion%>" placeholder="Dirección">
		<input type="text" name="ema" value="<%=email%>"     placeholder="E-mail">
		<input type="text" name="tel" value="<%=telefono%>"  placeholder="Teléfono">

		<button type="submit" name="btncli">Registrar</button>
		<button type="submit" name="btncon">Consultar</button>

		</form>


</body>
</html>