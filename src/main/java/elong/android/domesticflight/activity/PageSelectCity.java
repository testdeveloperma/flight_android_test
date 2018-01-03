package elong.android.domesticflight.activity;


import org.openqa.selenium.WebElement;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyMetastate;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageSelectCity {
	AndroidDriver<MobileElement> driver;
	
	@AndroidFindBy(id="com.elong.android.flight:id/city_select_search")
	MobileElement city_select_search;
	@AndroidFindBy(id="com.elong.android.flight:id/flight_search_bottomtab_domestic")
	MobileElement domestic;
	
	public PageSelectCity(AndroidDriver<MobileElement> driver){
		this.driver = driver;
	}
		
	public void selectCity(String city){
		//adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'	
//		String cmd = "adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'";
//		try {
//			AndroidTool.executeAdbShell(cmd);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		long start = System.currentTimeMillis();
//		city_select_search.sendKeys(city);
		String cmd = "adb shell am broadcast -a clipper.set -e text " + city;
		mAndroidUtil.executeAdbShell(cmd);
		mAndroidUtil.dynamicWait(driver, "定位", 3000);
		driver.pressKeyCode(50, AndroidKeyMetastate.META_CTRL_ON);
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		domestic.click();
	}
}
