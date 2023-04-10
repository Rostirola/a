<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Milkshake</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Milkshake</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/milkshake" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty milkshakes}">
			<h5>Não existem milkshakes cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty milkshakes}">
			<h5>Quantidade de milkshakes cadastradas: ${milkshakes.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Especial</th>
			      <th>Sabor</th>
			      <th>Tamanho</th>
			      <th>Chantily</th>
			      <th>Preço</th>
				  <th>Quantidade</th>
                  <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="s" items="${milkshakes}">
				    <tr>
				      <td>${s.id}</td>
				      <td>${s.especial}</td>
				      <td>${s.sabor}</td>
				      <td>${s.tamanho}</td>
				      <td>${s.chantily}</td>
                      <td>${s.preco}</td>
					  <td>${s.quantidade}</td>
				      <td><a href="/milkshake/${s.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>