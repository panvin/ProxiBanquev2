package com.clementvincent2software.proxibanquesi.service.test;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.domaine.Conseiller;
import com.clementvincent2software.proxibanquesi.service.ClientService;

public class ClientServiceTest {
	
	Client clientTest;
	Conseiller conseillerTest;
	ClientService clientService;
	
	@Before
	public void avantChaqueTest(){
		
		conseillerTest = new Conseiller("responsable", "antoine", "monsieur", "login", "password");
		clientTest = new Client("dupond", "toto", "monsieur", "asez@fr.com", "120 rue factice", "Lyon", "0102030405", "69003", 1, conseillerTest, null, null);
		clientService = new ClientService();
	}

	@Test
	public void testCreerClient() {
		
		boolean status;
		status = clientService.creerClient(clientTest);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testLireClient() {
		
		Client testClient;
		testClient = clientService.lireClient(1);
		Assert.assertEquals(testClient, clientTest);
	}
	
	@Test
	public void testLireClient2() {
		
		Client testClient;
		testClient = clientService.lireClient(1);
		Assert.assertNotNull(testClient);
	}
	

	@Test
	public void testModificationClient() {
		
		boolean status; 
		status = clientService.modifierClient(2, clientTest);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testModificationClient2() {
		
		clientService.modifierClient(2, clientTest);
		Assert.assertEquals( clientService.lireClient(2), clientTest);
	}

	@Test
	public void testSuppressionClient() {
		
		boolean status = clientService.suppressionClient(clientTest.getId());
		Assert.assertTrue(status);
		
	}

	@Test
	public void testLireTousLesCLients() {
		
		ArrayList<Client> listeClient;
		listeClient = clientService.lireTousLesCLients();
		Assert.assertNotNull(listeClient);
	}
}
