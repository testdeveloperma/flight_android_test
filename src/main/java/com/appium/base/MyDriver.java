package com.appium.base;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class MyDriver{
	String deviceName;

	AppiumDriver<WebElement> driver;
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public AppiumDriver<WebElement> getDriver() {
		return driver;
	}

	public void setDriver(AppiumDriver<WebElement> driver) {
		this.driver = driver;
	}





//	DesiredCapabilities cap = new DesiredCapabilities();
	
	public MyDriver() {
		
		Parameters pa=new Parameters();
		try {
			this.deviceName =pa.getDeviceName();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	


	public  AppiumDriver<WebElement> androidDriverRun()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",deviceName);
		//"LE67A06200010087"
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("dontStopAppOnReset", true);
		cap.setCapability("platformVersion", "7.0");
		/*if(appurl != null || !appurl.equals("")){
			cap.setCapability("app", appurl);
		}*/
		cap.setCapability("appPackage", "com.dp.android.elong");
		//cap.setCapability("appActivity",
		 //"com.elong.activity.others.TabHomeActivity");
		cap.setCapability("appActivity",
				"com.elong.activity.others.AppGuidActivity");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		this.driver = new AppiumDriver<WebElement>(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
	public  AppiumDriver<WebElement> androidDriverRun2()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",deviceName);
	//	com.huawei.systemmanager/.mainscreen.MainScreenActivity: +259ms
		cap.setCapability("appPackage", "com.huawei.systemmanager");
		cap.setCapability("appActivity",
				"mainscreen.MainScreenActivity");
		//"LE67A06200010087"
		cap.setCapability("noReset", true);
		cap.setCapability("fullReset", false);
		cap.setCapability("dontStopAppOnReset", true);
		cap.setCapability("platformVersion", "7.0");
		cap.setCapability("unicodeKeyboard", true);
		cap.setCapability("resetKeyboard", true);
		System.out.println("我是4725");
		this.driver = new AppiumDriver<WebElement>(new URL(
				"http://127.0.0.1:4725/wd/hub"), cap);
		return driver;
	}

	
	public  AppiumDriver iosDriverRun()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "IOS");
		cap.setCapability("platformVersion", "11.0");
		cap.setCapability("deviceName", "iPhone 6s Plus");
		cap.setCapability("bundleId", "com.elong.travel");
		cap.setCapability("udid", "2680be7d55dda2597d57da7cadaa7b848bf08b18");
		AppiumDriver driver = new AppiumDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}
	
}