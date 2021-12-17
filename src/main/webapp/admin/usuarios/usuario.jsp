<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<main class="container">
		<div class="row mb-4">
			<div class="col-9">
				<h2>Usuario: ${usuarioAVer.nombre}</h2>
			</div>
			<div class="col-3 d-flex flex-row justify-content-end">
				<a href="javascript:window.history.back()"
					class="btn btn-primary rounded-0"
					role="button"
					title="Volver">
					<i class="bi bi-arrow-left-circle-fill"></i>
					Volver
				</a>
				<a href="<c:url value="/admin/usuarios/editar.do?id=${usuarioAVer.idUsuario}"></c:url>"
					class="btn btn-success rounded-0"
					role="button"
					title="Editar">
					<i class="bi bi-pencil-fill"></i>
					Editar
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-12 fs-4">
				<p>Es administrador: <c:choose><c:when test="${usuarioAVer.esAdmin()}">Si</c:when><c:otherwise>No</c:otherwise></c:choose></p>
				<p>Tipo favorito: <c:out value="${usuarioAVer.tipoFavorito}"></c:out></p>
				<p>Presupuesto: <c:out value="${usuarioAVer.presupuesto}"></c:out></p>
				<p>Tiempo disponible: <c:out value="${usuarioAVer.tiempoDisponible}"></c:out></p>
				<p>Itinerario:</p>
			</div>
		</div>
		<div class="row">
			<div class="col-12">
				<table class="table caption-top">
					<caption>Promociones</caption>
					<thead>
						<tr>
							<th>Nombre del pack</th>
							<th>Tipo de Promoción</th>
							<th>Tipo de Atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
							<th>Atracciones incluidas</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${!empty usuarioAVer.itinerario.promociones}">
								<c:forEach items="${usuarioAVer.itinerario.promociones}" var="promocion">
									<tr>
										<td><c:out value="${promocion.nombre}"></c:out></td>
										<td><c:out value="${promocion.getClass().getSimpleName()}"></c:out></td>
										<td><c:out value="${promocion.tipoDeAtraccion }"></c:out></td>
										<td><c:out value="${promocion.costo }"></c:out></td>
										<td><c:out value="${promocion.tiempo }"></c:out></td>
										<td>
											<ul>
												<c:forEach items="${promocion.atracciones}" var="atraccion">
													<li><c:out value="${atraccion.nombre}"></c:out></li>
												</c:forEach>
											</ul>
											<c:if test="${promocion.getClass().simpleName.equals('PromocionAXB')}">
												Pagas
												<ul>
													<c:forEach items="${promocion.atraccionesPagas}" var="atraccionPaga">
														<li><c:out value="${atraccionPaga.nombre}"></c:out></li>
													</c:forEach>
												</ul>
											</c:if>
										</td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="6">No tiene promociones compradas.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
				<table class="table caption-top">
					<caption>Atracciones</caption>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Tipo de Atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
						</tr>
					</thead>
					<tbody>
						<c:choose>
							<c:when test="${!empty usuarioAVer.itinerario.atracciones}">
								<c:forEach items="${usuarioAVer.itinerario.atracciones}" var="atraccion">
									<tr>
										<td><c:out value="${atraccion.nombre}"></c:out></td>
										<td><c:out value="${atraccion.tipoDeAtraccion}"></c:out></td>
										<td><c:out value="${atraccion.costo}"></c:out></td>
										<td><c:out value="${atraccion.tiempo}"></c:out></td>
									</tr>
								</c:forEach>
							</c:when>
							<c:otherwise>
								<tr>
									<td colspan="4">No tiene atracciones compradas.</td>
								</tr>
							</c:otherwise>
						</c:choose>
					</tbody>
				</table>
			</div>
		</div>
		
	</main>
</body>
</html>
