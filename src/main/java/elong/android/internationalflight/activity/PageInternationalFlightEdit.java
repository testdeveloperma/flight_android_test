package elong.android.internationalflight.activity;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightEdit {
	AndroidDriver<MobileElement> driver;

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
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "InternationalFlightEdit");
		}
	}
}
