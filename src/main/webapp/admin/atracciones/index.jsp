<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<jsp:include page="/partials/head.jsp"></jsp:include>
<jsp:include page="/partials/datatables.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>
	<main class="container">
		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${esValido != null}">
						<ul>
							<c:forEach items="${esValido}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
		<div class="row">
			<div class="col-12">
				<div class="bg-light p-4 mb-3 rounded">
					<h1>Estas son las atracciones de la Tierra Media</h1>
				</div>
				<div class="mb-3">
					<a href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/crear.do"
						class="btn btn-primary" role="button"> <i class="bi bi-plus-lg"></i>
						Nueva Atracción
					</a>
				</div>
				<table id="listadoDeAtracciones" class="table table-stripped table-hover">
					<thead>
						<tr>
							<th>Id</th>
							<th>Nombre</th>
							<th>Tipo de Atracción</th>
							<th>Costo</th>
							<th>Tiempo</th>
							<th>Cupo Total</th>
							<th>Cupo Ocupado</th>
							<th>Acciones</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${atracciones}" var="atraccion">
							<tr>
								<td><c:out value="${atraccion.idAtraccion}"></c:out></td>
								<td><c:out value="${atraccion.nombre}"></c:out></td>
								<td><c:out value="${atraccion.tipoDeAtraccion}"></c:out></td>
								<td><c:out value="${atraccion.costo}"></c:out></td>
								<td><c:out value="${atraccion.tiempo}"></c:out></td>
								<td><c:out value="${atraccion.cupoPersonas}"></c:out></td>
								<td><c:out value="${atraccion.visitantes}"></c:out></td>
								<td>
									<a href="<c:url value="/admin/atracciones/ver.do?id=${atraccion.idAtraccion}"></c:url>"
										class="btn btn-primary rounded-0"
										role="button"
										title="Ver">
										<i class="bi bi-eye-fill"></i>
									</a>
									<a href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/editar.do?id=${atraccion.idAtraccion}"
										class="btn btn-success rounded-0"
										role="button"
										title="Editar">
										<i class="bi bi-pencil-fill"></i>
									</a>
									<a href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/borrar.do?id=${atraccion.idAtraccion}"
										class="btn btn-danger rounded-0"
										role="button"
										title="Eliminar">
										<i class="bi bi-x-circle-fill"></i>
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
			$('#listadoDeAtracciones').DataTable({
				language: {
					url: 'https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'
				}
			});
		})
	</script>
</body>
</html>
