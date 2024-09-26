package com.protean.flakey.security;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.*;
import java.security.*;

public class AesEncryption {
    public AesEncryption() {
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

    public static final int GCM_TAG_LENGTH = 128;

    public static void main(String[] args) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException {
//        String mode = "AES";
        String mode = "AES/GCM/NoPadding";
        String pass = "sdsscpid123";
        String passHex = "";
        String keyHex = "F21E2A7FB6C68037FAEAA55222E320F7"; //seed
        byte[] keyByte_array = {-14, 30, 42, 127, -74, -58, -128, 55, -6, -22, -91, 82, 34, -29, 32, -9};
        byte[] decrypted_array = {115, 100, 115, 115, 99, 112, 105, 100, 49, 50, 51};
//        String seed_raw = "�*�ƀ7��R"� �";

        byte[] byteKey = hexStringToByteArray(keyHex);
        SecretKeySpec sks = new SecretKeySpec(byteKey, mode);
        Cipher cipher = Cipher.getInstance(mode);
        cipher.init(Cipher.DECRYPT_MODE, sks);
        byte[] decrypted = cipher.doFinal(hexStringToByteArray(passHex));
        String orgpwd = new String(decrypted);
        System.out.println(orgpwd);
        String seed = new String(keyByte_array);
        System.out.println(seed);


    }
 

}


