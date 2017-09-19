package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;
import com.appium.util.AndroidTool;

import elong.android.domesticflight.bean.CabinDetailData;
import io.appium.java_client.android.AndroidDriver;

public class PageDomesticCabinDetail extends AndroidTool {
	AndroidDriver driver;
	WebElement bookButton; // 预定按钮
	WebElement price; // 票价控件
	private WebElement departCity; // 出发城市
	private WebElement arriveCity; // 到达城市
	private WebElement departDate; // 出发日期
	private WebElement departTime; // 出发日期
	private WebElement arriveTime; // 出发日期

	public PageDomesticCabinDetail(AndroidDriver driver) {
		super(driver);
		this.driver = driver;

	}

	public void initViews() {
		try {
			bookButton = driver.findElementByXPath(
					"//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/lv_flights_info\"]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]");
			price = driver.findElementsById("com.elong.android.flight:id/main_price").get(0);
			departCity = driver.findElementById("com.elong.android.flight:id/tv_flight_number_depart_city");
			arriveCity = driver.findElementById("com.elong.android.flight:id/tv_flight_number_arrive_city");
			departDate = driver.findElementById("com.elong.android.flight:id/common_head_title");
			departTime = driver.findElementById("com.elong.android.flight:id/tv_flight_number_time_start");
			arriveTime = driver.findElementById("com.elong.android.flight:id/tv_flight_number_time_end");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidTool.screencap("domestiCabinDetail");
			e.printStackTrace();
		}

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
		String priceText = price.getText();
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
		bookButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
