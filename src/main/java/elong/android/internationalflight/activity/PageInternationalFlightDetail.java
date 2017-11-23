package elong.android.internationalflight.activity;

import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightDetail {
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="com.elong.android.flight:id/cabinBook")
	MobileElement cabinBook;
	
	
	public void selectCabin(){
		cabinBook.click();
	}
}
