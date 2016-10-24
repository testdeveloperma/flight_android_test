package elong.android.flight.test.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class OrderEdit extends AndroidTool {
	AndroidDriver driver;
	WebElement next;
	WebElement addCustomer;
	public OrderEdit(AndroidDriver driver) {
		super(driver);
		this.driver=driver;
		// TODO Auto-generated constructor stub
	//	driver.execute(driverCommand, parameters);
		next=driver.findElementById("com.elong.android.flight:id/next");
		addCustomer=driver.findElementByAndroidUIAutomator("new UiSelector().text(\"添加乘机人\")");
				
				//findElementByName("添加乘机人");
	}
	public void addCustomer() throws InterruptedException, IOException{
		addCustomer.click();
		new SelectCustomer(driver).addCustomer();;
	}
	public void createOrder(){
		//new SelectCustomer(driver)
		next.click();
	}

}
