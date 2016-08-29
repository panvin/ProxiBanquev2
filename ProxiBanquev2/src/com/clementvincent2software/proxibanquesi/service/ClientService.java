package com.clementvincent2software.proxibanquesi.service;

import java.util.ArrayList;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.dao.ClientDao;

/**
 * Classe du domaine service qui concerne l'ensemble des services Clients
 * Cette classe va permettre de: modifier, supprimer, creer, lire unclient et egalement d'obtenir la liste de tous les clients.
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class ClientService {
	
	public boolean creerClient (Client client){
		ClientDao.createClient(client);
		return true;

	}
	
	public boolean modificationClient(int id, Client client){
		ClientDao.updateClientById(id, client);
		return true;
	}
	
	public boolean suppressionClient(int id){
		ClientDao.deleteClientById(id);
		return false;
		
	}
	
	public Client lireClient(int id){
		Client client = ClientDao.readClientById(id);
		return client;
	}
	
	public ArrayList<Client> lireTousLesCLients(){
		ArrayList<Client> listeClient;
		listeClient = (ArrayList<Client>) ClientDao.readAllClient();
		return listeClient;
	}
	
	

}
