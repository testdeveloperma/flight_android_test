package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Hello world!
 *
 */
public class PageHome {
	AppiumDriver<WebElement> driver;
	// 线上包
	// @AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.view.View[1]")
	@iOSFindBy(accessibility = "homeItemFlight.png")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.widget.RelativeLayout[1]")
	MobileElement flight_button;

	private String build;

	private String jenkinsHome;

	private String project;

	public PageHome(AppiumDriver<WebElement> driver, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}

	public void clearDialog(int width, int height) {
		// String pageSource = driver.getPageSource();
		// String id = "com.elong.android.home:id/img_zhichong_close";
		// if(pageSource.contains(id)){
		// driver.findElementById(id).click();
		// }
		String pageSource = driver.getPageSource();
		String homepageid = "com.dp.android.elong:id/shouye";
		for (int i = 0; i < 6; i++) {
			if (pageSource.contains(homepageid))
				break;
			else {
				try {
					Thread.sleep(1000);
					pageSource = driver.getPageSource();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int x = 300 * width / 1540;
		int y = 2480 * height / 2560;
		TouchAction touch = new TouchAction(driver);
		touch.press(x, y).release().perform();
	}

	public void gotoFlight() {
		try {
			flight_button.click();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(jenkinsHome, project,build, driver, "homepage");

		}
	}
}
