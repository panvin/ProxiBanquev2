package com.clementvincent2software.proxibanquesi.domaine;

/**
 *  Classe CompteEpargne, représente le compte epargne d'un client proxibanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteEpargne extends Compte {

	private Client titulaire;

	/**
	 *  Constructeur de la classe CompteEpargne
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 * @param titulaire
	 */
	public CompteEpargne(String numero, Float solde, String dateOuverture, Client titulaire) {
		super(numero, solde, dateOuverture);
		this.titulaire = titulaire;
	}

	/**
	 * Constructeur de la classe CompteEpargne
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteEpargne(String numero, Float solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
	}

	/**
	 * Méthode permettant d'obtenir le titulaire du CompteEpargne
	 * @return
	 */
	public Client getTitulaire() {
		return titulaire;
	}

	/**
	 * Méthode permettant de modifier le titulaire du CompteEpargne
	 * @param titulaire
	 */
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
	
	
}
