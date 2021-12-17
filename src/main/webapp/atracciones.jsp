<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Atracciones</title>
	
	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	
<jsp:include page="partials/head.jsp"></jsp:include>

	<style>
	
 	body {
	background-color:#1c1b1b;
	} 
	
	</style>

</head>
<body>

	<jsp:include page="partials/nav.jsp"></jsp:include>

<h1 class="text-success mb-0 p-4 fs-6 d-flex justify-content-center">
Atracciones
</h1>
	
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
      <a href="comprar.do" class="btn btn-success">comprar</a>
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
