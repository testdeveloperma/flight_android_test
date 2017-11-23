package elong.android.domesticflight.activity;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageSelectCity {
	AppiumDriver driver;
	
	@AndroidFindBy(id="com.elong.android.flight:id/city_select_search")
	MobileElement city_select_search;
	@AndroidFindBy(id="com.elong.android.flight:id/flight_search_bottomtab_domestic")
	MobileElement domestic;
	
	public PageSelectCity(AppiumDriver driver){
		this.driver = driver;
	}
		
	public void selectCity(String city){
		//adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'		
		//Runtime.getRuntime().exec("adb shell am broadcast -a ADB_INPUT_TEXT --es msg '广州'");				
		city_select_search.sendKeys(city);
		domestic.click();
	}
}
