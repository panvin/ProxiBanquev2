<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="css/style.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="js/skel-layers.min.js"></script>
<title>ProxiBanque</title>
</head>
<body>

	<nav class="navbar navbar-inverse navbar-static-top">
  		<div class="container-fluid">
			<ul class="nav navbar-left">
			  <li role="presentation"><a href="clientsoperations.jsp"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Accueil ProxiBanque</a></li>
			</ul>
			<ul class="nav navbar-right">
			  <li role="presentation"><a href="index.html"><span class="glyphicon glyphicon-log-out" aria-hidden="true"></span>  Deconnexion</a></li>
			</ul>
		</div>
	</nav>
	<!-- Banner -->
	<div id="banner">
		<h2>Application ProxiBanque V2</h2>
		<p>Bienvenue <c:out value="${conseiller.nom}"/> sur l'application ProxiBanque V2</p>
		<br>

	<div class="row">
	<section class="feature 6u 12u$(small)">	
	<form action="editionClientServlet" method="Post">
		<label for="nomClient">Nom    </label>
			<input type="text" id="nomClient" name="nomClient" placeholder="Votre nom"><br>
		<label for="prenomClient">Prenom </label>
			<input type="text" id="prenomClient" name="prenomClient" placeholder="votre pr�nom"><br>
		<label for="emailClient">Email  </label>
			<input type="text" id="emailClient" name="emailClient" placeholder="votre mot de passe"><br>
		<label for="adresseClientl">adresse  </label>
			<input type="text" id="adresseClientl" name="adresseClientl" placeholder="exemple@gmail.com"><br>
		<label for="villeClient">ville  </label>
			<input type="text" id="villeClient" name="villeClient" placeholder="votre mot de passe"><br>
		<label for="cpClient">code postal  </label>
			<input type="text" id="cpClient" name="cpClient" placeholder="votre mot de passe"><br>
		<label for="telephoneClient">t�l�phone  </label>
			<input type="text" id="telephoneClient" name="telephoneClient" placeholder="votre mot de passe"><br>
			
			<input id="submit" type="submit"  value="Envoyer"><br>
		</form>
	</section>
	</div>
	</div>


	<!-- Section 1  -->
	<div id="one" class="container-fluid">

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
	</div>
</body>
</body>
</html>