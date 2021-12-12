<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Administrador</title>
	

	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/datatables.min.css">
</head>
<body>
	Hola administrador
	<br>
	<a href="<c:url value="/admin/usuarios/index.do"></c:url>">Listar usuarios</a>
	<br>
	<a href="<c:url value="/admin/atracciones/index.do"></c:url>">abm atracciones</a>
</body>
</html>
