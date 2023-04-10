<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">AppSorvete</a>
        </div>

        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <c:if test= "${not empty usuario}">
                <li><a href="/alimento/lista">Alimento</a></li>
                <li><a href="/bebida/lista">Bebida</a></li>
                <li><a href="/milkshake/lista">Milkshake</a></li>
                <li><a href="/sorvete/lista">Sorvete</a></li>
                <li><a href="/cliente/lista">Cliente</a></li>
                <li><a href="/pedido/lista">Pedido</a></li>
                <li><a href="/usuario/lista">Usuario</a></li>
            </c:if>
        </ul>

        <ul class="nav navbar-nav navbar-right">
            <c:if test="${empty usuario}">
                <li><a href="/usuario"><span class="glyphicon glypchicon-user"></span>Sign Up</a></li>
                <li><a href="/login"><span class="glyphicon glypchicon-log-in"></span>Login</a></li>
            </c:if>

            <c:if test="${not empty usuario}">
                <li><a href="/logout"><span class="glyphicon glypchicon-log-out"></span>Logout, ${usuario.nome}</a></li>
            </c:if>
        </ul>

    </div>
</nav>