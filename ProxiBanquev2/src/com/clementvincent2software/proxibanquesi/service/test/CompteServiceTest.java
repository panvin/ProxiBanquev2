package com.clementvincent2software.proxibanquesi.service.test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.clementvincent2software.proxibanquesi.service.CompteService;

/**
 * Classe de test de la classe Service compte (CompteService.java)
 * Cette classe regroupe l'ensemble des méthodes de tests unitaires réalisées surles méthodes de la classe Compte service
 * @author Clement CASTRO et VIncent PANOUILLERES
 *
 */
public class CompteServiceTest {

	private Compte compteEpargne, compteCourant;
	private CompteService compteService;
	private Client client;
	
	/**
	 * Methode a realiser avant chaque test. Elle va créer mettre en memoire des données pour les tests: une instance d'un compte epargne, une instance d'un compte courant, une instance d'un service compte.
	 */
	@Before
	public void avantChaqueTest(){
		
		compteService = new CompteService();
		compteEpargne = new CompteEpargne("01234", (float)152000, "15 fevrier 2016");
		compteCourant = new CompteCourant("01234", (float)152000, "15 fevrier 2016");
		client = new Client("dupond", "jean", "monsieur", 4);
	}
		
	/**
	 * Teste l'ajout de compte
	 */
	@Test
	public void testAjouterCompte() {
		boolean status;
		status = compteService.ajouterCompte( client, "Epargne", compteEpargne.getNumero(), compteEpargne.getSolde(), compteEpargne.getDateOuverture());
		Assert.assertTrue(status);
	}

//	/**
//	 * Teste la creation de compte courant
//	 */
//	@Test
//	public void testCreerCompteCourant() {
//		boolean status;
//		status = compteService.creerCompteCourant(client, "1234567", (float) 12500, new Date(15,"fevrier", 2016));
//		Assert.assertTrue(status);
//	}
//	
//	/**
//	 *  Teste la creation de compte epargne
//	 */
//	@Test
//	public void testCreerCompteEpargne() {
//		boolean status;
//		status = compteService.creerCompteEpargne(client, "1247893654", (float) 12500, "15 fevrier 2016"));
//		Assert.assertTrue(status);
//	}

//	/**
//	 * Teste le virement compte a compte
//	 */
//	@Test
//	public void testVirementCompteACompte() {
//		float soldeInitial = compteEpargne.getSolde();
//		compteService.virementCompteACompte(compteEpargne, compteCourant, 140);
//		Assert.assertTrue(soldeInitial>compteEpargne.getSolde());
//	}
//	
//	public void testVirementCompteACompte2() {
//		float soldeInitial = compteEpargne.getSolde();
//		compteService.virementCompteACompte(compteEpargne, compteCourant, 140);
//		Assert.assertTrue(soldeInitial == (compteEpargne.getSolde()+140));
//	}
//	
//	public void testVirementCompteACompte3() {
//		float soldeInitial = compteCourant.getSolde();
//		compteService.virementCompteACompte(compteEpargne, compteCourant, 140);
//		Assert.assertTrue(soldeInitial<compteCourant.getSolde());
//	}
//	
//	public void testVirementCompteACompte4() {
//		float soldeInitial = compteCourant.getSolde();
//		compteService.virementCompteACompte(compteEpargne, compteCourant, 140);
//		Assert.assertTrue(soldeInitial == (compteEpargne.getSolde() - 140));
//	}

	@Test
	public void testSupprimerClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterCompte() {
		fail("Not yet implemented");
	}

}
