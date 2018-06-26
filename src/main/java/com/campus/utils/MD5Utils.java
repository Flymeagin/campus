package com.campus.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {


    //Base64 可逆转
    public static  String encodeBase64(String input){
        return new BASE64Encoder().encodeBuffer(input.getBytes());
    }

    public static String decodeBase64(String input) throws IOException {
        byte []bytes =  new BASE64Decoder().decodeBuffer(input);
        return new String (bytes);
    }

    public static String md5(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.reset();
            md.update(input.getBytes());
            return new BigInteger(1, md.digest()).toString(16);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(md5("123"));
    }

}
