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
		<h1>Promoción</h1>
		<img width="300" src="<c:url value="/assets/img/uploads/promociones/${promocionAVer.imagen}"></c:url>">
		<p>Id: <c:out value="${promocionAVer.idPromocion}"></c:out></p>
		<p>Nombre: <c:out value="${promocionAVer.nombre}"></c:out></p>
		<p>Tipo de promoción: <c:out value="${promocionAVer.getClass().getSimpleName()}"></c:out></p>
		<p>Tipo de atracción: <c:out value="${promocionAVer.tipoDeAtraccion}"></c:out></p>
		<p>Descripción: <c:out value="${promocionAVer.descripcion}"></c:out></p>
		<p>Costo: <c:out value="${promocionAVer.getCosto()}"></c:out></p>
		<p>Tiempo: <c:out value="${promocionAVer.getTiempo()}"></c:out></p>
		<div>
			<p>Atracciones:</p>
			<ul>
				<c:forEach items="${promocionAVer.atracciones}" var="atraccion">
					<li><c:out value="${atraccion}"></c:out></li>
				</c:forEach>
			</ul>
			<c:if test="${promocionAVer.getClass().getSimpleName().equals('PromocionAXB')}">
				<p>Atracciones pagas:</p>
				<ul>
					<c:forEach items="${promocionAVer.atraccionesPagas}" var="atraccionPaga">
						<li><c:out value="${atraccionPaga}"></c:out></li>
					</c:forEach>
				</ul>
			</c:if>
		</div>
	</main>
</body>
</html>
