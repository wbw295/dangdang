package org.tarena.dang.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtil {
	public static String md5Encrypt(String s){
		if("".equals(s)||s==null){
			return "";
		}
		try {
			MessageDigest md=MessageDigest.getInstance("MD5");
			byte[] bytes=md.digest(s.getBytes());
			return Base64Ecrypt(bytes);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}

	private static String Base64Ecrypt(byte[] bytes) {
		// TODO Auto-generated method stub
		BASE64Encoder encoder=new BASE64Encoder();
		String s=encoder.encode(bytes);
		return s;
	}
	
	public static byte[] Base64Decrypt(String s) throws Exception{
		BASE64Decoder decoder=new BASE64Decoder();
		return decoder.decodeBuffer(s);
	}

}
