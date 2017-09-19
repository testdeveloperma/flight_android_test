package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class PageOrderPay {

	AndroidDriver driver;
	WebElement payPrice;//支付总价
	
	public PageOrderPay(AndroidDriver driver){
		this.driver = driver;
	}
	public void initViews(){
		try {
			payPrice = driver.findElementById("com.dp.android.elong:id/ca_proAmount");
		} catch (Exception e) {
			AndroidTool.screencap("orderPay");
			e.printStackTrace();
		}

	}
	
	
}
