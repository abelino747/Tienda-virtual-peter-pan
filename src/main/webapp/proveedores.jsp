<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="shortcut icon" href="imagenes/Favicon Peter Pan.ico">
    <link rel="stylesheet" href="css/EstilosMenu.css">
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

 <header>
        <h1>Panaderia Peter Pan</h1>
        <img class="img" src="imagenes/PeterPan Transparente.png" alt="logo" height="150px">
        <h3>El Rincón del Sabor</h3>
    </header>
    
    <main>
        <h3>Menu</h3>

        <nav class="contenedor">
            <a href="menu.jsp">
                <div class="opcion">
                    <img src="imagenes/house-1110868_1280.png" alt="Reportes">
                    <h2>Inicio</h2>
                </div>
            </a>
            <a href="Usuarios.jsp">
                <div class="opcion">
                    <img src="imagenes/usuarios.png" alt="Usuarios">
                    <h2>Usuarios</h2>
                </div>
            </a>
            <a href="clientes.jsp">
                <div class="opcion">
                    <img src="imagenes/clientes.png" alt="Clientes">
                    <h2>Clientes</h2>
                </div>
            </a>
            <a href="proveedores.jsp">
                <div class="opcion">
                    <img src="imagenes/proveedoress.png" alt="Proveedores">
                    <h2>Proveedores</h2>
                </div>
            </a>
            <a href="productos.jsp">
                <div class="opcion">
                    <img src="imagenes/donut-1727493_1920.png" alt="productos">
                    <h2>Productos</h2>
                </div>
            </a>
            <a href="reportes.jsp">
                <div class="opcion">
                    <img src="imagenes/symbol-2444430_1280.png" alt="Reportes">
                    <h2>Reportes</h2>
                </div>
            </a>
            <a href="ventas.jsp">
                <div class="opcion">
                    <img src="imagenes/shopping-cart-1105049_1280.png" alt="Reportes">
                    <h2>Ventas</h2>
                </div>
            </a>
            <a href="index.jsp">
                <div class="opcion">
                    <img src="imagenes/log-out-2355227_1280.png" alt="Reportes">
                    <h2>Salir</h2>
                </div>
            </a>
        </nav>
    </main>
    
       <nav   class="usuarios" >
        <div id="formulario" class="formulario">
		<form action="ServletProveedores" method="POST">
		<p>NIT :</p>
		<input type="text" name="nit1" value="<%=nit%>" placeholder="nit_proveedor">
		<p>Nombre :</p>
		<input type="text" name="nombre1" value="<%=nombre%>" placeholder="nombre_proveedor">
		<p>Ciudad :</p>
		<input type="text" name="ciudad1"   value="<%=ciudad%>"  placeholder="ciudad_proveedor">
		<p>Dirección :</p>
		<input type="text" name="direccion1"  value="<%=direccion%>"placeholder="direccion_proveedor">
		<p>Teléfono :</p>
		<input type="text" name="telefono1" value="<%=telefono%>" placeholder="telefono_proveedor">

		<button type="submit" name="btnProveedor" class="chek" type="checkbox" id="chek">Registrar</button>
		<button type="submit" name="btnprove" class="chek" type="checkbox" id="chek">Consultar</button>
        <button type="submit" name="btnact" class="chek" type="checkbox" id="chek">Actualizar</button>
        <button type="submit" name="btnEli" class="chek" type="checkbox" id="chek">Eliminar</button>
	
	</form>
</body>
</html>

