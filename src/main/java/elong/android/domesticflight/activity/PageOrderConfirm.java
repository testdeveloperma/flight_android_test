package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class PageOrderConfirm {

	AndroidDriver driver;
	WebElement gotoPay;
	WebElement totalPrice;
	public PageOrderConfirm(AndroidDriver driver){
		
		this.driver = driver;
		
	}
	
	public void initViews(){
		try {
			gotoPay = driver.findElementById("com.elong.android.flight:id/btn_order_sumbit");
			totalPrice = driver.findElementById("com.elong.android.flight:id/tv_order_confirm_price");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidTool.screencap("orderConfirm");
			e.printStackTrace();
		}
	}
	
	public void gotoPay(){
		gotoPay.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
}
