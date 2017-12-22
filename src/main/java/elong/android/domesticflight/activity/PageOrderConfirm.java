package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageOrderConfirm {

	AppiumDriver<WebElement> driver;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeButton[2]")
	@AndroidFindBy(id = "com.elong.android.flight:id/btn_order_sumbit")
	MobileElement gotoPay;
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_order_confirm_price")
	MobileElement totalPrice;

	private String build;

	private String jenkinsHome;

	private String project;

	public PageOrderConfirm(AppiumDriver<WebElement> driver, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}

	public void gotoPay() {
		try {
			gotoPay.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(jenkinsHome, project,build, driver, "OrderConfirm");
		}

	}

}
