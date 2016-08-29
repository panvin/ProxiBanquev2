package com.clementvincent2software.proxibanquesi.service.test;

import org.junit.Assert;
import org.junit.Test;

import com.clementvincent2software.proxibanquesi.service.AuthService;;

/**
 * Classe de test pour le service authentification
 * Cette classe va permettre de tester le service authentification dans plusieurs cas: lorsque le login et le password sont correct, lorsque le login est incorrect et lorsque le login est correct mais le password est incorrect.
 * @author Clement CASTRO et Vincent PANOUILLERES
 *
 */
public class AuthServiceTest {

	/**
	 * Ce test doit retourner un booleen true
	 */
	@Test
	public void testAuthConseiller() {
		String login ="ccastro";
		String pwd ="gtm";
		boolean status;
		
		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);
		
		Assert.assertTrue(status);		
	}
	
	/**
	 * Ce test doit retourner un booleen false car on donne au service d'authentification un conseiller qui n'existe pas
	 */
	@Test
	public void testAuthConseiller2() {
		String login ="azerty";
		String pwd ="1234";
		boolean status;
		
		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);
		
		Assert.assertFalse(status);		
	}
	
	/**
	 * Ce test doit retourner un booleen false car on donne au service d'authentification un conseiller qui existe mais dont le password est incorrect
	 */
	@Test
	public void testAuthConseiller3() {
		String login ="ccastro";
		String pwd ="1234";
		boolean status;
		
		AuthService servicePourTest = new AuthService();
		status = servicePourTest.authConseiller(login, pwd);
		
		Assert.assertFalse(status);		
	}
}
