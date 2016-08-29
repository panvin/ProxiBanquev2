package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ClientDao;
import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.clementvincent2software.proxibanquesi.domaine.Date;

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
			Date dateOuverture) {

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
	public boolean creerCompteCourant(Client client, String numero, float solde, Date dateOuverture) {
		if (client.getCompteCourant() == null) {
			CompteCourant compteCourantClient = new CompteCourant(numero, solde, dateOuverture, client);
			client.setCompteCourant(compteCourantClient);
			CompteDao.createAccount(compteCourantClient, "Courant", client.getId());
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
	public boolean creerCompteEpargne(Client client, String numero, float soldeDepart, Date dateOuverture) { 
		if (client.getCompteEpargne() == null) {
			CompteEpargne compteEpargneClient = new CompteEpargne(numero, soldeDepart, dateOuverture, client);
			client.setCompteEpargne(compteEpargneCLient);
			CompteDao.createAccount(compteEpargneClient, "Epargne", client.getId());
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
	public void virementCompteACompte(Compte compteADebiter, Compte compteACrediter, float montant){
		if (compteADebiter instanceof CompteCourant && compteADebiter.getSolde() - montant < ((CompteCourant) compteADebiter).getValeurDecouvert()){
			System.out.println("Le compte a debiter a un decouvert trop important. Virement annule.");
		}
		else {
		compteADebiter.setSolde(compteADebiter.getSolde() - montant);		
		compteACrediter.setSolde(compteACrediter.getSolde() + montant);
		}
	}
	
	public void supprimerCompte(){
		
	}
	
	public Compte consulterCompte(String numeroCompte){
		Compte compteDemande = CompteDao.getAccountByNumber(numeroCompte);
		return compteDemande;
	}
}
