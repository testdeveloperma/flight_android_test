package elong.android.domesticflight.activity;

import org.openqa.selenium.WebElement;

import com.appium.util.AndroidTool;
import com.appium.util.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class PageLogin {
	AndroidDriver driver;
	WebElement username;
	WebElement password;
	WebElement loginButton;
	WebElement loginwithPassword;
	public PageLogin(AndroidDriver driver) {
		// TODO Auto-generated method stub
		this.driver = driver;
	}
	
	public void initViews(){
		try {
			loginwithPassword=driver.findElementById("com.dp.android.elong:id/tv_switch_login_way");
			loginwithPassword.click();
			username=driver.findElementById("com.dp.android.elong:id/login_phone");
			password=driver.findElementById("com.dp.android.elong:id/login_password");
			loginButton=driver.findElementById("com.dp.android.elong:id/tv_login");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			AndroidTool.screencap("login");
			e.printStackTrace();
		}
	}
	
	public void login(){
		//Parameters userdata=new Parameters();
		//18668147007  777777liu
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
