package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Parameters {
	String isautogetdevice;// 是否自动获取手机设备号
	String defalutDeviceName;// 默认手机设备号
	public static String username; // 测试账号
	public static String password;// 密码

	public Parameters() {
		Properties pro = new Properties();
		File directory = new File("");

		try {
			String proPath = directory.getCanonicalPath();// 获取工程路径
			System.out.println(proPath);
			FileInputStream fis = new FileInputStream(proPath + "/src/main/resources/config.properties");
			// FileInputStream fis=new
			// FileInputStream("classpath:config.properties");

			pro.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isautogetdevice = pro.getProperty("isautogetdevice");
		defalutDeviceName = pro.getProperty("defalutDeviceName");
		username = pro.getProperty("username");
		password = pro.getProperty("password");
	}
	public static String getPlatformVersion(){
		String cmd = "adb shell getprop ro.build.version.release";
		BufferedReader adbShellResult = mAndroidUtil.getAdbShellResult(cmd);
		String version = null;
		try {
			version = adbShellResult.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return version;
	}
	public static void main(String[] args) {
		System.out.println(getPlatformVersion());
	}

	/**
	 * 获取测试机的设备号
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public String getDeviceName() throws InterruptedException {
		if (isautogetdevice.equals("false")) {
			return defalutDeviceName;
		} else {
			return autoGetDeviceName();
		}
	}

	/**
	 * 使用adb自动获取手机的设备号
	 * 
	 * @return
	 * @throws InterruptedException
	 */
	public static String autoGetDeviceName() throws InterruptedException {
		String[] deviceName = null;
		Runtime run = Runtime.getRuntime();
		try {
			String cmd = "adb devices";
			BufferedReader br = mAndroidUtil.getAdbShellResult(cmd);
			
			String line = null;
			while ((line = br.readLine()) != null) {
				System.out.println(line.toString());
				if (line.endsWith("device")) {
					deviceName = line.split("	");
				}
			}
			br.close();
			//process.waitFor();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (deviceName != null){
			System.out.println(deviceName[0]);
			return deviceName[0];
		}
		return null;
	}

}
