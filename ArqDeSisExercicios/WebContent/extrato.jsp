<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="to.ExtratoTO" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Extrato</title>
</head>
<body>
	<% ArrayList<ExtratoTO> to = (ArrayList<ExtratoTO>)request.getAttribute("extrato"); %>
	<table>
		<tr>
			<th>Id Movimento</th>
			<th>Tipo de Movimento</th>
			<th>Valor</th>
			<th>Data</th>
			<% for (ExtratoTO extrato : to){ %>
			<tr>
				<td><%=extrato.getIdMovimento() %></td>
				<td><%=extrato.getTipoMovimento() %></td>
				<td><%=extrato.getValor() %></td>
				<td><%=extrato.getData() %></td>
			</tr>
		</tr>
			<%}%>	
	</table>
</body>
</html>