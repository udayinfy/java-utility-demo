package demo.encrypt;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AES128Encrypt {

	private static final String ALGORITHM = "AES";// AES128

	public static String encrypt(String valueToEnc, String keyString) throws Exception {
		Key key = generateKey(keyString);
		Cipher c = Cipher.getInstance(ALGORITHM);
		c.init(Cipher.ENCRYPT_MODE, key);
		byte[] encValue = c.doFinal(valueToEnc.getBytes());
		byte[] encode = new Base64().encode(encValue);
		String encryptedValue = new String(encode);
		return encryptedValue;
	}

	public static String decrypt(String encryptedValue, String keyString) throws Exception {

		try {
			Key key = generateKey(keyString);
			Cipher c = Cipher.getInstance(ALGORITHM);
			c.init(Cipher.DECRYPT_MODE, key);
			byte[] decordedValue = new Base64().decode(encryptedValue);
			byte[] decValue = c.doFinal(decordedValue);

			String decryptedValue = new String(decValue);
			return decryptedValue;
		} catch (Throwable e) {
			System.out.println(e);
			return null;
		}

	}

	private static Key generateKey(String keyString) throws Exception {
		Key key = new SecretKeySpec(keyString.getBytes(), ALGORITHM);
		return key;
	}

	public static void main(String[] args) throws Exception {

		String str = "abcdefgaa|aaaaa|aaaaaaaaa";
		String key = "APppHc=537130111";
		String enc = AES128Encrypt.encrypt(str, key);
		System.out.println(str);
		System.out.println(enc);

		String decrypt = AES128Encrypt.decrypt(enc, key);
		System.out.println(decrypt);

	}

}