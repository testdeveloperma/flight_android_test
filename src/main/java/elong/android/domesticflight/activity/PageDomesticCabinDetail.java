package elong.android.domesticflight.activity;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;

import elong.android.domesticflight.bean.CabinDetailData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageDomesticCabinDetail extends AndroidTool {
	AppiumDriver<WebElement> driver;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeButton[4]")
	@AndroidFindBy(id = "com.elong.android.flight:id/ll_cabin_item_book")
	List<MobileElement> bookButtons; // 预定按钮
	@AndroidFindBy(id = "com.elong.android.flight:id/main_price")
	List<MobileElement> price; // 票价控件
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_flight_number_depart_city")
	private MobileElement departCity; // 出发城市
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_flight_number_arrive_city")
	private MobileElement arriveCity; // 到达城市'
	@AndroidFindBy(id = "com.elong.android.flight:id/common_head_title")
	private MobileElement departDate; // 出发日期
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_flight_number_time_start")
	private MobileElement departTime; // 出发时间
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_flight_number_time_end")
	private MobileElement arriveTime; // 到达时间
	
	private String build;
	public PageDomesticCabinDetail(AppiumDriver driver,String build) {
		super(driver);
		this.driver = driver;
		this.build = build;
	}

	public CabinDetailData getCabinDetailData() {
		CabinDetailData cabinDetailData = new CabinDetailData();
		cabinDetailData.setDepartCity(departCity.getText());
		cabinDetailData.setArriveCity(arriveCity.getText());
		cabinDetailData.setDepartDate(departDate.getText());
		cabinDetailData.setDepartTime(departTime.getText());
		cabinDetailData.setArriveTime(arriveTime.getText());
		return cabinDetailData;
	}

	public void getFlightTicketPrice() {
		int ticketPrice = 0;
		String priceText = price.get(0).getText();
		System.out.println(priceText);
		// Integer.valueOf(priceText.substring(1));
		// System.out.println(ticketPrice+"");

	}

	/**
	 * 点击预定按钮，进入舱位详情页
	 * 
	 * @throws InterruptedException
	 */
	public void clickBookButton() {
		
		try {
			bookButtons.get(1).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			AndroidTool.takeScreenShot(build,driver, "DomesticCabinDetail");
		}

	}

}
