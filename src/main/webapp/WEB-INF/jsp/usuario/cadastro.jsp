<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
	<meta charset="UTF-8">
	<title>Cadastro de Usuario</title>
</head>
<body>

	<c:import url="/WEB-INF/jsp/menu.jsp" />

	<div class="container">

		<form action="/cep" class="form-inline" method="post">

			<label>Cep:</label> 	
			<input type="text" name="cep" value="20010020" class="form-control">

			<button type="submit" class="btn btn-primary">Buscar</button>
		</form>

		<form action="/usuario/incluir" method="post">
			<h3>Cadastro de Usuario</h3>
		
			<div class="form-group">
				<label>Nome:</label> 	
				<input type="text" name="nome" value="Juan Rostirola" class="form-control">
			</div>
			
			<div class="form-group">
				<label>Senha:</label>
				<input type="password" name="senha" value="123" class="form-control">
			</div>
			
			<div class="form-group">
				<label>E-mail:</label>
				<input type="email" name="email" value="juanrostirola@gmail.com" class="form-control">
			</div>
						
			<div class="form-group">
				<label>Idade:</label> 	
				<input type="text" name="idade" value="22" class="form-control">
			</div>

			<div class="form-group">
				<label>Salario:</label> 	
				<input type="text" name="salario" value="1640" class="form-control">
			</div>

			<div class="form-group">
				<label>Caracteristica:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="caracteristica" value="Maquinario" class="form-check-input" > Maquinario
			      </label>
			    </div>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="checkbox" name="caracteristica" value="Limpeza" checked class="form-check-input"> Limpeza
			      </label>
			    </div>
			    <div class="form-check">
			      <label class="form-check-label">
		        		<input type="checkbox" name="caracteristica" value="Estoque" class="form-check-input"> Estoque
			      </label>
			    </div>
			</div>

			<div class="form-group">						
				<label>Tipo:</label>			
				<div class="form-check">
				  <label class="form-check-label">
				    <input type="radio" name="tipo" value="Gestor" class="form-check-input" > Gestor
				  </label>
				</div>			
				<div class="form-check">
				  <label class="form-check-label">
					<input type="radio" name="tipo" value="Analista" class="form-check-input"> Analista
				  </label>
				</div>			
				<div class="form-check">
				  <label class="form-check-label">
				    <input type="radio" name="tipo" value="Funcionario" checked class="form-check-input"> Funcionario
				  </label>
				</div>			
			</div>
			
			<div class="form-group">
				<label>Setor:</label>
				<select name="setor" class="form-control">
					<option value="1">Gestão</option>
					<option value="2">Analise</option>
					<option value="3" selected>Produção</option>
				</select>
			</div>
			
			<c:import url="/WEB-INF/jsp/endereco/cadastro.jsp"/>
			
			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>