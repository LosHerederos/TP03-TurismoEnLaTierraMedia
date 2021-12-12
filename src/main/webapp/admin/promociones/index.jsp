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
		<div class="bg-light p-4 mb-3 rounded">
			<h1>Estas son las promociones de la Tierra Media</h1>
		</div>
		<div class="mb-3">
			<a href="<c:url value="/admin/promociones/crear.do"></c:url>"
				class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i>
				Nueva Promoción
			</a>
		</div>
		<table id="listadoDePromociones" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Tipo de promoción</th>
					<th>Tipo de atracción</th>
					<th>Costo</th>
					<th>Tiempo</th>
					<th>Cupo disponible</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${promociones}" var="promocion">
					<tr>
						<td><c:out value="${promocion.idPromocion}"></c:out></td>
						<td><c:out value="${promocion.nombre}"></c:out></td>
						<td><c:out value="${promocion.getClass().getSimpleName()}"></c:out></td>
						<td><c:out value="${promocion.tipoDeAtraccion}"></c:out></td>
						<td><c:out value="${promocion.getCosto()}"></c:out></td>
						<td><c:out value="${promocion.getTiempo()}"></c:out></td>
						<td><c:choose><c:when test="${promocion.tieneCupoCompleto()}">No</c:when><c:otherwise>Si</c:otherwise></c:choose></td>
						<td>
							<a href="<c:url value="/admin/promociones/ver.do?id=${promocion.idPromocion}"></c:url>">Ver</a>
							<a href="<c:url value="/admin/promociones/editar.do?id=${promocion.idPromocion}"></c:url>">Editar</a>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
	<script src="<c:url value="/assets/js/bootstrap.bundle.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/js/jquery-3.6.0.min.js"></c:url>"></script>
	<script src="<c:url value="/assets/js/datatables.min.js"></c:url>"></script>
	<script>
		$(document).ready(function(){
			$('#listadoDePromociones').DataTable({
				language: {
					url: 'https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'
				}
			});
		})
	</script>
</body>
</html>
