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
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<main class="container">
		<h1>Usuario</h1>
		<p>Id: <c:out value="${usuarioAVer.idUsuario}"></c:out></p>
		<p>Es administrador: <c:choose><c:when test="${usuario.esAdmin()}">Si</c:when><c:otherwise>No</c:otherwise></c:choose></p>
		<p>Nombre: <c:out value="${usuarioAVer.nombre}"></c:out></p>
		<p>Tipo favorito: <c:out value="${usuarioAVer.tipoFavorito}"></c:out></p>
		<p>Presupuesto: <c:out value="${usuarioAVer.presupuesto}"></c:out></p>
		<p>Tiempo disponible: <c:out value="${usuarioAVer.tiempoDisponible}"></c:out></p>
		<p>Itinerario: <c:out value="${usuarioAVer.itinerario}"></c:out></p>
	</main>
</body>
</html>
