package com.clementvincent2software.proxibanquesi.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.clementvincent2software.proxibanquesi.dao.ConseillerDao;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;
import com.clementvincent2software.proxibanquesi.service.AuthService;

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
			Conseiller conseiller = ConseillerDao.readConseillerByLogin(login);
			HttpSession maSession = request.getSession();
			maSession.setAttribute("conseiller", conseiller);

			dispatcher = request.getRequestDispatcher("clientsoperations.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("loginincorrect.html");
		}
		dispatcher.forward(request, response);
	}
}
