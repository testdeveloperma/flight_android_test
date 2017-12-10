package com.appium.listener;


import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.appium.base.AndroidTool;
import com.appium.base.AppiumServer;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class AppiumListener {

	static AppiumDriver<WebElement> driver;
	static boolean isListen = true;
	AndroidTool appium;
	@BeforeTest
	public void beforeSuite(String appurl) throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().androidDriverRun();	
		
	}
	
	@Test
	public void testListen(){
		Map<String, String> elements = new HashMap<>();
		elements.put("huawei_id", "com.android.packageinstaller:id/decide_to_continue");
		elements.put("goon_name", "继续安装");
		while (isListen) {
			String pageSource = driver.getPageSource();
			if(pageSource.contains(elements.get("huawei_id"))){
				
				driver.findElementById(elements.get("huawei_id")).click();
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				driver.findElementByName(elements.get("goon_name")).click();;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
//		for(Map.Entry<String, String> entry:elements.entrySet()){
//			if(pageSource.contains(entry.getValue())){
//				
//				driver.findElementById(entry.getValue()).click();
//				driver.findElementByName(goOn);
//			}
//		}
		
		
		
	}
	
	@AfterTest
	public void afterSuite(){
		driver.quit();
	}
	
	
	
	

}
