package elong.android.domesticflight.activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;
import com.appium.util.PageManager;

import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageDomesticFlightList extends AndroidTool {
	AndroidDriver driver;

	@AndroidFindBy(id="com.elong.android.flight:id/ll_pre_day")
	private WebElement lastDay; // 前一天按钮
	@AndroidFindBy(id="com.elong.android.flight:id/ll_next_day")
	private WebElement nextDay; // 后一天按钮
	@AndroidFindBy(id="com.elong.android.flight:id/flights_list_result")
	private WebElement flightList;
	@AndroidFindBy(className="android.widget.LinearLayout")
	private List<WebElement> flightLists;
	@AndroidFindBy(id="com.elong.android.flight:id/flight_info_title_depart")
	private WebElement departCity; // 出发城市
	@AndroidFindBy(id="com.elong.android.flight:id/flight_info_title_arrive")
	private WebElement arriveCity; // 到达城市
	@AndroidFindBy(id="com.elong.android.flight:id/tv_cur_day_info")
	private WebElement departDate; // 出发日期

	public PageDomesticFlightList(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
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
