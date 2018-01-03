package com.appium.listener;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class DialogCheck extends Thread {

	public static boolean isListen = true;
	// AndroidTool appium;
	AndroidDriver<MobileElement> driver;

	public DialogCheck(AndroidDriver<MobileElement> driver2) {
		// TODO Auto-generated constructor stub
		this.driver = driver2;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*System.out.println("DialogCheck watting...");*/
		
		System.out.println("DialogCheck going...");
		Map<String, String> elements = new HashMap<>();
		elements.put("huawei_id", "com.android.packageinstaller:id/decide_to_continue");
		elements.put("goon_name", "android:id/button1");
		int j = 0;
//		for(int i = 0; i< 10; i ++){
		while(isListen)	{
			System.out.println("进入 while......");
			String pageSource = driver.getPageSource();

			for (Map.Entry<String, String> entry : elements.entrySet()) {
				System.out.println("进入for.....");
				if (pageSource.contains(entry.getValue())) {
					System.out.println("进入if" + j);
					j++;
					driver.findElementById(entry.getValue()).click();
					break;
				}
			}
			if(j == 2){
				break;
			}
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
}