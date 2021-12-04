<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="es">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>TP03 - Index</title>
	
	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<link rel="stylesheet" href="assets/css/datatables.min.css">
</head>
<body>
	<div class="container">
		<h1><%= new java.util.Date() %></h1>
		<table id="example">
			<thead>
				<tr>
					<th>Id</th>
					<th>Nombre</th>
					<th>Tipo de Atracción</th>
					<th>Costo</th>
					<th>Tiempo</th>
					<th>Cupo de Personas</th>
					<th>Visitantes</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td>1</td>
					<td>Moria</td>
					<td>Aventura</td>
					<td>10</td>
					<td>2.0</td>
					<td>6</td>
					<td>0</td>
				</tr>
				<tr>
					<td>2</td>
					<td>Minas Tirith</td>
					<td>Paisaje</td>
					<td>5</td>
					<td>2.5</td>
					<td>25</td>
					<td>0</td>
				</tr>
				<tr>
					<td>3</td>
					<td>La Comarca</td>
					<td>Degustación</td>
					<td>3</td>
					<td>6.5</td>
					<td>150</td>
					<td>0</td>
				</tr>
				<tr>
					<td>4</td>
					<td>Mordor</td>
					<td>Aventura</td>
					<td>25</td>
					<td>3.0</td>
					<td>4</td>
					<td>0</td>
				</tr>
				<tr>
					<td>5</td>
					<td>Abismo de Helm</td>
					<td>Paisaje</td>
					<td>5</td>
					<td>2.0</td>
					<td>15</td>
					<td>0</td>
				</tr>
				<tr>
					<td>6</td>
					<td>Lothlórien</td>
					<td>Degustación</td>
					<td>35</td>
					<td>1.0</td>
					<td>30</td>
					<td>0</td>
				</tr>
				<tr>
					<td>7</td>
					<td>Erebor</td>
					<td>Paisaje</td>
					<td>12</td>
					<td>3.0</td>
					<td>32</td>
					<td>0</td>
				</tr>
				<tr>
					<td>8</td>
					<td>Bosque Negro</td>
					<td>Aventura</td>
					<td>3</td>
					<td>4.0</td>
					<td>12</td>
					<td>0</td>
				</tr>
			</tbody>
		</table>
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
	</script>
</body>
</html>
