<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Administrador</title>

<jsp:include page="/partials/head.jsp"></jsp:include>
<link rel="shortcut icon" href="assets/img/favicon.ico">
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/datatables.min.css">
</head>
<body>

	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">

		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${esValido != null}">
						<ul>
							<c:forEach items="${esValido}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>

		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las atracciones de la Tierra Media</h1>
		</div>


		<div class="mb-3">
			<a href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/crear.do"
				class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i>
				Nueva Atracción
			</a>
		</div>

		<table class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Atracci&oacute;n</th>
					<th>Descripci&oacute;n</th>
					<th>imagen</th>
					<th>Costo</th>
					<th>Duraci&oacute;n</th>
					<th>Cupo</th>
					<th>Visitantes</th>
					<th>Tipo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${atracciones}" var="atraccion">
					<tr>
						<td><strong><c:out value="${atraccion.nombre}"></c:out></strong></td>
						<td><c:out value="${atraccion.descripcion}"></c:out></td>
						<td><c:out value="${atraccion.imagen}"></c:out></td>
						<td><c:out value="${atraccion.costoVisita}"></c:out></td>
						<td><c:out value="${atraccion.tiempoParaRealizarla}"></c:out></td>
						<td><c:out value="${atraccion.cupoPersonas}"></c:out></td>
						<td><c:out value="${atraccion.visitantes}"></c:out></td>
						<td><c:out value="${atraccion.tipoDeAtraccion}"></c:out></td>
						<td><c:out value="${attraction.duration}"></c:out></td>
						<td><c:out value="${attraction.capacity}"></c:out></td>

						<td><a
							href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/editar.do?id=${atraccion.idAtraccion}"
							class="btn btn-light rounded-0" role="button"><i
								class="bi bi-pencil-fill"></i></a> <a
							href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/borrar.do?id=${atraccion.idAtraccion}"
							class="btn btn-danger rounded" role="button"><i
								class="bi bi-x-circle-fill"></i></a> <c:choose>
								<c:when
									test="${user.canAfford(attraction) && user.canAttend(attraction) && attraction.canHost(1)}">
									<a href="/turismo/attractions/buy.do?id=${attraction.id}"
										class="btn btn-success rounded" role="button">Comprar</a>
								</c:when>
								<c:otherwise>
									<a href="#" class="btn btn-secondary rounded disabled"
										role="button">No se puede comprar</a>
								</c:otherwise>
							</c:choose></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</main>

</body>
</html>
