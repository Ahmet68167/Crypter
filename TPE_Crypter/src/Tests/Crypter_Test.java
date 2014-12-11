package Tests;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import crypter.Crypter;
import crypter.CrypterFactory;
import crypter.CrypterFactory.Crypt;
import crypter.exception.CrypterException;
import crypter.exception.IllegalKeyException;
import crypter.iterable.IterableCrypter;
import crypter.iterable.IterableDecrypter;

public class Crypter_Test {

	@Test //(expected = IllegalKeyException.class)
	public void Crypter_Caesar_KeyTest() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("AA", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_Caesar_KeyTest_Zeichen() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("/", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_Caesar_KeyTest_zuKurz() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_Caesar_KeyTest_zuLang() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("ADC", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_Caesar_KeyTest_klein() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("a", CrypterFactory.Crypt.CAESAR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("AAA", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest_Zeichen() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("ÄBCDEFGHIJKLMNOPQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest_zuKurz() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("ABCDEFGHIJKLMNOPQRSTUVWXY", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest_zuLang() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("ABCDEFGHIJKLMNOPQRSTUVWXYZA", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest_doppelt() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("ABCDEFGHIJKLMNOPQRSTUVWXYY", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_SUB_KeyTest_klein() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("abcdefghijklmnopqrstuvwxyz", CrypterFactory.Crypt.SUBSTITUTION);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_XOR_KeyTest() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("Ä", CrypterFactory.Crypt.XOR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_XOR_KeyTest_Zeichen() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("A-", CrypterFactory.Crypt.XOR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_XOR_KeyTest_klein() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("a", CrypterFactory.Crypt.XOR);
			fail();
		} catch(IllegalKeyException e) {
			assertTrue(true);
		} 
	}
	
	@Test
	public void Crypter_Caesar_encrypt_message_HALLO() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("B", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("JCNNQ", caesar.encrypt("HALLO"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_message_A_um1() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("B", caesar.encrypt("A"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_message_A_um26() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Z", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("A", caesar.encrypt("A"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_message_Z_um1() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("A", caesar.encrypt("Z"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_message_Z_um26() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Z", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("Z", caesar.encrypt("Z"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_List_HALLO_TEST_DA() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HALLO", "TEST", "DA");
		String encrypted = "IBMMP UFTU EB ";
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			IterableCrypter c = new IterableCrypter(toencrypt, caesar);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_encrypt_List_H() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H");
		String encrypted = "I ";
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			IterableCrypter c = new IterableCrypter(toencrypt, caesar);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_message_JCNNQ() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("B", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("HALLO", caesar.decrypt("JCNNQ"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_message_B_um1() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("A", caesar.decrypt("B"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_message_A_um26() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Z", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("A", caesar.decrypt("A"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_message_A_um1() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("Z", caesar.decrypt("A"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_message_Z_um26() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter caesar = crypter.createCrypter("Z", CrypterFactory.Crypt.CAESAR);
			try {
				assertEquals("Z", caesar.decrypt("Z"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_List_IBMMP_UFTU_EB() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("IBMMP", "UFTU", "EB");
		String encrypted = "HALLO TEST DA ";
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			IterableDecrypter c = new IterableDecrypter(toencrypt, caesar);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Caesar_decrypt_List_I() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("I");
		String encrypted = "H ";
		
		try {
			Crypter caesar = crypter.createCrypter("A", CrypterFactory.Crypt.CAESAR);
			IterableDecrypter c = new IterableDecrypter(toencrypt, caesar);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_encrypt_message_HALLO() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("BACDEFGHIJKLMNOPQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			try {
				assertEquals("HBLLO", sub.encrypt("HALLO"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_encrypt_List_HALLO_TEST_DA() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HALLO", "TEST", "DA");
		String encrypted = "HBLLO TDST EB ";
		
		try {
			Crypter sub = crypter.createCrypter("BACEDFGHIJKLMNOPQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			IterableCrypter c = new IterableCrypter(toencrypt, sub);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_encrypt_List_H() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H");
		String encrypted = "I ";
		
		try {
			Crypter sub = crypter.createCrypter("ABCDEFGIHJKLMNOPQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			IterableCrypter c = new IterableCrypter(toencrypt, sub);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_decrypt_message_HBLLP() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter sub = crypter.createCrypter("BACDEFGHIJKLMNPOQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			try {
				assertEquals("HALLO", sub.decrypt("HBLLP"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_decrypt_List_HBTTP_LESL_KB() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HBTTP", "LESL", "KB");
		String encrypted = "HALLO TEST DA ";
		
		try {
			Crypter sub = crypter.createCrypter("BACKEFGHIJDTMNPOQRSLUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			IterableDecrypter c = new IterableDecrypter(toencrypt, sub);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_SUB_decrypt_List_I() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("I");
		String encrypted = "H ";
		
		try {
			Crypter sub = crypter.createCrypter("ABCDEFGIHJKLMNOPQRSTUVWXYZ", CrypterFactory.Crypt.SUBSTITUTION);
			IterableDecrypter c = new IterableDecrypter(toencrypt, sub);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_encrypt_message_HALLO() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter xor = crypter.createCrypter("AERF_", CrypterFactory.Crypt.XOR);
			try {
				assertEquals("ID^JP", xor.encrypt("HALLO"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_encrypt_List_HALLO_TEST_DA() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HALLO", "TEST", "DA");
		String encrypted = "H@NLN TDQT D@ ";
		
		try {
			Crypter xor = crypter.createCrypter("@AB", CrypterFactory.Crypt.XOR);
			IterableCrypter c = new IterableCrypter(toencrypt, xor);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_encrypt_List_H() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H");
		String encrypted = "V ";
		
		try {
			Crypter xor = crypter.createCrypter("^AB", CrypterFactory.Crypt.XOR);
			IterableCrypter c = new IterableCrypter(toencrypt, xor);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_decrypt_message_IDJP() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter xor = crypter.createCrypter("AERF_", CrypterFactory.Crypt.XOR);
			try {
				assertEquals("HALLO", xor.decrypt("ID^JP"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_decrypt_List_HNLN_TDQT_D() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H@NLN", "TDQT", "D@");
		String encrypted = "HALLO TEST DA ";
		
		try {
			Crypter xor = crypter.createCrypter("@AB", CrypterFactory.Crypt.XOR);
			IterableDecrypter c = new IterableDecrypter(toencrypt, xor);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_XOR_decrypt_List_V() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("V");
		String encrypted = "H ";
		
		try {
			Crypter xor = crypter.createCrypter("^AB", CrypterFactory.Crypt.XOR);
			IterableDecrypter c = new IterableDecrypter(toencrypt, xor);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_encrypt_message_HALLO() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter re = crypter.createCrypter("AERF_", CrypterFactory.Crypt.REVERSE);
			try {
				assertEquals("OLLAH", re.encrypt("HALLO"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_encrypt_List_HALLO_TEST_DA() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HALLO", "TEST", "DA");
		String encrypted = "OLLAH TSET AD ";
		
		try {
			Crypter re = crypter.createCrypter("@AB", CrypterFactory.Crypt.REVERSE);
			IterableCrypter c = new IterableCrypter(toencrypt, re);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_encrypt_List_H() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H");
		String encrypted = "H ";
		
		try {
			Crypter re = crypter.createCrypter("^AB", CrypterFactory.Crypt.REVERSE);
			IterableCrypter c = new IterableCrypter(toencrypt, re);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_decrypt_message_OLLAH() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter re = crypter.createCrypter("AERF_", CrypterFactory.Crypt.REVERSE);
			try {
				assertEquals("HALLO", re.decrypt("OLLAH"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_decrypt_List_OLLAH_TSET_AD() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("OLLAH", "TSET", "AD");
		String encrypted = "HALLO TEST DA ";
		
		try {
			Crypter re = crypter.createCrypter("@AB", CrypterFactory.Crypt.REVERSE);
			IterableDecrypter c = new IterableDecrypter(toencrypt, re);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_Reverse_decrypt_List_V() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("V");
		String encrypted = "V ";
		
		try {
			Crypter re = crypter.createCrypter("^AB", CrypterFactory.Crypt.REVERSE);
			IterableDecrypter c = new IterableDecrypter(toencrypt, re);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_encrypt_message_HALLO() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter nu = crypter.createCrypter("AERF_", CrypterFactory.Crypt.NULL);
			try {
				assertEquals("HALLO", nu.encrypt("HALLO"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_encrypt_List_HALLO_TEST_DA() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("HALLO", "TEST", "DA");
		String encrypted = "HALLO TEST DA ";
		
		try {
			Crypter nu = crypter.createCrypter("@AB", CrypterFactory.Crypt.NULL);
			IterableCrypter c = new IterableCrypter(toencrypt, nu);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_encrypt_List_H() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("H");
		String encrypted = "H ";
		
		try {
			Crypter nu = crypter.createCrypter("^AB", CrypterFactory.Crypt.NULL);
			IterableCrypter c = new IterableCrypter(toencrypt, nu);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_decrypt_message_OLLAH() {
		CrypterFactory crypter = new CrypterFactory();
		
		try {
			Crypter nu = crypter.createCrypter("AERF_", CrypterFactory.Crypt.NULL);
			try {
				assertEquals("OLLAH", nu.decrypt("OLLAH"));
			} catch (CrypterException e) {
				e.printStackTrace();
			}
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_decrypt_List_OLLAH_TSET_AD() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("OLLAH", "TSET", "AD");
		String encrypted = "OLLAH TSET AD ";
		
		try {
			Crypter nu = crypter.createCrypter("@AB", CrypterFactory.Crypt.NULL);
			IterableDecrypter c = new IterableDecrypter(toencrypt, nu);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void Crypter_NULL_decrypt_List_V() {
		CrypterFactory crypter = new CrypterFactory();
		String txt = "";
		List<String> toencrypt = Arrays.asList("V");
		String encrypted = "V ";
		
		try {
			Crypter nu = crypter.createCrypter("^AB", CrypterFactory.Crypt.NULL);
			IterableDecrypter c = new IterableDecrypter(toencrypt, nu);
			for(String msg : c)
				txt += msg + " ";
			assertEquals(encrypted, txt);
		} catch (IllegalKeyException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void IterableCrypter() {
		Crypter caesar, xor;
		String txt = "";
		String encrypted = "MT_G P^J NTL [JKF ";
		
		try {
			caesar = CrypterFactory.createCrypter("U", CrypterFactory.Crypt.CAESAR);
			xor = CrypterFactory.createCrypter("TPEISTCOOL", CrypterFactory.Crypt.XOR);
			List<String> liste = Arrays.asList("DIES", "IST", "EIN", "TEST");
			
			IterableCrypter iterableCrypter = new IterableCrypter(new IterableCrypter(liste, caesar), xor);
			
			for (String cypherText : iterableCrypter) {
				txt += cypherText + " ";
			}
			
			assertEquals(encrypted, txt);
			
		} catch (IllegalKeyException e) {
			
			e.printStackTrace();
		}
	}
	
	@Test
	public void IterableDecrypter() {
		List<String> s = Arrays.asList("QOZEG]A[UXDKZIZLAB\\NUQIO^^RXYHADV[EFFJ\\\\[\\U_]YDVZABDZT\\V\\SKB@X");
		List<String> t = Arrays.asList("PMMBI", "TVBML", "UFNIB");
		String decrypt = "";
		String decrypted = "JETZTXISTXTPEXAUCHXBALDXGESCHAFFTXEINXFROHESXFESTXWUENSCHEXICH ";
		
		try {
			Crypter sub = CrypterFactory.createCrypter("MNBVCXYLKJHGFDSAPOIUZTREWQ", CrypterFactory.Crypt.SUBSTITUTION);
			Crypter cae = CrypterFactory.createCrypter("L", CrypterFactory.Crypt.CAESAR);
			Crypter um = CrypterFactory.createCrypter("", CrypterFactory.Crypt.REVERSE);
			Crypter xor = CrypterFactory.createCrypter("IAMTHEONEWHOKNOCKS", CrypterFactory.Crypt.XOR);
			
			IterableDecrypter c = new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(new IterableDecrypter(s, xor), um), cae), sub);
			
			for(String msg : c)
				decrypt += msg + " ";
			
			assertEquals(decrypted, decrypt);
	
		} catch (IllegalKeyException e) {
			
			e.printStackTrace();
		}
	}

}
