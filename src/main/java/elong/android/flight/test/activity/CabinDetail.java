package elong.android.flight.test.activity;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.appium.util.AndroidTool;
import io.appium.java_client.android.AndroidDriver;

public class CabinDetail extends AndroidTool {
	AndroidDriver driver;
	@FindBy(id = "com.elong.android.flight:id/hotel_list_filter_submit")
	WebElement bookButton; // 预定按钮
	WebElement price;
	public CabinDetail(AndroidDriver driver) {
		super(driver);
		this.driver = driver;
		
		bookButton=driver.findElementsById("com.elong.android.flight:id/hotel_list_filter_submit").get(0);
		price=driver.findElementsById("com.elong.android.flight:id/flights_site_change_list_item_siteprice").get(0);
		
	}
	
	public void getFlightTicketPrice(){
		int ticketPrice = 0;
		String priceText=price.getText();	
		System.out.println(priceText);
		
		//Integer.valueOf(priceText.substring(1));
		//System.out.println(ticketPrice+"");
		
	}

	/**
	 * 点击预定按钮，进入舱位详情页
	 * @throws InterruptedException 
	 */
	public void clickBookButton() throws InterruptedException {
		bookButton.click();
		Thread.sleep(3000);
	}

}
