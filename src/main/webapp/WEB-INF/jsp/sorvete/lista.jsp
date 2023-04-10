<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Sorvete</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Sorvete</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/sorvete" method="get">
			<button type="submit">Novo</button>
		</form>
		
		<c:if test="${empty sorvetes}">
			<h5>Não existem sorvetes cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty sorvetes}">
			<h5>Quantidade de sorvetes cadastradas: ${sorvetes.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Tipo</th>
			      <th>Sabor</th>
			      <th>Tamanho</th>
			      <th>Tooping</th>
			      <th>Preço</th>
				  <th>Quantidade</th>
                  <th></th>
			    </tr>
			  </thead>
			  <tbody>
 
			  	<c:forEach var="s" items="${sorvetes}">
				    <tr>
				      <td>${s.id}</td>
				      <td>${s.tipo}</td>
				      <td>${s.sabor}</td>
				      <td>${s.tamanho}</td>
				      <td>${s.tooping}</td>
                      <td>${s.preco}</td>
					  <td>${s.quantidade}</td>
				      <td><a href="/sorvete/${s.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>