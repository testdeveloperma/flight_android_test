package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.base.AndroidTool;
import com.appium.base.Parameters;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSFindBy;

public class PageLogin {
	AppiumDriver<WebElement> driver;
	
	@iOSFindBy
	@AndroidFindBy(id="com.dp.android.elong:id/login_phone")
	MobileElement username;
	@AndroidFindBy(id="com.dp.android.elong:id/login_password")
	MobileElement password;
	@AndroidFindBy(id="com.dp.android.elong:id/tv_login")
	MobileElement loginButton;
	@AndroidFindBy(id="com.dp.android.elong:id/tv_switch_login_way")
	MobileElement loginwithPassword;
	public PageLogin(AppiumDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
	}
	
	
	
	public void login(){
		//Parameters userdata=new Parameters();
		//18668147007  777777liu
		loginwithPassword.click();
		username.sendKeys(Parameters.username);
		password.sendKeys(Parameters.password);
		loginButton.click();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
