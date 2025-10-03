package com.example.first;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Arrays;

public class AES {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static byte[] encrypt(String plainText, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        return cipher.doFinal(plainText.getBytes(StandardCharsets.UTF_8));
    }

    public static String decrypt(byte[] cipherText, String key) throws Exception {
        Key secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        byte[] decryptedBytes = cipher.doFinal(cipherText);
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

    public static void main(String[] args) {
        String plaintext = "This is a test plaintext string.";
       // String key = "1234567890123456";
        String key = "dellLPTOPMYMMACHN";

        try {
            byte[] encryptedBytes = AES.encrypt(plaintext, key);
            System.out.println("Encrypted bytes: " + Arrays.toString(encryptedBytes));

            String decryptedText = AES.decrypt(encryptedBytes, key);
            System.out.println("Decrypted text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
