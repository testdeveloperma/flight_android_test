package elong.android.domesticflight.activity;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageOrderPay {

	AppiumDriver driver;
	@AndroidFindBy(id="com.dp.android.elong:id/payment_head_title")
	MobileElement headTitle;
	@iOSFindBy(accessibility="basevc navback normal")
	@AndroidFindBy(id="com.dp.android.elong:id/common_head_back")
	MobileElement back;
	@AndroidFindBy(id="com.dp.android.elong:id/ca_proAmount")
	MobileElement payPrice;//支付总价
	@iOSFindBy(accessibility="查看订单")
	@AndroidFindBy(id="com.dp.android.elong:id/dialog_positive_button")
	public MobileElement lookOrder; //查看订单
	public PageOrderPay(AppiumDriver driver){
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
