package crypter;

import static org.junit.Assert.*;

import org.junit.Test;

import crypter.exception.IllegalKeyException;

public class Crypter_Test {

	@Test
	public void Crypter_Caesar_Test() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("K", CrypterFactory.Crypt.CAESAR);
		} catch(IllegalKeyException e) {
			
		} finally {
			fail();
		}
		
		}

}
