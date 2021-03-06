<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>

	<main class="container">

		<c:if test="${atraccion != null && !atraccion.isValid()}">
			<div class="alert alert-danger">
				<p>Se encontraron errores al actualizar la atracción.</p>
			</div>
		</c:if>

		<form action="/TP03-TurismoEnLaTierraMedia/admin/atracciones/editar.do" method="post">
			<input type="hidden" name="idAtraccion" value="${atraccion.idAtraccion}">
			<jsp:include page="/admin/atracciones/formulario.jsp"></jsp:include>
		</form>
	</main>
</body>
</html>