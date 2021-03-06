<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta charset="ISO-8859-1">
<!-- Import de BootStrap via CDN  -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<title>ProxiBanque</title>
</head>

<body>
	<!-- Banner -->
	<section id="banner">
	
			<div class="alert alert-danger" role="alert">Vous �tes d�connect�</div>
	
		<h2>Application ProxiBanque V2</h2>
		<p>Bienvenue sur l'application ProxiBanque V2, votre outil de
			gestion client�le</p>
		<br>

		<form action="AuthServlet" method="Post" class="form-inline">
			<label for="login">Login </label>
			<div class="form-group">
				<input type="text" class="form-control" id="login" name="login" placeholder="Conseiller">
			</div>
			<label for="pwd"> Mot de passe </label>
			<div class="form-group">
				<input type="password" class="form-control" id="pwd" name="pwd" placeholder="Mot de passe">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-success btn-lg">Espace Conseiller</button>
			</div>
		</form>
	</section>

	<!-- Section 1  -->
	<section id="one" class="container-fluid">
		<div class="center">
			<h2>Gestion client�le</h2>
			<p>L'application ProxiBanque V2 vous offre un outil de gestion
				pour r�pondre aux besoins de vos clients.</p>
			<br>
		</div>
		<div id="div1" class="center col-xs-4">
			<span class="glyphicon glyphicon-refresh"></span>
			<p>L'application ProxiBanque vous permet de mettre � jour les
				informations clients.</p>
		</div>
		<div id="div1" class="center col-xs-4">
			<span class="glyphicon glyphicon-folder-open"></span>
			<p>L'application ProxiBanque vous permet de consulter les comptes
				Courants et Epargnes de vos clients.</p>
		</div>
		<div id="div1" class="center col-xs-4">
			<span class="glyphicon glyphicon-euro"></span>
			<p>L'application ProxiBanque vous permet d'effectuer pour vos
				clients des virements entre comptes.</p>
		</div>
	</section>
</body>

</html>