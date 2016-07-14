var alerta = "<div class='alert alert-danger' role='alert'>"+
			  "<span class='glyphicon glyphicon-exclamation-sign' aria-hidden='true'></span>"+
			  "<span class='sr-only'>Erro:</span>"+
			  " Corrija o campo Senha"+
			"</div>";
var alertaLocal = document.querySelector("#campo-erros");
var campoSenhaOriginal = document.querySelector("#senha");
var campoSenha = document.querySelector("#senha");

console.log(campoSenha);
campoSenha.addEventListener("focusout", function(){
	console.log("caiu no focusout");
	if(campoSenha.value == ""){
		//alertaLocal.innerHTML += alerta;
		alertaLocal.style.display = 'block';
	}else{
		//alertaLocal.innerHTML = campoSenhaOriginal.innerHTML;
		alertaLocal.style.display = 'none';
	}
});


