package com.appserver.utils;

import java.io.UnsupportedEncodingException;


/**����ת��������
 * @author lijing
 * @date 2015��11��23�� ����8:53:57
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
