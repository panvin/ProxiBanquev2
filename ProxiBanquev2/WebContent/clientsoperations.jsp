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
	
	<!-- Liste des clients du conseiller -->
 	<div class="panel panel-default">
 		<div class="panel-heading">Liste des clients pour le conseiller : <c:out value="${conseiller.nom}"/></div>
 		<table class="table">
		  <thead>
		    <tr>
		      <th>ID</th>
		      <th>Civilit�</th>
		      <th>Nom</th>
		      <th>Prenom</th>
		    </tr>
		  </thead>
		  <tbody>
		 	<c:forEach var="Client" items="${listeClient}">
				<tr>
					<th scope="row"><c:out value="${Client.id}"/></th>
		     	 	<td><c:out value="${Client.civilite}"/></td>
		      		<td><c:out value="${Client.nom}"/></td>
		      		<td><c:out value="${Client.prenom}"/></td>
				</tr>
			</c:forEach>
		  </tbody>
		</table>
	</div>

	<br>
		<div action="EditClientServlet" method="Post" class="form-inline form-group container">
   				<select class="form-control" name="idClient">
			    	<c:forEach var="Client" items="${listeClient}">
							<option><c:out value="${Client.id}"/></option>
					</c:forEach>
			    </select>
				<button type="submit" class="btn btn-success">Edition du Client</button>
 		</div>
 		
 		<br>
		<div action="ConsultCompteServlet" method="Post" class="form-inline form-group container">
   				<label class="sr-only">ID Client</label>
   				<select class="form-control" name="idClient">
			    	<c:forEach var="Client" items="${listeClient}">
							<option><c:out value="${Client.id}"/></option>
					</c:forEach>
			    </select>
				<button type="submit" class="btn btn-success">Consulter Compte</button>
 		</div>
 		
 		<br>
		<div action="VirementServlet" method="Post" class="form-inline form-group container">
   				<select class="form-control" name="idClient">
			    	<c:forEach var="Client" items="${listeClient}">
							<option><c:out value="${Client.id}"/></option>
					</c:forEach>
			    </select>
				<button type="submit" class="btn btn-success">Effectuer Virement</button>
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