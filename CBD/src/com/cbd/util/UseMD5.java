package com.cbd.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 使用md5加密
 * @author yinshi
 * @date 2018年1月31日
 */
public class UseMD5 {

	
	/**
	 * 使用MD5加盐
	 * @author yinshi
	 * @date 2018年1月31日
	 * @param password  传入一个你要加密的字符串
	 * @return 返回加密完成后的密码
	 */
	public static String md5MakePassword(String password) {

        try {
            // 得到一个信息摘要器
            MessageDigest digest = MessageDigest.getInstance("md5");
            byte[] result = digest.digest(password.getBytes());
            StringBuffer buffer = new StringBuffer();
            // 把每一个byte 做一个与运算 0xff;
            for (byte b : result) {
                // 与运算
                int number = b & 0xff;// 加盐
                String str = Integer.toHexString(number);
                if (str.length() == 1) {
                    buffer.append("0");
                }
                buffer.append(str);
            }

            // 标准的md5加密后的结果
            return buffer.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return "";
        }
	}
}
