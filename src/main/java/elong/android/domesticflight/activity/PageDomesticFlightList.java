package elong.android.domesticflight.activity;

import java.util.List;
import java.util.Random;

import com.appium.base.mAndroidUtil;

import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class PageDomesticFlightList{
	AndroidDriver<MobileElement> driver;

	@AndroidFindBy(id = "com.elong.android.flight:id/ll_pre_day")
	private MobileElement lastDay; // 前一天按钮
	@AndroidFindBy(id = "com.elong.android.flight:id/ll_next_day")
	private MobileElement nextDay; // 后一天按钮
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[3]")
	@AndroidFindBy(id = "com.elong.android.flight:id/flights_list_result")
	private MobileElement flightList;
	@AndroidFindBy(id = "com.elong.android.flight:id/flight_list_item_wrapper")
	private List<MobileElement> flightLists;
	@AndroidFindBy(id = "com.elong.android.flight:id/flight_info_title_depart")
	private MobileElement departCity; // 出发城市
	@AndroidFindBy(id = "com.elong.android.flight:id/flight_info_title_arrive")
	private MobileElement arriveCity; // 到达城市
	@AndroidFindBy(id = "com.elong.android.flight:id/tv_cur_day_info")
	private MobileElement departDate; // 出发日期

	private String build;

	private String jenkinsHome;

	private String project;

	public PageDomesticFlightList(AndroidDriver<MobileElement> driver2, String jenkinsHome,String project, String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
		this.jenkinsHome = jenkinsHome;
		this.project = project;
		this.build = build;
	}

	/**
	 * 获取航班列表页面数据
	 * 
	 * @return
	 */
	public FlightListData getFlightListData() {
		FlightListData flightListData = new FlightListData();
		flightListData.setDepartCity(departCity.getText());
		flightListData.setArriveCity(arriveCity.getText());
		// 09-14 周四 ¥510
		String text = departDate.getText();
		flightListData.setDepartDate(text);
		return flightListData;
	}

	public void iosselectFlight3() {
		flightList.click();
	}

	/**
	 * 选中航班列表中的第几个航班，下标从0开始
	 * 
	 * @param index
	 */
	public void selectFlight(int index) {
		try {
			flightLists.get(index).click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			mAndroidUtil.takeScreenShot(jenkinsHome, project, build, driver, "DomesticFlightList");
		}

	}
	/**
	 * 使用随机函数，随机选择一个航班
	 */
	public void selectFlight(){
		int i = flightLists.size();
		if(i <= 1){
			selectFlight(0);
		}else{
			Random random = new Random();
			int nextInt = random.nextInt(i-1);
			selectFlight(nextInt);
		}
	}
	
	public static void main(String[] args) {
		Random random = new Random();
		int nextInt = random.nextInt(10);
		System.out.println(nextInt);
	}

}
