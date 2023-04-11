<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<meta charset="UTF-8">
	<title>Cadastro de Alimentos</title>
</head>
<body>
    <c:import url="/WEB-INF/jsp/menu.jsp"/>

	<div class="container">
	
		<form action="/alimento/incluir" method="post">
			<h3>Cadastro de Alimentos</h3>

            <div class="form-group">
                <label>Preco:</label> 	
                <input type="text" name="preco" value="5" class="form-control">
            </div>

            <div class="form-group">
                <label>Sabor:</label> 	
                <input type="text" name="sabor" value="limao" class="form-control">
            </div>

            <div class="form-group">
                <label>Quantidade:</label> 	
                <input type="text" name="quantidade" value="10" class="form-control">
            </div>
    
    <button type="submit">Cadastrar</button>
		</form>
	</div>

</body>
</html>