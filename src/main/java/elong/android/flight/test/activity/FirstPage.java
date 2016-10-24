package elong.android.flight.test.activity;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class FirstPage extends AndroidTool{
	AndroidDriver driver;
	WebElement searchButton;		//查询按钮
	WebElement interFlightTab;	//国际标签
	WebElement departCity;		//出发城市按钮
	WebElement arriveCity;		//到达城市按钮
	boolean foundActivity;
	public FirstPage(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		searchButton=driver.findElementById("com.elong.android.flight:id/flightsearch_submit");
		interFlightTab=driver.findElementById("com.elong.android.flight:id/search_flight_global_checkbox");
		departCity=driver.findElementById("com.elong.android.flight:id/flightssearch_leavecity_trigger");
		arriveCity=driver.findElementById("com.elong.android.flight:id/flightssearch_arrivecity_trigger");
		//com.elong.android.flight:id/flightssearch_arrivecity
	}
	/**
	 * 选择出发城市
	 * @param city
	 */
	public void selectDepartCity(String city){
		departCity.click();
		new SelectCity(driver).selectCity(city);					
	}
	/**
	 * 选择到达城市
	 * @param city
	 */
	public void selectArriveCity(String city){
		arriveCity.click();
		new SelectCity(driver).selectCity(city);
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
		searchButton.click();
	}
}
