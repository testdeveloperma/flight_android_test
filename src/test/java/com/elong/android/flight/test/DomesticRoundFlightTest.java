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

import elong.android.domesticflight.bean.CabinDetailData;
import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.AppiumDriver;
import jxl.read.biff.BiffException;

public class DomesticRoundFlightTest extends BasicTestCase{

	CabinDetailData cabinDetailData;
	FlightListData flightListData;

	
//	private PageManager pm;
//	private AppiumDriver<WebElement> driver;
	
	
	@BeforeClass
	public void setUp(){

		super.setUp();
	}
	
	
	@DataProvider(name = "city")
	public Object[][] Numbers() throws IOException, BiffException {
		ExcelData e = new ExcelData("testdata", "city");
		return e.getExcelData();
	}

	@Test(dataProvider = "city",description="选择城市和日期搜索，进入航班列表")
	public void test1(HashMap<String, String> data) throws InterruptedException, IOException {
		pm.getPageFlightFirstPage().clearBoot();
		System.out.println(data.toString());
		String departCity = String.valueOf(data.get("departCity"));
		String arriveCity = String.valueOf(data.get("arriveCity"));
		pm.getPageFlightFirstPage().searchRoundFlight(departCity, arriveCity);
//		flightListData = pm.getPageDomesticFlightList().getFlightListData();
		
	}
	
	@Test(description="选择航班列表的第三个航班")
	public void test2() {

		pm.getPageDomesticFlightList().selectFlight(2);
		cabinDetailData = pm.getPageDomesticCabinDetail().getCabinDetailData();
		pm.getPageDomesticCabinDetail().getFlightTicketPrice();
	}
	

	@Test(description="选择往返去程舱位，点击预定进入返程航班列表页")
	public void test3() {
		pm.getPageDomesticCabinDetail().clickBookButton();
		// 登录
//		pm.getPageLogin().login();
		// oe.addCustomer();
	}
	
	@Test(description="选择返程航班列表的第三个航班")
	public void test4() {

		pm.getPageDomesticFlightList().selectFlight(0);
		cabinDetailData = pm.getPageDomesticCabinDetail().getCabinDetailData();
		pm.getPageDomesticCabinDetail().getFlightTicketPrice();		

	}

	@Test(description="选择返程舱位，点击预定进入填写页")
	public void test5() {
		pm.getPageDomesticCabinDetail().clickBookButton();
	}
	
	@Test(description="创建订单，去支付")
	public void test6() {
		pm.getPageDomesticOrderEdit().createOrder();
		pm.getPageOrderConfirm().gotoPay();
		pm.getPageOrderPay().goBack();
		pm.getPageOrderPay().gotoOrderDetail();
		
	}
	
	@AfterClass
	public void testClassOver(){
		super.tearDown();

	}

}
