package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageDomesticOrderEdit extends AndroidTool {
	AndroidDriver driver;
	@AndroidFindBy(id="com.elong.android.flight:id/next")
	MobileElement next;
	@AndroidFindBy(name="添加")
	MobileElement addCustomer;

	public PageDomesticOrderEdit(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		// TODO Auto-generated constructor stub
		// driver.execute(driverCommand, parameters);

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
