package com.elong.android.flight.test;

import java.io.IOException;
import java.util.HashMap;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.base.ExcelData;
import jxl.read.biff.BiffException;

public class InternationalRoundFlightTest extends BasicTestCase{

//	private PageManager pm;
//	private AppiumDriver<WebElement> driver;
	
	
	@BeforeClass
	public void setUp(){
		super.setUp();
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
	
		@AfterClass
		public void tearDown() {
			// TODO Auto-generated method stub
			super.tearDown();
		}
	
}
