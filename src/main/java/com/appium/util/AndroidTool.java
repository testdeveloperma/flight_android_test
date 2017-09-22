package com.appium.util;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.thoughtworks.selenium.webdriven.commands.GetAllFields;

//import android.app.Activity;
//import android.app.Instrumentation.ActivityMonitor;
//import android.content.IntentFilter;
//import android.os.SystemClock;
import io.appium.java_client.android.AndroidDriver;

public class AndroidTool {

	AndroidDriver driver;

	public AndroidTool(AndroidDriver driver) {
		super();
		this.driver = driver;
	}

	/**
	 * 安卓截屏方法，图片保存到项目的根目录下
	 * 
	 * @param picturename
	 *            保存的图片名称
	 */
	public static void screencap(String picturename) {
	
		URL classUrl = Thread.currentThread().getContextClassLoader().getResource("");
		String agentPath = classUrl.getPath();

		String cmd = "sh " + agentPath + "screencap.sh " + picturename;  //shell
		cmd = agentPath + "screencap.bat " + picturename;  //批处理
	//	String adb = "/Users/user/android-sdk-macosx/platform-tools/adb";
		try {
			System.out.println(cmd);
			Process p = Runtime.getRuntime().exec(cmd);
			
			int exitcode = p.waitFor();
			System.out.println(exitcode);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getTimeXpath() {

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new java.util.Date();
		long ltime = date.getTime() + 20 * 24 * 60 * 60 * 1000;
		String format = df.format(new Date(ltime));
		String xpath = null;
		Map<String, String> festivals = getFestivals();
		if(festivals.containsKey(format)){
			xpath = "//android.widget.TextView[@text=\"" + festivals.get(format) + "\"]";
			return xpath;
		}
		String[] split = format.split("-");
		Integer valueOf = Integer.valueOf(split[2]);
		System.out.println(valueOf);
		xpath = "//android.widget.TextView[@text=\"" + String.valueOf(valueOf) + "\"]";
		System.out.println(xpath);
		return xpath;
	}

	public static String getTimeXpath(String date) {
		String xpath = null;
		Map<String, String> festivals = getFestivals();
		//节假日
		if(festivals.containsKey(date)){
			xpath = "//android.widget.TextView[@text=\"" + festivals.get(date) + "\"]";
			return xpath;
		}
		String[] split = date.split("-");
		Integer valueOf = Integer.valueOf(split[2]);
		 xpath = "//android.widget.TextView[@text=\"" + String.valueOf(valueOf) + "\"]";
				
		return xpath;
	}

	
	public static Map<String, String> getFestivals(){
		Map<String, String> festivals = new HashMap<>();
		festivals.put("2017-10-04", "中秋节");
		festivals.put("2017-10-28", "重阳节");
		festivals.put("2017-12-24", "平安节");
		festivals.put("2017-12-25", "圣诞节");
		festivals.put("2018-01-01", "元 旦");
		festivals.put("2018-01-24", "腊 八");
		festivals.put("2018-02-08", "小 年");
		festivals.put("2018-02-14", "情人节");
		festivals.put("2018-02-15", "除 夕");
		festivals.put("2018-02-16", "春 节");
		festivals.put("2018-03-02", "元宵节");
		festivals.put("2018-03-08", "妇女节");
		
		return festivals;
	}
	// 等待元素出现
	public static void waitForEelementById(AndroidDriver driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public static void waitForElementByText(AndroidDriver driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));

	}

	public boolean waitForActivity(String activityName) {
		if (driver.currentActivity().equalsIgnoreCase(activityName)) {
			return true;
		}
		boolean foundActivity = false;
		long currentTime = System.currentTimeMillis();
		final long endTime = currentTime + 10000;
		while (currentTime < endTime) {
			if (driver.currentActivity().equalsIgnoreCase(activityName)) {
				foundActivity = true;
				break;
			}
			currentTime = System.currentTimeMillis();
		}
		return foundActivity;
	}

	public boolean waitForActivity(String activityName, int timeout) {
		if (driver.currentActivity().equalsIgnoreCase(activityName)) {
			return true;
		}
		boolean foundActivity = false;
		long currentTime = System.currentTimeMillis();
		final long endTime = currentTime + timeout;
		while (currentTime < endTime) {
			if (driver.currentActivity().equalsIgnoreCase(activityName)) {
				foundActivity = true;
				break;
			}
			currentTime = System.currentTimeMillis();
		}
		return foundActivity;
	}

	// public boolean waitForActivity11(String name,int timeout){
	// if(isActivityMatching(activityUtils.getCurrentActivity(false, false),
	// name)){
	// return true;
	// }
	//
	// boolean foundActivity = false;
	// ActivityMonitor activityMonitor = getActivityMonitor();
	// long currentTime = SystemClock.uptimeMillis();
	// final long endTime = currentTime + timeout;
	//
	// while(currentTime < endTime){
	// Activity currentActivity =
	// activityMonitor.waitForActivityWithTimeout(endTime - currentTime);
	//
	// if(isActivityMatching(currentActivity, name)){
	// foundActivity = true;
	// break;
	// }
	// currentTime = SystemClock.uptimeMillis();
	// }
	// removeMonitor(activityMonitor);
	// return foundActivity;
	// }
	//
	// private boolean isActivityMatching(Activity currentActivity, String
	// name){
	// if(currentActivity != null &&
	// currentActivity.getClass().getSimpleName().equals(name)) {
	// return true;
	// }
	// return false;
	// }
	//
	// private ActivityMonitor getActivityMonitor(){
	// IntentFilter filter = null;
	// ActivityMonitor activityMonitor = instrumentation.addMonitor(filter,
	// null, false);
	// return activityMonitor;
	// }
	//
	// private void removeMonitor(ActivityMonitor activityMonitor){
	// try{
	// instrumentation.removeMonitor(activityMonitor);
	// }catch (Exception ignored) {}
	// }

}
