package com.clementvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

import com.clementvincent2software.proxibanquesi.domaine.Client;

/**
 * Classe ClientDao
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ClientDao {

	/**
	 * Méthode permettant la création d'un nouveau client en base
	 * @param client
	 */
	public static void createClient(Client client) {
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
			String sql = "INSERT INTO Client(nom, prenom, civilite, email, id, idconseiller) VALUES ('" + client.getNom() + "','" + client.getPrenom() + "','" + client.getCivilite() + "','" + client.getEmail() + "','" + client.getId() + "','" + client.getMonConseiller() + "');";
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
	 * 
	 */
	public static Collection<Client> readAllClient() {
		// INformation d'acces à la base de donnees
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Collection<Client> collection = new ArrayList<Client>();
		String nomClient, prenomClient, civiliteClient;
		int idClient;

		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM client";
			// Etape 4: Execution requête
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomClient = rs.getString("nom");
				prenomClient = rs.getString("prenom");
				civiliteClient = rs.getString("civilite");
				idClient = rs.getInt("id");
				collection.add(new Client(nomClient, prenomClient, civiliteClient, idClient));
			}

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
		return collection;
	}


}
