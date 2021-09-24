
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro Usuario</title>
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

		<form action="ServletUsuario" method="POST">
		<input type="text" name="ced" value="<%=cedula%>" placeholder="Cedula">
		<input type="text" name="nom" value="<%=nombre%>" placeholder="Nombre">
		<input type="text" name="e"   value="<%=email%>"  placeholder="E-mail">
		<input type="text" name="us"  value="<%=usuario%>"placeholder="Usuario">
		<input type="text" name="pas" value="<%=contra%>" placeholder="Password">

		<button type="submit" name="btnus">Registrar</button>
		<button type="submit" name="btncon">Consultar</button>

	
	</form>


</body>
</html>