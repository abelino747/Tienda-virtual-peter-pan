$(document).ready(function() {

	$("#btnrepUsuarios").on("click", function() {
		alert("Generando Datos")
		genera_datos();
		
		// copiado de la pagina jquery
		function genera_datos() {

			$.ajax({
				url: "ServletUsuario",
				type: "post",
				dataType: "json",

				success: function(result) {
					alert("Ingresando Base de Datos")
					console.log(result);
					let tabla = document.querySelector('#datos_en_tabla')
					console.log(tabla);
					tabla.innerHTML = "";
					tabla.innerHTML = `<tr>
						<th>cedula</th>
						<th>nombre</th>
						<th>email</th>
						<th>usuario</th>
						<th>password</th>
					</tr>`
					for (let i of result) {
						tabla.innerHTML += `<tr>
							  <td>${i.cedula_usuario}</td>
							  <td>${i.nombre_usuario}</td>
							  <td>${i.email_usuario}</td>
						      <td>${i.usuario}</td>
							  <td>${i.password}</td>
							  
						  </tr>`

					}



				}
			});

		}
	});
	
	$("#btnrepVentas").on("click", function() {
		alert("Generando Datos")
		genera_datos();
		
		// copiado de la pagina jquery
		function genera_datos() {

			$.ajax({
				url: "ServletReportes",
				type: "get",
				dataType: "json",

				success: function(result) {
					alert("Ingresando Base de Datos")
					console.log(result);
					let tabla = document.querySelector('#datos_en_tabla')
					console.log(tabla);
					tabla.innerHTML = "";
					tabla.innerHTML = `<tr>
						<th>Cedula Cliente</th>
						<th>Nombre Cliente</th>
						<th>Total Ventas</th>
					</tr>`
					for (let i of result) {
						tabla.innerHTML += `<tr>
							  <td>${i.cedula_cliente}</td>
							  <td>${i.nombre_cliente}</td>
							  <td>${i.total_ventas}</td>
							  
						  </tr>`

					}
				}
			});

		}
	});
	
		$("#btnrepClientes").on("click", function() {
		alert("Generando Datos")
		genera_datos();
		
		// copiado de la pagina jquery
		function genera_datos() {

			$.ajax({
				url: "ServletReportes",
				type: "post",
				dataType: "json",

				success: function(result) {
					alert("Ingresando Base de Datos")
					console.log(result);
					let tabla = document.querySelector('#datos_en_tabla')
					console.log(tabla);
					tabla.innerHTML = "";
					tabla.innerHTML = `<tr>
						<th>Cedula</th>
						<th>Nombre</th>
						<th>Dirección</th>
						<th>Email</th>
						<th>Telefono</th>
					</tr>`
					for (let i of result) {
						tabla.innerHTML += `<tr>
							  <td>${i.cedula_cliente}</td>
							  <td>${i.nombre_cliente}</td>
							  <td>${i.direccion_cliente}</td>
						      <td>${i.email_cliente}</td>
							  <td>${i.telefono_cliente}</td>
							  
						  </tr>`

					}
				}
			});

		}
	});
	
})