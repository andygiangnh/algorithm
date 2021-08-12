package com.andy.encryption;

// Java program to implement the
// encryption and decryption

import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

// Creating the symmetric
// class which implements
// the symmetric
public class Symmetric {

    private static final String AES = "AES";

    // We are using a Block cipher(CBC mode)
    private static final String AES_CIPHER_ALGORITHM = "AES/CBC/PKCS5PADDING";

    private static Scanner message;

    // Function to create a
    // secret key
    public static SecretKey createAESKey() throws Exception
    {
        SecureRandom securerandom = new SecureRandom();
        KeyGenerator keygenerator = KeyGenerator.getInstance(AES);

        keygenerator.init(256, securerandom);
        SecretKey key = keygenerator.generateKey();

        return key;
    }

    public static SecretKey createAESKeyFromString(String encodedKey) throws Exception
    {
        // decode the base64 encoded string
        byte[] decodedKey = Base64.getDecoder().decode(encodedKey);
// rebuild key using SecretKeySpec
        SecretKey originalKey = new SecretKeySpec(decodedKey, 0, decodedKey.length, "AES");
        return originalKey;
    }

    // Function to initialize a vector
    // with an arbitrary value
    public static byte[] createInitializationVector()
    {

        // Used with encryption
        byte[] initializationVector = new byte[16];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(initializationVector);
        return initializationVector;
    }

    // This function takes plaintext,
    // the key with an initialization
    // vector to convert plainText
    // into CipherText.
    public static byte[] do_AESEncryption(
            String plainText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivParameterSpec);

        return cipher.doFinal(plainText.getBytes());
    }

    // This function performs the
    // reverse operation of the
    // do_AESEncryption function.
    // It converts ciphertext to
    // the plaintext using the key.
    public static String do_AESDecryption(
            byte[] cipherText,
            SecretKey secretKey,
            byte[] initializationVector)
            throws Exception
    {
        Cipher cipher = Cipher.getInstance(AES_CIPHER_ALGORITHM);

        IvParameterSpec ivParameterSpec = new IvParameterSpec(initializationVector);

        cipher.init(Cipher.DECRYPT_MODE, secretKey, ivParameterSpec);

        byte[] result = cipher.doFinal(cipherText);

        return new String(result);
    }

    // Driver code
    public static void main(String args[]) throws Exception
    {
        SecretKey symmetricKey = createAESKey();
        String encodedKey = Base64.getEncoder().encodeToString(symmetricKey.getEncoded());

        System.out.println("Encoded Key: " + encodedKey);

        symmetricKey = createAESKeyFromString("Xt/y60fqBZJue86UMz3NZ6lbHcVjT3TQ+6yG8eIx3zg=");

        System.out.println("The Symmetric Key is :"
                + DatatypeConverter.printHexBinary(symmetricKey.getEncoded()));

        byte[] initializationVector = createInitializationVector();

        String plainText = "This is the message I want To Encrypt.";

        // Encrypting the message
        // using the symmetric key
        byte[] cipherText = do_AESEncryption(plainText, symmetricKey, initializationVector);

        System.out.println(
                "The ciphertext or "
                        + "Encrypted Message is: "
                        + DatatypeConverter.printHexBinary(cipherText));

        // Decrypting the encrypted
        // message
        String decryptedText = do_AESDecryption(cipherText, symmetricKey, initializationVector);

        System.out.println("Your original message is: " + decryptedText);
    }
}