package crypter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crypter.CrypterFactory.IterableCrypter;
import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;

public class Test {

	public static void main(String[] args) {
	
		CrypterFactory a = new CrypterFactory();
		List<String> s = Arrays.asList("HALLO", "KLAUS", "AHMET");
		
		
		try {
			Crypter sub = a.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterFactory.Crypt.SUBSTITUTION);
			Crypter cae = a.createCrypter("L", CrypterFactory.Crypt.CAESAR);
			Crypter um = a.createCrypter("", CrypterFactory.Crypt.REVERSE);
			Crypter xor = a.createCrypter("IAMTHEONEWHOKNOCKS", CrypterFactory.Crypt.XOR);
			
			IterableCrypter c = new IterableCrypter(new IterableCrypter(s, um), cae);
			
			try {
				System.out.println(sub.decrypt(cae.decrypt(um.decrypt(xor.decrypt("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X")))));

			} catch (CrypterException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			
			e.printStackTrace();
		}
		
		
		// QOZEG]A[UXDKZIZLAB\NUQIO^^RXYHADV[EFFJ\\[\U_]YDVZABDZT\V\SKB@X

	}

}
