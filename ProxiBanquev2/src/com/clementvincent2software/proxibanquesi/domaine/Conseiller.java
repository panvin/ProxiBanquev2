package com.clementvincent2software.proxibanquesi.domaine;

import java.util.List;

/**
 * Classe Conseiller, repr�sente les Conseillers de ProxiBanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
public class Conseiller extends Personne {
	
	private String login;
	private String password;
	private List<Client> clients;

	/**
	 * Constructeur de la classe Conseiller
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @param login
	 * @param password
	 * @param clients
	 */
	public Conseiller(String nom, String prenom, String civilite, String login, String password, List<Client> clients) {
		super(nom, prenom, civilite);
		this.login = login;
		this.password = password;
		this.clients = clients;
	}
	
	/**
	 * Constructeur de la classe Conseiller
	 * @param nom
	 * @param prenom
	 * @param civilite
	 */
	public Conseiller(String nom, String prenom, String civilite) {
		super(nom, prenom, civilite);
	}

	/**
	 * M�thode permettant d'obtenir le Login du Conseiller
	 * @return
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * M�thode permettant de modifier le Login du Conseiller
	 * @param login
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * M�thode permettant d'obtenir le mot de passe du Conseiller
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * M�thode permettant de modifier le mot de passe du Conseiller
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * M�thode permettant d'obtenir la Liste des Clients du Conseiller
	 * @return
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * M�thode permettant de modifier la liste des Clients du Conseiller
	 * @param clients
	 */
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
}
