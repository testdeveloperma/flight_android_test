package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

/**
 * Hello world!
 *
 */
public class PageHome {
	AndroidDriver driver;
	//线上包
	//@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.view.View[1]")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.widget.RelativeLayout[1]")
	MobileElement flight_button;

	
	
	public PageHome(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}



	public void gotoFlight(){
		flight_button.click();
	}
}
