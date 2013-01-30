package demo.md5;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Test {

	private static void Md5(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}

			System.out.println("result: " + buf.toString());// 32位的加密

			System.out.println("result: " + buf.toString().substring(8, 24));// 16位的加密

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		try {

			MessageDigest md = MessageDigest.getInstance("MD5");

			byte[] digest = md.digest();

			System.out.println(digest);

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

}
