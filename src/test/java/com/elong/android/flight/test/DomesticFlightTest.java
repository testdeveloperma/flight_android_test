package com.elong.android.flight.test;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.util.AndroidTool;
import com.appium.util.AppiumServer;
import com.appium.util.ExcelData;
import elong.android.domesticflight.bean.CabinDetailData;
import elong.android.domesticflight.bean.FlightListData;
import io.appium.java_client.android.AndroidKeyCode;
import jxl.read.biff.BiffException;

public class DomesticFlightTest extends BasicTestCase {

	// PageDomesticFlightList flightlist;
	CabinDetailData cabinDetailData;
	FlightListData flightListData;

	@DataProvider(name = "city")
	public Object[][] Numbers() throws IOException, BiffException {
		ExcelData e = new ExcelData("testdata", "city");
		return e.getExcelData();
	}

	/**
	 * 点击查询按钮，页面调整到航班列表页
	 * 
	 * @throws InterruptedException
	 * @throws IOException
	 */
	@Test(dataProvider = "city",description="选择城市和日期搜索，进入航班列表")
	public void test1(HashMap<String, String> data) throws InterruptedException, IOException {
		System.out.println(data.toString());
		String departCity = String.valueOf(data.get("departCity"));
		String arriveCity = String.valueOf(data.get("arriveCity"));
		pm.getPageFlightFirstPage().searchFlight(departCity, arriveCity);
		flightListData = pm.getPageDomesticFlightList().getFlightListData();
		
	}
	
	@Test(description="选择航班列表的第三个航班")
	public void test2() {

		pm.getPageDomesticFlightList().selectFlight(2);
		cabinDetailData = pm.getPageDomesticCabinDetail().getCabinDetailData();
		pm.getPageDomesticCabinDetail().getFlightTicketPrice();
		

	}


	@Test(description="选择自营第一个舱位，点击预定进入填写页")
	public void test3() {
		pm.getPageDomesticCabinDetail().clickBookButton();
		// 登录
		//pm.getPageLogin().login();

		// oe.addCustomer();
		Assert.assertEquals(cabinDetailData.getDepartCity(), flightListData.getDepartCity());
		Assert.assertEquals(cabinDetailData.getArriveCity(), flightListData.getArriveCity());
		System.out.println(flightListData.getDepartDate());
		System.out.println(cabinDetailData.getDepartDate());
	//	Assert.assertEquals(flightListData.getDepartDate().contains(cabinDetailData.getDepartDate()),true );
	}
	

	
	@Test
	public void test4() {
		pm.getPageDomesticOrderEdit().createOrder();

		// PageOrderConfirm orderConfirm = new PageOrderConfirm(driver);
		pm.getPageOrderConfirm().gotoPay();

	//	driver.sendKeyEvent(AndroidKeyCode.BACK);
		pm.getPageOrderPay().goBack();
		pm.getPageOrderPay().gotoOrderDetail();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
