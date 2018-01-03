package com.appium.listener;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class InstallThread extends Thread {

	public String appurl;
	public AndroidDriver<MobileElement> driver;
	public String getAppurl() {
		return appurl;
	}
	public void setAppurl(String appurl) {
		this.appurl = appurl;
	}
	public AndroidDriver<MobileElement> getDriver() {
		return driver;
	}
	public void setDriver(AndroidDriver<MobileElement> driver) {
		this.driver = driver;
	}
	
	
	@Override
	public void run() {
		System.out.println("install start .....");
		driver.installApp(appurl);
		System.out.println("install end .....");
	}
	
}
