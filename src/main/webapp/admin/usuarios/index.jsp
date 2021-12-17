<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
	<jsp:include page="/partials/datatables.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<main class="container">
		<div class="row">
			<div class="col-12">
				<div class="bg-light p-4 mb-3 rounded">
					<h1>Estos son los usuarios de la Tierra Media</h1>
				</div>
				<table id="listadoDeUsuarios" class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Tipo favorito</th>
							<th>Presupuesto</th>
							<th>Tiempo disponible</th>
							<th>Administrador</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${usuarios}" var="usuario">
							<tr>
								<td><c:out value="${usuario.nombre}"></c:out></td>
								<td><c:out value="${usuario.tipoFavorito}"></c:out></td>
								<td><c:out value="${usuario.presupuesto}"></c:out></td>
								<td><c:out value="${usuario.tiempoDisponible}"></c:out></td>
								<td><c:choose><c:when test="${usuario.esAdmin()}">Si</c:when><c:otherwise>No</c:otherwise></c:choose></td>
								<td>
									<a href="<c:url value="/admin/usuarios/ver.do?id=${usuario.idUsuario}"></c:url>"
										class="btn btn-primary rounded-0"
										role="button"
										title="Ver">
										<i class="bi bi-eye-fill"></i>
									</a>
									<a href="<c:url value="/admin/usuarios/editar.do?id=${usuario.idUsuario}"></c:url>"
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
			$('#listadoDeUsuarios').DataTable({
				language: {
					url: 'https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'
				}
			});
		})
	</script>
</body>
</html>
