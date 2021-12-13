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
	<link rel="stylesheet" href="<c:url value="/assets/css/bootstrap-icons.css"></c:url>">
	<link rel="stylesheet" href="<c:url value="/assets/css/datatables.min.css"></c:url>">
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<main class="container">
		<div class="row">
			<div class="col-12">
				<h2>Editar usuario</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-10 offset-1">
				<form method="post">
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" name="nombre" id="nombre" class="form-control" readonly value="<c:out value="${usuarioAEditar.nombre}"></c:out>">
					</div>
					<div class="mb-3">
						<label for="presupuesto" class="form-label">Presupuesto</label>
						<input type="number" name="presupuesto" id="presupuesto" class="form-control" required min="0" value="<c:out value="${usuarioAEditar.presupuesto}"></c:out>">
					</div>
					<div class="mb-3">
						<label for="tiempoDisponible" class="form-label">Tiempo disponible</label>
						<input type="number" name="tiempoDisponible" id="tiempoDisponible" class="form-control" required min="0" value="<c:out value="${usuarioAEditar.tiempoDisponible}"></c:out>">
					</div>
					<div class="mb-3">
						<label for="tipoFavorito">Tipo favorito</label>
						<select name="tipoFavorito" id="tipoFavorito" class="form-select">
							<c:forEach items="${tipoDeAtracciones}" var="tipoDeAtraccion">
								<option value="${tipoDeAtraccion.ordinal()}" <c:if test="${tipoDeAtraccion == usuarioAEditar.tipoFavorito}">selected</c:if>><c:out value="${tipoDeAtraccion}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<div class="form-check">
							<input type="checkbox" name="esAdmin" id="esAdmin" <c:if test="${usuarioAEditar.esAdmin()}">checked</c:if>>
							<label for="esAdmin" class="form-check-label">Es admin</label>
						</div>
					</div>
					
					<div class="mb-3 text-center">
						<input type="hidden" name="id" value="<c:out value="${usuarioAEditar.idUsuario}"></c:out>">
						<input type="submit" class="btn btn-primary" value="Modificar">
						<input type="button" class="btn btn-danger" value="Cancelar" onclick="window.history.back()">
					</div>
				</form>
			</div>
		</div>
	</main>
	<jsp:include page="/partials/scripts.jsp"></jsp:include>
</body>
</html>
