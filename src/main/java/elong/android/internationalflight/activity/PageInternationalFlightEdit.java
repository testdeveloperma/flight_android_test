package elong.android.internationalflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightEdit {
	AppiumDriver<WebElement> driver;

	@AndroidFindBy(id = "com.elong.android.flight:id/next")
	MobileElement next;

	private String build;

	private String jenkinsHome;

	private String project;

	public void submitOrder() {
		try {
			next.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(jenkinsHome, project,build, driver, "InternationalFlightEdit");
		}
	}
}
