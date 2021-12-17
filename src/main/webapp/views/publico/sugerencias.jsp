<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<h1 class="text-success mb-0 p-4 fs-6 d-flex justify-content-center">
		Sugerencias
	</h1>
	<!-- Cartas de atracciones -->
	<div class="card-group">
		<c:forEach items="${sugerencias}" var="sugerencia">
			<div class="card">
				<c:set var="carpetaImagen" value="${sugerencia.getClass().simpleName.equals('Atraccion') ? 'atracciones' : 'promociones' }"></c:set>
				<img src="<c:url value="/assets/img/uploads/${carpetaImagen}/${sugerencia.imagen}"></c:url>" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><c:out value="${sugerencia.nombre}"></c:out></h5>
					<p class="card-text"><c:out value="${sugerencia.descripcion}"></c:out></p>
					<p>Costo: ${sugerencia.costo} / Tiempo: ${sugerencia.tiempo}</p>
					<c:choose>
						<c:when
							test="${!usuario.estaEnElItinerario(sugerencia) && (usuario.poseeRecursosSuficientes(sugerencia.getCosto(), sugerencia.getTiempo()) && !sugerencia.tieneCupoCompleto())}">
							<c:set var="rutaComprar" value="${sugerencia.getClass().simpleName.equals('Atraccion') ? 'Atraccion' : 'Promocion' }"></c:set>
							<c:set var="idSugerencia" value="${sugerencia.getClass().simpleName.equals('Atraccion') ? sugerencia.idAtraccion : sugerencia.idPromocion }"></c:set>
							<a href="comprar${rutaComprar}.do?id${rutaComprar}=${idSugerencia}"
								class="btn btn-success rounded" role="button">Comprar</a>
						</c:when>
						<c:otherwise>
							<a href="#" class="btn btn-secondary rounded disabled"
								role="button">No se puede comprar</a>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>