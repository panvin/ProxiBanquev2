package com.clementvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.clementvincent2software.proxibanquesi.domaine.Compte;

/**
 * Classe CompteDao, permet la gestion des Comptes en base
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class CompteDao {
	
	/**
	 * Méthode permettant de créer en base un compte
	 * @param compte Objet compte
	 * @param typeCompte Type du compte Courant/Epargne
	 * @param idClient identifiant du client titulaire du futur compte
	 */
	public void createCompte(Compte compte, String typeCompte, int idClient) {
		// INfomration d'accès à la base de données
				String url = "jdbc:mysql://localhost/ProxiBanque";
				String login = "root";
				String passwd = "";
				Connection cn = null;
				Statement st = null;

				try {
					// Etape 1: chargement du driver
					Class.forName("com.mysql.jdbc.Driver");
					// Etape 2 : recuperation de la connexion
					cn = DriverManager.getConnection(url, login, passwd);
					// Etape 3 : Creation d'un statement
					st = cn.createStatement();
					String sql = "INSERT INTO Compte (type, numero, solde, dateouverture, idclient) VALUES ('" + typeCompte + "','" + compte.getNumero() + "','" + compte.getSolde() + "','" + compte.getDateOuverture() + "','" + idClient + "');";
					// Etape 4: Execution requête
					st.executeUpdate(sql);

				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						// Etape 5 : liberer une ressource de la memoire
						cn.close();
						st.close();

					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}

	/**
	 * Méthode permettant de modifier en base le solde d'un compte à partir du numéro de compte
	 * @param numCompte
	 * @param newSolde
	 */
	public void updateCompteByNum(String numCompte, float newSolde) {
		// INformation d'acces à la base de donnees
				String url = "jdbc:mysql://localhost/formation";
				String login = "root";
				String passwd = "";
				Connection cn = null;
				Statement st = null;

				try {
					// Etape 1: chargement du driver
					Class.forName("com.mysql.jdbc.Driver");
					// Etape 2 : recuperation de la connexion
					cn = DriverManager.getConnection(url, login, passwd);
					// Etape 3 : Creation d'un statement
					st = cn.createStatement();
					String sql = "UPDATE Compte SET solde = '" + newSolde + "' WHERE numero='"+numCompte+"';";
					// Etape 4: Execution requête
					st.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						// Etape 6 : liberer ressources de la memoire.
						cn.close();
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}
	
	/**
	 * Méthode permettant de supprimer en base un compte  à partir de son numéro
	 * @param numCompte numéro du compte à supprimer
	 */
	public void deleteCompteByNUm(String numCompte) {
		// INformation d'acces à la base de donnees
				String url = "jdbc:mysql://localhost/formation";
				String login = "root";
				String passwd = "";
				Connection cn = null;
				Statement st = null;

				try {
					// Etape 1: chargement du driver
					Class.forName("com.mysql.jdbc.Driver");
					// Etape 2 : recuperation de la connexion
					cn = DriverManager.getConnection(url, login, passwd);
					// Etape 3 : Creation d'un statement
					st = cn.createStatement();
					String sql = "DELETE FROM Compte WHERE numero ="+numCompte+";";
					// Etape 4: Execution requête
					st.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} finally {
					try {
						// Etape 5 : liberer ressources de la memoire.
						cn.close();
						st.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
	}
}
