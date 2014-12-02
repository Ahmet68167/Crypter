package crypter;

import java.util.List;

import crypter.exception.CrypterException;

public interface Crypter {
	
	public String encrypt(String message) throws CrypterException;
	
	public List<String> encrypt(List<String> messages) throws CrypterException;
	
	public String decrypt(String cypherText) throws CrypterException;
	
	public List<String> decrypt(List<String> cypherTexte) throws CrypterException;
	
}
