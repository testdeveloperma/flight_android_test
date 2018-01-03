package com.appium.base;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AppiumServer {
	String deviceName;
	
	
	
	public AppiumServer() {
		super();
		Parameters pa=new Parameters();
		try {
			this.deviceName =pa.getDeviceName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	public  AndroidDriver<MobileElement> androidDriverRun(String appurl)
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",deviceName);
		//"LE67A06200010087"
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("dontStopAppOnReset", true);
		cap.setCapability("platformVersion", Parameters.getPlatformVersion());
		
		if(appurl != null && !appurl.equals("0")){
			cap.setCapability("app", appurl);
		}
		cap.setCapability("appPackage", "com.dp.android.elong");
//		cap.setCapability("appActivity",
//		 "com.elong.activity.others.TabHomeActivity");
		cap.setCapability("appActivity",
				"com.elong.activity.others.AppGuidActivity");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
	public  AndroidDriver<WebElement> androidDriverRun()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",deviceName);
		//"LE67A06200010087"
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("dontStopAppOnReset", true);
		cap.setCapability("platformVersion", "7.1");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		AndroidDriver<WebElement> driver = new AndroidDriver<WebElement>(new URL(
				"http://127.0.0.1:4725/wd/hub"), cap);
		return driver;
	}

	
	public  AndroidDriver iosDriverRun()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "IOS");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("deviceName", "iPhone 6s Plus");
		cap.setCapability("bundleId", "com.elong.travel");
		cap.setCapability("udid", "2680be7d55dda2597d57da7cadaa7b848bf08b18");
		AndroidDriver driver = new AndroidDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
}
