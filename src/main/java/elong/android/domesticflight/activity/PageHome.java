package elong.android.domesticflight.activity;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

/**
 * Hello world!
 *
 */
public class PageHome {
	AndroidDriver<MobileElement> driver;
	// 线上包
	// @AndroidFindBy(xpath="//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.view.View[1]")
	@iOSFindBy(accessibility = "homeItemFlight.png")
	@AndroidFindBy(xpath = "//android.widget.RelativeLayout[@resource-id=\"com.elong.android.home:id/home_module_flight\"]/android.widget.RelativeLayout[1]")
	MobileElement flight_button;

	@AndroidFindBy(id="com.dp.android.elong:id/home_debug_server")
	MobileElement debug_server;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"com.dp.android.elong:id/popup_multicheck_list\"]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
	MobileElement preline;
	
	private String build;

	private String jenkinsHome;

	private String project;

	public PageHome(AndroidDriver<MobileElement> driver2, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}
	
	public void setPreLine(){
		debug_server.click();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		preline.click();
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
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "homepage");

		}
	}
}
