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
		Promociones
	</h1>
	<!-- Cartas de atracciones -->
	<div class="card-group">
		<c:forEach items="${promociones}" var="promocion">
			<div class="card">
				<img src="<c:url value="/assets/img/uploads/promociones/${promocion.imagen}"></c:url>" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><c:out value="${promocion.nombre}"></c:out></h5>
					<p class="card-text"><c:out value="${promocion.descripcion}"></c:out></p>
					<c:choose>
								<c:when
									test="${usuario.poseeRecursosSuficientes(promocion.getCosto(), promocion.getTiempo()) && !promocion.tieneCupoCompleto() && !itinerario.getPromociones().contains(promocion)}">
									<a href="comprar.do?id=${promocion.idPromocion}"
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