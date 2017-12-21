package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageSelectCity {
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="com.elong.android.flight:id/city_select_search")
	MobileElement city_select_search;
	@AndroidFindBy(id="com.elong.android.flight:id/flight_search_bottomtab_domestic")
	MobileElement domestic;
	
	public PageSelectCity(AppiumDriver<WebElement> driver){
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
		city_select_search.sendKeys(city);
		long end = System.currentTimeMillis();
		System.out.println("time: " + (end - start));
		domestic.click();
	}
}
