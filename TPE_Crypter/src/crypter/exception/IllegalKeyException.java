package crypter.exception;

public class IllegalKeyException extends CrypterException {

	public IllegalKeyException() {
		super("Der eingegebene Schluessel ist ungueltig.");
	}
	
	public IllegalKeyException(String s) {
		super(s);
	}
	
}
