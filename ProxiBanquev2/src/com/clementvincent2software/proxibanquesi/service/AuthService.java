package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ConseillerDao;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;

/**
 * Classe du domaine service permettant � l'authentification des utilisateurs
 * Cette classe va permettre de valider l'authentification d'un conseiller si ses informations (login et password) sont correctes. Dans le cas contraire il ne pourra pas s'authentifier.
 * @author Stagiaire
 *
 */
public class AuthService {

	/**
	 * Cette m�thode permet � l'utilisateur de s'identifier. Elle retourne un bool�en true si l'authentification a reussi et sinon elle retourne un false
	 * @param login Le login 
	 * @param pwd
	 * @return
	 */
	public boolean authConseiller(String login, String pwd) {

		Conseiller conseiller = ConseillerDao.readConseillerByLogin(login);

		if (conseiller == null || conseiller.getLogin() == null) {
			return false;
		}

		if ((conseiller.getLogin().equalsIgnoreCase(login)) && (conseiller.getPassword().equalsIgnoreCase(pwd))) {
			return true;
		} else {
			return false;
		}
	}

}
