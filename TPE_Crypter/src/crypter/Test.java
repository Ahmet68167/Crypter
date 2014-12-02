package crypter;

import java.util.Arrays;

import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;

public class Test {

	public static void main(String[] args) {
	
		CrypterFactory a = new CrypterFactory();
		
		try {
			CrypterFactory.Crypter sub = a.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterFactory.Crypt.SUBSTITUTION);
			CrypterFactory.Crypter cae = a.createCrypter("L", CrypterFactory.Crypt.CAESAR);
			CrypterFactory.Crypter um = a.createCrypter("", CrypterFactory.Crypt.REVERSE);
			CrypterFactory.Crypter xor = a.createCrypter("IAMTHEONEWHOKNOCKS", CrypterFactory.Crypt.XOR);
			
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
