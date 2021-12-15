<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Login</title>
	
	<link rel="shortcut icon" href="assets/img/favicon.ico">
	<link rel="stylesheet" href="assets/css/bootstrap.min.css">
	<style>
		html, body {
			height: 100%;
		}
		
		body {
			display: flex;
			align-items: center;
			padding-top: 40px;
			padding-bottom: 40px;
			background-color: #f5f5f5;
		}
		
		.form-signin {
			width: 100%;
			max-width: 330px;
			padding: 15px;
			margin: auto;
		}
		
		.form-signin .checkbox {
			font-weight: 400;
		}
		
		.form-signin .form-floating:focus-within {
			z-index: 2;
		}
		
		.form-signin input[type="email"] {
			margin-bottom: -1px;
			border-bottom-right-radius: 0;
			border-bottom-left-radius: 0;
		}
		
		.form-signin input[type="password"] {
			margin-bottom: 10px;
			border-top-left-radius: 0;
			border-top-right-radius: 0;
		}
	</style>
</head>
<body>
	<main class="form-signin">
		
		<form action="login" method="post">
			<h1 class="h3 mb-3 fw-normal">Login</h1>
			<div class="form-floating">
				<input type="text" name="nombre" class="form-control" id="floatingInput"
					placeholder="Pepe"> <label for="floatingInput">Nombre</label>
			</div>
			<br>
			<button class="w-100 btn btn-lg btn-primary" type="submit">Ingresar</button>
		</form>
	</main>
</body>
</html>