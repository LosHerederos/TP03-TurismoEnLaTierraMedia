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
		Atracciones
	</h1>
	<!-- Cartas de atracciones -->
	<div class="card-group">
		<c:forEach items="${atracciones}" var="atraccion">
			<div class="card">
				<img src="<c:url value="/assets/img/uploads/atracciones/${atraccion.imagen}"></c:url>" class="card-img-top" alt="...">
				<div class="card-body">
					<h5 class="card-title"><c:out value="${atraccion.nombre}"></c:out></h5>
					<p class="card-text"><c:out value="${atraccion.descripcion}"></c:out></p>
							<c:choose>
								<c:when
									test="${usuario.poseeRecursosSuficientes(atraccion.getCosto(), atraccion.getTiempoParaRealizarla()) && !atraccion.tieneCupoCompleto()}">
									<a href="comprar.do?id=${atraccion.idAtraccion}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>