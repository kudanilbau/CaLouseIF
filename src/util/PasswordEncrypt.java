package util;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.UUID;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordEncrypt {
//	static salt
	private static final byte[] SALT = "saltissalty".getBytes();

	/**
	 * Encrypts the provided password using the PBKDF2 algorithm with HMAC-SHA1.
	 * <p>
	 * This method generates a salted hash of the given password using the PBKDF2
	 * algorithm with 65536 iterations and a key length of 128 bits. The resulting
	 * hash is then encoded in Base64 format and returned as a string.
	 * </p>
	 *
	 * @param password the plaintext password to encrypt
	 * @return the encrypted password as a Base64-encoded string
	 */

	public static String encrypt(String password) {
		try {
			KeySpec spec = new PBEKeySpec(password.toCharArray(), SALT, 65536, 128);
			SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = factory.generateSecret(spec).getEncoded();
			return Base64.getEncoder().encodeToString(hash);
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			e.printStackTrace();
		}
		return "";
	}

	public static void main(String[] args) {
//		String password = "admin";
//		System.out.println(UUID.randomUUID());
//		System.out.println(encrypt(password));
		int MAX_ITERATION = 3;
		for(int i = 0; i < MAX_ITERATION; i++) {
			System.out.println(UUID.randomUUID());
		}
	}
}
