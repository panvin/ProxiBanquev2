package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Coordonnées, représente les coordonées d'un client proxibanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class Coordonnees {

	private String adresse;
	private String ville;
	private String telephone;
	private String cp;
	
	/**
	 * Constructeur de la classe Coordonnees
	 * @param adresse
	 * @param ville
	 * @param telephone
	 * @param cp
	 */
	public Coordonnees(String adresse, String ville, String telephone, String cp) {
		super();
		this.adresse = adresse;
		this.ville = ville;
		this.telephone = telephone;
		this.cp = cp;
	}

	/**
	 * Méthode permettant d'obtenir l'adresse 
	 * @return
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * Méthode permettant de modifier
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Méthode permettant d'obtenir
	 * @return
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * Méthode permettant de modifier
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Méthode permettant d'obtenir
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * Méthode permettant de modifier
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Méthode permettant d'obtenir
	 * @return
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * Méthode permettant de modifier
	 * @param cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
}
