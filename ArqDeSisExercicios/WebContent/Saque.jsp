<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="to.SaqueTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
 <meta http-equiv="X-UA-Compatible" content="IE=edge">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <title>Consultar Extrato</title>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <link href="css/style.css" rel="stylesheet">
<meta charset="UTF-8">
<link href="css/bootstrap-combined.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" media="screen"  href="css/bootstrap-datetimepicker.min.css">
</head>
<body>
<%SaqueTO to = (SaqueTO)request.getAttribute("saque"); %>
<nav class="navbar navbar-default navbar-fixed-top">
 <div class="container-fluid">
  <div class="navbar-header">
   <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
    <span class="sr-only">Toggle navigation</span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
    <span class="icon-bar"></span>
   </button>
   <a class="navbar-brand" href="index.html">Caixa Eletronico</a>
  </div>
  <div id="navbar" class="navbar-collapse collapse">
   <ul class="nav navbar-nav navbar-right">
    <li><a href="extrato_form.html">Extrato</a></li>
    <li><a href="saque_form.html">Saque</a></li>
   </ul>
  </div>
 </div>
</nav>
	<div class="col-md-3 col-md-offset-4">
	<h3>Sacar</h3>	
		<div class="well">
				<form action="efetuar_saque.do" method="post">
						<div class="row">
							<div class="col-md-12">
							  Efetuado saque no valor de: <%= to.getValor() %> <br>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
							  da conta <%= to.getNumConta() %> e banco <%= to.getNumBanco() %>	
							</div>
						</div>
				</form>
		</div>
	</div>
</body>
</html>