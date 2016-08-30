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
 * Servlet implementation class AuthServlet
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		traitement(request, response);
	}

	protected void traitement(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Etape 1 : R�cup�ration des param�tres de la requ�te
		String login = request.getParameter("login");
		String pwd = request.getParameter("pwd");

		// Etape 2 : Soumettre les param�tres de la requete � la couche service
		AuthService authService = new AuthService();
		Boolean resultAuth;
		resultAuth = authService.authConseiller(login, pwd);
		

		// Etape 3 : R�ponse � l'utilisateur
		RequestDispatcher dispatcher;

		if (resultAuth == true) {
			ConseillerService conseillerService = new ConseillerService();
			ClientService clientService = new ClientService();
			Conseiller conseiller = conseillerService.lireConseiller(login);
			ArrayList<Client> listeClient = clientService.lireClientsParConseiller(login);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("conseiller", conseiller);
			maSession.setAttribute("listeClient", listeClient);

			dispatcher = request.getRequestDispatcher("clientsoperations.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("loginincorrect.html");
		}
		dispatcher.forward(request, response);
	}
}
