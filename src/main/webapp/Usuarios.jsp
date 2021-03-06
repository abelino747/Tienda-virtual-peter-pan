
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


<title>Usuario</title>
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
	
    <header>
        <h1>Panaderia Peter Pan</h1>
        <img class="img" src="imagenes/PeterPan Transparente.png" alt="logo" height="150px">
        <h3>El Rinc?n del Sabor</h3>
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
		<form action="ServletUsuario" method="POST">
		<p>Cedula Usuario:</p>
		<input type="number" name="ced" value="<%=cedula  != null ? cedula: "" %>" required placeholder="Cedula">
		<p>Nombre Usuario:</p>
		<input type="text" name="nom" value="<%=nombre  != null ? nombre: "" %>"  placeholder="Nombre">
		<p>Correo Usuario:</p>
		<input type="email" name="e"   value="<%=email   != null ? email: ""  %>" placeholder="E-mail">
		<p> Nickname Usuario :</p>
		<input type="text" name="us"  value="<%=usuario != null ? usuario: ""%>" placeholder="Usuario">
		<p>Password Usuario:</p>
		<input type="password" name="pas" value="<%=contra  != null ? cedula: "" %>" placeholder="Password">
		<button type="submit" name="btnus" class="chek"  id="chek">Registro </button>		
		<button type="submit" name="btncon" class="chek" id="chek">Consultar</button>
		<button type="submit" name="btnact" class="chek" id="chek">Actualizar</button>
		<button type="submit" name="btneli" class="chek" id="chek">Eliminar</button>
		
		</form>
	</div>
    </nav>
	
</body>
</html>