package crypter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;

/**
 * Beinhaltet die Verschluesselungsmethoden und die CreateCrypter Methode,
 * Die CreateCrypter Methode gibt ein Verschluesselungsverfahren mit dem uebergebenen
 * Schluessel zurueck
 *
 */
public class CrypterFactory {
	
	/**
	 * Ansammlung der Verschluesselungsmethoden
	 * CAESAR
	 * SUBSTITUTION
	 * REVERSE
	 * XOR
	 * NULL
	 *
	 */
	public enum Crypt {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}
	
	/**
	 * @param key - Schluessel mit dem das Wort verschluesselt bzw. entschluesselt wird
	 * @param chiffre - Verschluesselungsmethode
	 * @return eine Verschluesselungsmethode
	 * @throws IllegalKeyException - wird bei einem ungueltigen Key geworfen
	 */
	public static Crypter createCrypter(String key, Crypt chiffre) throws IllegalKeyException {

		if(chiffre == Crypt.CAESAR) {
			if(key.length() != 1 || key.charAt(0) < 65 || key.charAt(0) > 90) 
				throw new IllegalKeyException();
			
			return new CrypterCaesar(key);
			
		} else if(chiffre == Crypt.SUBSTITUTION) {
			char[] keys = new char[26];
			char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z' };
			
			if(key.length() > 26)
				throw new IllegalKeyException();
			
			for(int i = 0; i < key.length(); i++) {
				keys[i] = key.charAt(i);
			}
			
			Arrays.sort(keys);
			
			if(!Arrays.equals(alphabet, keys))
				throw new IllegalKeyException();
			
			return new CrypterSubstitution(key);
			
		} else if(chiffre == Crypt.XOR) {
			if(!key.matches("([A-Z]|[@]|[\\[]|[\\]]|[\\\\]|[_]|[\\^])*"))
				throw new IllegalKeyException();
			
			return new CrypterXOR(key);
			
		} else if(chiffre == Crypt.REVERSE) {
			
			return new CrypterReverse();
			
		} else if(chiffre == Crypt.NULL) {
			
			return new CrypterNull();
			
		} else
			
			return null;
	}
	
	/**
	 * Legt ein CrypterCaesar mit einem Schluessel an, um die 
	 * Caesar-Verschluesselung anzuwenden.
	 * 
	 * Beinhaltet encrypt(String); encrypt(List); decrypt(String); decrypt(List)
	 *
	 */
	private static class CrypterCaesar implements Crypter {
		
		private String key;
		
		/**
		 * Legt einen CrypterCaesar mit dem entsprechenden Schluessel an.
		 * 
		 * @param key - Schluessel, mit dem das Verfahren durchgefuehrt werden soll.
		 */
		private CrypterCaesar(String key) {
			this.key = key;
		}

		@Override
		public String encrypt(String message) throws CrypterException {
			String txt = "";
			
			for(int i = 0; i < message.length(); i++) {
				
				if(message.charAt(i) + key.charAt(0) - 64 > 90)
					txt += (char) (message.charAt(i) + key.charAt(0) - 64 - 26);
				else
					txt += (char) (message.charAt(i) + key.charAt(0) - 64);
			}
			
			return txt;
		}

		@Override
		public List<String> encrypt(List<String> messages)
				throws CrypterException {
			
			List<String> msg = new ArrayList<>();
			
			for(String txt : messages) {
				msg.add(encrypt(txt));
			}

			return msg;
		}

		@Override
		public String decrypt(String cypherText) throws CrypterException {
			String txt = "";
			
			for(int i = 0; i < cypherText.length(); i++) {
				
				if(cypherText.charAt(i) - key.charAt(0) + 64 < 65)
					txt += (char) (cypherText.charAt(i) - key.charAt(0) + 64 + 26);
				else
					txt += (char) (cypherText.charAt(i) - key.charAt(0) + 64);
			}
			
			return txt;
		}

		@Override
		public List<String> decrypt(List<String> cypherTexte)
				throws CrypterException {
			
			List<String> msg = new ArrayList<>();
			
			for(String txt : cypherTexte) {
				msg.add(decrypt(txt));
			}

			return msg;
		}
		
	}
	
	/**
	 * Legt ein CrypterSubstitution mit einem Schluessel an, um die 
	 * Substitutions-Verschluesselung anzuwenden.
	 * 
	 * Beinhaltet encrypt(String); encrypt(List); decrypt(String); decrypt(List)
	 *
	 */
	private static class CrypterSubstitution implements Crypter {

		private String key;
		
		/**
		 * Legt einen CrypterSubstitution mit dem entsprechenden Schluessel an.
		 * 
		 * @param key - Schluessel, mit dem das Verfahren durchgefuehrt werden soll.
		 */
		private CrypterSubstitution(String key) {
			this.key = key;
		}
		
