<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<nav class="navbar navbar-expand-md navbar-dark bg-dark mb-4">
	<div class="container">
		<a class="navbar-brand" href="/TP03-TurismoEnLaTierraMedia/index.jsp">Turismo en la Tierra Media</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto mb-2 mb-md-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="/TP03-TurismoEnLaTierraMedia/admin/atracciones/index.do">Atracciones</a></li>
					<c:if test="${user.isAdmin()}">
						<li class="nav-item"><a class="nav-link active"
						aria-current="page" href="/TP03-TurismoEnLaTierraMedia/admin/usuarios/index.do">Usuarios</a></li>
					</c:if>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown">
					<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<c:out value="${usuario.nombre}"></c:out>
					</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="monedas" style="color: gold;" class="bi bi-coin"></i> <c:out value="${usuario.monedas}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
							<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i> <c:out value="${usuario.tiempoDisponible}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/TP03-TurismoEnLaTierraMedia/logout" class="dropdown-item">Salir</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>

<c:if test="${success != null}">
	<div class="alert alert-success">
		<p>
			<c:out value="${success}" />
		</p>
	</div>
</c:if>