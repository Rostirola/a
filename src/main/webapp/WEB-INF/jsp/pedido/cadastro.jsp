<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Cadastro de Pedidos</title>
</head>
<body>

	<c:set var="botao" value=""/>

	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/pedido/incluir" method="post">
			<h3>Cadastro de Pedidos</h3>

			<div class="form-group">
				<label>Comentario:</label> 	
				<input type="text" name="comentario" value="Primeiro Pedido Cadastrado" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Dinheiro:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="dinheiro" value="true" class="form-check-input" > A vista
			      </label>
			    </div>
			</div>
			
<!-- 			<div class="form-group"> -->
<!-- 				<label>Data:</label> 	 -->
<!-- 				<input type="text" name="data" value="16/03/2023" class="form-control"> -->
<!-- 			</div> -->

			<div class="form-group">
				<c:if test="${not empty clientes}">
					<label>Cliente:</label>
					<select name="cliente" class="form-control">
						<c:forEach var="s" items="${clientes}">
							<option value="${s.id}">${s.nome}</option>
						</c:forEach>
					</select>
				</c:if>
				<c:if test="${empty clientes}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem clientes cadastrados!</label>
				</c:if>
			</div>
			
			<div class="form-group">
				<c:if test="${not empty alimentos}">
					<label>Alimentos:</label>
				    <c:forEach var="p" items="${alimentos}">
				    <div class="form-check">
				      <label class="form-check-label">
			        		<input type="checkbox" name="alimentos" value="${p.id}" class="form-check-input"> ${p.sabor}
				      </label>
				    </div>
				    </c:forEach>
				</c:if>
				<c:if test="${empty alimentos}">
					<c:set var="botao" value="disabled"/>
					<label>Não existem alimentos cadastrados!</label>
				</c:if>
			</div>
			
			<button ${botao} type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>
