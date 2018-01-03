package elong.android.domesticflight.activity;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageOrderPay {

	AndroidDriver<MobileElement> driver;
	@AndroidFindBy(id = "com.dp.android.elong:id/payment_head_title")
	MobileElement headTitle;
	@iOSFindBy(accessibility = "basevc navback normal")
	@AndroidFindBy(id = "com.dp.android.elong:id/common_head_back")
	MobileElement back;
	@AndroidFindBy(id = "com.dp.android.elong:id/ca_proAmount")
	MobileElement payPrice;// 支付总价
	@iOSFindBy(accessibility = "查看订单")
	@AndroidFindBy(id = "com.dp.android.elong:id/dialog_positive_button")
	public MobileElement lookOrder; // 查看订单
	private String build;

	private String jenkinsHome;

	private String project;

	public PageOrderPay(AndroidDriver<MobileElement> driver2, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}

	public void gotoOrderDetail() {
		try {
			lookOrder.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "lookOrder");
		}
	}

	public void goBack() {
		try {
			headTitle.getText();
			back.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "orderPay");
		}
	}

}
