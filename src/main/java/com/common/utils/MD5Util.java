package com.common.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Alvin.WU
 * 加密功能
 * 
 * */ 
public class MD5Util {
	private final static String[] hexDigits = { "0", "1", "2", "3", "4", "5",

		"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };

		public static String byteArrayToString(byte[] b) {

			StringBuffer resultSb = new StringBuffer();

			for (int i = 0; i < b.length; i++) {
				resultSb.append(byteToHexString(b[i]));
			}

			return resultSb.toString();
		}
		
		@SuppressWarnings("unused")
		private static String byteToNumString(byte b) {

			int _b = b;
			if (_b < 0) {
				_b = 256 + _b;
			}
			return String.valueOf(_b);
		}

		private static String byteToHexString(byte b) {
			int n = b;

			if (n < 0) {
				n = 256 + n;
			}
			int d1 = n / 16;

			int d2 = n % 16;

			return hexDigits[d1] + hexDigits[d2];
		}

		public static String encode(String origin) throws NoSuchAlgorithmException {

			String resultString = null;

			MessageDigest md = MessageDigest.getInstance("MD5");
			resultString = new String(origin);
			resultString = byteArrayToString(md.digest(resultString.getBytes()));

			return resultString;
		}

}
