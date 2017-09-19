package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class PageDomesticOrderEdit extends AndroidTool {
	AndroidDriver driver;
	WebElement next;
	WebElement addCustomer;

	public PageDomesticOrderEdit(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		// driver.execute(driverCommand, parameters);

	}

	public void initViews() {
		try {
			next = driver.findElementById("com.elong.android.flight:id/next");
			addCustomer = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"添加\")");
		} catch (Exception e) {
			screencap("orderedit");
			e.printStackTrace();
		}

		// findElementByName("添加乘机人");
	}

	public void addCustomer() throws InterruptedException, IOException {
		addCustomer.click();
		new PageSelectCustomer(driver).addCustomer();
		;
	}

	public void createOrder() {
		// new SelectCustomer(driver)

		next.click();
		// 确认页6秒进度条
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
