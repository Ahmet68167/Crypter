package crypter.exception;

/**
 * Wirft eine Exception, wenn ein Problem bei der
 * Verschluesselung auftritt
 *
 */
public class CrypterException extends Exception {

	/**
	 * Gibt den folgenden String aus:
	 * "Es ist ein Fehler mit der Verschluesselung aufgetreten"
	 * 
	 */
	public CrypterException() {
		super("Es ist ein Fehler mit der Verschluesselung aufgetreten");
	}
	
	
	/**
	 * Gibt den uebergebenen String aus
	 * 
	 * @param s - String, der ausgegeben werden soll
	 */
	public CrypterException(String s) {
		super(s);
	}
	
}
