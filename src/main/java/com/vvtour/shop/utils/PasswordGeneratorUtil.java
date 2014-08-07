package com.vvtour.shop.utils;

import java.util.Random;

public class PasswordGeneratorUtil {
	
	private static String originStr = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890~!@#$%^&*()";
	
	public  static String getRandomPassword(){
		Random rng = new Random();
		int length = 10;
		char[] text = new char[length];
		for (int i = 0; i < length; i++)
	    {
	        text[i] = originStr.charAt(rng.nextInt(originStr.length()));
	    }
	    return new String(text);
	}
	
	
	public static void main(String[] args) {
		System.out.println(getRandomPassword());
	}
}
