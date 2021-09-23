<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Proveedores</title>
</head>
<body>
	<form action="ServletProveedores" method="post">	
		<input type="text" name="nit" placeholder="nit_proveedor">
		<input type="text" name="nombre" placeholder="nombre_proveedor">
		<input type="text" name="ciudad" placeholder="ciudad_proveedor">
		<input type="text" name="direccion" placeholder="direccion_proveedor">
		<input type="text" name="telefono" placeholder="telefono_proveedor">
		<button type="submit" name="btnProveedor">enviar</button>
	</form>

</body>
</html>