		@Override
		public String encrypt(String message) throws CrypterException {
			String txt = "";
			
			for(int i = 0; i < message.length(); i++) {
				txt += key.charAt(message.charAt(i) - 65);
			}
			
			return txt;
		}

		@Override
		public List<String> encrypt(List<String> messages)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : messages) {
				msg.add(encrypt(txt));
			}

			return msg;
		}

		@Override
		public String decrypt(String cypherText) throws CrypterException {
			String txt = "";
			
			for(int i = 0; i < cypherText.length(); i++) {
				txt += (char) (key.indexOf(cypherText.charAt(i)) + 65);
			}
			
			return txt;
		}

		@Override
		public List<String> decrypt(List<String> cypherTexte)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : cypherTexte) {
				msg.add(decrypt(txt));
			}

			return msg;
		}
		
	}
	
	/**
	 * Legt ein CrypterXOR mit einem Schluessel an, um die 
	 * XOR-Verschluesselung anzuwenden.
	 * 
	 * Beinhaltet encrypt(String); encrypt(List); decrypt(String); decrypt(List)
	 *
	 */
	private static class CrypterXOR implements Crypter {

		private String key;
		
		/**
		 * Legt einen CrypterXOR mit dem entsprechenden Schluessel an.
		 * 
		 * @param key - Schluessel, mit dem das Verfahren durchgefuehrt werden soll.
		 */
		private CrypterXOR(String key) {
			this.key = key;
		}
		
		@Override
		public String encrypt(String message) throws CrypterException {
			String txt = "";
			String tmp = key;
			
			while(key.length() < message.length()) {
				key += tmp;
			}
			
			for(int i = 0; i < message.length(); i++) {
				if(((message.charAt(i) - 64) ^ (key.charAt(i) - 64)) > 32)
					txt += (char) ((message.charAt(i) - 64) ^ (key.charAt(i) - 64) + 64 - 32);
				else
					txt += (char) ((message.charAt(i) - 64) ^ (key.charAt(i) - 64) + 64); 
			}
			
			return txt;
		}

		@Override
		public List<String> encrypt(List<String> messages)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : messages) {
				msg.add(encrypt(txt));
			}

			return msg;
			
		}

		@Override
		public String decrypt(String cypherText) throws CrypterException {
			String txt = "";
			String tmp = key;
			
			while(key.length() < cypherText.length()) {
				key += tmp;
			}
			
			for(int i = 0; i < cypherText.length(); i++) {
				if(((cypherText.charAt(i) - 64) ^ (key.charAt(i) - 64)) > 32)
					txt += (char) ((cypherText.charAt(i) - 64) ^ (key.charAt(i) - 64) + 64 - 32);
				else
					txt += (char) ((cypherText.charAt(i) - 64) ^ (key.charAt(i) - 64) + 64);
			}
			
			return txt;
		}

		@Override
		public List<String> decrypt(List<String> cypherTexte)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : cypherTexte) {
				msg.add(decrypt(txt));
			}

			return msg;
		}
		
	}
	
	/**
	 * Legt ein CrypterNull an, um die Null-Verschluesselung anzuwenden.
	 * 
	 * Beinhaltet encrypt(String); encrypt(List); decrypt(String); decrypt(List)
	 *
	 */
	private static class CrypterNull implements Crypter {

		@Override
		public String encrypt(String message) throws CrypterException {
			return message;
		}

		@Override
		public List<String> encrypt(List<String> messages)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : messages) {
				msg.add(encrypt(txt));
			}

			return msg;

		}

		@Override
		public String decrypt(String cypherText) throws CrypterException {
			return cypherText;
		}

		@Override
		public List<String> decrypt(List<String> cypherTexte)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : cypherTexte) {
				msg.add(decrypt(txt));
			}

			return msg;
		}
		
	}
	
	/**
	 * Legt ein CrypterReverse an, um die Reverse-Verschluesselung anzuwenden.
	 * 
	 * Beinhaltet encrypt(String); encrypt(List); decrypt(String); decrypt(List)
	 *
	 */
	private static class CrypterReverse implements Crypter {

		@Override
		public String encrypt(String message) throws CrypterException {
			String txt = "";
			
			for(int i = message.length() - 1; i >= 0; i--) {
				txt += message.charAt(i);
			}
			
			return txt;
		}

		@Override
		public List<String> encrypt(List<String> messages)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : messages) {
				msg.add(encrypt(txt));
			}

			return msg;

		}

		@Override
		public String decrypt(String cypherText) throws CrypterException {
			return encrypt(cypherText);
		}

		@Override
		public List<String> decrypt(List<String> cypherTexte)
				throws CrypterException {

			List<String> msg = new ArrayList<>();
			
			for(String txt : cypherTexte) {
				msg.add(decrypt(txt));
			}

			return msg;
		}
		
	}
	
}
