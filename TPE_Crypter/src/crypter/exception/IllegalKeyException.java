package crypter.exception;


/**
 * Gibt eine IllegalKeyException aus, wenn der eingegebene
 * Schluessel ungueltig ist.
 *
 */
public class IllegalKeyException extends CrypterException {

	
	/**
	 * Gbt den folgenden String aus:
	 * "Der eingegebene Schluessel ist ungueltig"
	 * 
	 */
	public IllegalKeyException() {
		super("Der eingegebene Schluessel ist ungueltig.");
	}
	
	
	/**
	 * Gibt den uebergebenen String aus
	 * 
	 * @param s - String, der ausgegeben werden soll
	 */
	public IllegalKeyException(String s) {
		super(s);
	}
	
}
