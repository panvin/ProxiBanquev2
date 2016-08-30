package com.clementvincent2software.proxibanquesi.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;
import com.clementvincent2software.proxibanquesi.service.AuthService;
import com.clementvincent2software.proxibanquesi.service.ClientService;
import com.clementvincent2software.proxibanquesi.service.ConseillerService;

/**
 * Servlet implementation class AuthServlet Cette Servlet permet
 * l'authentification des conseillers
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
@WebServlet("/AuthServlet")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AuthServlet() {
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
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		// Etape 2 : Soumettre les paramètres de la requete à la couche service
		AuthService authService = new AuthService();
		Boolean resultAuth;
		resultAuth = authService.authConseiller(login, pwd);

		// Etape 3 : Réponse à l'utilisateur
		RequestDispatcher dispatcher;

		if (resultAuth == true) {
			ConseillerService conseillerService = new ConseillerService();
			ClientService clientService = new ClientService();
			Conseiller conseiller = conseillerService.lireConseiller(login);
			ArrayList<Client> listeClient = clientService.lireClientsParConseiller(login);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("conseiller", conseiller);
			maSession.setAttribute("listeClient", listeClient);
			maSession.setAttribute("resultVirement", false);
			maSession.setAttribute("resultUpdate", false);
			dispatcher = request.getRequestDispatcher("clientsoperations.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("loginincorrect.html");
		}
		dispatcher.forward(request, response);
	}
}
