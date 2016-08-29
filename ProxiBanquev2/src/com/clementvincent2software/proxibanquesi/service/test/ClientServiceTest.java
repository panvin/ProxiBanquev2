package com.clementvincent2software.proxibanquesi.service.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.domaine.Client;
import com.clementvincent2software.proxibanquesi.service.ClientService;

public class ClientServiceTest {
	
	Client client1;
	ClientService clientService;
	
	@Before
	public void avantChaqueTest(){
		
		client1 = new Client("Dupond", "Francois", "Mr", "duponf@proxibanque.com", "120 rue massena", "Lyon", "0102030405", "69003");
		clientService = new ClientService();
	}

	@Test
	public void testCreerClient() {
		
		boolean status;
		status = clientService.creerClient(client1);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testLireClient() {
		
		Client testClient;
		testClient = clientService.lireClient(1);
		Assert.assertEquals(testClient, client1);
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
		status = clientService.modificationClient(2, client1);
		Assert.assertTrue(status);
	}
	
	@Test
	public void testModificationClient2() {
		
		clientService.modificationClient(2, client1);
		Assert.assertEquals( clientService.lireClient(2), client1);
	}

	@Test
	public void testSuppressionClient() {
		
		boolean status = clientService.suppressionClient(client1);
		Assert.assertTrue(status);
		
	}

	@Test
	public void testLireTousLesCLients() {
		
		ArrayList<Client> listeClient;
		listeClient = clientService.lireTousLesCLients();
		Assert.assertNotNull(listeClient);
	}
}
