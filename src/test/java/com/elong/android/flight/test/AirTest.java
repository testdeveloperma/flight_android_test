package com.elong.android.flight.test;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.appium.util.AndroidTool;
import com.appium.util.AppiumServer;
import com.appium.util.ExcelData;

import elong.android.flight.test.activity.CabinDetail;
import elong.android.flight.test.activity.FirstPage;
import elong.android.flight.test.activity.FlightList;
import elong.android.flight.test.activity.Login;
import elong.android.flight.test.activity.OrderEdit;
import io.appium.java_client.android.AndroidDriver;
import jxl.read.biff.BiffException;

public class AirTest{
	
	AndroidDriver driver;
	AndroidTool appium;
	FirstPage firstpage;
	FlightList flightlist;
	
	@BeforeClass
	public void setUp() throws MalformedURLException, InterruptedException{
		driver=new AppiumServer().androidDriverRun();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		appium=new AndroidTool(driver);
		boolean foundTabHomeActivity=appium.waitForActivity("com.elong.activity.others.TabHomeActivity");		
		Assert.assertTrue(foundTabHomeActivity);
		//进入机票首页
		WebElement selectAir=driver.findElementById("com.elong.android.home:id/home_module_flight");
				//findElementByAccessibilityId("com.elong.android.home:id/home_module_flight");		
		selectAir.click();	
		firstpage=new FirstPage(driver);
		
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
	@DataProvider(name="city")
    public Object[][] Numbers() throws BiffException, IOException{
        ExcelData e=new ExcelData("testdata", "city");
        return e.getExcelData();
    }
	
	
	/**
	 * 点击查询按钮，页面调整到航班列表页
	 * @throws InterruptedException
	 * @throws IOException 
	 */
	@Test(dataProvider="city")
	public void test(HashMap<String, String> data) throws InterruptedException, IOException {	
		System.out.println(data.toString());
		String departCity=String.valueOf(data.get("departCity"));
		String arriveCity=String.valueOf(data.get("arriveCity"));
		//firstpage.selectLeaveCity();
		//firstpage.searchFlight();
		firstpage.searchFlight(departCity,arriveCity);
		Thread.sleep(3000);
		driver.sendKeyEvent(4);
		
	/*	System.out.println("当前上下文"+driver.getContext());
		//System.out.println("应用的字符串"+driver.getAppStrings());
		System.out.println("可用上下文"+driver.getContextHandles());
		//System.out.println(driver.getTitle());
		
		flightlist=new FlightList(driver);
		flightlist.selectFlight(1);
		//Thread.sleep(5000);
		CabinDetail cd=new CabinDetail(driver);
		cd.getFlightTicketPrice();
		cd.clickBookButton();
		new Login(driver).login();
		
		OrderEdit oe=new OrderEdit(driver);
		oe.addCustomer();
		oe.createOrder();
		Thread.sleep(5000);*/
				
	}

}
