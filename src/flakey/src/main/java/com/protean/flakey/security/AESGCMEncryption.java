package com.protean.flakey.security;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

// https://www.javainterviewpoint.com/java-aes-256-gcm-encryption-and-decryption/

public class AESGCMEncryption {

    public static final int AES_KEY_SIZE = 256;
    public static final int GCM_IV_LENGTH = 12;
    public static final int GCM_TAG_LENGTH = 16;

    public static void main(String[] args) throws Exception {
        String mode = "AES/GCM/NoPadding";
//        String pass = "sdsscpid123";
        String pass = "sdssuat123";
        String passHex = "A90EC2C63E90AEDAE69C3C4AB84EA759";
        String keyHex = "F21E2A7FB6C68037FAEAA55222E320F7"; //seed
//        String gcmPass = "CE308DA0F6A4F55B944D543B8F6264C03606371212A717C29BD53D"; // FOR decrypt_text {-50..61}
        String gcmPass = "D09D9A8B1A4E41BF0DE2072BF73C53C9D1E83F9D057C2580949A8Fww"; // FOR initializeVector {-87...-38} and decrypt_text={-48...-113}
        byte[] keyByte_array = {-14, 30, 42, 127, -74, -58, -128, 55, -6, -22, -91, 82, 34, -29, 32, -9};
        byte[] decrypted_array = {115, 100, 115, 115, 99, 112, 105, 100, 49, 50, 51};
        byte[] gcm_cipherText = {70, -113, -45, 110, -98, 37, 21, 28, -107, 107, -109, -5};

        String GCM_seed_key = "zjCNoPak9VuUTVQ7j2JkwDYGNxISpxfCm9U9"; // save
//        String iv = "90AEDAE69C3C4AB8"; //""AAAAAAAAAAAAAAAA";
        String iv = "A90EC2C63E90AEDA"; // converts to {-87,14,-62,-58,62,-112,-82,-38};

        byte[] IV = new byte[GCM_IV_LENGTH];
        System.out.println("Saving IV in plainText");
        System.out.println(Base64.getEncoder().encodeToString(IV));
        SecureRandom secRandom = new SecureRandom() ;
        secRandom.nextBytes(IV);
        System.out.println("Original Pass : " + pass);
        byte[] aadTagData = "DiassIntegration".getBytes() ;
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);
        SecretKey key = keyGenerator.generateKey();

        SecretKeySpec sks = new SecretKeySpec(keyByte_array, "AES"); // fixed already because keyByte_array is fixed.
//
//        byte[] InitializeVector = Base64.getDecoder().decode(iv);
        byte[]  InitializeVector = {-87,14,-62,-58,62,-112,-82,-38}; // this is obtained via hexstringtobyte conversion and not Base64.
        byte[] cipherText = encrypt(pass.getBytes(), sks, InitializeVector);
        System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));


//        byte[] decrypt_text = Base64.getDecoder().decode(GCM_seed_key);
//        byte[] decrypt_text = {-50,48,-115,-96,-10,-92,-11,91,-108,77,84,59,-113,98,100,-64,54,6,55,18,18,-89,23,-62,-101,-43,61};
//        byte[] decrypt_text = {-48,-99,-102,-117,26,78,65,-65,13,-30,7,43,-9,60,83,-55,-47,-24,63,-99,5,124,37,-128,-108,-102,-113}; // this is hexStringtoByteconversion and not base64
        byte[] decrypt_text = {-48, -99, -102, -117, 12, 95, 92, -22, 14, -29, -51, 65, 12, -68, -63, 59, 23, 97, -40, 4, -107, -10, 106, 113, -127, -67}; // uat pass sdssuat123
//        byte[] InitializeVector = Base64.getDecoder().decode(iv);
//        String decryptedText = decrypt(decrypt_text, sks, IV);
        String decryptedText = decrypt(decrypt_text, sks, InitializeVector);
        System.out.println("DeCrypted Text : " + decryptedText);

    }

    public static byte[] encrypt(byte[] plaintext, SecretKeySpec keySpec, byte[] IV) throws Exception
    {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        // Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext); //
        System.out.println("Place debugger before this line at cipherText and copy that byte array for decrypt");

        return cipherText;
    }

    public static String decrypt(byte[] cipherText, SecretKeySpec keySpec, byte[] IV) throws Exception
    {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        // Create SecretKeySpec
//        SecretKeySpec keySpec = new SecretKeySpec(key.getEncoded(), "AES");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);

        // Initialize Cipher for DECRYPT_MODE
        cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Decryption
        byte[] decryptedText = cipher.doFinal(cipherText);

        return new String(decryptedText);
    }

}
