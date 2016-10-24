package com.appium.util;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

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



	public  AndroidDriver androidDriverRun()
			throws MalformedURLException, InterruptedException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("platformName", "Android");
		cap.setCapability("deviceName",deviceName);
		//"LE67A06200010087"
		cap.setCapability("platformVersion", "6.0");
		cap.setCapability("appPackage", "com.dp.android.elong");
		//cap.setCapability("appActivity",
		 //"com.elong.activity.others.TabHomeActivity");
		cap.setCapability("appActivity",
				"com.elong.activity.others.AppGuidActivity");
		cap.setCapability("unicodeKeyboard", "True");
		cap.setCapability("resetKeyboard", "True");
		AndroidDriver driver = new AndroidDriver(new URL(
				"http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

	
}
