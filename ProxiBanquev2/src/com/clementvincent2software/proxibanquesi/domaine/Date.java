package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Date, repr�sente la date de cr�ation d'un compte client
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
	 * M�thode permettant d'obtenir le jour de cr�ation du compte
	 * @return
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * M�thode permettant de modifier le jour de cr�ation du compte
	 * @param jour
	 */
	public void setJour(int jour) {
		this.jour = jour;
	}

	/**
	 * M�thode permettant d'obtenir le mois de cr�ation du compte
	 * @return
	 */
	public String getMois() {
		return mois;
	}

	/**
	 * M�thode permettant de modifier le mois de cr�ation du compte
	 * @param mois
	 */
	public void setMois(String mois) {
		this.mois = mois;
	}

	/**
	 * M�thode permettant d'obtenir l'ann�e de cr�ation du compte
	 * @return
	 */
	public int getAnnee() {
		return annee;
	}

	/**
	 * M�thode permettant de modifier l'ann�e de cr�ation du compte
	 * @param annee
	 */
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	
	
	
}
