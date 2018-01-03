package com.elong.android.flight.test;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.base.mAndroidUtil;
import com.appium.base.MyDriver;
import com.appium.base.PageManager;
import io.appium.java_client.android.AndroidDriver;

public class IOSBasicTestCase {

	AndroidDriver driver;
	mAndroidUtil appium;
//	PageFlightFirstPage firstpage;
	PageManager pm;
	@BeforeClass
	public void setUp(String build) throws MalformedURLException, InterruptedException{
		driver=new MyDriver().iosDriverRun();
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//		pm = new PageManager(driver,build);
		appium=new mAndroidUtil(driver);
				
		pm.getPageHome().gotoFlight();
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterClass
	public void tearDown(){
		//driver.removeApp("com.dp.android.elong");
		driver.quit();
	}
}
