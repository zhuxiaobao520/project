package com.cbd.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 字符串格式转日期格式自定义类型转换器
 * @author yin
 *
 */
public class StringToDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String dateString) {
		// TODO Auto-generated method stub
		Date date = null;
		SimpleDateFormat sdFormat = null;
		try {
			sdFormat = new SimpleDateFormat("yyyy-MM-dd");
			date  = sdFormat.parse(dateString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			sdFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				date  = sdFormat.parse(dateString);
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				System.out.println("日期格式不正确");
				e1.printStackTrace();
			}
		}
		return date;
	}	
}


