package com.clementvincent2software.proxibanquesi.service;

import java.util.ArrayList;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.dao.ClientDao;

public class ClientService {
	
	public boolean creerClient (Client client){
		
		ClientDao.createClient(client);
		
		return false;
	}
	
	public boolean modificationClient(int id, Client client){
		return false;
		
	}
	
	public boolean suppressionClient(Client client){
		return false;
		
	}
	
	public Client lireClient(int i){
		
		return null;
	}
	
	public ArrayList<Client> lireTousLesCLients(){
		
		return null;
	}
	
	

}
