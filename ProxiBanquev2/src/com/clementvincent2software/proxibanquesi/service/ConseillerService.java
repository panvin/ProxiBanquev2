package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ConseillerDao;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;

public class ConseillerService {
	
	public boolean creerConseiller (Conseiller conseiller){
		ConseillerDao.createConseiller(conseiller);
		return true;

	}
	
	public boolean modifierConseiller(String login, Conseiller conseiller){
		ConseillerDao.updateConseillerByLogin(login, conseiller);
		return true;
	}
	
	public boolean supprimerConseiller(String login){
		ConseillerDao.deleteConseillerByLogin(login);
		return false;	
	}
	
	public Conseiller lireConseiller(String login){
		Conseiller conseiller = ConseillerDao.readConseillerByLogin(login);
		return conseiller;
	}
}
