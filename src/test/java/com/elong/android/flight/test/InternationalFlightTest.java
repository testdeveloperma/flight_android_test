package com.elong.android.flight.test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.base.AndroidTool;
import com.appium.base.ExcelData;
import com.appium.base.PageManager;

import io.appium.java_client.AppiumDriver;
import jxl.read.biff.BiffException;

public class InternationalFlightTest extends BasicTestCase{

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
		//System.out.println(data.toString());
		String departCity = String.valueOf(data.get("departCity"));
		String arriveCity = String.valueOf(data.get("arriveCity"));
		pm.getPageFlightFirstPage().searchInternationalFlight(departCity, arriveCity);
		//flightListData = pm.getPageDomesticFlightList().getFlightListData();
		
	}
	
	@Test(description="选择一个舱位，点击预定进入国际填写页")
	public void test2(){
		pm.getPageInternationalFlightList().selectFlight();
	}
	
	@Test(description="")
	public void test3(){
		pm.getPageInternationalFlightDetail().selectCabin();
//		pm.getPageLogin().login();
	}
	
	@Test(description="创建订单，进入支付页")
	public void test4(){
		pm.getPageInternationalFlightEdit().submitOrder();
//		try {
//			Thread.sleep(15000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
	
	@Test(description="点击返回按钮，弹出查看订单详情，点击查看订单")
	public void test5(){
		pm.getPageOrderPay().goBack();
		pm.getPageOrderPay().gotoOrderDetail();
	}
	
	@AfterClass
	public void testClassOver(){
		super.tearDown();
	}
	
}
