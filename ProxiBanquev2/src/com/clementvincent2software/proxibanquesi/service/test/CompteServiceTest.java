package com.clementvincent2software.proxibanquesi.service.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Compte;
import com.clementvincent2software.proxibanquesi.domaine.CompteCourant;
import com.clementvincent2software.proxibanquesi.domaine.CompteEpargne;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;
import com.clementvincent2software.proxibanquesi.domaine.Date;
import com.clementvincent2software.proxibanquesi.service.ClientService;
import com.clementvincent2software.proxibanquesi.service.CompteService;

public class CompteServiceTest {

	private Compte compteEpargne, compteCourant;
	private CompteService compteService;
	
	@Before
	public void avantChaqueTest(){
		
		compteService = new CompteService();
		compteEpargne = new CompteEpargne("01234", (float)152000, new Date(15,"fevrier", 2016));
		compteCourant = new CompteCourant("01234", (float)152000, new Date(15,"fevrier", 2016));
	}
	
	
	@Test
	public void testAjouterCompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreerCompteCourant() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreerCompteEpargne() {
		fail("Not yet implemented");
	}

	@Test
	public void testVirementCompteACompte() {
		fail("Not yet implemented");
	}

	@Test
	public void testSupprimerClient() {
		fail("Not yet implemented");
	}

	@Test
	public void testConsulterCompte() {
		fail("Not yet implemented");
	}

}
