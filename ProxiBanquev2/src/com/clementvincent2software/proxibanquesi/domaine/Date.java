package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Date, représente la date de création d'un compte client
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class Date {
	
	private int jour;
	private String mois;
	private int annee;
	
	/**
	 * Constructeur de la classe Date
	 * @param jour
	 * @param mois
	 * @param annee
	 */
	public Date(int jour, String mois, int annee) {
		super();
		this.jour = jour;
		this.mois = mois;
		this.annee = annee;
	}

	/**
	 * Méthode permettant d'obtenir le jour de création du compte
	 * @return
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * Méthode permettant de modifier le jour de création du compte
	 * @param jour
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * Méthode permettant d'obtenir le mois de création du compte
	 * @return
	 */
	public String getMois() {
		return mois;
	}

	/**
	 * Méthode permettant de modifier le mois de création du compte
	 * @param mois
	 */
	public void setMois(String mois) {
		this.mois = mois;
	}

	/**
	 * Méthode permettant d'obtenir l'année de création du compte
	 * @return
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * Méthode permettant de modifier l'année de création du compte
	 * @param annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	
}
