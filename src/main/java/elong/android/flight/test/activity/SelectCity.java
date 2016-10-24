package elong.android.flight.test.activity;

import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;

public class SelectCity {
	AndroidDriver driver;
	WebElement city_select_search;
	WebElement domestic;
	public SelectCity(AndroidDriver driver){
		city_select_search=driver.findElementById("com.elong.android.flight:id/city_select_search");
		domestic=driver.findElementById("com.elong.android.flight:id/flight_search_bottomtab_domestic");
	}
	public void selectCity(String city){
		//adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'		
		//Runtime.getRuntime().exec("adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'");
				
		city_select_search.sendKeys(city);
		domestic.click();
	}
}
