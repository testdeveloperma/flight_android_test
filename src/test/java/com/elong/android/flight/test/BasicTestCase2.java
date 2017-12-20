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
import com.appium.base.MyDriver;
import com.appium.base.PageManager;
import com.appium.base.UpdateApp;
import com.appium.listener.AppiumListener;
import com.appium.listener.DialogCheck;
import com.appium.listener.InstallThread;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class BasicTestCase2 {

	static AppiumDriver<WebElement> driver;
	AndroidTool appium;
//	PageFlightFirstPage firstpage;
	static PageManager pm;
	@BeforeTest
	@Parameters(value={"appurl","build"})
	public void beforeSuite(String appurl,String build) throws MalformedURLException, InterruptedException{
		String force = "adb shell am force-stop io.appium.unlock";
		AndroidTool.executeAdbShell(force);
		
		String start = "adb shell am start -W -n io.appium.unlock/.Unlock -a android.intent.action.Main -c android.intent.category.LAUNCHER -f 0x10200000";
		AndroidTool.executeAdbShell(start);
		
		String packageName = "com.dp.android.elong";
		if(appurl != null && !appurl.equals("")) {
			UpdateApp updateApp = new UpdateApp();
			updateApp.install(packageName, appurl);
		}
		String uicmd = "adb shell am instrument -w -r   -e debug false -e class com.chengjunma.apk_install.InstrumentedTest com.chengjunma.apk_install.test/android.support.test.runner.AndroidJUnitRunner";
		AndroidTool.executeAdbShell(uicmd);
		waitinstall();
		
		
		driver = new MyDriver().androidDriverRun();
		//driver.removeApp("com.dp.android.elong");
//		InstallThread installThread = new InstallThread();
//		installThread.setAppurl(appurl);
//		installThread.setDriver(driver);
//		
//		DialogCheck dialogCheck = new DialogCheck(driver);
//		installThread.start();
//		dialogCheck.start();
		
		
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
		pm.getPageHome().clearDialog();
		pm.getPageHome().gotoFlight();
		//firstpage=new PageFlightFirstPage(driver);
		
	}
	
	@AfterTest
	public void afterSuite(){
		System.out.println("4723正在关闭。。。");
//		driver.removeApp("com.dp.android.elong");	
		driver.quit();
		AppiumListener.isListen = false;
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
	
	
	public static void main(String[] args){

		String cmd = "adb shell ps | grep \"uiautomator\"";
		BufferedReader adbShellResult = AndroidTool.getAdbShellResult(cmd);
		try {
			String line = adbShellResult.readLine();
			System.err.println(line);
			if(line != null){
				String[] split = line.split(" ");
				for (int i = 0; i < split.length; i++) {
					String string = split[i];
					System.out.println(string);
					
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	
	}

	public static void waitinstall() {
		for(int i = 0;i< 30; i++){
			System.out.println(i);
			String cmd = "adb shell pm list package|grep \"com.dp.android.elong\"";
			BufferedReader bufferedReader = AndroidTool.getAdbShellResult(cmd);
			
			try {
				String line = bufferedReader.readLine();
				if(line != null)
					break;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
