package com.clementvincent2software.proxibanquesi.presentation;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clementvincent2software.proxibanquesi.service.CompteService;

/**
 * Servlet implementation class SauvegardeVirementServlet
 * Cette servlet permet de rendre effectif dans la base de donnée les virements mis en oeuvre sur la page jsp de virement
 */
/**
 * @author Stagiaire
 *
 */
@WebServlet("/SauvegardeVirementServlet")
public class SauvegardeVirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SauvegardeVirementServlet() {
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
		String compteDebiteur = request.getParameter("compteDebiteur");
		String compteCrediteur = request.getParameter("compteCrediteur");
		float montantVirement = Integer.parseInt(request.getParameter("montantVirement"));

		// Etape 2 : Soumettre les paramètres de la requete à la couche service
		CompteService compteService = new CompteService();
		Boolean resultVirement;
		resultVirement = compteService.virementCompteACompte(compteDebiteur, compteCrediteur, montantVirement);

		// Etape 3 : Réponse à l'utilisateur
		RequestDispatcher dispatcher;
		if (resultVirement == true) {
			HttpSession maSession = request.getSession();
			maSession.setAttribute("resultVirement", resultVirement);
			maSession.setAttribute("resultUpdate", false);
			dispatcher = request.getRequestDispatcher("clientsoperations.jsp");
		} else {
			dispatcher = request.getRequestDispatcher("virementerror.jsp");
		}
		dispatcher.forward(request, response);
	}
}
