package elong.android.internationalflight.activity;

import com.appium.base.mAndroidUtil;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageInternationalFlightList {
	AndroidDriver<MobileElement> driver;

	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/iflightList\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout[1]")
	MobileElement flight1;

	@AndroidFindBy(xpath = "//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/iflightList\"]/android.widget.LinearLayout[1]/android.widget.LinearLayout[1]")
	MobileElement backFlight;

	private String build;

	private String jenkinsHome;

	private String project;

	public void selectFlight() {
		try {
			flight1.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "InternationalFlightList");
		}
	}

	public void selectRoundFlight() {
		try {
			flight1.click();
			backFlight.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project,build, driver, "InternationalRoundFlightList");
		}
	}
}
