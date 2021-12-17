<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<c:choose>
		<c:when test="${tipoDePromocion.equals('PromocionAbsoluta')}">
			<c:set var="costoTotal" value="${promocionAEditar.costoTotal}"></c:set>
			<c:set var="atraccionesPagas" value="${listaVacia}"></c:set>
		</c:when>
		<c:when test="${tipoDePromocion.equals('PromocionAXB')}">
			<c:set var="atraccionesPagas" value="${promocionAEditar.atraccionesPagas}"></c:set>
		</c:when>
		<c:when test="${tipoDePromocion.equals('PromocionPorcentual')}">
			<c:set var="porcentaje" value="${promocionAEditar.porcentaje}"></c:set>
			<c:set var="atraccionesPagas" value="${listaVacia}"></c:set>
		</c:when>
	</c:choose>
	<jsp:include page="/partials/nav-admin.jsp"></jsp:include>
	<main class="container">
		<div class="row">
			<div class="col-12">
				<h2>Editar promoción</h2>
			</div>
		</div>
		<div class="row">
			<div class="col-10 offset-1">
				<form method="post">
					<div class="mb-3">
						<label for="nombre" class="form-label">Nombre</label>
						<input type="text" name="nombre" id="nombre" class="form-control" value="${promocionAEditar.nombre}" required>
					</div>
					<div class="mb-3">
						<label for="descripcion" class="form-label">Descripción</label>
						<textarea name="descripcion" id="descripcion" class="form-control"><c:out value="${promocionAEditar.descripcion}"></c:out></textarea>
					</div>
					<div class="mb-3">
						<label for="imagen" class="form-label">Imagen</label>
						<input type="text" name="imagen" id="imagen" class="form-control" value="${promocionAEditar.imagen}">
					</div>
					<div class="mb-3">
						<label for="tipoDeAtraccion" class="form-label">Tipo de atracción</label>
						<select name="tipoDeAtraccion" id="tipoDeAtraccion" class="form-select" data-tipo-actual="${promocionAEditar.tipoDeAtraccion.ordinal()}">
							<c:forEach items="${tipoDeAtracciones}" var="tipoDeAtraccion">
								<option value="${tipoDeAtraccion.ordinal()}" <c:if test="${tipoDeAtraccion == promocionAEditar.tipoDeAtraccion}">selected</c:if>><c:out value="${tipoDeAtraccion}"></c:out></option>
							</c:forEach>
						</select>
					</div>
					<div class="mb-3">
						<label for="atracciones" class="form-label">Atracciones</label>
						<select name="atracciones" id="atracciones" multiple class="form-select" style="height:12rem">
						</select>
					</div>
					<div class="mb-3">
						<label for="tipoDePromocion" class="form-label">Tipo de promoción</label>
						<select disabled name="tipoDePromocion" id="tipoDePromocion" class="form-select" data-tipo-actual="${tipoActual}">
							<option value="absoluta" <c:if test="${tipoDePromocion.equals('PromocionAbsoluta')}">selected</c:if>>Absoluta</option>
							<option value="axb" <c:if test="${tipoDePromocion.equals('PromocionAXB')}">selected</c:if>>AxB</option>
							<option value="porcentual" <c:if test="${tipoDePromocion.equals('PromocionPorcentual')}">selected</c:if>>Porcentual</option>
						</select>
					</div>
					<div id="absoluta" <c:if test="${!tipoDePromocion.equals('PromocionAbsoluta')}">hidden</c:if> class="mb-3">
						<label for="costoTotal" class="form-label">Costo total</label>
						<input type="number" name="costoTotal" id="costoTotal" class="form-control" value="${costoTotal}" min="1">
					</div>
					<div id="axb" <c:if test="${!tipoDePromocion.equals('PromocionAXB')}">hidden</c:if> class="mb-3">
						<label for="atraccionesPagas" class="form-label">Atracciones pagas</label>
						<select name="atraccionesPagas" id="atraccionesPagas" multiple class="form-select" style="height:12rem">
						</select>
					</div>
					<div id="porcentual" <c:if test="${!tipoDePromocion.equals('PromocionPorcentual')}">hidden</c:if> class="mb-3">
						<label for="porcentaje" class="form-label">Porcentaje</label>
						<input type="number" name="porcentaje" id="porcentaje" class="form-control" value="${porcentaje}" min="0.01" max="1.0" step="0.01">
					</div>
					<div class="mb-3 text-center">
						<input type="hidden" name="id" value="<c:out value="${promocionAEditar.idPromocion}"></c:out>">
						<input type="hidden" name="tipoActual" value="<c:out value="${tipoActual}"></c:out>">
						<input type="submit" class="btn btn-primary" value="Modificar">
						<input type="button" class="btn btn-danger" value="Cancelar" onclick="window.history.back()">
					</div>
				</form>
			</div>
		</div>
	</main>
	<script>
		const tipoDeAtraccionSelect = document.querySelector('#tipoDeAtraccion');
		const atraccionesSelect = document.querySelector('#atracciones');
		const atraccionesPagasSelect = document.querySelector('#atraccionesPagas');
		const tipoDePromocionSelect = document.querySelector('#tipoDePromocion');

		// Datos de atracciones
		const listadoDeAtracciones = {
			'0': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 0}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}', 
							seleccionado: ${promocionAEditar.atracciones.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
			'1': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 1}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}',
							seleccionado: ${promocionAEditar.atracciones.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
			'2': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 2}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}',
							seleccionado: ${promocionAEditar.atracciones.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
		};

		const listadoDeAtraccionesPagas = {
			'0': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 0}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}', 
							seleccionado: ${atraccionesPagas.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
			'1': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 1}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}',
							seleccionado: ${atraccionesPagas.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
			'2': [
				<c:forEach items="${atracciones}" var="atraccion">
					<c:if test="${atraccion.tipoDeAtraccion.ordinal() == 2}">
						{
							id: '${atraccion.idAtraccion}',
							nombre: '${atraccion.nombre}',
							seleccionado: ${atraccionesPagas.contains(atraccion)}
						},
					</c:if>
				</c:forEach>
			],
		};
		
		cargarAtraccionesPorTipo(atraccionesSelect, tipoDeAtraccionSelect.value, listadoDeAtracciones);
		<c:if test="${tipoActual.equals('axb')}">activarSelectsMutuamenteExcluyente();</c:if>
		
		tipoDePromocionSelect.addEventListener('change', function() {
			//console.log(this.value, this.dataset.tipoActual);
			document.querySelector('#' + this.dataset.tipoActual).toggleAttribute('hidden');
			document.querySelector('#' + this.value).toggleAttribute('hidden');
			this.dataset.tipoActual = this.value;
			if (this.value === 'axb') {
				activarSelectsMutuamenteExcluyente();
			} else {
				desactivarSelectMutuamenteExcluyente();
			}
		});
		
		tipoDeAtraccionSelect.addEventListener('change', function() {
			actualizarListadoDeAtraccion(listadoDeAtracciones, this.dataset.tipoActual, atraccionesSelect.options);
			this.dataset.tipoActual = this.value;
			cargarAtraccionesPorTipo(atraccionesSelect, this.value, listadoDeAtracciones);
			if (tipoDePromocionSelect.value === 'axb') {
				cargarAtraccionesPorTipo(atraccionesPagasSelect, this.value, listadoDeAtraccionesPagas);
				quitarOpcionesSeleccionadas(atraccionesPagasSelect, atraccionesSelect.selectedOptions);
				quitarOpcionesSeleccionadas(atraccionesSelect, atraccionesPagasSelect.selectedOptions);
			}
		})
		
		function activarSelectsMutuamenteExcluyente() {
			cargarAtraccionesPorTipo(atraccionesSelect, tipoDeAtraccionSelect.value, listadoDeAtracciones);
			cargarAtraccionesPorTipo(atraccionesPagasSelect, tipoDeAtraccionSelect.value, listadoDeAtraccionesPagas);
			quitarOpcionesSeleccionadas(atraccionesPagasSelect, atraccionesSelect.selectedOptions);
			quitarOpcionesSeleccionadas(atraccionesSelect, atraccionesPagasSelect.selectedOptions);
			atraccionesSelect.addEventListener('change', onChangeAtraccionesSelect, false);
			atraccionesPagasSelect.addEventListener('change', onChangeAtraccionesPagasSelect, false);
		}
		
		function desactivarSelectsMutuamenteExcluyente() {
			cargarAtraccionesPorTipo(atraccionesSelect, tipoDeAtraccionSelect.value, listadoDeAtracciones);
			atraccionesSelect.removeEventListener('change', onChangeAtraccionesSelect)
			atraccionesPagasSelect.removeEventListener('change', onChangeAtraccionesPagasSelect)
		}
		
		function onChangeAtraccionesSelect() {
			actualizarListadoDeAtraccion(listadoDeAtracciones, tipoDeAtraccionSelect.value, this.options);
			cargarAtraccionesPorTipo(atraccionesPagasSelect, tipoDeAtraccion.value, listadoDeAtraccionesPagas);
			quitarOpcionesSeleccionadas(atraccionesPagasSelect, this.selectedOptions);
		}
		
		function onChangeAtraccionesPagasSelect() {
			actualizarListadoDeAtraccion(listadoDeAtraccionesPagas, tipoDeAtraccionSelect.value, this.options)
			cargarAtraccionesPorTipo(atraccionesSelect, tipoDeAtraccion.value, listadoDeAtracciones);
			quitarOpcionesSeleccionadas(atraccionesSelect, this.selectedOptions);
		}
		
		function cargarAtraccionesPorTipo(select, tipoDeAtraccion, listado) {
			while (select.options.length > 0) {
				select.remove(0);
			}
			for (atraccion of listado[tipoDeAtraccion]) {
				select.add(generarOpcion(atraccion));
			}
		}

		function generarOpcion(datosOpcion) {
			const opcion = new Option(datosOpcion.nombre, datosOpcion.id, false, datosOpcion.seleccionado);
			opcion.setAttribute("name", "atraccion"+ datosOpcion.id);
			return opcion;
		}

		function quitarOpcionesSeleccionadas(select, opcionesSeleccionadas) {
			for (opcionSeleccionada of opcionesSeleccionadas) {
				if (opcion = select.namedItem(opcionSeleccionada.getAttribute("name"))) {
					select.remove(opcion.index);
				}
			}	
		}

		function actualizarListadoDeAtraccion(listado, tipoDeAtraccion, opciones) {
			for (atraccion of listado[tipoDeAtraccion]) {
				if (opcion = opciones.namedItem('atraccion' + atraccion.id)) {
					atraccion.seleccionado = opcion.selected;
				}
			}
		}
	</script>
</body>
</html>
