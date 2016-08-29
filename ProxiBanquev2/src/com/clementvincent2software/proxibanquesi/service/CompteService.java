package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ClientDao;
import com.clementvincent2software.proxibanquesi.dao.CompteDao;
import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;

/**
 * Classe de la couche service d�di� � tout ce qui concerne les comptes.
 * Cette classe permet de traiter les comptes clients: ajouter des comptes (cr�er), modifier des comptes, supprimer des comptes, consulter des comptes. 
 * Ce service permet egalement de r�aliser des virements comptes � comptes entre les clients de l'etablissment. 
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteService {
	
	/**
	 * Cette methode permet d'ajouter un compte � un client existant
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
	 * Cette methode permet de creer un compte courant � partir des infos clients
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
	 * Cette methode permet de creer un compte Epargne � partir des infos clients
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
	
	
	/** Cette methode permet de realiser un virement compte � compte au sein de la banque
	 * @param compteADebiter Le compte � debiter
	 * @param compteACrediter Le compte � crediter
	 * @param montant Le montant du virement.
	 */
	public void virementCompteACompte(String numCompteADebiter, String numCompteACrediter, float montant){
		
		float soldeCompteADebiter = CompteDao.readCompteByNum(numCompteADebiter).getSolde() - montant;
		float soldeCompteACrediter = CompteDao.readCompteByNum(numCompteACrediter).getSolde() + montant;

		CompteDao.updateCompteByNum(numCompteADebiter, soldeCompteADebiter);
		CompteDao.updateCompteByNum(numCompteACrediter, soldeCompteACrediter);
	}
	
	/**
	 * Cette m�thode permet de supprimer un compte de la base de donn�e � partir du numero de compte
	 * @param numeroCompte Le numero du compte � supprimer.
	 */
	public void supprimerCompte(String numeroCompte){
		CompteDao.deleteCompteByNum(numeroCompte);		
	}
	
	/**
	 * Cette m�thode permet de consulter les informations relatives � un compte et de les retourner sous forme d'objet Compte
	 * @param numeroCompte Le numero de compte dont on souhaite visualiser les infos
	 * @return Retourne l'objet compte demande.
	 */
	public Compte consulterCompte(String numeroCompte){
		Compte compteDemande = CompteDao.readCompteByNum(numeroCompte);
		return compteDemande;
	}
	
	/**
	 * Cette methode permet de mettre � jour les donnes du compte en banque � partir de son numero.
	 * @param compteAModifier L'objet compte dont on souhaite faire une modification.
	 * @param montant Le montant de la transaction effectu� sur le compte.
	 */
	public void modifierCompte(String numeroCompte, float montant){
		CompteDao.updateCompteByNum(numeroCompte, montant);
	}
}
