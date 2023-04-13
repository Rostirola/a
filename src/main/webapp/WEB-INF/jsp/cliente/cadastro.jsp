<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Cadastro de Clientes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/cliente/incluir" method="post">
			<h3>Cadastro de Clientes</h3>
		
			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Juan Rostirola" class="form-control">
			</div>

			<div class="form-group">
				<label>CPF:</label> 	
				<input type="text" name="cpf" value="098765432-21" class="form-control">
			</div>

			<div class="form-group">
                <label>Idade:</label>
                <input type="text" name="idade" value="21" class="form-control">
            </div>

			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="juanrostirola@gmail.com" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>