package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe abstraite Compte, repr�sente les comptes des clients de proxibanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public abstract class Compte {

	private String numero;
	private Float solde;
	private Date dateOuverture;
	
	/**
	 * Constructeur de la classe Compte
	 * @param numero
	 * @param solde
	 * @param dateOuverture
	 */
	public Compte(String numero, Float solde, Date dateOuverture) {
		super();
		this.numero = numero;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
	}

	/**
	 * M�thode permettant d'obtenir le num�ro du compte
	 * @return
	 */
	public String getNumero() {
		return numero;
	}

	/**
	 * M�thode permettant de modifier le num�ro du compte
	 * @param numero
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}

	/**
	 * M�thode permettant d'obtenir le solde du compte
	 * @return
	 */
	public Float getSolde() {
		return solde;
	}

	/**
	 * M�thode permettant de modifier le solde du compte
	 * @param solde
	 */
	public void setSolde(Float solde) {
		this.solde = solde;
	}

	/**
	 * M�thode permettant d'obtenir la date d'ouverture du compte
	 * @return
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * M�thode permettant de modifier la date d'ouverture du compte
	 * @param dateOuverture
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	
	
}
