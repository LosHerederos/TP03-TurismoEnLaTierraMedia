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

	pre {
		font-size: 17px;
	}


	</style>
</head>
<body>

<!-- NAVBAR -->
<jsp:include page="partials/nav.jsp"></jsp:include>

<div class="card">
  <h5 class="card-header">Tu itinerario</h5>
  <div class="card-body">
    <h5 class="card-title">Atracciones y promociones</h5>
    <pre>|Nombre de atracción| 		 |Tipo de atracción| 	 |Costo| 	 |Tiempo|</pre>
    <p class="card-text"><c:out value="${usuario.itinerario}"></c:out></p>
    <a href="/TP03-TurismoEnLaTierraMedia/index.jsp" class="btn btn-primary">volver</a>
  </div>
</div>

</body>
</html>
