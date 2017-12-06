package com.appium.base;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatUtil {

	public static String DateFormatToMinute(Date date) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		return sdf.format(date);

	}
	/**
	 * 获取系统当前时间，格式：yyyy-MM-dd HH:mm
	 * @return
	 */
	public static String getCurrentTime() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

		return sdf.format(new Date());

	}
	
	/**
	 * 获取未来的时间，格式：yyyy-MM-dd
	 * @param day 在当前时间加上的天数
	 * @return
	 */
	public static String getFutureDate(int day) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new java.util.Date();
		long ltime = date.getTime() + day * 24 * 60 * 60 * 1000;
		String format = df.format(new Date(ltime));
		return format;
	}

}
