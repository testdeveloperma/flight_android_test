package elong.android.flight.test.activity;

import org.openqa.selenium.WebElement;

import com.appium.util.Parameters;

import io.appium.java_client.android.AndroidDriver;

public class Login {

	WebElement username;
	WebElement password;
	WebElement loginButton;
	public Login(AndroidDriver driver) {
		// TODO Auto-generated method stub
		username=driver.findElementById("com.dp.android.elong:id/login_phone");
		password=driver.findElementById("com.dp.android.elong:id/login_password");
		loginButton=driver.findElementById("com.dp.android.elong:id/login_submit");
	}
	public void login(){
		Parameters userdata=new Parameters();
		username.sendKeys(userdata.username);
		password.sendKeys(userdata.password);
		loginButton.click();
	}
	
}
