package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe CompteCourant, repr�sente le compte courant d'un client proxibanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteCourant extends Compte {

	private Client titulaire;

	/**
	 * Constructeur de la classe CompteCourant
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 * @param titulaire
	 */
	public CompteCourant(String numero, Float solde, String dateOuverture, Client titulaire) {
		super(numero, solde, dateOuverture);
		this.titulaire = titulaire;
	}

	/**
	 * Constructeur de la classe CompteCourant
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public CompteCourant(String numero, Float solde, String dateOuverture) {
		super(numero, solde, dateOuverture);
		// TODO Auto-generated constructor stub
	}

	/**
	 * M�thode permettant d'obtenir le titulaire du CompteCourant
	 * @return
	 */
	public Client getTitulaire() {
		return titulaire;
	}

	/**
	 * M�thode permettant de modifier le titulaire du CompteCourant
	 * @param titulaire
	 */
	public void setTitulaire(Client titulaire) {
		this.titulaire = titulaire;
	}
	
	
}
