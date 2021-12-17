<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<h1 class="text-success mb-0 p-4 fs-6 d-flex justify-content-center">
		Tu Itinerario
	</h1>
	<main class="container">
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
							<c:when test="${!empty usuario.itinerario.promociones}">
								<c:forEach items="${usuario.itinerario.promociones}" var="promocion">
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
							<c:when test="${!empty usuario.itinerario.atracciones}">
								<c:forEach items="${usuario.itinerario.atracciones}" var="atraccion">
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