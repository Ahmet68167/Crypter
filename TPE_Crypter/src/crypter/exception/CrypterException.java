package crypter.exception;

public class CrypterException extends Exception {

	public CrypterException() {
		super("Es ist ein Fehler mit der Verschluesselung aufgetreten");
	}
	
	public CrypterException(String s) {
		super(s);
	}
	
}
