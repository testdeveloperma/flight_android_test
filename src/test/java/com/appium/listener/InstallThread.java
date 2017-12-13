package com.appium.listener;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;

public class InstallThread extends Thread {

	public String appurl;
	public AppiumDriver<WebElement> driver;
	public String getAppurl() {
		return appurl;
	}
	public void setAppurl(String appurl) {
		this.appurl = appurl;
	}
	public AppiumDriver<WebElement> getDriver() {
		return driver;
	}
	public void setDriver(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}
	
	
	@Override
	public void run() {
		System.out.println("install start .....");
		driver.installApp(appurl);
		System.out.println("install end .....");
	}
	
}
