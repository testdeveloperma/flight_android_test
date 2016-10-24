package elong.android.flight.test.activity;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class FlightList extends AndroidTool{
	AndroidDriver driver;
	
	private WebElement lastDay;	//前一天按钮
	private WebElement nextDay;	//后一天按钮
	private WebElement flightList;
	private List<WebElement> flightLists;
	public FlightList(AndroidDriver driver) {
		super(driver);
		this.driver = driver;		
		lastDay=driver.findElementById("com.elong.android.flight:id/ll_pre_day");		
		nextDay=driver.findElementById("com.elong.android.flight:id/ll_next_day");	
		flightList=driver.findElementById("com.elong.android.flight:id/flights_list_result");
		flightLists=flightList.findElements(By.className("android.widget.LinearLayout"));
	}
	/**
	 * 选中航班列表中的第几个航班，下标从1开始
	 * @param index 
	 */
	public void selectFlight(int index){
		flightLists.get(1).click();
		
	}
	
}
