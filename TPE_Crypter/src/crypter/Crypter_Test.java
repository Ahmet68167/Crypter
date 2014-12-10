package crypter;

import static org.junit.Assert.*;

import org.junit.Test;

import crypter.exception.IllegalKeyException;

public class Crypter_Test {

	@Test //(expected = IllegalKeyException.class)
	public void Crypter_Caesar_Test() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Ka", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
		
		}

}
