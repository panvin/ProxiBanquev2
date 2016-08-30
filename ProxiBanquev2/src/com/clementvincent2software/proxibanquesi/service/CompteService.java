package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ClientDao;
import com.clementvincent2software.proxibanquesi.dao.CompteDao;
import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe de la couche service dédié à tout ce qui concerne les comptes.
 * Cette classe permet de traiter les comptes clients: ajouter des comptes (créer), modifier des comptes, supprimer des comptes, consulter des comptes. 
 * Ce service permet egalement de réaliser des virements comptes à comptes entre les clients de l'etablissment. 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteService {
	
	/**
	 * Cette methode permet d'ajouter un compte à un client existant
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param typeCompte Type de compte: "Courant", "Epargne"
	 * @param numero Le Numero de compte
	 * @param solde Le Solde du compte
	 * @param dateOuverture La Date d'ouverture du compte
	 * @return Retourne un booleen: true si le compte est cree et ajoute, false sinon
	 */
	public boolean ajouterCompte(Client client, String typeCompte, String numero, float solde,
			String dateOuverture) {

		switch (typeCompte) {
		case "Courant":
			return this.creerCompteCourant(client, numero, solde, dateOuverture);

		case "Epargne":
			return this.creerCompteEpargne(client, numero, solde, dateOuverture);

		default:
			return false;
		}
	}
	
	/**
	 * Cette methode permet de creer un compte courant à partir des infos clients
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param numero Le Numero de compte
	 * @param solde Le Solde du compte
	 * @param compteEntreprise Est-ce un compte entreprise: si oui true sinon false
	 * @param dateOuverture La Date d'ouverture du compte
	 * @return Retourne un boleen: true: creation reussie sinon false.
	 */
	public boolean creerCompteCourant(Client client, String numero, float solde, String dateOuverture) {
		if (client.getCompteCourant() == null) {
			CompteCourant compteCourantClient = new CompteCourant(numero, solde, dateOuverture, client);
			client.setCompteCourant(compteCourantClient);
			CompteDao.createCompte(compteCourantClient, "Courant", client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Cette methode permet de creer un compte Epargne à partir des infos clients
	 * @param client Objet client auquel le compte va etre ajoute
	 * @param numero Le Numero de compte
	 * @param soldeDepart Le Solde du compte
	 * @param dateOuverture La Date d'ouverture du compte
	 * @param compteEntreprise Est-ce un compte entreprise: si oui true sinon false
	 * @return Retourne un boleen: true: creation reussie sinon false.
	 */
	public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, String dateOuverture) { 
		if (client.getCompteEpargne() == null) {
			CompteEpargne compteEpargneClient = new CompteEpargne(numero, soldeDepart, dateOuverture, client);
			client.setCompteEpargne((CompteEpargne)compteEpargneClient);
			CompteDao.createCompte(compteEpargneClient, "Epargne", client.getId());
			ClientDao.updateClientById(client.getId(), client);
			return true;
		} else {
			return false;
		}
	}
	
	
	/** Cette methode permet de realiser un virement compte à compte au sein de la banque
	 * @param compteADebiter Le compte à debiter
	 * @param compteACrediter Le compte à crediter
	 * @param montant Le montant du virement.
	 */
	public boolean virementCompteACompte(String numCompteADebiter, String numCompteACrediter, float montant){
		
		boolean statusCompteADebiter, statusCompteACrediter;
		float soldeCompteADebiter = CompteDao.readCompteByNum(numCompteADebiter).getSolde() - montant;
		float soldeCompteACrediter = CompteDao.readCompteByNum(numCompteACrediter).getSolde() + montant;

		statusCompteADebiter  = CompteDao.updateCompteByNum(numCompteADebiter, soldeCompteADebiter);
		statusCompteACrediter = CompteDao.updateCompteByNum(numCompteACrediter, soldeCompteACrediter);
		
		return (statusCompteADebiter && statusCompteACrediter);
	}
	
	/**
	 * Cette méthode permet de supprimer un compte de la base de donnée à partir du numero de compte
	 * @param numeroCompte Le numero du compte à supprimer.
	 */
	public boolean supprimerCompte(String numeroCompte){
		boolean status;
		status = CompteDao.deleteCompteByNum(numeroCompte);	
		return status;
	}
	
	public boolean supprimerCompteParClient(int idClient){
		boolean status;
		status = CompteDao.deleteCompteByIdClient(idClient);
		return status;
	}
	
	/**
	 * Cette méthode permet de consulter les informations relatives à un compte et de les retourner sous forme d'objet Compte
	 * @param numeroCompte Le numero de compte dont on souhaite visualiser les infos
	 * @return Retourne l'objet compte demande.
	 */
	public Compte consulterCompte(String numeroCompte){
		Compte compteDemande = CompteDao.readCompteByNum(numeroCompte);
		return compteDemande;
	}
	
	/**
	 * Cette methode permet de mettre à jour les donnes du compte en banque à partir de son numero.
	 * @param compteAModifier L'objet compte dont on souhaite faire une modification.
	 * @param montant Le montant de la transaction effectué sur le compte.
	 */
	public void modifierCompte(String numeroCompte, float montant){
		CompteDao.updateCompteByNum(numeroCompte, montant);
	}
}
