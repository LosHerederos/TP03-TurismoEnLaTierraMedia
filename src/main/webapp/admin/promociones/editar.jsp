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
				<h2>Editar promoción</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-10 offset-1">
				<form action="">
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" name="nombre" id="nombre" class="form-control" value="${promocionAEditar.nombre}">
					</div>
					<div class="mb-3">
						<label for="descripcion" class="form-label">Descripción</label>
						<textarea name="descripcion" id="descripcion" class="form-control"><c:out value="${promocionAEditar.descripcion}"></c:out></textarea>
					</div>
					<div class="mb-3">
						<label for="imagen" class="form-label">Imagen</label>
						<input type="text" name="imagen" id="imagen" class="form-control">
					</div>
					<div class="mb-3">
						<label for="tipoDeAtraccion" class="form-label">Tipo de atracción</label>
						<select name="tipoDeAtraccion" id="tipoDeAtraccion" class="form-select">
							<c:forEach items="${tipoDeAtracciones}" var="tipoDeAtraccion">
								<option value="${tipoDeAtraccion.ordinal()}" <c:if test="${tipoDeAtraccion == promocionAEditar.tipoDeAtraccion}">selected</c:if>><c:out value="${tipoDeAtraccion}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="" class="form-label" style="height:4rem">Atracciones</label>
						<select name="" id="" multiple class="form-select">
							<c:forEach items="${atracciones}" var="atraccion">
								<option value="${atraccion.idAtraccion}" <c:if test="${promocionAEditar.atracciones.contains(atraccion)}">selected</c:if>><c:out value="${atraccion.nombre}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="" class="form-label">Tipo de promoción</label>
						<select name="tipoDePromocion" id="" class="form-select">
							<option value="">Absoluta</option>
							<option value="">AxB</option>
							<option value="">Porcentual</option>
						</select>
					</div>
					
					<div id="promocionAbsoluta" hiddens class="mb-3">
						<label for="">Costo total</label>
						<input type="number">
					</div>
					<div id="promocionAxB" hiddens class="mb-3">
						<label for=""></label>
						<input type="text">
					</div>
					<div id="promocionPorcentual" hiddens class="mb-3">
						<label for="">Porcentaje</label>
						<input type="number" class="form-control">
					</div>
					<div class="form-row">
						<input type="hidden" name="id" value="<c:out value="${promocionAEditar.idPromocion}"></c:out>">
						<input type="submit" value="Modificar">
					</div>
				</form>
			</div>
		</div>
	</main>
	<jsp:include page="/partials/scripts.jsp"></jsp:include>
</body>
</html>
