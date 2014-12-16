package crypter.iterable;

import java.util.Iterator;
import java.util.List;

import crypter.Crypter;
import crypter.exception.CrypterException;
/**
 * Iterable zur Verschluesselung von mehreren Nachrichten.
 *
 */
public class IterableCrypter implements Iterable<String> {

	private Iterator<String> iterator;
	private Crypter crypter;
	
	/**
	 * Verschluesselt die uebergebene Liste waehrend der Iteration
	 * 
	 * @param list - Liste von Nachrichten, die verschluesselt werden sollen
	 * @param crypter - Verschluesselungsmethode
	 */
	public IterableCrypter(Iterable<String> list, Crypter crypter) {
		this.crypter = crypter;
		this.iterator = list.iterator();
	}
	
	@Override
	public Iterator<String> iterator() {
		
		return new Iterator<String>() {
			
			@Override
			public boolean hasNext() {
				return iterator.hasNext();
			}

			@Override
			public String next() {
				String txt = "";
				
				try {
					txt = crypter.encrypt(iterator.next());
				} catch (CrypterException e) {
					e.printStackTrace();
				}
				
				return txt;
			}
			
		};
	}
	
}
