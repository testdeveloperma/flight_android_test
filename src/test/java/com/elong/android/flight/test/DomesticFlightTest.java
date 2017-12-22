package com.elong.android.flight.test;

import java.io.IOException;
import java.util.HashMap;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.appium.base.ExcelData;
import elong.android.domesticflight.bean.CabinDetailData;
import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.read.biff.BiffException;

public class DomesticFlightTest extends BasicTestCase {

	CabinDetailData cabinDetailData;
	FlightListData flightListData;

	@BeforeClass
	public void setUp() {
		super.setUp();
	}

	@DataProvider(name = "city")
	public Object[][] Numbers() throws IOException, BiffException {
		ExcelData e = new ExcelData("testdata", "city");
		return e.getExcelData();
	}

	@Test(dataProvider = "city", description = "选择城市和日期搜索，进入航班列表")
	public void test1(HashMap<String, String> data) throws InterruptedException, IOException {
		pm.getPageFlightFirstPage().clearBoot();
		System.out.println(data.toString());
		String departCity = String.valueOf(data.get("departCity"));
		String arriveCity = String.valueOf(data.get("arriveCity"));
		Thread.sleep(1000);
		pm.getPageFlightFirstPage().searchFlight(departCity, arriveCity);
		flightListData = pm.getPageDomesticFlightList().getFlightListData();

	}

	@Test(description = "选择航班列表的第三个航班")
	public void test2() {

		pm.getPageDomesticFlightList().selectFlight(3);
		cabinDetailData = pm.getPageDomesticCabinDetail().getCabinDetailData();
		pm.getPageDomesticCabinDetail().getFlightTicketPrice();

	}

//	@Test(description = "选择自营第一个舱位，点击预定进入填写页")
	public void test3() {
		pm.getPageDomesticCabinDetail().clickBookButton();
		pm.getPageLogin().login();

	}

//	 @Test(description="创建订单，去支付")
	 public void test4() {
	 pm.getPageDomesticOrderEdit().createOrder();
	 pm.getPageOrderConfirm().gotoPay();
	
	 pm.getPageOrderPay().goBack();
	 pm.getPageOrderPay().gotoOrderDetail();
	
	 try {
	 Thread.sleep(1000);
	 } catch (Exception e) {
	 // TODO Auto-generated catch block
	 e.printStackTrace();
	 }	
	 }

	@AfterClass
	public void testClassOver() {
		super.tearDown();
	}
	
	

	

}
