package com.clementvincent2software.proxibanquesi.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Coordonnees;
import com.clementvincent2software.proxibanquesi.service.ClientService;

/**
 * Servlet implementation class SauvegardeClientServlet
 */
@WebServlet("/SauvegardeClientServlet")
public class SauvegardeClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SauvegardeClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : R�cup�ration des param�tres de la requ�te
		String nom = request.getParameter("nomClient");
		String prenom = request.getParameter("prenomClient");
		String email = request.getParameter("emailClient");
		String adresseClient = request.getParameter("adresseClient");
		String ville = request.getParameter("villeClient");
		String telephone = request.getParameter("telClient");
		String cpClient = request.getParameter("cpClient");

		// Etape 2 : Soumettre les param�tres de la requete � la couche service
		ClientService clientService= new ClientService();
		HttpSession maSession = request.getSession();
		Client clientAModifier = (Client) maSession.getAttribute("lectureClient");
		int idClient = clientAModifier.getId();
		Coordonnees nouvCoordonnes = new Coordonnees(adresseClient, ville, telephone, cpClient);
		clientAModifier.setNom(nom);
		clientAModifier.setPrenom(prenom);
		clientAModifier.setEmail(email);
		clientAModifier.setCoordonnees(nouvCoordonnes);
		
		clientService.modifierClient(idClient, clientAModifier);
		
		// Etape 3 : R�ponse � l'utilisateur
		RequestDispatcher dispatcher;
		dispatcher = request.getRequestDispatcher("clientsoperations.jsp");
		dispatcher.forward(request, response);
	}
}
