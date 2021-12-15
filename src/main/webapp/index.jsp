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
	
	
 	.carousel-inner {
	background: rgba(0,0,0,.1);
	} 
	</style>
</head>
<body>

	<jsp:include page="partials/nav.jsp"></jsp:include>

<p class="text-success mb-0 p-2 fs-6 d-flex justify-content-center">
¡Bienvenido, <c:out value="${usuario.nombre}" />!
</p>

	
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
  <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Previous</span>
  </button>
  <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="visually-hidden">Next</span>
  </button>
</div> 

</body>
</html>
