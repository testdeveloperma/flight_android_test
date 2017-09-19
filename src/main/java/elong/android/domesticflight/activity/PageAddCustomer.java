package elong.android.domesticflight.activity;

import java.io.IOException;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;

import io.appium.java_client.android.AndroidDriver;

public class PageAddCustomer {
	AndroidDriver driver;
	WebElement chinese_name; // 中文姓名
	WebElement select_id_type; // 证件类型
	WebElement passport; // 护照
	WebElement id_number; // 证件号码
	WebElement ok; // 确认按钮

	public PageAddCustomer(AndroidDriver driver) {
		this.driver = driver;
	}
	//初始化视图
	public void initViews() {
		try {
			// com.elong.android.flight:id/people_name_text_chinese_value
			chinese_name = driver.findElementById("com.elong.android.flight:id/people_name_text_chinese_value");
			select_id_type = driver.findElementById("com.elong.android.flight:id/paper_text");
			// passport=driver.findElementByAndroidUIAutomator("new
			// UiSelector().text(\"护照\")");
			id_number = driver.findElementById("com.elong.android.flight:id/paper_number_text");
			ok = driver.findElementById("com.elong.android.flight:id/flight_add_customer_ok");
		} catch (Exception e) {
			AndroidTool.screencap("addcustomer");
			e.printStackTrace();
		}
	}

	//添加客史
	public void addCustomer() throws IOException {
		chinese_name.sendKeys("马成俊");
		id_number.click();
		id_number.sendKeys("210301198311109360");
		ok.click();
		/*
		 * Runtime.getRuntime().exec("adb shell input text wangxiaoming");
		 * id_number.click();
		 * Runtime.getRuntime().exec("adb shell input text 341181199009232611");
		 * ok.click();
		 */

	}
}
