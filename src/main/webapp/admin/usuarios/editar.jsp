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
		Usuario
		<form method="post">
			<div class="form-row">
				<label for="">Nombre</label>
				<input type="text" name="nombre" required value="<c:out value="${usuarioAEditar.nombre}"></c:out>">
			</div>
			<div class="form-row">
				<label for="">Presupuesto</label>
				<input type="number" name="presupuesto" required min="0" value="<c:out value="${usuarioAEditar.presupuesto}"></c:out>">
			</div>
			<div class="form-row">
				<label for="">Tiempo disponible</label>
				<input type="number" name="tiempoDisponible" required min="0" value="<c:out value="${usuarioAEditar.tiempoDisponible}"></c:out>">
			</div>
			<div class="form-row">
				<label for="">Tipo favorito</label>
				<select name="tipoFavorito">
					<c:forEach items="${tipoDeAtracciones}" var="tipoDeAtraccion">
						<option value="${tipoDeAtraccion.ordinal()}" <c:if test="${tipoDeAtraccion == usuarioAEditar.tipoFavorito}">selected</c:if>><c:out value="${tipoDeAtraccion}"></c:out></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-row">
				<label for="">
					Es admin
					<input type="checkbox" name="esAdmin" <c:if test="${usuarioAEditar.esAdmin()}">checked</c:if>>
				</label>
			</div>
			
			<div class="form-row">
				<input type="hidden" name="id" value="<c:out value="${usuarioAEditar.idUsuario}"></c:out>">
				<input type="submit" value="Modificar">
			</div>
		</form>
	</main>
	<jsp:include page="/partials/scripts.jsp"></jsp:include>
</body>
</html>
