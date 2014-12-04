package crypter.iterable;

import java.util.Iterator;
import java.util.List;

import crypter.Crypter;
import crypter.exception.CrypterException;

public class IterableCrypter implements Iterable<String> {

	private Iterator<String> iterator;
	private Crypter crypter;
	
	public IterableCrypter(List<String> list, Crypter crypter) {
		this.crypter = crypter;
		this.iterator = list.iterator();
	}
	
	public IterableCrypter(IterableCrypter iterable, Crypter crypter) {
		// FEHLT
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
