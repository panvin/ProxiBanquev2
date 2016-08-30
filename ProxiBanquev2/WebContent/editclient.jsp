<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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

	<nav class="navbar navbar-inverse navbar-static-top">
	<div class="container-fluid">
		<ul class="nav navbar-left">
			<li role="presentation"><a href="clientsoperations.jsp"><span
					class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil
					ProxiBanque</a></li>
		</ul>
		<ul class="nav navbar-right">
			<li role="presentation"><a href="LogOutServlet"><span
					class="glyphicon glyphicon-log-out" aria-hidden="true"></span>
					Deconnexion</a></li>
		</ul>
	</div>
	</nav>
	<!-- Banner -->
	<div id="banner">
		<h2>Application ProxiBanque V2</h2>
		<p>
			Edition fichier client
		</p>
		<br>

		<div class="container">
			<form class="form-group row" action="SauvegardeClientServlet" method="Post">
				
					<label for="nomClient" class="col-sm-2 col-form-label">Nom</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="nomClient" name="nomClient"
							value="<c:out value="${lectureClient.nom}"/>">
				<br>
				</div>
				
				
					<label for="prenomClient" class="col-sm-2 col-form-label">Prenom</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="prenomClient" name="prenomClient"
							value="<c:out value="${lectureClient.prenom}"/>">
				<br>
				</div>
				
				
					<label for="emailClient" class="col-sm-2 col-form-label">email</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="emailClient" name="emailClient"
							value="<c:out value="${lectureClient.email}"/>">
				<br>
				</div>
				
				
					<label for="adresseClient" class="col-sm-2 col-form-label">adresse</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="adresseClient" name="adresseClient"
							value="<c:out value="${lectureClient.coordonnees.adresse}"/>">
				<br>	
				</div>
				
				
					<label for="villeClient" class="col-sm-2 col-form-label">ville</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="villeClient" name="villeClient"
							value="<c:out value="${lectureClient.coordonnees.ville}"/>">
				<br>	
				</div>
				
				
					<label for="telClient" class="col-sm-2 col-form-label">telephone</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="telClient" name="telClient"
							value="<c:out value="${lectureClient.coordonnees.telephone}"/>">
				<br>	
				</div>
				
					<label for="cpClient" class="col-sm-2 col-form-label">cp</label>
					<div class="col-sm-10">
						<input type="text" class="form-control" id="cpClient" name="cpClient"
							value="<c:out value="${lectureClient.coordonnees.cp}"/>">
				<br>
				</div>
				
				<button type="submit" class="btn btn-success btn-lg">Envoyer</button>
				
			</form>
		</div>
	</div>

		<!-- Section 1  -->
		<div id="one" class="container-fluid">

			<div class="center">
				<h2>Gestion clientèle</h2>
				<p>L'application ProxiBanque V2 vous offre un outil de gestion
					pour répondre aux besoins de vos clients.</p>
				<br>
			</div>
			<div id="div1" class="center col-xs-4">
				<span class="glyphicon glyphicon-refresh"></span>
				<p>L'application ProxiBanque vous permet de mettre à jour les
					informations clients.</p>
			</div>
			<div id="div1" class="center col-xs-4">
				<span class="glyphicon glyphicon-folder-open"></span>
				<p>L'application ProxiBanque vous permet de consulter les
					comptes Courants et Epargnes de vos clients.</p>
			</div>
			<div id="div1" class="center col-xs-4">
				<span class="glyphicon glyphicon-euro"></span>
				<p>L'application ProxiBanque vous permet d'effectuer pour vos
					clients des virements entre comptes.</p>
			</div>
		</div>
</body>
</body>
</html>