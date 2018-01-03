package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageSelectCustomer extends mAndroidUtil{
	@AndroidFindBy(id="com.elong.android.flight:id/add_customer_button_flight")
	private MobileElement addCustomer;
	@AndroidFindBy(id="com.elong.android.flight:id/flight_add_customer_ok")
	MobileElement ok_button;
	AndroidDriver<WebElement> driver;
	public PageSelectCustomer(AndroidDriver driver){
		super(driver);
		this.driver=driver;
		
	}
	

	
	public void addCustomer() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		addCustomer.click();
		//Thread.sleep(2000);
		new PageAddCustomer(driver).addCustomer();
		ok_button.click();
	}
	
}
