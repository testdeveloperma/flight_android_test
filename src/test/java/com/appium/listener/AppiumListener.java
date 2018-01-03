package com.appium.listener;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.android.AndroidDriver;

public class AppiumListener {

	static AndroidDriver<WebElement> driver;
	public static boolean isListen = true;
	mAndroidUtil appium;

	@BeforeTest
	public void beforeSuite() throws MalformedURLException, InterruptedException {
		
/*		driver = new AppiumServer().androidDriverRun();
*/
	}

	@Test
	public void testListen() {
		Map<String, String> elements = new HashMap<>();
		elements.put("huawei_id", "com.android.packageinstaller:id/decide_to_continue");
		elements.put("goon_name", "android:id/button1");
		while (isListen) {
			String pageSource = driver.getPageSource();

			for (Map.Entry<String, String> entry : elements.entrySet()) {
				if (pageSource.contains(entry.getValue())) {

					driver.findElementById(entry.getValue()).click();
					break;
				}
			}
			
			 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 

			// if (pageSource.contains(elements.get("huawei_id"))) {
			//
			// driver.findElementById(elements.get("huawei_id")).click();
			// try {
			// Thread.sleep(500);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
			// driver.findElementById(elements.get("goon_name")).click();
			//
			// }
			// try {
			// Thread.sleep(2000);
			// } catch (InterruptedException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		}

	}

	@AfterTest
	public void afterSuite() {
		System.out.println("4725正在停止...");
		driver.quit();
	}

}
