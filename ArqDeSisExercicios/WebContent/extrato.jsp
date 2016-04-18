<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Extrato</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>
<body>
<c:import url="menu.jsp" />
	<jsp:useBean id="lista" class="to.ExtratoTO" scope="request" />
	<div id="list" class="row">

                    <div class="table-responsive col-md-12">
                        <table class="table table-striped" cellspacing="0" cellpadding="0">
                         <thead>
                                <tr>
                                    <th>Id Movimento</th>
									<th>Tipo de Movimento</th>
									<th>Valor</th>
									<th>Data</th>
                                    
                                </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="extrato" items="${lista.extrato}">
                             <tr>
							 	<td> ${extrato.idMovimento }</td>
							 	<td> ${extrato.tipoMovimento}</td>
							 	<td> ${extrato.valor}</td>
							 	<td> ${extrato.data}</td>
							 </tr>
							 </c:forEach>
							 </tbody>
						</table>	 
					</div>
                </div>
                 <div id="bottom" class="row">
                    <div class="col-md-12">
                        <!-- paginação ainda não foi implementada -->
                        <ul class="pagination">
                            <li class="disabled"><a>&lt; Anterior</a>
                            </li>
                            <li class="disabled"><a>1</a>
                            </li>
                            <li><a href="#">2</a>
                            </li>
                            <li><a href="#">3</a>
                            </li>
                            <li class="next"><a href="#" rel="next">Próximo &gt;</a>
                            </li>
                        </ul>
                        <!-- /.pagination -->

                    </div>
                </div>
                <!-- /#bottom -->
            </div>
            <!-- /#main -->
            <script src="js/jquery.min.js"></script>
            <script src="js/bootstrap.min.js"></script>
</body>
</html>