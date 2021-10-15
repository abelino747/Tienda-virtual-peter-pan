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
<script type="text/javascript" src="js/consultar.js"></script>



<title>Ventas</title>
</head>
<body>

	<main>
		<header id="contenedortitulo" class="headerclass">
			<h1>Modulo de Ventas</h1>
		</header>


		<form action="ServletVentas" method="post">


			<input type="text" name="cedula" value="${cliente.getCedula_cliente()}" placeholder="cedula">
			<input type="text" name="nombre" value="${cliente.getNombre_cliente()}" placeholder="nombre">
			<input type="submit" name="confirmar">

			<table>

				<tr>
					<th>Codigo del producto</th>
					<th>Consultar producto</th>
					<th>Nombre del producto</th>
					<th>Precio Unitario</th>
					<th>Cantidad de producto</th>
					<th>IVA</th>
					<th>Total a Pagar</th>
				</tr>

				<tr>
					<td><input type="text"   name="codigo" value="${producto.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro" value="Buscar producto"></td>
					<td><input type="text"   name="n2"     class="nombre"  value="${producto.getNombre_producto()}"></td>
					<td><input type="text"   name="precio" class="pre" id="pre"  value="${producto.getPrecio_venta()}"></td>
					<td><input type="text"   name="can"    class="cantidad" id="cantidad" ></td>
					<td><input type="text"   name="iva"    class="iva" id="iva"  value="${producto.getIva_compra()}"></td>
					<td><input type="text"   name="precio" class="pret" id="pret"  value=""></td>
				</tr>

				<tr>
					<td><input type="text"   name="codigo2" value="${producto2.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro2" value="Buscar producto"></td>
					<td><input type="text"   name="n2"      class="nombre" value="${producto2.getNombre_producto()}"></td>
					<td><input type="text"   name="precio2" class="pre2" id="pre2" value="${producto2.getPrecio_venta()}"></td>
					<td><input type="text"   name="can2"    class="cantidad2" id="cantidad2" ></td>
					<td><input type="text"   name="iva"     class="iva2" id="iva2"  value="${producto2.getIva_compra()}"></td>
					<td><input type="text"   name="precio" class="pret2" id="pret2"  value=""></td>
				</tr>
				
				<tr>
					<td><input type="text"   name="codigo3" value="${producto3.getCodigo_producto()}"></td>
					<td><input type="submit" name="conpro3" value="Buscar producto"></td>
					<td><input type="text"   name="n2"      class="nombre" value="${producto3.getNombre_producto()}"></td>
					<td><input type="text"   name="precio3" class="pre3" id="pre3" value="${producto3.getPrecio_venta()}"></td>
					<td><input type="text"   name="can3"    class="cantidad3" id="cantidad3" ></td>
					<td><input type="text"   name="iva"     class="iva3" id="iva3"  value="${producto3.getIva_compra()}"></td>
					<td><input type="text"   name="precio"  class="pret3" id="pret3"  value=""></td>
				</tr>

				<tr><td class="ult" colspan="5"><input type="submit" name="total" value="Enviar venta"></td></tr>

			</table>
			
			<input type="text" name="cu" value="544567"  >
			
		</form>

	</main>

</body>
</html>