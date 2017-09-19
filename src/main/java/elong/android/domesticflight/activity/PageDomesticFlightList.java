package elong.android.domesticflight.activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;
import com.appium.util.PageManager;

import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.android.AndroidDriver;

public class PageDomesticFlightList extends AndroidTool {
	AndroidDriver driver;

	private WebElement lastDay; // 前一天按钮
	private WebElement nextDay; // 后一天按钮
	private WebElement flightList;
	private List<WebElement> flightLists;
	private WebElement departCity; // 出发城市
	private WebElement arriveCity; // 到达城市
	private WebElement departDate; // 出发日期

	public PageDomesticFlightList(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void initViews() {

		try {
			lastDay = driver.findElementById("com.elong.android.flight:id/ll_pre_day");
			nextDay = driver.findElementById("com.elong.android.flight:id/ll_next_day");
			flightList = driver.findElementById("com.elong.android.flight:id/flights_list_result");
			flightLists = flightList.findElements(By.className("android.widget.LinearLayout"));
			departCity = driver.findElementById("com.elong.android.flight:id/flight_info_title_depart");
			arriveCity = driver.findElementById("com.elong.android.flight:id/flight_info_title_arrive");
			departDate = driver.findElementById("com.elong.android.flight:id/tv_cur_day_info");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidTool.screencap("domesticFlightList");
			e.printStackTrace();
		}

	}
	/**
	 * 获取航班列表页面数据
	 * @return
	 */
	public FlightListData getFlightListData(){
		FlightListData flightListData = new FlightListData();
		flightListData.setDepartCity(departCity.getText());
		flightListData.setArriveCity(arriveCity.getText());
		//09-14 周四 ¥510
		String text = departDate.getText();
		flightListData.setDepartDate(text);
		return flightListData;
	}
	

	/**
	 * 选中航班列表中的第几个航班，下标从1开始
	 * 
	 * @param index
	 */
	public void selectFlight(int index) {
		flightLists.get(index).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		PageManager pm = new PageManager(driver);
		
		
	}

}
