package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Coordonn�es, repr�sente les coordon�es d'un client proxibanque
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
	 * M�thode permettant d'obtenir l'adresse 
	 * @return
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * M�thode permettant de modifier
	 * @param adresse
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * M�thode permettant d'obtenir
	 * @return
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * M�thode permettant de modifier
	 * @param ville
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * M�thode permettant d'obtenir
	 * @return
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * M�thode permettant de modifier
	 * @param telephone
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * M�thode permettant d'obtenir
	 * @return
	 */
	public String getCp() {
		return cp;
	}

	/**
	 * M�thode permettant de modifier
	 * @param cp
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}
	
	
}
