$(document).ready(function() {
	


	$(".btngeneral").on("click", function() {
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
})