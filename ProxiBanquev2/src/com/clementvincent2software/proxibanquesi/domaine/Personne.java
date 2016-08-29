package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Personne, représente les personnes qui interviennent dans le SI
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
public abstract class Personne {
	
	private String nom;
	private String prenom;
	private String civilite;
	
	/**
	 * Constructeur de la classe Personne
	 * @param nom nom de la personne
	 * @param prenom prenom de la personne
	 * @param civilite civilité de la personne (Homme/Femme)
	 */
	public Personne(String nom, String prenom, String civilite) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.civilite = civilite;
	}

	/**
	 * Méthode permettant d'obtenir le nom de la personne
	 * @return
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * Méthode permettant de modifier le nom de la personne
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Méthode permettant d'obtenir le prenom de la personne
	 * @return
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Méthode permettant de modifier le prenom de la personne
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Méthode permettant d'obtenir la civilité de la personne
	 * @return
	 */
	public String getCivilite() {
		return civilite;
	}

	/**
	 * Méthode permettant de modifier la civilité de la personne
	 * @param civilite
	 */
	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	
	
}
