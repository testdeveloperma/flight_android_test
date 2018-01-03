package com.appium.base;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class UpdateApp {

	

	public static String download(String apkurl) {
		int connectTimeout = 30 * 1000; // 连接超时:30s  
        int readTimeout = 1 * 1000 * 1000; // IO超时:1min  
		FileOutputStream output = null;
		File file =  null;
//		String appPath = "http://10.20.254.206/busapp/man.php?type=download&filedir=apk/busandroid/Elong_Trunk_9341_93.apk";

//		String appPath = "http://10.20.254.206/busapp/man.php?type=download&filedir=apk/busandroid/Elong_Trunk_9360_117.apk";
		try {
			file = new File("flight_android.apk");			 
            URL url=new URL(apkurl);  
            HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
            conn.setConnectTimeout(connectTimeout);
            conn.setReadTimeout(readTimeout);
            conn.connect();
            //取得inputStream，并进行读取  
            InputStream input=conn.getInputStream();  
            byte[] buffer = new byte[10*1024];
            output = new FileOutputStream(file);  
            for (;;) {  
                int bytes = input.read(buffer);  
                if (bytes == -1) {  
                    break;  
                }  
                output.write(buffer, 0, bytes);      
            }  
            output.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
            try {
				output.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return file.getAbsolutePath();
	}

	// 安装
	public void install(String classname,String appPath) {
		uninstall(classname);
		if(appPath.contains("http://")){
			appPath = download(appPath);
		}		
		String cmd = "adb install " + appPath;
		mAndroidUtil.executeAdbShell(cmd);
		System.out.println("安装成功！");
	}

	// 卸载
	public void uninstall(String classname) {
		String cmd = "adb uninstall " + classname;
		mAndroidUtil.executeAdbShell(cmd);
		System.out.println("卸载成功！");
	}

	public void execCmd(String cmd) {
		System.out.println("----execCmd:  " + cmd);
		try {
			Process p = Runtime.getRuntime().exec(cmd);
			// 正确输出流
			InputStream input = p.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(input));
			String line = "";
			while ((line = reader.readLine()) != null) {
				// 因为安装过程中，会不断输出发送百分比，这里就只输出“Success”
				if (line.equalsIgnoreCase("Success")) {
					System.out.println(line);
				}
				// 虽然上一部屏蔽了一些信息，但还是会写入log文件中
				saveToFile(line, "runlog.log", false);
			}
			// 错误输出流，这里就不屏蔽任何错误信息了
			InputStream errorInput = p.getErrorStream();
			BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));
			String eline = "";
			while ((eline = errorReader.readLine()) != null) {
				System.out.println(eline);
				saveToFile(eline, "runlog.log", false);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void saveToFile(String text, String path, boolean isClose) {
		File file = new File("runlog.log");
		BufferedWriter bf = null;
		try {
			FileOutputStream outputStream = new FileOutputStream(file, true);
			OutputStreamWriter outWriter = new OutputStreamWriter(outputStream);
			bf = new BufferedWriter(outWriter);
			bf.append(text);
			bf.newLine();
			bf.flush();

			if (isClose) {
				bf.close();
			}
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
