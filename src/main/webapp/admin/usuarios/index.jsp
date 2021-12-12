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
			<h1>Estos son los usuarios de la Tierra Media</h1>
		</div>
		<table id="listadoDeUsuarios" class="table table-stripped table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Tipo favorito</th>
					<th>Presupuesto</th>
					<th>Tiempo disponible</th>
					<th>Es administrador</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${usuarios}" var="usuario">
					<tr>
						<th><c:out value="${usuario.nombre}"></c:out></th>
						<th><c:out value="${usuario.tipoFavorito}"></c:out></th>
						<th><c:out value="${usuario.presupuesto}"></c:out></th>
						<th><c:out value="${usuario.tiempoDisponible}"></c:out></th>
						<th><c:choose><c:when test="${usuario.esAdmin()}">Si</c:when><c:otherwise>No</c:otherwise></c:choose></th>
						<th>
							<a href="<c:url value="/admin/usuarios/ver.do?id=${usuario.idUsuario}"></c:url>">Ver</a>
							<a href="<c:url value="/admin/usuarios/editar.do?id=${usuario.idUsuario}"></c:url>">Editar</a>
						</th>
					</tr>
				</c:forEach>
			</tbody>
		</table>
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
