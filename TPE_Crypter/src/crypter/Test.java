package crypter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;
import crypter.iterable.IterableCrypter;
import crypter.iterable.IterableDecrypter;

public class Test {

	public static void main(String[] args) {
	
		List<String> s = Arrays.asList("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X");
		List<String> t = Arrays.asList("PMMBI", "TVBML", "UFNIB");
		
		try {
			Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterFactory.Crypt.SUBSTITUTION);
			Crypter cae = CrypterFactory.createCrypter("L", CrypterFactory.Crypt.CAESAR);
			Crypter um = CrypterFactory.createCrypter("", CrypterFactory.Crypt.REVERSE);
			Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CrypterFactory.Crypt.XOR);
			
			IterableDecrypter c = new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(s, xor), um), cae), sub);
			
			for(String msg : c)
				System.out.println(msg);
	
		} catch (IllegalKeyException e) {
			
			e.printStackTrace();
		}
		
		
		// QOZEG]A[UXDKZIZLAB\NUQIO^^RXYHADV[EFFJ\\[\U_]YDVZABDZT\V\SKB@X

	}

}
