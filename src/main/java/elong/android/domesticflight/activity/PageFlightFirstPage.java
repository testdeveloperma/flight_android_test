package elong.android.domesticflight.activity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;
import com.appium.base.PageManager;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class PageFlightFirstPage extends AndroidTool{
	AndroidDriver driver;
	PageManager pm;
	@AndroidFindBy(id="com.elong.android.flight:id/flightsearch_submit")
	MobileElement searchButton;		//查询按钮
	@AndroidFindBy(id="com.elong.android.flight:id/rb_search_tab_global")
	MobileElement interFlightTab;	//国际标签
	@AndroidFindBy(id="com.elong.android.flight:id/flightssearch_leavecity")
	MobileElement departCity;		//出发城市按钮
	@AndroidFindBy(id="com.elong.android.flight:id/flightssearch_arrivecity")
	MobileElement arriveCity;		//到达城市按钮
	boolean foundActivity;
	@AndroidFindBy(id="com.elong.android.flight:id/flightsearch_leave_date")
	MobileElement departDate;		//出发日期标签
	public PageFlightFirstPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		pm = new PageManager(driver);
	}
	
	

	public void selectDepartDate(){
		departDate.click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String xpath = AndroidTool.getTimeXpath();
		List<WebElement> today = driver.findElementsByXPath(xpath);
		
		today.get(0).click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//WebElement date_list = driver.findElementById("com.elong.android.flight:id/date_list");
		//List<WebElement> linearLayouts = date_list.findElements(By.);
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[1]
		//android.widget.ListView[@resource-id=\"com.elong.android.flight:id/date_list\"]/android.widget.LinearLayout[2]
		
	}
	
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
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
