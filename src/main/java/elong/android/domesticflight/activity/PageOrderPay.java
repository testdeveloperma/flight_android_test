package elong.android.domesticflight.activity;


import com.appium.util.AndroidTool;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageOrderPay {

	AndroidDriver driver;
	@AndroidFindBy(id="com.dp.android.elong:id/payment_head_title")
	MobileElement headTitle;
	@AndroidFindBy(id="com.dp.android.elong:id/common_head_back")
	MobileElement back;
	@AndroidFindBy(id="com.dp.android.elong:id/ca_proAmount")
	MobileElement payPrice;//支付总价
	@AndroidFindBy(id="com.dp.android.elong:id/dialog_positive_button")
	public MobileElement lookOrder; //查看订单
	public PageOrderPay(AndroidDriver driver){
		this.driver = driver;
	}
	public void gotoOrderDetail(){
		lookOrder.click();
	}
	
	public void goBack(){
		headTitle.getText();
		back.click();
	}
	
}
