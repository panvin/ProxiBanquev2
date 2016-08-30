package com.clementvincent2software.proxibanquesi.service;

import com.clementvincent2software.proxibanquesi.dao.ConseillerDao;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;

public class ConseillerService {
	
	public boolean creerConseiller (Conseiller conseiller){
		boolean status;
		status = ConseillerDao.createConseiller(conseiller);
		return status;

	}
	
	public boolean modifierConseiller(String login, Conseiller conseiller){
		boolean status = ConseillerDao.updateConseillerByLogin(login, conseiller);
		return status;
	}
	
	public boolean supprimerConseiller(String login){
		boolean status;
		status = ConseillerDao.deleteConseillerByLogin(login);
		return status;	
	}
	
	public Conseiller lireConseiller(String login){
		Conseiller conseiller = ConseillerDao.readConseillerByLogin(login);
		return conseiller;
	}
}
