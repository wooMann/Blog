package com.blog.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Sha256HashGenerator {

    public static String hashGenerate(String text)  {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(text.getBytes());
            return bytesToHex(md.digest());
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
            return null;
        }
    }

    private static String bytesToHex(byte[] bytes){
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }
}
