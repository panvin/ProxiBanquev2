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
			<form action="SauvegardeVirementServlet" method="Post">
			
				<div class="form-group">
				    <label for="compteDebiteur">D�biteur</label>
				    <select class="form-control" id="compteDebiteur" name="compteDebiteur">
				      <c:forEach var="Compte" items="${listeCompte}"> 
				      <option><c:out value="${Compte.numero}"/></option>
				      </c:forEach>
				    </select>
				  </div>
 				<br>
				
				<div class="form-group row">
					<label for="compteCrediteur" class="col-sm-2 col-form-label">Cr�diteur</label>
					<select class="form-control" id="compteCrediteur" name="compteCrediteur">
				      <c:forEach var="Compte" items="${listeCompte}"> 
				      <option><c:out value="${Compte.numero}"/></option>
				      </c:forEach>
				    </select>
				  </div>
 				<br>

				<label class="sr-only" for="montantVirement">Montant (en Euros)</label>
    			<div class="input-group">
      			<div class="input-group-addon">$</div>
      			<input type="text" class="form-control" id="montantVirement" name="montantVirement" placeholder="montant">
      			<div class="input-group-addon">.00</div>
				</div>
				<br>
				<button type="submit" class="btn btn-success">Transfer cash</button>
				
			</form>
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