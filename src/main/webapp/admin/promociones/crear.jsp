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
		Promoción
		<form action="">
			<div class="form-row">
				<label for="">Nombre:</label>
				<input type="text" value="${promocionAEditar.nombre}">
			</div>
			<div class="form-row">
				<label for="">Descripción:</label>
				<textarea name="" id=""><c:out value="${promocionAEditar.descripcion}"></c:out></textarea>
			</div>
			<div class="form-row">
				<label for="">Imagen:</label>
				<input type="text"></div>
			<div class="form-row">
				<label for="">Tipo de atracción</label>
				<select name="tipoDeAtraccion">
					<c:forEach items="${tipoDeAtracciones}" var="tipoDeAtraccion">
						<option value="${tipoDeAtraccion.ordinal()}" <c:if test="${tipoDeAtraccion == usuarioAEditar.tipoFavorito}">selected</c:if>><c:out value="${tipoDeAtraccion}"></c:out></option>
					</c:forEach>
				</select>
			</div>
			<div class="form-row">
				<label for="">Atracciones</label>
				<select name="" id="">
				</select>
			</div>
			<div class="form-row">
				<label for="">Tipo de promoción</label>
				<select name="" id=""></select>
			</div>
			<div class="form-row">
				<label for=""></label>
				<input type="text">
			</div>
			<div class="form-row">
				<label for=""></label>
				<input type="text">
			</div>
			<div class="form-row">
				<label for=""></label>
				<input type="text">
			</div>
			<div class="form-row">
				<input type="hidden" name="id" value="<c:out value="${promocionAEditar.idPromocion}"></c:out>">
				<input type="submit" value="Crear">
			</div>
		</form>
	</main>
	<jsp:include page="/partials/scripts.jsp"></jsp:include>
</body>
</html>
