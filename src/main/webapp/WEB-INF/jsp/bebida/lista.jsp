<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Listagem de Bebidas</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<h3>Listagem de Bebidas</h3>
		
		<c:if test="${not empty mensagem}">		
			<div class="alert alert-success">
			  <strong>Atenção!</strong> ${mensagem}
			</div>		
		</c:if>

		<form action="/bebida/cadastro">
			<input type="submit" value="novo"/>
		</form>
		
		<c:if test="${empty bebidas}">
			<h5>Não existem bebidas cadastradas!!!</h5>
		</c:if>
	
		<c:if test="${not empty bebidas}">
			<h5>Quantidade de bebidas cadastradas: ${bebidas.size()}!!!</h5>
	
			<table class="table table-striped">
			  <thead>
			    <tr>
			      <th>ID</th>
			      <th>Marca</th>
			      <th>Sabor</th>
			      <th>Tamanho</th>
			      <th>Alcoolico</th>
			      <th>Preço</th>
				  <th>Quantidade</th>
                  <th></th>
			    </tr>
			  </thead>
			  <tbody>

			  	<c:forEach var="s" items="${bebidas}">
				    <tr>
				      <td>${s.id}</td>
				      <td>${s.marca}</td>
				      <td>${s.sabor}</td>
				      <td>${s.tamanho}</td>
				      <td>${s.alcoolico}</td>
                      <td>${s.preco}</td>
					  <td>${s.quantidade}</td>
				      <td><a href="/bebida/${s.id}/excluir">excluir</a></td>
				    </tr>
			    </c:forEach>
			  </tbody>
			</table>
		</c:if>	
	</div>
</body>
</html>