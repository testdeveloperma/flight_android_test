package elong.android.domesticflight.activity;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import elong.android.domesticflight.bean.CabinDetailData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageDomesticCabinDetail extends AndroidTool {
	AndroidDriver driver;
	
	@AndroidFindBy(xpath="//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/lv_flights_info\"]/android.widget.RelativeLayout[2]/android.widget.LinearLayout[1]/android.widget.RelativeLayout[1]/android.widget.RelativeLayout[1]/android.widget.LinearLayout[2]/android.widget.TextView[1]")
	WebElement bookButton; // 预定按钮
	@AndroidFindBy(id="com.elong.android.flight:id/main_price")
	List<MobileElement> price; // 票价控件
	@AndroidFindBy(id="com.elong.android.flight:id/tv_flight_number_depart_city")
	private MobileElement departCity; // 出发城市
	@AndroidFindBy(id="com.elong.android.flight:id/tv_flight_number_arrive_city")
	private MobileElement arriveCity; // 到达城市'
	@AndroidFindBy(id="com.elong.android.flight:id/common_head_title")
	private MobileElement departDate; // 出发日期
	@AndroidFindBy(id="com.elong.android.flight:id/tv_flight_number_time_start")
	private MobileElement departTime; // 出发日期
	@AndroidFindBy(id="com.elong.android.flight:id/tv_flight_number_time_end")
	private MobileElement arriveTime; // 出发日期

	public PageDomesticCabinDetail(AndroidDriver driver) {
		super(driver);
		this.driver = driver;

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
		bookButton.click();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

}
