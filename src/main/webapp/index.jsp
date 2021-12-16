<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bienvenido a la Tierra Media</title>
	
	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	
<jsp:include page="partials/head.jsp"></jsp:include>
	<style>
	
 	body {
	background-color:#1c1b1b;
	} 
	

/* 	.bienvenida {
	background-color: rgb(219, 26, 26);
	position: realtive;
	z-index:10;
	box-shadow: 0 0 10px rgba(0,0,0,0.5);
	} */
	
 	.carousel-inner {
	background: rgba(0,0,0,.0.5);
	} 
	
	.card {
	background: rgba(0,0,0,.1);
	}
	
	</style>
</head>
<body>

<!-- NAVBAR -->
<jsp:include page="partials/nav.jsp"></jsp:include>
	
<!-- Carrusel -->
 <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
    <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
  </div>
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="assets/img/castillo.jpg" class="d-block w-50 mx-auto my-auto" alt="">
    </div>
    <div class="carousel-item">
      <img src="assets/img/vuelta.jpg" class="d-block w-50 mx-auto my-auto" alt="">
    </div>
    <div class="carousel-item">
      <img src="assets/img/puente bosque.jpg" class="d-block w-50 mx-auto my-auto" alt="">
    </div>
  </div>
</div> 

<!-- descripcion -->
<%-- <div class="bienvenida">
<p class="text-success mb-0 p-2 fs-6 d-flex justify-content-center">
¡Bienvenido, <c:out value="${usuario.nombre}" />!
</p>
<p class="text-light mb-0 d-flex justify-content-center"> Este verano 2021/2022 te esperamos en la Tierra media! </p>
<p class="text-light mb-0 d-flex justify-content-center"> Segun tus preferencias te recomendamos estas promociones.</p>
<a href="#" class="btn btn-success">Promociones</a>
</div> --%>

<div class="card text-center">
  <div class="card-header text-warning">
    ¡Bienvenido, <c:out value="${usuario.nombre}" />!
  </div>
  <div class="card-body">
    <h5 class="card-title text-warning">Este verano 2021/2022 te esperamos en la Tierra media!</h5>
    <p class="card-text text-warning">Segun tus preferencias te recomendamos estas promociones.</p>
    <a href="/TP03-TurismoEnLaTierraMedia/sugerencias.jsp" class="btn btn-primary">Promociones</a>
  </div>
  <div class="card-footer text-muted mt-4">
   Para obtener asistencia con tu visita a Tierra Media, llama al (011) 5354-8119.
Los Visitantes menores de 18 años de edad deben contar con el permiso de sus padres o tutores para llamar.
  </div>
</div>


</body>
</html>
