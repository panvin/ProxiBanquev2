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
import com.clementvincent2software.proxibanquesi.service.ClientService;

/**
 * Servlet implementation class ConsultCompteServlet Cette servlet permet la
 * consultation de compte apres le choix d'un ID client
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
@WebServlet("/ConsultCompteServlet")
public class ConsultCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConsultCompteServlet() {
		super();
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

	/**
	 * Cette méthode se charge de l'ensemble des traitements de la servlet pour
	 * les post et les get
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void traitement(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Etape 1 : Récupération des paramètres de la requète
		int idClient = Integer.parseInt(request.getParameter("idClient"));

		// Etape 2 : Soumettre les paramètres de la requete à la couche service
		ClientService clientService = new ClientService();
		Client client = clientService.lireClient(idClient);

		// Etape 3 : Réponse à l'utilisateur
		RequestDispatcher dispatcher;
		HttpSession maSession = request.getSession();
		maSession.setAttribute("client", client);
		maSession.setAttribute("resultUpdate", false);
		maSession.setAttribute("resultVirement", false);
		dispatcher = request.getRequestDispatcher("compteclient.jsp");
		dispatcher.forward(request, response);

	}
}
