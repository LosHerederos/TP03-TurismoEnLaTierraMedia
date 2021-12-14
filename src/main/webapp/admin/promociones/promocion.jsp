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
		<div class="row">
			<div class="col-9">
				<p>Id: <c:out value="${promocionAVer.idPromocion}"></c:out></p>
				<p>Nombre: <c:out value="${promocionAVer.nombre}"></c:out></p>
				<p>Tipo de promoción: <c:out value="${promocionAVer.getClass().getSimpleName()}"></c:out></p>
				<p>Tipo de atracción: <c:out value="${promocionAVer.tipoDeAtraccion}"></c:out></p>
				<p>Descripción: <c:out value="${promocionAVer.descripcion}"></c:out></p>
				<p>Costo: <c:out value="${promocionAVer.getCosto()}"></c:out></p>
				<p>Tiempo: <c:out value="${promocionAVer.getTiempo()}"></c:out></p>
			</div>
			<div class="col-3">
				<img style="width: 100%" src="<c:url value="/assets/img/uploads/promociones/${promocionAVer.imagen}"></c:url>">
			</div>
		</div>		
		<div class="row">
			<div class="col-12">
				<p>Atracciones:</p>
				<table class="table">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Tipo de atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
							<th>Cupo</th>
							<th>Cupo ocupado</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${promocionAVer.atracciones}" var="atraccion">
							<tr>
								<td><c:out value="${atraccion.nombre}"></c:out></td>
								<td><c:out value="${atraccion.tipoDeAtraccion}"></c:out></td>
								<td><c:out value="${atraccion.costo}"></c:out></td>
								<td><c:out value="${atraccion.tiempo}"></c:out></td>
								<td><c:out value="${atraccion.cupoPersonas}"></c:out></td>
								<td><c:out value="${atraccion.visitantes}"></c:out></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<c:if test="${promocionAVer.getClass().getSimpleName().equals('PromocionAXB')}">
					<p>Atracciones pagas:</p>
					<table class="table">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Tipo de atracción</th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo</th>
								<th>Cupo ocupado</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${promocionAVer.atraccionesPagas}" var="atraccionPaga">
								<tr>
									<td><c:out value="${atraccionPaga.nombre}"></c:out></td>
									<td><c:out value="${atraccionPaga.tipoDeAtraccion}"></c:out></td>
									<td><c:out value="${atraccionPaga.costo}"></c:out></td>
									<td><c:out value="${atraccionPaga.tiempo}"></c:out></td>
									<td><c:out value="${atraccionPaga.cupoPersonas}"></c:out></td>
									<td><c:out value="${atraccionPaga.visitantes}"></c:out></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>
		</div>
	</main>
</body>
</html>
