package com.elong.android.flight.test;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import javax.swing.event.SwingPropertyChangeSupport;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.appium.base.AndroidTool;
import com.appium.base.AppiumServer;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasicTestCase {

	static AppiumDriver<WebElement> driver;
	AndroidTool appium;
//	PageFlightFirstPage firstpage;
	static PageManager pm;
	@BeforeSuite
	@Parameters("appurl")
	public void setUp(String appurl) throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().androidDriverRun(appurl);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pm = new PageManager(driver);
		//appium=new AndroidTool(driver);
		
	//	boolean foundTabHomeActivity=appium.waitForActivity("com.elong.activity.others.TabHomeActivity");		
	//	Assert.assertTrue(foundTabHomeActivity);
		String pageSource = driver.getPageSource();
		String photo = "com.dp.android.elong:id/app_start_photo_item";
		 for (int i = 0; i < 5; i++) {
			if(pageSource.contains(photo)){
				TouchAction touch = new TouchAction(driver);
				touch.press(1100,1000).moveTo(-500, 0).release().perform();
				driver.findElementById("com.dp.android.elong:id/continueee").click();

				break;
			}else{
				Thread.sleep(500);
				System.out.println(i);
				pageSource = driver.getPageSource();
			}
		}
		pm.getPageHome().clearDialog();
		pm.getPageHome().gotoFlight();
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterSuite
	public void tearDown(){
		driver.removeApp("com.dp.android.elong");
		
		driver.quit();
	}
}
