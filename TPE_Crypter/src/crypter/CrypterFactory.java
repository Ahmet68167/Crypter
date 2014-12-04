package crypter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;

public class CrypterFactory {
	
	public enum Crypt {
		CAESAR, SUBSTITUTION, REVERSE, XOR, NULL;
	}
	
	public static Crypter createCrypter(String key, Crypt chiffre) throws IllegalKeyException{

		if(chiffre == Crypt.CAESAR) {
			if(key.length() != 1 || key.charAt(0) < 65 && key.charAt(0) > 90) 
				throw new IllegalKeyException();
			
			return new CrypterCaesar(key);
			
		} else if(chiffre == Crypt.SUBSTITUTION) {
			char[] keys = new char[26];
			char[] alphabet = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J',
					'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V',
					'W', 'X', 'Y', 'Z' };
			
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
	
	private static class CrypterCaesar implements Crypter {
		
		private String key;
		
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
	
	private static class CrypterSubstitution implements Crypter {

		private String key;
		
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
	
	private static class CrypterXOR implements Crypter {

		private String key;
		
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
				if(((message.charAt(i) - 64) ^ (key.charAt(i) - 64) + 64) > 32)
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
