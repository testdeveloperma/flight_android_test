package com.elong.android.flight.test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.testng.annotations.Test;

import com.appium.util.AndroidTool;


public class JunitTest{

	@Test
	public void test() {
		AndroidTool.screencap("orderdetail");
	}
	@Test
	public void test2(){
		SimpleDateFormat df = new SimpleDateFormat("dd");//设置日期格式
		String dd = "2017-09-15";
		java.util.Date date = new java.util.Date();
		System.out.println(date.getTime());
		String format = df.format(new java.util.Date());
		System.out.println(format);
		System.out.println();// new Date()为获取当前系统时间
	}
}
