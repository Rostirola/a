<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Cleintes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Cleintes</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/cliente" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty clientes}">
			<h5>Não existem clientes cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty clientes}">
			<h5>Quantidade de clientes cadastrados: ${clientes.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>CPF</th>
			      <th>Idade</th>
			      <th>E-mail</th>
			      <th>Usuário</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="c" items="${clientes}">
				    <tr>
				      <td>${c.id}</td>
				      <td>${c.nome}</td>
				      <td>${c.cpf}</td>
				      <td>${c.idade}</td>
				      <td>${c.email}</td>
				      <td>${c.usuario.nome}</td>
				      <td><a href="/cliente/${c.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>