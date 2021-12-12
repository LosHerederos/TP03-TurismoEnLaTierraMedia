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
	<h1>Usuarios</h1>
	<table>
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
</body>
</html>
