package crypter.iterable;

import java.util.Iterator;
import java.util.List;

import crypter.Crypter;
import crypter.exception.CrypterException;

public class IterableCrypter implements Iterable<String> {

	private Iterator<String> iterator;
	private Crypter crypter;
	
	private IterableCrypter(Crypter crypter) {
		this.crypter = crypter;
	}
	
	public IterableCrypter(Iterable list, Crypter crypter) {
		this(crypter);
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
