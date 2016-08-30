package com.clementvincent2software.proxibanquesi.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clementvincent2software.proxibanquesi.service.AuthService;

/**
 * Servlet implementation class EditClientServlet
 */
@WebServlet("/EditClientServlet")
public class EditClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditClientServlet() {
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
				String idClient = request.getParameter("idClient");
				
				// Etape 2 : Soumettre les paramètres de la requete à la couche service
				AuthService authService = new AuthService();
				Boolean resultAuth;
				resultAuth = authService.authConseiller(login, pwd);
	}

}
