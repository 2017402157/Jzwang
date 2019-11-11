package com.wz.util;

import java.util.Date;

public class StringUtil {
	public static String getId() {
		Long id = new Date().getTime();
		return id.toString();
	}
	
	public static boolean isBlankOrEmpty(String string){
		return string==null || string.trim().length() == 0;
	}
}
