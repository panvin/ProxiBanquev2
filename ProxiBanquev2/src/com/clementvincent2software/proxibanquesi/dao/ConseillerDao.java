package com.clementvincent2software.proxibanquesi.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;

public class ConseillerDao {
	
	/**
	 * M�thode permettant la cr�ation d'un nouveau client en base
	 * @param client
	 */
	public static void createConseiller(Conseiller conseiller) {
		// INfomration d'acc�s � la base de donn�es
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
			String sql = "INSERT INTO Conseiller(nom, prenom, civilite, login, password) VALUES ('" + conseiller.getNom() + "','" + conseiller.getPrenom() + "','" + conseiller.getCivilite() + "','" + conseiller.getLogin() + "','" + conseiller.getPassword() + "');";
			// Etape 4: Execution requ�te
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

	public static Collection<Conseiller> readAllConseiller() {
		// INformation d'acces � la base de donnees
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Collection<Conseiller> collection = new ArrayList<Conseiller>();
		String nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller;
	
		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM conseiller";
			// Etape 4: Execution requ�te
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomConseiller = rs.getString("nom");
				prenomConseiller = rs.getString("prenom");
				civiliteConseiller = rs.getString("civilite");
				loginConseiller = rs.getString("login");
				passwordConseiller = rs.getString("password");
				collection.add(new Conseiller(nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller));
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

	public static Conseiller readConseillerByLogin() {
		// INformation d'acces � la base de donnees
		String url = "jdbc:mysql://localhost/formation";
		String login = "root";
		String passwd = "";
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		Conseiller conseiller = null;
		String nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller;
		
	
		try {
			// Etape 1: chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : recuperation de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Creation d'un statement
			st = cn.createStatement();
			String sql = "SELECT * FROM conseiller WHERE login=";
			// Etape 4: Execution requ�te
			rs = st.executeQuery(sql);
			// Etape 5 : Parcours de resultset
			while (rs.next()) {
				nomConseiller = rs.getString("nom");
				prenomConseiller = rs.getString("prenom");
				civiliteConseiller = rs.getString("civilite");
				loginConseiller = rs.getString("login");
				passwordConseiller = rs.getString("password");
				conseiller = new Conseiller(nomConseiller, prenomConseiller, civiliteConseiller, loginConseiller, passwordConseiller);
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
		return conseiller;
	}
}