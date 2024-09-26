package com.protean.flakey.security;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class AESGCM_Merck_share {

    public static final int AES_KEY_SIZE = 256;
    public static final int GCM_IV_LENGTH = 12;
    public static final int GCM_TAG_LENGTH = 16;
    private final static String HEX = "0123456789ABCDEF";


    public static void main(String[] args) throws Exception {

        // Enter the db password string here and this is converted to Hex String output to be entered in properties
        String pass = "sdsscpid123";
//        String pass = "sdssuat123";

        // This is present in All Constant file as tmp variable.
        String keyHex = "F21E2A7FB6C68037FAEAA55222E320F7"; //seed
        byte[] keyByte_array = hexStringToByteArray(keyHex);

        // This is present in All Constant file as INITIALIZEVECTOR variable.
        String iv = "A90EC2C63E90AEDA"; // converts to {-87,14,-62,-58,62,-112,-82,-38};

        byte[] IV = new byte[GCM_IV_LENGTH];
        System.out.println("Saving IV in plainText");
        System.out.println(Base64.getEncoder().encodeToString(IV));
        SecureRandom secRandom = new SecureRandom();
        secRandom.nextBytes(IV);
        System.out.println("Original Pass : " + pass);
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(AES_KEY_SIZE);

        SecretKeySpec sks = new SecretKeySpec(keyByte_array, "AES"); // fixed already because keyByte_array is fixed.

        byte[]  InitializeVector = hexStringToByteArray(iv);
        byte[] cipherText = encrypt(pass.getBytes(), sks, InitializeVector);
        System.out.println("Encrypted Text : " + Base64.getEncoder().encodeToString(cipherText));

        String s = toHex(cipherText);
        System.out.println(s);

    }



    public static byte[] encrypt(byte[] plaintext, SecretKeySpec keySpec, byte[] IV) throws Exception
    {
        // Get Cipher Instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");

        // Create GCMParameterSpec
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, IV);

        // Initialize Cipher for ENCRYPT_MODE
        cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);

        // Perform Encryption
        byte[] cipherText = cipher.doFinal(plaintext); //
        System.out.println("Place debugger before this line at cipherText and copy that byte array for decrypt");

        return cipherText;
    }

    public static byte[] hexStringToByteArray(String s){
        byte[] b = new byte[s.length()/2];
        for(int i = 0; i<b.length; i++){
            int index = i*2;
            int v = Integer.parseInt(s.substring(index,index+2),16);
            b[i] = (byte) v;
        }
        return b;
    }

    public static String toHex(String txt) {
        return toHex(txt.getBytes());
    }

    public static String toHex(byte[] buf) {
        if (buf == null)
            return "";
        StringBuffer result = new StringBuffer(2 * buf.length);
        for (int i = 0; i < buf.length; i++) {
            appendHex(result, buf[i]);
        }
        return result.toString();
    }

    private static void appendHex(StringBuffer sb, byte b) {
        sb.append(HEX.charAt((b >> 4) & 0x0f)).append(HEX.charAt(b & 0x0f));
    }
}
