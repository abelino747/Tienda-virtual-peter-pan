<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
</head>
<body>
<%	
	// las variables que viajan por el servlet se colocan en nuevas variables que se muestran
	// en el input o donde se quieran mostrar como una tabla aparte con value
		    String nit = request.getParameter("nit1");
			String nombre= request.getParameter("nombre1");
			String ciudad= request.getParameter("ciudad1");
			String direccion = request.getParameter("direccion1");
			String telefono= request.getParameter("telefono1");
	%>

		<form action="ServletProveedores" method="POST">
		<input type="text" name="nit1" value="<%=nit%>" placeholder="nit_proveedor">
		<input type="text" name="nombre1" value="<%=nombre%>" placeholder="nombre_proveedor">
		<input type="text" name="ciudad1"   value="<%=ciudad%>"  placeholder="ciudad_proveedor">
		<input type="text" name="direccion1"  value="<%=direccion%>"placeholder="direccion_proveedor">
		<input type="text" name="telefono1" value="<%=telefono%>" placeholder="telefono_proveedor">

		<button type="submit" name="btnProveedor">Registrar</button>
		<button type="submit" name="btnprove">Consultar</button>
        <button type="submit" name="btnact">Actualizar</button>
        <button type="submit" name="btnEli">Eliminar</button>
	
	</form>
</body>
</html>

