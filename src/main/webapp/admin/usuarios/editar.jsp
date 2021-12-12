<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Administrador</title>
	

	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/datatables.min.css">
</head>
<body>
	Usuario
	<form method="post">
		<div class="form-row">
			<label for="">Nombre</label>
			<input type="text" name="nombre" value="<c:out value="${usuarioAEditar.nombre}"></c:out>">
		</div>
		<div class="form-row">
			<label for="">Presupuesto</label>
			<input type="number" name="presupuesto" value="<c:out value="${usuarioAEditar.presupuesto}"></c:out>">
		</div>
		<div class="form-row">
			<label for="">Tiempo disponible</label>
			<input type="number" name="tiempoDisponible" value="<c:out value="${usuarioAEditar.tiempoDisponible}"></c:out>">
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
</body>
</html>
