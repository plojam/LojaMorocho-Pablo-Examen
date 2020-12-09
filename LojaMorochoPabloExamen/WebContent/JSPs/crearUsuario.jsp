<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Crear usuario</title>
	<link rel="stylesheet" type="text/css" href="/LojaMorochoPabloExamen/CSS/usuario.css">
	<script src="/LojaMorochoPabloExamen/JavaScript/funciones.js"></script>
</head>
<body>
	
	
	<header>
        <aside><img id="logo" src="/LojaMorochoPabloExamen/img/logo_ups.png" alt="Logo" width="700" height="100"/></aside>
        <h1>Registrar Usuario</h1>
 
    </header> 
	
	<div class="espacio"></div>
	
	
	<form class="form" action="/LojaMorochoPabloExamen/CrearUsuario" method="post">
		<label>Nombres</label>
		<input type="text" name="nombres">
		<div class="control"></div>
		<label>Apellidos</label>
		<input type="text" name="apellidos">
		<div class="control"></div>
		<label>Cedula</label>
		<input type="text" name="cedula">
		<div class="control"></div>
		<label>Correo</label>
		<input type="text" name="correo">
		<div class="control"></div>
		<label>Contraseña</label>
		<input type="password" name="contrasena">
		<div class="control"></div>
		<label>Cantidad de telefonos</label>
		<input type="text" name="numero" id="numero">
		
		<div class="control"></div>
		
		<input type="button" value="Generar espacios" onclick="generarTelefonos()">
		
		<div id="informacion"></div>
		
		<input type="button" value="Regresar" onclick="location.href='/LojaMorochoPabloExamen/HTMLs/index.html'">
		
	</form>

</body>
</html>