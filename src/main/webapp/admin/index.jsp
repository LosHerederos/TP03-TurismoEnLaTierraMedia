<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Administrador</title>
	

	<link rel="shortcut icon" href="<c:url value="/assets/img/favicon.ico"></c:url>">
	<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap.min.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/assets/css/datatables.min.css"></c:url>">
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	<main class="container">
		<h1>Hola administrador</h1>
		<ul>
			<li><a href="<c:url value="/admin/usuarios/index.do"></c:url>">Listar usuarios</a></li>
			<li><a href="<c:url value="/admin/atracciones/index.do"></c:url>">Listar atracciones</a></li>
			<li><a href="<c:url value="/admin/promociones/index.do"></c:url>">Listar promociones</a></li>
		</ul>
	</main>
	<jsp:include page="/partials/scripts.jsp"></jsp:include>
</body>
</html>
