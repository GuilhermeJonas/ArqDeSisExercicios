<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="to.SaqueTO" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Saque</title>
</head>
<body>
	<%SaqueTO to = (SaqueTO)request.getAttribute("saque"); %>
	Efetuado saque no valor de: <%= to.getValor() %> <br>
	da conta <%= to.getNumConta() %> e banco <%= to.getNumBanco() %>
</body>
</html>