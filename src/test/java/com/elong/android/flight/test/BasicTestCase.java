package com.elong.android.flight.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.MalformedURLException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.appium.base.AndroidTool;
import com.appium.base.AppiumServer;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasicTestCase {

	static AppiumDriver<WebElement> driver;
	AndroidTool appium;
//	PageFlightFirstPage firstpage;
	static PageManager pm;
	@BeforeTest
	@Parameters("appurl")
	public void beforeSuite(String appurl) throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().androidDriverRun(appurl);
		//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		pm = new PageManager(driver);
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
		pm.getPageHome().clearDialog();
		pm.getPageHome().gotoFlight();
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterTest
	public void afterSuite(){
		driver.removeApp("com.dp.android.elong");	
		driver.quit();
	}
	
	
	public void setUp(){
		String cmd = "adb shell ps |grep \"com.dp.android.elong\"";
//		String cmd = "adb devices";
		BufferedReader adbShellResult = AndroidTool.getAdbShellResult(cmd);
		try {
			String line;
			if((line = adbShellResult.readLine()) == null){
				BufferedReader br = AndroidTool.getAdbShellResult("adb shell am start -W -n com.dp.android.elong/com.elong.activity.others.AppGuidActivity");
				pm.getPageHome().gotoFlight();
				System.out.println("开启APP");
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public void tearDown() {
		AndroidTool.executeAdbShell("adb shell am force-stop com.dp.android.elong");
		String cmd = "adb shell ps |grep \"com.dp.android.elong\"";
		for (int i = 0; i < 7; i++) {

			BufferedReader adbShellResult = AndroidTool.getAdbShellResult(cmd);
			try {
				String line = null;
				if ((line = adbShellResult.readLine()) != null) {
					AndroidTool.executeAdbShell("adb shell am force-stop com.dp.android.elong");
					System.out.println("关闭APP " + i);
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	

}
