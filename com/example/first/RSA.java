package com.example.first;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.util.Base64;

public class RSA {

    public static void main(String[] args) {
        try {
            // Step 1: Create a KeyPairGenerator object for RSA
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");

            // Step 2: Initialize the KeyPairGenerator with key size and SecureRandom
            // Common key sizes are 1024, 2048, or 3072 bits. 2048 is generally recommended.
            SecureRandom secureRandom = new SecureRandom();
            keyPairGenerator.initialize(2048, secureRandom);

            // Step 3: Generate the KeyPair
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            // Step 4: Get the public and private keys
            PublicKey publicKey = keyPair.getPublic();
            PrivateKey privateKey = keyPair.getPrivate();

            // Optional: Encode keys to Base64 for easier storage or transmission
            String publicKeyString = Base64.getEncoder().encodeToString(publicKey.getEncoded());
            String privateKeyString = Base64.getEncoder().encodeToString(privateKey.getEncoded());

            System.out.println("RSA Public Key (Base64): " + publicKeyString);
            System.out.println("\n");
            System.out.println("RSA Private Key (Base64): " + privateKeyString);

        } catch (NoSuchAlgorithmException e) {
            System.err.println("RSA algorithm not found: " + e.getMessage());
        }
    }
}