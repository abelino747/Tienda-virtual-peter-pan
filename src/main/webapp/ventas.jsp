<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="modelo.ClientesDTO"%>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon" href="Favicon Peter Pan.ico">
<script type="text/javascript" src="js/jquery-3.6.0.min.js"></script>
<script type="text/javascript" src="js/ventas.js"></script>
<link rel="stylesheet" href="css/reportes.css">

<title>Ventas</title>
</head>
<body>

	<main>
		<header id="contenedortitulo" class="headerclass">
			<h1>Modulo de Ventas</h1>
		</header>

		<div class="formulario">
		<form action="ServletVentas" method="post" >
			<div class="ca">

			<input  class="c" type="text" name="cedula" value="${cliente.getCedula_cliente()}" placeholder="cedula">
			<input class="c" type="text" name="nombre" value="${cliente.getNombre_cliente()}" placeholder="nombre">
			<input type="submit" name="confirmar"class="chek" >
			</div>
			<table >

				<tr>
					<th>Codigo</th>
					<th>Consultar </th>
					<th>Producto</th>
					<th>Valor Unitario</th>
					<th>Cantidad </th>
					<th>IVA %</th>
					<th>Total a Pagar</th>
				</tr>

				<tr>
					<td><input type="text"   name="codigo" class="co"value="${producto.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro" value="Buscar" class="chek"></td>
					<td><input type="text"   name="n2"     class="c"  value="${producto.getNombre_producto()}"></td>
					<td><input type="text"   name="precio" class="co" id="pre"  value="${producto.getPrecio_venta()}"></td>
					<td><input type="text"   name="can"    class="co" id="cantidad" ></td>
					<td><input type="text"   name="iva"    class="co" id="iva"  value="${producto.getIva_compra()}"></td>
					<td><input type="text"   name="precio" class="co" id="pret"  value=""></td>
				</tr>

				<tr>
					<td><input type="text"   name="codigo2" class="co"value="${producto2.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro2" value="Buscar" class="chek"></td>
					<td><input type="text"   name="n2"      class="c" value="${producto2.getNombre_producto()}"></td>
					<td><input type="text"   name="precio2" class="co" id="pre2" value="${producto2.getPrecio_venta()}"></td>
					<td><input type="text"   name="can2"    class="co" id="cantidad2" ></td>
					<td><input type="text"   name="iva"     class="co" id="iva2"  value="${producto2.getIva_compra()}"></td>
					<td><input type="text"   name="precio" class="co" id="pret2"  value=""></td>
				</tr>
				
				<tr>
					<td><input type="text"   name="codigo3" class="co"value="${producto3.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro3" value="Buscar" class="chek"></td>
					<td><input type="text"   name="n2"      class="c" value="${producto3.getNombre_producto()}"></td>
					<td><input type="text"   name="precio3" class="co" id="pre3" value="${producto3.getPrecio_venta()}"></td>
					<td><input type="text"   name="can3"     class="co" id="cantidad3" ></td>
					<td><input type="text"   name="iva"      class="co" id="iva3"  value="${producto3.getIva_compra()}"></td>
					<td><input type="text"   name="precio"   class="co" id="pret3"  value=""></td>
				</tr>

				<tr><td class="ult" >
				<input type="submit" name="total" value="Enviar venta" class="chek"></td></tr>

			</table>
			
			<input type="text" name="cu" value="${vs.getCedula_usuario()}" class="c"  >
			
		</form>
</div>
	</main>

</body>
</html>