$(document).ready(function(){
	

	$('.cantidad').on('keyup',function(){
	//alert("alerta ");
	let cat=$('.cantidad').val();
	let pre=$('#pre').val();
	let iva=$('#iva').val();
	let datos=document.querySelector('#pret');
	let res=(cat*pre)+((cat*pre)*(iva/100));
	datos.value = res;
		
		
	});
	
	
	$('.cantidad2').on('keyup',function(){
	//alert("alerta ");
	let cat=$('.cantidad2').val();
	let pre=$('#pre2').val();
	let iva=$('#iva2').val();
	let datos=document.querySelector('#pret2');
	let res=(cat*pre)+((cat*pre)*(iva/100));
	datos.value = res;
		
		
	});	
	
	$('.cantidad3').on('keyup',function(){
	//alert("alerta ");
	let cat=$('.cantidad3').val();
	let pre=$('#pre3').val();
	let iva=$('#iva3').val();
	let datos=document.querySelector('#pret3');
	let res=(cat*pre)+((cat*pre)*(iva/100));
	datos.value = res;
		
		
	});	
	
	//console.log(datos2)
	
});