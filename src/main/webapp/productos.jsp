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
	<title>Productos</title>
</head>
<body>
	<%	
	// las variables que viajan por el servlet se colocan en nuevas variables que se muestran
	// en el input o donde se quieran mostrar como una tabla aparte con value
	
		String codigo_producto=request.getParameter("cod");
		String nombre_producto=request.getParameter("nom");
		String nit_proveedor=request.getParameter("nit");
		String precio_compra=request.getParameter("precio_compra");
		String iva_compra=request.getParameter("iva_compra");	
		String precio_venta=request.getParameter("precio_venta");	
	
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

		<form action="ServletProductos" method="POST" enctype="multipart/form-data">
		
		<p>Código del Producto :</p>
		<input type="text" name="cod" value="<%=codigo_producto%>"    placeholder="Código">
		<p>Nombre del Producto:</p>
		<input type="text" name="nom" value="<%=nombre_producto%>"    placeholder="Nombre">
		<p>Nit Proveedor :</p>
		<input type="text" name="nit" value="<%=nit_proveedor%>" placeholder="Nit del Proveedor">
		<p>Precio compra :</p>
		<input type="text" name="precio_compra" value="<%=precio_compra%>"     placeholder="Precio de Compra">
		<p>Iva de Compra :</p>
		<input type="text" name="iva_compra" value="<%=iva_compra%>"  placeholder="Iva de Compra">
		<p>Precio de venta :</p>
		<input type="text" name="precio_venta" value="<%=precio_venta%>"  placeholder="Precio de venta">

		
		<button type="submit" name="btncon" class="chek" id="chek">Consultar</button>
		<button type="submit" name="btnact" class="chek" id="chek">Actualizar</button>
		
		<!-- 
		<button type="submit" name="btncli" class="chek" id="chek">Registrar</button>
		<button type="submit" name="btnEli" class="chek" id="chek">Eliminar</button>
		
	
		
		 -->
		
		<input type="file" name="archivo" class="chek" value="">
		<input type="submit" name="cargar" class="chek" value="Agregar Archivo">

		</form>
</div>
</nav>
</body>





</html>