package crypter.iterable;

import java.util.Iterator;

import crypter.Crypter;
import crypter.exception.CrypterException;

public class IterableDecrypter implements Iterable<String>{

	private Iterator<String> iterator;
	private Crypter crypter;
	
	public IterableDecrypter(Iterable list, Crypter crypter) {
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
					txt = crypter.decrypt(iterator.next());
				} catch (CrypterException e) {
					e.printStackTrace();
				}
				
				return txt;
			}
			
		};
	}
	
}
