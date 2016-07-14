<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav class="navbar navbar-default">
        <div class="container-fluid">
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Caixa Eletrônico</a>
          </div>
          <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
              <li class="active"><a href="menuUser.jsp">Home</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Ações <span class="caret"></span></a>
                <ul class="dropdown-menu">
                  <li><a href="saque_form.jsp">Saque</a></li>
                  <li><a href="extrato_form.jsp">Extrato</a></li>
                  <li role="separator" class="divider"></li>
                  <li class="dropdown-header">Não implementadas</li>
                  <li><a href="">Transferência</a></li>
                  <li><a href="">Débito Automático</a></li>
                  <li><a href="">Depósitos</a></li>
                </ul>
              </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <li class = "id">Logado como ${nome}</li>
              <li><a href="../navbar-fixed-top/">Sair</a></li>
            </ul>
          </div><!--/.nav-collapse -->
        </div><!--/.container-fluid -->
      </nav>