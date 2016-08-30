package com.clementvincent2software.proxibanquesi.service.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.clementvincent2software.proxibanquesi.service.CompteService;

/**
 * Classe de test de la classe Service compte (CompteService.java)
 * Cette classe regroupe l'ensemble des m�thodes de tests unitaires r�alis�es surles m�thodes de la classe Compte service
 * @author Clement CASTRO et VIncent PANOUILLERES
 *
 */
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
		client = new Client("dupond", "toto", "monsieur", 2);
		client2 = new Client("test", "test", "madame", 4);
		compteService.ajouterCompte( client, "Courant", "1357", (float) 12000, "15/02/2016");
		compteService.ajouterCompte( client, "Epargne", "2468", (float) 15000, "15/02/2016");
	}
		
	@Test
	public void testAjouterCompte() {
		boolean status;
		status = compteService.ajouterCompte( client, "Epargne", compteEpargne.getNumero(), compteEpargne.getSolde(), compteEpargne.getDateOuverture());
		Assert.assertTrue(status);
	}

	@Test
	public void testCreerCompteCourant() {
		boolean status;
		status = compteService.creerCompteCourant(client2, "1234567", (float) 12500, "15/02/2016");
		Assert.assertTrue(status);
	}
	
	@Test
	public void testCreerCompteEpargne() {
		boolean status;
		status = compteService.creerCompteEpargne(client2, "1247893654", (float) 12500, "15 fevrier 2016");
		Assert.assertTrue(status);
	}

	@Test
	public void testVirementCompteACompte() {
		boolean status;
		status = compteService.virementCompteACompte("1357", "2468", (float) 140);
		Assert.assertTrue(status);
	}
	
	@Test
	 public void testVirementCompteACompte2() {
		boolean status;
		status = compteService.virementCompteACompte("1357", "2468", (float) 140);
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
		status = compteService.supprimerCompteParClient(4);
		Assert.assertTrue(status);
	}

	@Test
	public void testConsulterCompte() {
		Compte compteTest;
		compteTest = compteService.consulterCompte("01234");
		Assert.assertNotNull(compteTest);
	}
	
	@After
	public void apresLesTests(){
		compteService.supprimerCompteParClient(4);
		compteService.supprimerCompteParClient(2);
		
	}
}
