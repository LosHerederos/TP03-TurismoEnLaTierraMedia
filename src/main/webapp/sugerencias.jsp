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
Sugerencias
</h1>
	
	<!-- Cartas de atracciones -->
<div class="card-group">
  <div class="card">
    <img src="assets/img/terror.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Promo 1</h5>
      <p class="card-text">El Reino de Moria eran las más grandes minas construidas por los enanos.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
   <div class="card">
    <img src="assets/img/rey.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Promo 2</h5>
      <p class="card-text"> Minas Tirith es la capital de Gondor en la tercera y Cuarta Edad del Sol de la Tierra Media. Originalmente conocida como Minas Anor.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
  <div class="card">
    <img src="assets/img/casco escudo.jpg" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Promo 3</h5>
      <p class="card-text">Es una región situada en el noroeste de la Tierra Media, uno de los continentes de Arda.</p>
      <a href="#" class="btn btn-success">comprar</a>
    </div>
  </div>
  </div>

	
	
</body>
</html>
