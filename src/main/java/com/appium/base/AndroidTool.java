package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
//import android.app.Activity;
//import android.app.Instrumentation.ActivityMonitor;
//import android.content.IntentFilter;
//import android.os.SystemClock;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class AndroidTool {

	 AppiumDriver<WebElement> driver;

	public AndroidTool(AppiumDriver<WebElement> d) {
		super();
		this.driver = d;
	}
	

	public static void dynamicClick(AppiumDriver<WebElement> driver,String id,int c){
		String pageSource = driver.getPageSource();
		for (int i = 0; i < c; i++) {
			if(pageSource.contains(id)){
				driver.findElementById(id).click();
				break;
			}else{
				try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pageSource = driver.getPageSource();
			}
		}
	}
	
	
	//截屏图片保存路径
	static String path = "";
	/*截屏
	* tag表示一个模块标记字符
	*/
	public static void takeScreenShot(AppiumDriver<WebElement> driver,String tag){  
		URL classUrl = Thread.currentThread().getContextClassLoader().getResource("");
		 path = classUrl.getPath();
		 System.out.println("path:" + path);
		File screenShotFile = 
	             ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	   try {   
	   FileUtils.copyFile(screenShotFile, new File(path + tag + 
	                 getCurrentDateTime()+ ".jpg"));  
//		      FileUtils.copyFile(screenShotFile, FileUtils.getFile(path), true);

	   }catch (IOException e) {
	   e.printStackTrace();
	   }  
	}
	
	//格式化当前时间
	public static String getCurrentDateTime(){
	   SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd_HHmmss");//设置日期格式
	   return df.format(new Date());
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
	
	/**
	 * 执行adb 命令
	 * @param cmd
	 */
	public static void executeAdbShell(String cmd){
		Properties properties = System.getProperties();
		String os = properties.getProperty("os.name");
		if(os.contains("Mac")){
			cmd = "/Users/user/android-sdk-macosx/platform-tools/" + cmd;
		}		
		Process p;
		try {
			p = Runtime.getRuntime().exec(cmd);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static BufferedReader getAdbShellResult(String cmd){
		Properties properties = System.getProperties();
		String os = properties.getProperty("os.name");
		if(os.contains("Mac")){
			cmd = "/Users/user/android-sdk-macosx/platform-tools/" + cmd;
		}		
		Process process;
		try {
			process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
			//Runtime.getRuntime().exec("222");
			BufferedReader br = new BufferedReader(new InputStreamReader(
					process.getInputStream()));
			return br;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static void main(String[] args) {
		String cmd = "adb shell ps |grep \"com.dp.android.elong\"";
		getAdbShellResult(cmd );
	}
	/**
	 * 获取当前日期自动加25天
	 * @return
	 */
	public static String getTimeXpath() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
		Date date = new java.util.Date();
		long ltime = date.getTime() + 25 * 24 * 60 * 60 * 1000;
		String format = df.format(new Date(ltime));
		String xpath = null;
		Map<String, String> festivals = getFestivals();
		if(festivals.containsKey(format)){
			xpath = "//android.widget.TextView[@text=\"" + festivals.get(format) + "\"]";
			System.out.println("单程xpath" + xpath);
			return xpath;
		}
		String[] split = format.split("-");
		Integer valueOf = Integer.valueOf(split[2]);
		System.out.println("xpathid" + valueOf);
		xpath = "//android.widget.TextView[@text=\"" + String.valueOf(valueOf) + "\"]";
		System.out.println(xpath);
		return xpath;
	}
	/**
	 * 精确控制搜索日期(正常只能选择 当月或下月的日期)
	 * @param date 格式：2018-12-1
	 * @return
	 */
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
		festivals.put("2017-12-24", "平安夜");
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
	public static void waitForEelementById(AndroidDriver<?> driver, String id) {
		WebDriverWait wait = new WebDriverWait(driver, 20);

		wait.until(ExpectedConditions.presenceOfElementLocated(By.id(id)));
	}

	public static void waitForElementByText(AndroidDriver<?> driver, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name(text)));

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
