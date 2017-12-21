package com.elong.android.flight.test;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;
import com.appium.base.MyDriver;
import com.appium.base.PageManager;
import com.appium.listener.DialogCheck;
import com.appium.listener.InstallThread;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;

public class Main {
	static AppiumDriver<WebElement> driver;
	AndroidTool appium;
	// PageFlightFirstPage firstpage;
	static PageManager pm;
	public static String appurl = "/Users/user/Downloads/Elong_Trunk_9360_110.apk";

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
					
			driver = new MyDriver().androidDriverRun();
			driver.removeApp("com.dp.android.elong");
			InstallThread installThread = new InstallThread();
			installThread.setAppurl(appurl);
			installThread.setDriver(driver);
			
			DialogCheck dialogCheck = new DialogCheck(driver);
			installThread.start();
			dialogCheck.start();
			String build = null;			
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			pm = new PageManager(driver,build);
			//appium=new AndroidTool(driver);
			
		//	boolean foundTabHomeActivity=appium.waitForActivity("com.elong.activity.others.TabHomeActivity");		
		//	Assert.assertTrue(foundTabHomeActivity);
			String pageSource = driver.getPageSource();
			String continueee = "com.dp.android.elong:id/continueee";
			 for (int i = 0; i < 5; i++) {
				if(pageSource.contains(continueee)){
					
					driver.findElementById("com.dp.android.elong:id/continueee").click();

					break;
				}else{
					TouchAction touch = new TouchAction(driver);
					touch.press(1100,1000).moveTo(-500, 0).release().perform();
					Thread.sleep(500);
					System.out.println(i);
					pageSource = driver.getPageSource();
				}
			}
//			pm.getPageHome().clearDialog();
			pm.getPageHome().gotoFlight();
			//firstpage=new PageFlightFirstPage(driver);
			
		}
	}

