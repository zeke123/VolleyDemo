package com.example.volleydemo;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by ÖÜ½¨ on 16-1-29.
 */
public class MD5
{
	public final static String getMD5(String text)
	{
		try
		{
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(text.getBytes());
			byte[] m = md5.digest();//åŠ å¯†
			return new String(m);
		}
		catch (NoSuchAlgorithmException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public final static String getMessageDigest(String text)
	{
		char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
		try
		{
			MessageDigest mdTemp = MessageDigest.getInstance("MD5");
			mdTemp.update(text.getBytes());
			byte[] md = mdTemp.digest();
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++)
			{
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		}
		catch (Exception e)
		{
			return null;
		}
	}	
}
