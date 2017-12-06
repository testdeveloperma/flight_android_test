package elong.android.domesticflight.activity;


import org.apache.tools.ant.taskdefs.condition.And;
import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Hello world!
 *
 */
public class PageHome {
	AppiumDriver<WebElement> driver;
	//线上包
	//@AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.view.View[1]")
	@iOSFindBy(accessibility="homeItemFlight.png")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.widget.RelativeLayout[1]")
	MobileElement flight_button;

	
	
	public PageHome(AppiumDriver<WebElement> driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public void clearDialog(){
		String pageSource = driver.getPageSource();
		String id = "com.elong.android.home:id/img_zhichong_close";
		if(pageSource.contains(id)){
			driver.findElementById(id).click();
		}
	}

	public void gotoFlight(){
		try {
			flight_button.click();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(driver, "homepage");
			
		}
	}
}
