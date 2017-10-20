package com.elong.android.flight.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.appium.util.AndroidTool;
import com.appium.util.AppiumServer;
import com.appium.util.PageManager;

import elong.android.domesticflight.activity.PageFlightFirstPage;
import io.appium.java_client.android.AndroidDriver;

public class BasicTestCase {

	AndroidDriver driver;
	AndroidTool appium;
//	PageFlightFirstPage firstpage;
	PageManager pm;
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().androidDriverRun();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pm = new PageManager(driver);
		appium=new AndroidTool(driver);
		
		boolean foundTabHomeActivity=appium.waitForActivity("com.elong.activity.others.TabHomeActivity");		
		Assert.assertTrue(foundTabHomeActivity);
		
		//进入机票首页
		//WebElement selectAir=driver.findElementByXPath("//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.view.View[1]");
		//测试包
		WebElement selectAir=driver.findElementByXPath("//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.widget.RelativeLayout[1]");
		
				//findElementByAccessibilityId("com.elong.android.home:id/home_module_flight");		
		
		
		selectAir.click();	
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterClass
	public void tearDown(){
		//driver.removeApp("com.dp.android.elong");
		driver.quit();
	}
}
