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
            <div class="opcion">
            <h2>Inicio</h2>
            <a href="menu.jsp">
                
                    <img src="imagenes/house-1110868_1280.png" alt="Reportes">                                   
            </a>
            </div>
            <div class="opcion">
            <h2>Usuarios</h2>
            <a href="Usuarios.jsp">
                
                    <img src="imagenes/usuarios.png" alt="Usuarios">                                  
            </a>
            </div>
            <div class="opcion">
            <h2>Clientes</h2>
            <a href="clientes.jsp">
                
                    <img src="imagenes/clientes.png" alt="Clientes">                             
            </a>
            </div>
            <div class="opcion">
            <h2>Proveedores</h2>
            <a href="proveedores.jsp">
               
                    <img src="imagenes/proveedoress.png" alt="Proveedores">                                   
            </a>
            </div>
            <div class="opcion">
            <h2>Productos</h2>
            <a href="productos.jsp">
                
                    <img src="imagenes/donut-1727493_1920.png" alt="productos">                                  
            </a>
            </div>
            <div class="opcion">
            <h2>Reportes</h2>
            <a href="reportes.jsp">
                
                    <img src="imagenes/symbol-2444430_1280.png" alt="Reportes">                                  
            </a>
            </div>
            <div class="opcion">
            <h2>Ventas</h2>
            <a href="ventas.jsp">
                
                    <img src="imagenes/shopping-cart-1105049_1280.png" alt="Reportes">                                 
            </a>
            </div>
            <div class="opcion">
            <h2>Salir</h2>
            <a href="index.jsp">
                
                    <img src="imagenes/log-out-2355227_1280.png" alt="Reportes">                                 
            </a>
            </div>
        </nav>
    </main>
    
       <nav   class="usuarios" >
       
        <div id="formulario" class="formulario">
        
		<form action="ServletProveedores" method="POST">
		<p>NIT Proveedor:</p>
		<input type="number" name="nit1" value="<%=nit != null ? nit: ""%>" required placeholder="nit_proveedor">
		<p>Nombre Proveedor:</p>
		<input type="text" name="nombre1" value="<%=nombre != null ? nombre: ""%>" placeholder="nombre_proveedor">
		<p>Ciudad Proveedor:</p>
		<input type="text" name="ciudad1"   value="<%=ciudad != null ? ciudad: ""%>"  placeholder="ciudad_proveedor">
		<p>Dirección Proveedor:</p>
		<input type="text" name="direccion1"  value="<%=direccion != null ? direccion: ""%>"placeholder="direccion_proveedor">
		<p>Teléfono Proveedor:</p>
		<input type="number" name="telefono1" value="<%=telefono != null ? telefono: ""%>" placeholder="telefono_proveedor">

		<button type="submit" name="btnProveedor" class="chek" id="chek">Registrar</button>
		<button type="submit" name="btnprove" class="chek" id="chek">Consultar</button>
        <button type="submit" name="btnact" class="chek" id="chek">Actualizar</button>
        <button type="submit" name="btnEli" class="chek" id="chek">Eliminar</button>
	
	</form>
</div>
</nav>
</body>
</html>

