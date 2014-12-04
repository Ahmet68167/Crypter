package crypter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;
import crypter.iterable.IterableCrypter;

public class Test {

	public static void main(String[] args) {
	
		List<String> s = Arrays.asList("HALLO", "KLAUS", "AHMET");
		
		
		try {
			Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterFactory.Crypt.SUBSTITUTION);
			Crypter cae = CrypterFactory.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			Crypter um = CrypterFactory.createCrypter("", CrypterFactory.Crypt.REVERSE);
			Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CrypterFactory.Crypt.XOR);
			
			IterableCrypter c = new IterableCrypter(s, cae);
			IterableCrypter d = new IterableCrypter(new IterableCrypter(s, cae), um);
			
			for(String msg : c)
				System.out.println(msg);
			
			for(String msg : d)
				System.out.println(msg);
			
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
