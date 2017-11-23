package elong.android.internationalflight.activity;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightList {
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/iflightList\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]")
	MobileElement flight1;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/iflightList\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")
	MobileElement backFlight;
	public void selectFlight(){
		flight1.click();
		backFlight.click();
	}
}
