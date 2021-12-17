<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
	<jsp:include page="/partials/datatables.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	<main class="container">
		<div class="row">
			<div class="col-12">
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
							<th>Tipo de Promoción</th>
							<th>Tipo de Atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
							<th>Cupo Disponible</th>
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
								<td><c:out value="${promocion.costo}"></c:out></td>
								<td><c:out value="${promocion.tiempo}"></c:out></td>
								<td><c:choose><c:when test="${promocion.tieneCupoCompleto()}">No</c:when><c:otherwise>Si</c:otherwise></c:choose></td>
								<td>
									<a href="<c:url value="/admin/promociones/ver.do?id=${promocion.idPromocion}"></c:url>"
										class="btn btn-primary rounded-0"
										role="button"
										title="Ver">
										<i class="bi bi-eye-fill"></i>
									</a>
									<a href="<c:url value="/admin/promociones/editar.do?id=${promocion.idPromocion}"></c:url>"
										class="btn btn-success rounded-0"
										role="button"
										title="Editar">
										<i class="bi bi-pencil-fill"></i>
									</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</main>
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
