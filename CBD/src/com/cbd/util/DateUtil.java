package com.cbd.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	//字符串转换成日期
	public static Date strToDate(String dateStr,String format){//参数是日期字符串、格式字符串
		if(dateStr == null || "".equals(dateStr)){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		Date date = null;
		try {
			date = sdf.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	//日期转换成字符串
	public static String dateToStr(Date date,String format){//参数是日期字符串、格式字符串
		if(date == null){
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return dateStr;
	}
}
