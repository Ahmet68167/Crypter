package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import crypter.Crypter;
import crypter.CrypterFactory;
import crypter.CrypterFactory.Crypt;
import crypter.exception.IllegalKeyException;

public class Crypter_Test {

	@Test //(expected = IllegalKeyException.class)
	public void Crypter_Caesar_KeyTest() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Ka", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
		
		}
	
	@Test
	public void Crypter_Caesar_KeyTest_Zeichen() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("/", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
		
	
	}
	
	@Test
	public void Crypter_SUB_KeyTest() {
		
	}
	
	@Test
	public void Crypter_SUB_KeyTest_Zeichen() {
		
	}
	
	@Test
	public void Crypter_SUB_KeyTest_zuKurz() {
		
	}
	
	@Test
	public void Crypter_SUB_KeyTest_zuLang() {
		
	}
	
	@Test
	public void Crypter_XOR_KeyTest() {
		
	}
	
	@Test
	public void Crypter_XOR_KeyTest_Zeichen() {
		
	}

}
