<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	<main class="container">
		<div class="row mb-4">
			<div class="col-9">
				<h2>Atracción: <c:out value="${atraccionAVer.nombre}"></c:out></h2>
			</div>
			<div class="col-3 d-flex flex-row justify-content-end">
				<a href="javascript:window.history.back()"
					class="btn btn-primary rounded-0"
					role="button"
					title="Volver">
					<i class="bi bi-arrow-left-circle-fill"></i>
					Volver
				</a>
				<a href="<c:url value="/admin/atracciones/editar.do?id=${atraccionAVer.idAtraccion}"></c:url>"
					class="btn btn-success rounded-0"
					role="button"
					title="Editar">
					<i class="bi bi-pencil-fill"></i>
					Editar
				</a>
			</div>
		</div>
		<div class="row">
			<div class="col-9 fs-4">
				<p>Tipo de atracción: <c:out value="${atraccionAVer.tipoDeAtraccion}"></c:out></p>
				<p>Descripción: <c:out value="${atraccionAVer.descripcion}"></c:out></p>
				<p>Costo: <c:out value="${atraccionAVer.getCosto()}"></c:out></p>
				<p>Tiempo: <c:out value="${atraccionAVer.getTiempo()}"></c:out></p>
			</div>
			<div class="col-3">
				<img style="width: 100%" src="<c:url value="/assets/img/uploads/atracciones/${atraccionAVer.imagen}"></c:url>">
			</div>
		</div>
	</main>
</body>
</html>