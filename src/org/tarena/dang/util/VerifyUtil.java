package org.tarena.dang.util;

import java.util.UUID;

public class VerifyUtil {
	public static String createCode(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
	public static void main(String args[]){
		String code=VerifyUtil.createCode();
		System.out.println(code);
	}

}
