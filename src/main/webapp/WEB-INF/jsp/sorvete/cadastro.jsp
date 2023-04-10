<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Cadastro de Sorvetes</title>
</head>
<body>
	<c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/sorvete/incluir" method="post">
			<h3>Cadastro de Sorvetes</h3>
		
			<c:import url="/WEB-INF/jsp/produto/cadastro.jsp"/>
			
			<div class="form-group">
				<label>Características:</label>
			    <div class="form-check">
			      <label class="form-check-label">
			        <input type="radio" name="casquinha" value="casquinha" class="form-check-input" > Casquinha
			      </label>
			    </div>
				<div class="form-check">
					<label class="form-check-label">
					  <input type="radio" name="cascao" value="cascao" class="form-check-input" > Cascao
					</label>
				  </div>
				  <div class="form-check">
					<label class="form-check-label">
					  <input type="radio" name="copo" value="copo" class="form-check-input" > Copo
					</label>
				  </div>
			</div>
			
			<div class="form-group">
				<label>Tamanho:</label> 	
				<input type="text" name="tamanho" value="500" class="form-control">
			</div>

			<button type="submit">Cadastrar</button>
		</form>
	</div>
</body>
</html>