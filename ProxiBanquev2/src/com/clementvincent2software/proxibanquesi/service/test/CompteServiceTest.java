package com.clementvincent2software.proxibanquesi.service.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.clementvincent2software.proxibanquesi.service.CompteService;

 public class CompteServiceTest {

	private static Compte compteEpargne, compteCourant, compteCourant2;
	private static CompteService compteService;
	private static Client client, client2;
	
	@BeforeClass
	public static void avantChaqueTest(){
		
		compteService = new CompteService();
		compteEpargne = new CompteEpargne("01234", (float)152000, "15/02/2016");
		compteCourant = new CompteCourant("012345", (float)152000, "15/02/2016");
		compteCourant2 = new CompteCourant("012346", (float)152000, "15/02/2016");
		client = new Client("dupond", "toto", "monsieur", "test@test.com", 1500);
		client2 = new Client("test", "test", "madame", "test@test.com", 1501);
		compteService.ajouterCompte( client, "Courant", "1357", (float) 12000, "15/02/2016");
		compteService.ajouterCompte( client, "Epargne", "2468", (float) 15000, "15/02/2016");
	}
		
	@Test
	public void testAjouterCompte() {
		boolean status;
		status = compteService.ajouterCompte( client2, "Epargne", compteEpargne.getNumero(), compteEpargne.getSolde(), compteEpargne.getDateOuverture());
		Assert.assertTrue(status);
	}
	
	@Test
	public void testSupprimerCompteParNumero() {
		boolean status;
		compteService.ajouterCompte( client, "Courant", compteCourant.getNumero(), compteCourant.getSolde(), compteCourant.getDateOuverture());
		status = compteService.supprimerCompte(compteCourant.getNumero());
		Assert.assertTrue(status);
	}
	
	@Test
	public void testSupprimerCompteParClient(){
		boolean status;
		compteService.ajouterCompte( client2, "Courant", compteCourant2.getNumero(), compteCourant2.getSolde(), compteCourant2.getDateOuverture());
		status = compteService.supprimerCompteParClient(1501);
		Assert.assertTrue(status);
	}
	
	@AfterClass
	public static void apresLesTests(){
		compteService.supprimerCompteParClient(1501);
		compteService.supprimerCompteParClient(1500);		
	}
}
