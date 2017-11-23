package com.elong.android.flight.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.base.AndroidTool;
import com.appium.base.AppiumServer;
import com.appium.base.PageManager;

import elong.android.domesticflight.activity.PageFlightFirstPage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class IOSBasicTestCase {

	AppiumDriver driver;
	AndroidTool appium;
//	PageFlightFirstPage firstpage;
	PageManager pm;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().iosDriverRun();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pm = new PageManager(driver);
		appium=new AndroidTool(driver);
				
		pm.getPageHome().gotoFlight();
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterClass
	public void tearDown(){
		//driver.removeApp("com.dp.android.elong");
		driver.quit();
	}
}
