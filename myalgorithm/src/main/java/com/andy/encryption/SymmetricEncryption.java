package com.andy.encryption;

import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class SymmetricEncryption {

    private static final String AES = "AES";

    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";

    public static SecretKey createAESKeyFromString(String encodedKey) throws Exception
    {
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return originalKey;
    }

    public static byte[] createInitializationVector()
    {
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    public static String do_AESEncryption(
            String plainText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);
        return Base64.getEncoder().encodeToString(cipher.doFinal(plainText.getBytes()));
    }

    public static String do_AESDecryption(
            String cipherText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);
        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);
        byte[] result = cipher.doFinal(Base64.getDecoder().decode(cipherText));

        return new String(result);
    }

    public static void main(String args[]) throws Exception
    {
        // TODO Mobile start here
        String keyStr = "Xt/y60fqBZJue86UMz3NZ6lbHcVjT3TQ+6yG8eIx3zg=";

        SecretKey symmetricKey = createAESKeyFromString(keyStr);
        byte[] initializationVector = createInitializationVector();
        String plainText = "84971234567";
        String cipherText = do_AESEncryption(plainText, symmetricKey, initializationVector);
        // Mobile End
        System.out.println("The Encrypted Message is: " + cipherText);

        // Test decryption
        String decryptedText = do_AESDecryption(cipherText, symmetricKey, initializationVector);
        System.out.println("Your original message is: " + decryptedText);
    }
}