package elong.android.internationalflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightDetail {
	AppiumDriver<WebElement> driver;
	
	@AndroidFindBy(id="com.elong.android.flight:id/cabinBook")
	MobileElement cabinBook;
	
	
	public void selectCabin(){
		try {
			cabinBook.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(driver, "InternationalFlightDetail");
		}
	}
}
