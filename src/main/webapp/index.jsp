<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Bienvenido a la tierra media</title>
	
	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/datatables.min.css">
	<style>
	
	body {
	background-color:#1c1b1b;
	}
	
	
	.carousel-inner {
	background: rgba(0,0,0,.5);
	}
	</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container-fluid">
    <a class="navbar-brand"  href="#"><img src="assets/img/favicon.ico" alt="" width="30" height="24" class="d-inline-block align-text-top">
    Tierra Media</a>
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor02" aria-controls="navbarColor02" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarColor02">
      <ul class="navbar-nav me-auto">
        <li class="nav-item">

        </li>
      </ul>
      
<a class="btn btn-outline-light my-2 my-sm-0" 
 	href=/TP03-TurismoEnLaTierraMedia/login.jsp type = "button">Login</a>
    </div>
  </div>
</nav>

<!-- mensaje de recomendacion -->
<p class="text-primary mb-0 p-4 fs-6 d-flex justify-content-center">
↓ Segun tus preferencias te recomendamos estas atracciones ↓
</p>

<!-- Recomendacion para usuario -->
<%-- 	<div class="container">
		<h1><%= session.getAttribute("usuario") %></h1>
	</div>
		<script src="assets/js/bootstrap.bundle.min.js"></script>
	<script src="assets/js/jquery-3.6.0.min.js"></script>
	<script src="assets/js/datatables.min.js"></script>
	<script>
		$(document).ready(function(){
			$('#example').DataTable({
				language: {
					url: 'https://cdn.datatables.net/plug-ins/1.11.3/i18n/es_es.json'
				}
			});
		})
	</script> --%>

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
      <img src="assets/img/armadura.jpg" class="d-block w-50 mx-auto my-auto" alt="">
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


<!-- Cartas de atracciones -->
<div class="card-group">
  <div class="card">
    <img src="assets/img/terror.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Moria</h5>
      <p class="card-text">El Reino de Moria eran las más grandes minas construidas por los enanos.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
   <div class="card">
    <img src="assets/img/casco escudo.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Minas Tirith</h5>
      <p class="card-text"> Minas Tirith es la capital de Gondor en la tercera y Cuarta Edad del Sol de la Tierra Media. Originalmente conocida como Minas Anor.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
  <div class="card">
    <img src="assets/img/casco escudo.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">La Comarca</h5>
      <p class="card-text">Es una región situada en el noroeste de la Tierra Media, uno de los continentes de Arda.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
    <div class="card">
    <img src="assets/img/terror.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Mordor</h5>
      <p class="card-text">En esta región principalmente volcánica, situada al este de Gondor, Sauron forjó el Anillo Único.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
  <div class="card">
    <img src="assets/img/rey.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Abismo del Helm</h5>
      <p class="card-text">El objetivo de las fuerzas de Isengard era aniquilar totalmente al pueblo de Rohan de un golpe.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
  <div class="card">
    <img src="assets/img/casco escudo.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Erebor</h5>
      <p class="card-text">Fue colonizada por el rey enano Thráin I y se la conoció como el Reino bajo la Montaña..</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
    <div class="card">
    <img src="assets/img/rey.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Bosque Negro</h5>
      <p class="card-text">Desde la construcción de la fortaleza de Dol Guldur por parte de Sauron, una gran sombra se cernió sobre el bosque, pasando a llamarse Bosque Negro.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
    <div class="card">
    <img src="assets/img/terror.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Lothlórien</h5>
      <p class="card-text">Reino élfico de la Tierra Media, ubicado al este de las Montañas Nubladas y más allá de las puertas de Moria.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
 
</div>


</body>
</html>
