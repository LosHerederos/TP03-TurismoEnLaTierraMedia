<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=MedievalSharp&display=swap" rel="stylesheet">

<style>
.titulo {
	font-family: 'MedievalSharp', cursive;
}

.navbar-brand {
	font-size: 1.60rem;
}
</style>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark mb-2">
	<div class="container-fluid">
		<div class="titulo">
			<a class="navbar-brand" href="/TP03-TurismoEnLaTierraMedia/index.jsp">
				<img src="<c:url value="/assets/img/favicon.ico"></c:url>" alt="" width="30" height="24" class="d-inline-block align-text-top">
				Tierra Media
			</a>
		</div>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse">
			<ul class="navbar-nav me-auto">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="<c:url value="/admin/atracciones/index.do"></c:url>">Atracciones</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="<c:url value="/admin/promociones/index.do"></c:url>">Promociones</a>
				</li>
				<li class="nav-item"><a class="nav-link active"
					aria-current="page"
					href="<c:url value="/admin/usuarios/index.do"></c:url>">Usuarios</a>
				</li>
			</ul>
			<ul class="navbar-nav">
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						<img src="<c:url value="/assets/img/bx-user-circle.svg"></c:url>" alt="" width="30" height="24">
					<c:out value="${usuario.nombre}"></c:out>
				</a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="monedas" style="color: gold;" class="bi bi-coin"></i>
								<c:out value="${usuario.presupuesto}"></c:out>
						</a></li>
						<li><a class="dropdown-item disabled" style="color: black;">
								<i title="tiempo" style="color: blue;" class="bi bi-clock-fill"></i>
								<c:out value="${usuario.tiempoDisponible}h"></c:out>
						</a></li>
						<li><hr class="dropdown-divider"></li>
						<li><a href="/TP03-TurismoEnLaTierraMedia/logout"
							class="dropdown-item">Cerrar sesion</a></li>
					</ul>
				</li>
			</ul>
		</div>
	</div>
</nav>