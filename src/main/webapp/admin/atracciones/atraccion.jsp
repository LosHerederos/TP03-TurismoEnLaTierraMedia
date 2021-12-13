<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="nombre" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre" required
		value="${atraccion.nombre}">
</div>
<div class="mb-3">
	<label for="descripcion" class="col-form-label">Descripcion:</label> <input
		type="text" class="form-control" id="nombre" name="descripcion"
		required value="${atraccion.descripcion}">
</div>
<div class="mb-3">
	<label for="imagen" class="col-form-label">Imagen:</label> <input
		type="text" class="form-control" id="imagen" name="imagen"
		disabled="disabled" required value="${atraccion.imagen} ">
		
</div>
<span class="btn btn-file"><input type="file" style='-ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)"; opacity: 0; background-color: transparent; color: transparent;'
		name="file_source" size="40"
		onchange='$("#upload-file-info").html($(this).val());' /></span>
<div class="mb-3">
	<label for="costoVisita"
		class='col-form-label ${atraccion.getErrors().get("costoVisita") != null ? "is-invalid" : "" }'>costoVisita:</label>
	<input class="form-control" type="number" id="costoVisita"
		name="costoVisita" required value="${atraccion.costoVisita}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.getErrors().get("costoVisita")}'></c:out>
	</div>
</div>

<div class="mb-3">
	<label for="tiempoParaRealizarla"
		class='col-form-label ${atraccion.getErrors().get("tiempoParaRealizarla") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoParaRealizarla"
		name="tiempoParaRealizarla" required
		value="${atraccion.tiempoParaRealizarla}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.getErrors().get("tiempoParaRealizarla")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupoPersonas"
		class='col-form-label ${atraccion.getErrors().get("cupoPersonas") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupoPersonas"
		name="cupoPersonas" required value="${atraccion.cupoPersonas}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.getErrors().get("cupoPersonas")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="visitantes"
		class='col-form-label ${atraccion.getErrors().get("visitantes") != null ? "is-invalid" : "" }'>visitantes:</label>
	<input class="form-control" type="number" id="visitantes"
		name="visitantes" required value="${atraccion.visitantes}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.getErrors().get("visitantes")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tipoDeAtraccion" class="col-form-label">Tipo:</label> <input
		type="text" class="form-control" id="tipoDeAtraccion"
		name="tipoDeAtraccion" required value="${atraccion.tipoDeAtraccion}">
</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>