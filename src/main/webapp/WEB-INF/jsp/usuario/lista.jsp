<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>AppSorvete</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">
			<h3>Listagem de Usuarios</h3>

			<c:if test="${not empty mensagem}">
				<div class="alert alert-success">
					<strong>Atenção</strong> ${mensagem}
				</div>
			</c:if>

			<c:if test="${empty usuarios}">
				<h5>Não existem usuários cadastrados!</h5>
			</c:if>

			<c:if test="${not empty usuarios}">
				<h5>Quantidade de usuários cadastrados: ${usuarios.size()}!</h5>
		
			<table class="table table-striped">
				<thead>
				  <tr>
					<th>ID</th>
					<th>Nome</th>
					<th>Senha</th>
					<th>E-mail</th>
					<th>Características</th>
					<th>Tipo</th>
					<th>Setor</th>
					<th>Idade</th>
					<th>Salário</th>
					<th>Func</th>
			      	<th>Endereço</th>
					<th>Cliente</th>
			      	<th>Alimentos</th>
					<th>Pedidos</th>	
					<c:if test="${usuario.func}">		      
						<th></th>		
					</c:if>	  
					<th></th>
				  </tr>
				</thead>
				<tbody>
		
				<c:forEach var="u" items="${usuarios}">
							<tr>
							<td>${u.id}</td>
							<td>${u.nome}</td>
							<td>${u.senha}</td>
							<td>${u.email}</td>
							<td>${u.caracteristicas}</td>
							<td>${u.tipo}</td>
							<td>${u.setor}</td>
							<td>${u.idade}</td>
							<td>${u.salario}</td>
							<td>${u.func}</td>
							<td>${u.endereco}</td>
							<td>${u.clientes.size()}</td>
				    		<td>${u.alimentos.size()}</td>
							<td>${u.pedidos.size()}</td>				      
							<c:if test="${usuario.admin}">
							<td><a href="/usuario/${u.id}/excluir">excluir</a></td>
							</c:if>
							</tr>
						</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>

</body>
</html>