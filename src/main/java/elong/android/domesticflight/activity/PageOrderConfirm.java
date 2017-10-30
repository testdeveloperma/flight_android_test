package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageOrderConfirm {

	AndroidDriver driver;
	
	
	@AndroidFindBy(id="com.elong.android.flight:id/btn_order_sumbit")
	MobileElement gotoPay;
	@AndroidFindBy(id="com.elong.android.flight:id/tv_order_confirm_price")
	MobileElement totalPrice;
	public PageOrderConfirm(AndroidDriver driver){
		
		this.driver = driver;
		
	}
	
	
	
	public void gotoPay(){
		gotoPay.click();
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

	}
	
	
	
	
	
}
