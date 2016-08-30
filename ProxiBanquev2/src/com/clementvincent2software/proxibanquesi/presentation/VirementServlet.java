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

import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.service.CompteService;

/**
 * Servlet implementation class VirementServlet Cette servlet permet de
 * rediriger 'lutilisateur vers une page ou il pourra effectuer un virement.
 */
@WebServlet("/VirementServlet")
public class VirementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public VirementServlet() {
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
		RequestDispatcher dispatcher;
		CompteService compteService = new CompteService();
		ArrayList<Compte> listeCompte = compteService.consulterTousLesCompte();
		HttpSession maSession = request.getSession();
		maSession.setAttribute("listeCompte", listeCompte);
		dispatcher = request.getRequestDispatcher("virementcompte.jsp");
		dispatcher.forward(request, response);
	}
}
