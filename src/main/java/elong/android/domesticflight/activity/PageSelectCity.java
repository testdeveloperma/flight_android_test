package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class PageSelectCity {
	AndroidDriver driver;
	WebElement city_select_search;
	WebElement domestic;
	public PageSelectCity(AndroidDriver driver){
		this.driver = driver;
	}
	
	public void initViews(){
		try {
			city_select_search=driver.findElementById("com.elong.android.flight:id/city_select_search");
			domestic=driver.findElementById("com.elong.android.flight:id/flight_search_bottomtab_domestic");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidTool.screencap("selectCity");
			e.printStackTrace();
		}
	}
	
	public void selectCity(String city){
		//adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'		
		//Runtime.getRuntime().exec("adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'");				
		city_select_search.sendKeys(city);
		domestic.click();
	}
}
