package elong.android.domesticflight.activity;

import java.io.IOException;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageDomesticOrderEdit {
	AndroidDriver<MobileElement> driver;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage/XCUIElementTypeButton[2]")
	@AndroidFindBy(id = "com.elong.android.flight:id/next")
	MobileElement next;
	// @AndroidFindBy(accessibility="")
	MobileElement addCustomer;

	private String build;

	private String jenkinsHome;

	private String project;

	public PageDomesticOrderEdit(AndroidDriver<MobileElement> driver2, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}

	public void addCustomer() throws InterruptedException, IOException {
		addCustomer.click();
		new PageSelectCustomer(driver).addCustomer();
	}

	public void createOrder() {
		// new SelectCustomer(driver)

		try {
			next.click();
			String id = "com.elong.android.flight:id/tv_direct_pay";
			mAndroidUtil.dynamicClick(driver, id, 5);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "DomesticOrderEdit");
		}
		// 确认页10秒进度条
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
