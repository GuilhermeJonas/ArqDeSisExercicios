<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<link rel="stylesheet" type="text/css" media="screen"
	href="css/bootstrap-datetimepicker.min.css">
</head>
<body>
	<c:import url="menu.jsp"/>
	<div class="col-md-6 col-md-offset-3">
		<center>
		<h3>Sacar</h3>
		</center>
		<!-- <div class="well"> -->
		<div class="alert alert-success" role="alert">
			<form action="efetuar_saque.do" method="post">
				<div class="row">
					<div class="col-md-12">
						<h4>
						<center>
							Efetuado saque no valor de:
							<b>${saque.valor}</b>
							da conta
							<b>${saque.numConta}</b>
							e banco
							<b>${saque.numBanco}</b>
							<br>
						</center>
						</h4>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>