package com.andy.encryption;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
public class SecureUtils {
    public static String getSecureID(String password, byte[] salt) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            byte[] bytes = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return generatedPassword;
    }
    private static byte[] getSalt() throws NoSuchAlgorithmException {
        // TODO BE get from Secret map; share between mobile and BE
        String saltStr = "fafd1d3db07a689ef3cafe2ae23a661493daa19fc82f9133df262a299f57ad59";
        return saltStr.getBytes();
    }
    public static void main(String[] args) throws NoSuchAlgorithmException {
        // same salt should be passed
        byte[] salt = getSalt();
        String idHash1 = getSecureID("84948961604", salt);
        String idHash2 = getSecureID("84948961604", salt);
        System.out.println(" Password 1 -> " + idHash1);
        System.out.println(" Password 2 -> " + idHash2);
        if (idHash1.equals(idHash2)) {
            System.out.println("mobile hashes are equal");
        }
    }
}