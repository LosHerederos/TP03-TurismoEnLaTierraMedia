<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="mb-3">
	<label for="name" class="col-form-label">Nombre:</label> <input
		type="text" class="form-control" id="nombre" name="nombre"
		required value="${atraccion.nombre}">
</div>
<div class="mb-3">
	<label for="costoVisita"
		class='col-form-label ${atraccion.esValido.get("costoVisita") != null ? "is-invalid" : "" }'>Costo:</label>
	<input class="form-control" type="number" id="costoVisita" name="costoVisita"
		required value="${atraccion.costoVisita}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.esValido.get("costoVisita")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="tiempoParaRealizarla"
		class='col-form-label ${atraccion.esValido.get("tiempoParaRealizarla") != null ? "is-invalid" : "" }'>Tiempo:</label>
	<input class="form-control" type="number" id="tiempoParaRealizarla" name="tiempoParaRealizarla"
		required value="${atraccion.tiempoParaRealizarla}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.esValido.get("tiempoParaRealizarla")}'></c:out>
	</div>
</div>
<div class="mb-3">
	<label for="cupoPersonas"
		class='col-form-label ${atraccion.esValido.get("cupoPersonas") != null ? "is-invalid" : "" }'>Cupo:</label>
	<input class="form-control" type="number" id="cupoPersonas" name="cupoPersonas"
		required value="${atraccion.cupoPersonas}"></input>
	<div class="invalid-feedback">
		<c:out value='${atraccion.esValido.get("cupoPersonas")}'></c:out>
	</div>
</div>

<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>