<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Alimentos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Alimentos</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<c:if test="${empty alimentos}">
			<h5>Não existem alimentos cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty alimentos}">
			<h5>Quantidade de alimentos cadastrados: ${alimentos.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Nome</th>
			      <th>Preco</th>
			      <th>Sabor</th>
			      <th>Quantidade</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="p" items="${alimentos}">
				    <tr>
				      <td>${p.id}</td>
				      <td>${p.nome}</td>
				      <td>${p.preco}</td>
				      <td>${p.sabor}</td>
				      <td>${p.quantidade}</td>
				      <td><a href="/produto/${p.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>