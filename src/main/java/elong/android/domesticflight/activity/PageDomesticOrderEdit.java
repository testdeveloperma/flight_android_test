package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageDomesticOrderEdit{
	AppiumDriver<WebElement> driver;
	
	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeImage/XCUIElementTypeButton[2]")
	@AndroidFindBy(id="com.elong.android.flight:id/next")
	MobileElement next;
	//@AndroidFindBy(accessibility="")
	MobileElement addCustomer;

	public PageDomesticOrderEdit(AppiumDriver driver) {
		this.driver = driver;
		// TODO Auto-generated constructor stub
		// driver.execute(driverCommand, parameters);
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
			AndroidTool.dynamicClick(driver,id, 5);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			AndroidTool.takeScreenShot(driver, "DomesticOrderEdit");
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
