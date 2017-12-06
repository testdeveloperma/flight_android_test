package com.elong.android.flight.test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.base.AndroidTool;
import com.appium.base.ExcelData;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;
import jxl.read.biff.BiffException;

public class InternationalRoundFlightTest extends BasicTestCase{

//	private PageManager pm;
//	private AppiumDriver<WebElement> driver;
	
	
	@BeforeClass
	public void setUp(){
//		pm = BasicTestCase.pm;
//		driver = BasicTestCase.driver;
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		super.caseSetUp();
	}
	
	@DataProvider(name = "InterCity")
	public Object[][] Numbers() throws IOException, BiffException {
		ExcelData e = new ExcelData("testdata", "InterCity");
		return e.getExcelData();
	}
	

	@Test(dataProvider = "InterCity",description="选择城市和日期搜索，进入航班列表")
	public void test1(HashMap<String, String> data) throws InterruptedException, IOException {
		pm.getPageFlightFirstPage().clearBoot();
		String departCity = String.valueOf(data.get("departCity"));
		String arriveCity = String.valueOf(data.get("arriveCity"));
		pm.getPageFlightFirstPage().searchInternationalRoundFlight(departCity, arriveCity);
		//flightListData = pm.getPageDomesticFlightList().getFlightListData();
		
	}
	
	@Test
	public void test2(){
		pm.getPageInternationalFlightList().selectRoundFlight();
	}
	
	@Test
	public void test3(){
		pm.getPageInternationalFlightDetail().selectCabin();
//		pm.getPageLogin().login();
	}
	
	@Test
	public void test4(){
		pm.getPageInternationalFlightEdit().submitOrder();
	}
	
}
