<?xml version="1.0" encoding="ISO-8859-1" ?>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@page import="ec.edu.ups.modelo.Usuario"%>
<%@page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Listar usuarios</title>
	<link rel="stylesheet" type="text/css" href="/LojaMorochoPabloExamen/CSS/agenda.css">
	<script src="/LojaMorochoPabloExamen/JavaScript/funciones.js"></script>
</head>
<body>
	
	<% 
		//List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
	%>
	
	<header>
        <aside><img id="logo" src="/LojaMorochoPabloExamen/img/logo_ups.png" alt="Logo" width="700" height="100"/></aside>
        <h1>Agenda</h1>
 
    </header> 
    
    <input type="button" value="Regresar" onclick="location.href='/LojaMorochoPabloExamen/HTMLs/index.html'">
    
    <form class="form">
    	<label>Cedula</label>
    	<input type="text" id="cedula">
		<input type="button" value="Buscar por cedula" onclick="buscarPorCedula()">
		
	</form>
	<br>
	<form class="form">
    	<label>Numero telefonico</label>
    	<input type="text" id="numero">
		<input type="button" value="Buscar por numero" onclick="buscarPorNumero()">
	</form>
	
	<br>
	
	<div id="informacion"></div>
	
	<br>
	<hr  width="98%">
	<br>
	
	<div>
		<c:set var="usus" scope="request" value="${usuarios}" />
		<c:forEach var="usu" items="${usus}">
			<table class='table'>
			<tr><td class='titulo'><strong>Nombres</strong></td>
			<td class='titulo'><strong>Apellidos</strong></td>
			<td class='titulo'><strong>Cedula</strong></td>
			<td class='titulo'><strong>Correo</strong></td></tr>
			<tr><td>${usu.nombres}</td>
			<td>${usu.apellidos}</td>
		    <td>${usu.cedula}</td>
		    <td>${usu.correo}</td></tr></table>
		    
		    <table class='table'>
		    <tr><td class='titulo'><strong>Numero</strong></td>
		    <td class='titulo'><strong>Tipo</strong></td>
		    <td class='titulo'><strong>Operadora</strong></td></tr>
		    
		    <c:forEach var="tel" items="${usu.telefonos}">
		    	<tr><td>${tel.numero}</td>
			    <td>${tel.tipo.tipo}</td>
			    <td>${tel.operadora.nombre}</td></tr>
		    </c:forEach>
		    </table>
		    <br>
		</c:forEach>
		
	</div>
	
		
	
</body>
</html>