<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<c:import url="menu.jsp" />
		<div class="col-md-3 col-md-offset-4">
			<h3>Sacar</h3>
			<div class="well">
				<form action="controller.do" method="post">
					<div class="row">
						<div class="col-md-4">Banco:</div>
						<div class="col-md-8">
							<input type="text" name="banco" size="10">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">Agencia:</div>
						<div class="col-md-8">
							<input type="text" name="agencia" size="10">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">Conta:</div>
						<div class="col-md-8">
							<input type="text" name="conta" size="10">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">Valor:</div>
						<div class="col-md-8">
							<input type="text" name="valor" size="10">
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">Data:</div>
						<div class="col-md-8">
							<input type="date" name="data" size="10">
						</div>
					</div>
					<div class="row">
						<br>
					</div>
					<div class="row">
						<div class="col-md-12 col-md-offset-2">
							<button type="submit" name="command" value="SaqueController"
								class="btn btn-primary">Sacar</button>
								<input type="reset" class="btn btn-default">
						</div>
					</div>
				</form>
			</div>
		</div>
	</body>
</html>