package elong.android.domesticflight.activity;


import com.appium.util.AndroidTool;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageOrderPay {

	AndroidDriver driver;
	@AndroidFindBy(id="com.dp.android.elong:id/ca_proAmount")
	MobileElement payPrice;//支付总价
	
	public PageOrderPay(AndroidDriver driver){
		this.driver = driver;
	}
	
	
	
	
}
