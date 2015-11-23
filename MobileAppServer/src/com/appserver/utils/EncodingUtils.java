package com.appserver.utils;

import java.io.UnsupportedEncodingException;


/**编码转换工具类
 * @author lijing
 * @date 2015年11月23日 下午8:53:57
 * @description 
 */
public class EncodingUtils {
	
	public static String UTF8Encoding(String v) {
		try {
			return new String(v.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
