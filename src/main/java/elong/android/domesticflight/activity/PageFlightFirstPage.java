package elong.android.domesticflight.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageFlightFirstPage{
	AppiumDriver<WebElement> driver;
	PageManager pm;
	@AndroidFindBy(id="com.elong.android.flight:id/flightssearch_arrivedate_trigger")
	MobileElement backDate;		//返程出发日期
	@AndroidFindBy(id="com.elong.android.flight:id/rb_search_tab_round")
	MobileElement roundTab;		//往返标签
	@iOSFindBy(xpath="//XCUIElementTypeApplication[@name=\"艺龙旅行\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeScrollView/XCUIElementTypeOther[3]/XCUIElementTypeButton")
	@AndroidFindBy(id="com.elong.android.flight:id/flightsearch_submit")
	MobileElement searchButton;		//搜索按钮
	@AndroidFindBy(id="com.elong.android.flight:id/rb_search_tab_global")
	MobileElement interFlightTab;	//国际标签
	@AndroidFindBy(id="com.elong.android.flight:id/flightssearch_leavecity")
	MobileElement departCity;		//出发城市按钮
	@AndroidFindBy(id="com.elong.android.flight:id/flightssearch_arrivecity")
	MobileElement arriveCity;		//到达城市按钮
	boolean foundActivity;
	@AndroidFindBy(id="com.elong.android.flight:id/flightsearch_leave_date")
	MobileElement departDate;		//出发日期标签
	
	
	public PageFlightFirstPage(AppiumDriver driver,String jenkinsHome,String project,String build) {	
		this.driver = driver;
		pm = new PageManager(driver,jenkinsHome,project,build);
	}
	public void clearBoot(){
		String pageSource = driver.getPageSource();
		String id = "com.elong.android.flight:id/btn_close";
		for (int i = 0; i < 5; i++) {
			if(pageSource.contains(id)){
				driver.findElementById(id).click();
				break;
			}else{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pageSource = driver.getPageSource();
			}
		}
		
	}
	

	public void selectDepartDate(){
		departDate.click();
		String xpath = AndroidTool.getTimeXpath();
		List<WebElement> flightDate = driver.findElementsByXPath(xpath);
		if(flightDate.size() > 1){
			flightDate.get(1).click();
		}else{
			flightDate.get(0).click();
		}
		

		//WebElement date_list = driver.findElementById("com.elong.android.flight:id/date_list");
		//List<WebElement> linearLayouts = date_list.findElements(By.);
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[1]
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[2]
		
	}
	
	public void selectBackDate(){
		backDate.click();
		String xpath = AndroidTool.getTimeXpath();
		List<WebElement> flightDate = driver.findElementsByXPath(xpath);
			if(flightDate.size() > 1){
				flightDate.get(1).click();
			}else{
				flightDate.get(0).click();
			}
				
			
	}
	/**
	 * 指定航班搜索日期
	 * @param date  格式：2018-1-1 
	 */
	public void selectDepartDate(String date){
		departDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = AndroidTool.getTimeXpath(date);
		List<WebElement> today = driver.findElementsByXPath(xpath);
		String[] split = date.split("-");
		SimpleDateFormat df = new SimpleDateFormat("MM");
		String format = df.format(new Date());
		int res = Integer.valueOf(split[1]) - Integer.valueOf(format);
		if(res == 1 && today.size() == 2){
			today.get(1).click();
		}else{
			today.get(0).click();
		}
//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		//WebElement date_list = driver.findElementById("com.elong.android.flight:id/date_list");
		//List<WebElement> linearLayouts = date_list.findElements(By.);
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[1]
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[2]
		
	}
	
	/**
	 * 选择出发城市
	 * @param city
	 */
	public void selectDepartCity(String city){
		departCity.click();
		pm.getPageSelectCity().selectCity(city);					
	}
	/**
	 * 选择到达城市
	 * @param city
	 */
	public void selectArriveCity(String city){
		arriveCity.click();
		pm.getPageSelectCity().selectCity(city);
	}
	/**
	 * 点击查询按钮	
	 */
	public void searchFlight(){
		//foundActivity=super.waitForActivity("com.elong.mobile.plugin.baseactivity");
		//Assert.assertTrue(foundActivity);
		searchButton.click();		
	}
	
	
	public void searchFlight(String departCity,String arriveCity){
		selectDepartCity(departCity);
		selectArriveCity(arriveCity);
		selectDepartDate();
		searchButton.click();
	}
	/**
	 * 搜索国内往返航班
	 * @param departCity
	 * @param arriveCity
	 */
	public void searchRoundFlight(String departCity,String arriveCity){
		
		selectDepartCity(departCity);
		selectArriveCity(arriveCity);
		selectDepartDate();
		roundTab.click();
		searchButton.click();

	}
	
	public void searchInternationalFlight(String departCity,String arriveCity){
		interFlightTab.click();
		selectDepartCity(departCity);
		selectArriveCity(arriveCity);
		selectDepartDate();
		searchButton.click();

	}
	
	public void searchInternationalRoundFlight(String departCity,String arriveCity){
		interFlightTab.click();
		selectDepartCity(departCity);
		selectArriveCity(arriveCity);
		selectDepartDate();
		selectBackDate();
		searchButton.click();

	}
	
	
}
