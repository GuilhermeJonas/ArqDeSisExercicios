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
<link rel="stylesheet" type="text/css" media="screen"  href="css/bootstrap-datetimepicker.min.css">
</head>
  <body>
  <c:import url="menu.jsp" />

    <div class="col-md-3 col-md-offset-4">
    	<h3>Consultar Extrato</h3>
    	<form action="consultar_extrato.do" method="post">
    		  	<div class="well">
            <form action="efetuar_saque.do" method="post">
                <div class="row">
                  <div class="col-md-4">
                    Conta:
                  </div>
                  <div class="col-md-8">
                    <input type="text" name="numConta" size="10">
                  </div>
                </div>
                <div class="row">
                  <div class="col-md-4">
                    Data:
                  </div>
                  <div class="col-md-8">
                    <input type="date" name="data" size="10">
                  </div>
                </div>
                <div class="row">
                <br>
                </div>
                <div class="row">
                  <div class="col-md-12 col-md-offset-2">
                    <button type="submit" class="btn btn-primary" name="acao" value="Carregar">Carregar</button>
                    <input type="reset" class="btn btn-default">
                  </div>
                </div>
            </form>
        </div>
    	</form>
    </div>
  </body>
</html>