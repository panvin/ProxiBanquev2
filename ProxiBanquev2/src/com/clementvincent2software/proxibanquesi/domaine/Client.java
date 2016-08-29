package com.clementvincent2software.proxibanquesi.domaine;

/**
 * Classe Client, repr�sente les Clients de ProxiBanque
 * @author Clement CASTRO et Vincent PANOUILLERES
 */
public class Client extends Personne {
	
	private String email;
	private Coordonnees coordonnees;
	private CompteEpargne compteEpargne;
	private CompteCourant compteCourant;
	
	

	/**
	 * Constructeur de la classe Client
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @param email
	 * @param adresse
	 * @param ville
	 * @param telephone
	 * @param cp
	 * @param compteEpargne
	 * @param compteCourant
	 */
	public Client(String nom, String prenom, String civilite, String email, String adresse, String ville, String telephone, String cp, 
			CompteEpargne compteEpargne, CompteCourant compteCourant) {
		super(nom, prenom, civilite);
		this.email = email;
		this.coordonnees =  new Coordonnees(adresse, ville, telephone, cp);
		this.compteEpargne = compteEpargne;
		this.compteCourant = compteCourant;
	}
	
	/**
	 * Constructeur de la classe Client avec compte epargne et courant null
	 * @param nom
	 * @param prenom
	 * @param civilite
	 * @param email
	 * @param adresse
	 * @param ville
	 * @param telephone
	 * @param cp
	 */
	public Client(String nom, String prenom, String civilite, String email, String adresse, String ville, String telephone, String cp) {
		super(nom, prenom, civilite);
		this.email = email;
		this.coordonnees =  new Coordonnees(adresse, ville, telephone, cp);
		this.compteEpargne = null;
		this.compteCourant = null;
	}

	/**
	 * Constructeur de la classe Client
	 * @param nom
	 * @param prenom
	 * @param civilite
	 */
	public Client(String nom, String prenom, String civilite) {
		super(nom, prenom, civilite);
	}

	/**
	 * M�thode permettant d'obtenir l'Email du Client
	 * @return
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * M�thode permettant de modifier l'Email du Client
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * M�thode permettant d'obtenir les coordonn�es du Client
	 * @return
	 */
	public Coordonnees getCoordonnees() {
		return coordonnees;
	}

	/**
	 * M�thode permettant de modifier les coordonn�es du Client
	 * @param coordonnees
	 */
	public void setCoordonnees(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	/**
	 * M�thode permettant d'obtenir les informations du compte epargne du Client
	 * @return
	 */
	public CompteEpargne getCompteEpargne() {
		return compteEpargne;
	}

	/**
	 * M�thode permettant de modifier les informations du compte epargne du Client
	 * @param compteEpargne
	 */
	public void setCompteEpargne(CompteEpargne compteEpargne) {
		this.compteEpargne = compteEpargne;
	}

	/**
	 * M�thode permettant d'obtenir les informations du compte courant du Client
	 * @return
	 */
	public CompteCourant getCompteCourant() {
		return compteCourant;
	}

	/**
	 * M�thode permettant de modifier les informations du compte courant du Client
	 * @param compteCourant
	 */
	public void setCompteCourant(CompteCourant compteCourant) {
		this.compteCourant = compteCourant;
	}
	
	
	
}
