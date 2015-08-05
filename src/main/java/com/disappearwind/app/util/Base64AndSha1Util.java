package com.disappearwind.app.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Encoder;

public class Base64AndSha1Util {

	public static void main(String[] args) throws Exception { 
    	
    	String token = "123";
		String base64token = Base64AndSha1Util.encryptBASE64(token);		
		System.out.println(Base64AndSha1Util.SHA2(base64token.trim()));

    } 
	
	    /** 
		 * BASE64加密
		 *  
		 * @param key 
		 * @return 
		 * @throws Exception 
		 */  
		@SuppressWarnings("restriction")
		public static String encryptBASE64(String keys) throws Exception {  
			byte[] key = keys.getBytes();
		    return (new BASE64Encoder()).encodeBuffer(key);  
		}  
		
		
		/**
		 * SHA1加密
		 * @param decript
		 * @return
		 * @throws NoSuchAlgorithmException
		 */
		public static String SHA2(String decript) throws NoSuchAlgorithmException {
	        MessageDigest digest = java.security.MessageDigest.getInstance("SHA-1");
	        digest.update(decript.getBytes());
	        byte messageDigest[] = digest.digest();
	        return String.format("%0" + (messageDigest.length * 2) + "X", new BigInteger(1, messageDigest));
		 }  

}
