<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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

		<form action="ServletProductos" method="POST">
		<!-- LE QUITE EL VALUEEE CUIDADOOOO QUEDAN ADVERTIDOS  -->  
		<input type="text" name="ced" placeholder="Productos">
		
		<button type="Button" name="btnus">Cargar</button>
		<button type="Button" name="btncon">Examinar</button>

		</form>


</body>
</html>