package elong.android.internationalflight.activity;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightDetail {
	AndroidDriver<MobileElement> driver;

	@AndroidFindBy(id = "com.elong.android.flight:id/cabinBook")
	MobileElement cabinBook;

	private String build;

	private String jenkinsHome;

	private String project;

	public void selectCabin() {
		try {
			cabinBook.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "InternationalFlightDetail");
		}
	}
}
