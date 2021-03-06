package com.clementvincent2software.proxibanquesi.service.test;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Conseiller;
import com.clementvincent2software.proxibanquesi.service.ConseillerService;

public class ConseillerServiceTest {

	private static Conseiller conseillerTest, conseillerTest2, conseillerTest3;
	private static ConseillerService conseillerService;

	@BeforeClass
	public static void aFaireAvantLesTests() {
		conseillerTest = new Conseiller("Test", "test", "monsieur", "test", "password");
		conseillerTest2 = new Conseiller("Test", "test", "monsieur", "test2", "password");
		conseillerTest3 = new Conseiller("Test", "test", "monsieur", "test3", "password");
		conseillerService = new ConseillerService();
		conseillerService.creerConseiller(conseillerTest2);
		conseillerService.creerConseiller(conseillerTest3);

	}

	@Test
	public void testCreerConseiller() {
		boolean status;
		status = conseillerService.creerConseiller(conseillerTest);
		Assert.assertTrue(status);
	}

	@Test
	public void testModifierConseiller() {
		boolean status;
		conseillerTest.setNom("test1");
		status = conseillerService.modifierConseiller("test", conseillerTest);
		Assert.assertTrue(status);
	}

	@Test
	public void testSupprimerConseiller() {
		boolean status;
		status = conseillerService.supprimerConseiller(conseillerTest2.getLogin());
		Assert.assertTrue(status);

	}

	@Test
	public void testLireConseiller() {
		Conseiller conseiller;
		conseiller = conseillerService.lireConseiller(conseillerTest3.getLogin());
		Assert.assertNotNull(conseiller);
	}

	@AfterClass
	public static void aFaireApresLesTests() {
		conseillerService.supprimerConseiller(conseillerTest.getLogin());
		conseillerService.supprimerConseiller(conseillerTest3.getLogin());
	}
}
