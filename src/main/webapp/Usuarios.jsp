
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
        <h3>El Rinc�n del Sabor</h3>
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
		<form action="ServletUsuario" method="POST">
		<p>Cedula :</p>
		<input type="text" name="ced" value="<%=cedula%>" required placeholder="Cedula">
		<p>Nombre :</p>
		<input type="text" name="nom" value="<%=nombre%>" required placeholder="Nombre">
		<p>Correo :</p>
		<input type="text" name="e"   value="<%=email%>" required placeholder="E-mail">
		<p>Usuario :</p>
		<input type="text" name="us"  value="<%=usuario%>" required placeholder="Usuario">
		<p>Password:</p>
		<input type="text" name="pas" value="<%=contra%>" placeholder="Password">
		<button type="submit" name="btnus" class="chek" type="checkbox" id="chek">Registro </button>		
		<button type="submit" name="btncon" class="chek" type="checkbox" id="chek">Consultar</button>
		<button type="submit" name="btnact" class="chek" type="checkbox" id="chek">Actualizar</button>
		<button type="submit" name="btneli" class="chek" type="checkbox" id="chek">Eliminar</button>
		
		</form>
	</div>
    </nav>
	
</body>
</html>