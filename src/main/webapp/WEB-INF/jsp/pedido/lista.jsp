<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Pedidos</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Pedidos</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/pedido" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty pedidos}">
			<h5>Não existem pedidos cadastrados!!!</h5>
		</c:if>
	
		<c:if test="${not empty pedidos}">
			<h5>Quantidade de pedidos cadastrados: ${pedidos.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Comentario</th>
			      <th>Dinheiro</th>
			      <th>Data</th>
			      <th>Cliente</th>
			      <th>Alimentos</th>
			      <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="p" items="${pedidos}">
				    <tr>
				      <td>${p.id}</td>
				      <td>${p.comentario}</td>
				      <td>${p.dinheiro}</td>
				      <td>${p.data}</td>
				      <td>${p.cliente.nome}</td>
				      <td>${p.alimentos.size()}</td>
				      <td><a href="/pedido/${p.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>