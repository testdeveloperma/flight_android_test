package com.appium.util;


//import android.app.Activity;
//import android.app.Instrumentation.ActivityMonitor;
//import android.content.IntentFilter;
//import android.os.SystemClock;
import io.appium.java_client.android.AndroidDriver;
import net.sourceforge.htmlunit.corejs.javascript.tools.debugger.Main;

public class AndroidTool {
	
	AndroidDriver driver;
	
	public AndroidTool(AndroidDriver driver) {
		super();
		this.driver = driver;
	}
	
	public boolean waitForActivity(String activityName){
		if(driver.currentActivity().equalsIgnoreCase(activityName)){
			return true;
		}
		boolean foundActivity = false;
		long currentTime = System.currentTimeMillis();
		final long endTime = currentTime + 10000;
		while(currentTime < endTime){
			if(driver.currentActivity().equalsIgnoreCase(activityName)){
				foundActivity = true;
				break;
			}	
			currentTime = System.currentTimeMillis();
		}
		return foundActivity;
	}
	

	public boolean waitForActivity(String activityName,int timeout){
		if(driver.currentActivity().equalsIgnoreCase(activityName)){
			return true;
		}
		boolean foundActivity = false;
		long currentTime = System.currentTimeMillis();
		final long endTime = currentTime + timeout;
		while(currentTime < endTime){
			if(driver.currentActivity().equalsIgnoreCase(activityName)){
				foundActivity = true;
				break;
			}	
			currentTime = System.currentTimeMillis();
		}
		return foundActivity;
	}
	
	
	
	
	
	
	
	

//	public boolean waitForActivity11(String name,int timeout){
//	if(isActivityMatching(activityUtils.getCurrentActivity(false, false), name)){
//		return true;
//	}
//	
//	boolean foundActivity = false;
//	ActivityMonitor activityMonitor = getActivityMonitor();
//	long currentTime = SystemClock.uptimeMillis();
//	final long endTime = currentTime + timeout;
//	
//	while(currentTime < endTime){
//		Activity currentActivity = activityMonitor.waitForActivityWithTimeout(endTime - currentTime);
//		
//		if(isActivityMatching(currentActivity, name)){
//			foundActivity = true;
//			break;
//		}	
//		currentTime = SystemClock.uptimeMillis();
//	}
//	removeMonitor(activityMonitor);
//	return foundActivity;
//}
//	
//	private boolean isActivityMatching(Activity currentActivity, String name){
//		if(currentActivity != null && currentActivity.getClass().getSimpleName().equals(name)) {
//			return true;
//		}
//		return false;
//	}
//
//	private ActivityMonitor getActivityMonitor(){
//		IntentFilter filter = null;
//		ActivityMonitor activityMonitor = instrumentation.addMonitor(filter, null, false);
//		return activityMonitor;
//	}
//
//private void removeMonitor(ActivityMonitor activityMonitor){
//		try{
//			instrumentation.removeMonitor(activityMonitor);	
//		}catch (Exception ignored) {}
//	}









}
