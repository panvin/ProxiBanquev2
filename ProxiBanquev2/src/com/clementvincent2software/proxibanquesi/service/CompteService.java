package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ClientDao;
import com.clementvincent2software.proxibanquesi.dao.CompteDao;
import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe de la couche service d�di� � tout ce qui concerne les comptes. Cette
 * classe permet de traiter les comptes clients: ajouter des comptes (cr�er),
 * modifier des comptes, supprimer des comptes, consulter des comptes. Ce
 * service permet egalement de r�aliser des virements comptes � comptes entre
 * les clients de l'etablissment.
 * 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteService {

	/**
	 * Cette methode permet d'ajouter un compte � un client existant
	 * 
	 * @param client
	 *            Objet client auquel le compte va etre ajoute
	 * @param typeCompte
	 *            Type de compte: "Courant", "Epargne"
	 * @param numero
	 *            Le Numero de compte
	 * @param solde
	 *            Le Solde du compte
	 * @param dateOuverture
	 *            La Date d'ouverture du compte
	 * @return Retourne un booleen: true si le compte est cree et ajoute, false
	 *         sinon
	 */
	public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde, String dateOuverture) {
		if(typeCompte.equals("Epargne") && client.getCompteEpargne() == null) {
			CompteEpargne compteClient = new CompteEpargne(numero, solde, dateOuverture, client);
			client.setCompteEpargne(compteClient);
			CompteDao.createCompte(compteClient, typeCompte, client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		}
		else if (typeCompte.equals("Courant") && client.getCompteEpargne() == null) {
			CompteCourant compteClient = new CompteCourant(numero, solde, dateOuverture, client);
			client.setCompteCourant(compteClient);
			CompteDao.createCompte(compteClient, typeCompte, client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		}
		else 
			return false;
	}

	/**
	 * Cette methode permet de realiser un virement compte � compte au sein de
	 * la banque
	 * 
	 * @param compteADebiter
	 *            Le compte � debiter
	 * @param compteACrediter
	 *            Le compte � crediter
	 * @param montant
	 *            Le montant du virement.
	 */
	public boolean virementCompteACompte(String numCompteADebiter, String numCompteACrediter, float montant) {

		boolean statusCompteADebiter, statusCompteACrediter;
		float soldeCompteADebiter = CompteDao.readCompteByNum(numCompteADebiter).getSolde() - montant;
		float soldeCompteACrediter = CompteDao.readCompteByNum(numCompteACrediter).getSolde() + montant;

		statusCompteADebiter = CompteDao.updateCompteByNum(numCompteADebiter, soldeCompteADebiter);
		statusCompteACrediter = CompteDao.updateCompteByNum(numCompteACrediter, soldeCompteACrediter);

		return (statusCompteADebiter && statusCompteACrediter);
	}

	/**
	 * Cette m�thode permet de supprimer un compte de la base de donn�e � partir
	 * du numero de compte
	 * 
	 * @param numeroCompte
	 *            Le numero du compte � supprimer.
	 */
	public boolean supprimerCompte(String numeroCompte) {
		boolean status;
		status = CompteDao.deleteCompteByNum(numeroCompte);
		return status;
	}

	public boolean supprimerCompteParClient(int idClient) {
		boolean status;
		status = CompteDao.deleteCompteByIdClient(idClient);
		return status;
	}

	/**
	 * Cette m�thode permet de consulter les informations relatives � un compte
	 * et de les retourner sous forme d'objet Compte
	 * 
	 * @param numeroCompte
	 *            Le numero de compte dont on souhaite visualiser les infos
	 * @return Retourne l'objet compte demande.
	 */
	public Compte consulterCompte(String numeroCompte) {
		Compte compteDemande = CompteDao.readCompteByNum(numeroCompte);
		return compteDemande;
	}

	/**
	 * Cette methode permet de mettre � jour les donnes du compte en banque �
	 * partir de son numero.
	 * 
	 * @param compteAModifier
	 *            L'objet compte dont on souhaite faire une modification.
	 * @param montant
	 *            Le montant de la transaction effectu� sur le compte.
	 */
	public void modifierCompte(String numeroCompte, float montant) {
		CompteDao.updateCompteByNum(numeroCompte, montant);
	}
}
