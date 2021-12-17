<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	<main class="container">
		<div class="row mb-4">
			<div class="col-9">
				<h2>Promoción: ${promocionAVer.nombre}</h2>
			</div>
			<div class="col-3 d-flex flex-row justify-content-end">
				<a href="javascript:window.history.back()"
					class="btn btn-primary rounded-0"
					role="button"
					title="Volver">
					<i class="bi bi-arrow-left-circle-fill"></i>
					Volver
				</a>
				<a href="<c:url value="/admin/promociones/editar.do?id=${promocionAVer.idPromocion}"></c:url>"
					class="btn btn-success rounded-0"
					role="button"
					title="Editar">
					<i class="bi bi-pencil-fill"></i>
					Editar
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-9 fs-4">
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
				
				<table class="table caption-top">
					<caption>Atracciones</caption>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Tipo de Atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
							<th>Cupo Total</th>
							<th>Cupo Ocupado</th>
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
				<c:if test="${promocionAVer.getClass().simpleName.equals('PromocionAXB')}">
					<table class="table caption-top">
						<caption>Atracciones Pagas:</caption>
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Tipo de Atracción</th>
								<th>Costo</th>
								<th>Tiempo</th>
								<th>Cupo Total</th>
								<th>Cupo Ocupado</th>
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
