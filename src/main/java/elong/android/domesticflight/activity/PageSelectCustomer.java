package elong.android.domesticflight.activity;

import java.io.IOException;

import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

public class PageSelectCustomer extends AndroidTool{
	
	private WebElement addCustomer;
	WebElement ok_button;
	AndroidDriver driver;
	public PageSelectCustomer(AndroidDriver driver){
		super(driver);
		this.driver=driver;
		
	}
	
	public void initViews(){
		
		try {
			
			addCustomer=driver.findElementById("com.elong.android.flight:id/add_customer_button_flight");		
			ok_button=driver.findElementById("com.elong.android.flight:id/flight_add_customer_ok");
		
		} catch (Exception e) {
			
			AndroidTool.screencap("selectCustomer");
			e.printStackTrace();
			
		}
	
	
	}
	
	
	public void addCustomer() throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		addCustomer.click();
		//Thread.sleep(2000);
		new PageAddCustomer(driver).addCustomer();
		ok_button.click();
	}
	
}
