package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Properties;

public class ReportEmail {

	public static void main(String[] args) {
		 URL classUrl =
		 Thread.currentThread().getContextClassLoader().getResource("");
		 String agentPath = classUrl.getPath();
		 String[] split = agentPath.split("target");
		 
		 System.out.println(agentPath);
		 String pathin = "";
		 String path = "";
		 Properties properties = System.getProperties();
		 String property = properties.getProperty("os.name");
		 if(property.contains("Mac")){
			 pathin = split[0] + "test-output/android suite/";
			 path = split[0] + "test-output/";
		 }else {
			 pathin = split[0] + "surefire-reports\\android suite\\";
			 path = split[0] + "surefire-reports\\";
		 }
		System.out.println("path:" + path);
		String htmlContent = getFileContent(pathin + "flight uitest.html").toString();
		StringBuilder contentFromCss = getAddContentFromCss(path, "testng.css", "pre {white-space: normal;}");
		String replaceAll = htmlContent.replaceAll("<link href=\"../testng.css\" rel=\"stylesheet\" type=\"text/css\" />", contentFromCss.toString());		
		System.out.println(replaceAll);
		try {			
			EmailUtil.sendEmail("安卓自动化测试-执行时间" + DateFormatUtil.getCurrentTime(), replaceAll);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	
	public static void sendTestNgEmail(){
		 URL classUrl =
				 Thread.currentThread().getContextClassLoader().getResource("");
				 String agentPath = classUrl.getPath();
				 String[] split = agentPath.split("target");
				 
				 System.out.println(agentPath);
				 String path = "";
				 Properties properties = System.getProperties();
				 String property = properties.getProperty("os.name");
				 if(property.contains("Mac")){
					 path = split[0] + "test-output/";
				 }else {
					 path = split[0] + "surefire-reports\\";
				 }
				System.out.println("path:" + path);
				String htmlContent = getFileContent(path + "emailable-report.html").toString();

				try {
					String html = htmlContent.replaceAll("white-space: pre;", "");
					EmailUtil.sendEmail("安卓自动化测试-执行时间" + DateFormatUtil.getCurrentTime(), html);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	private static StringBuilder getAddContentFromCss(String path, String fileName,String style) {
		StringBuilder cssContent = getFileContent(path + fileName);
		cssContent.insert(0, "<style>" + style);
		cssContent.append("</style>");

		return cssContent;
	}
	private static StringBuilder getContentFromCss(String path, String fileName) {
		StringBuilder cssContent = getFileContent(path + fileName);
		cssContent.insert(0, "<style>");
		cssContent.append("</style>");

		return cssContent;
	}

	private static StringBuilder getContentFromJS(String path, String fileName) {
		StringBuilder jsContent = getFileContent(path + fileName);
		jsContent.insert(0, "<script type='text/javascript'>");
		jsContent.append("</script>");
		return jsContent;
	}

	public static StringBuilder getFileContent(String path) {
		StringBuilder sb = new StringBuilder();
		File file = new File(path);
		FileInputStream fis = null;
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			fis = new FileInputStream(file);
			isr = new InputStreamReader(fis);
			br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null) {
				// if(line.contains("//")){
				//
				// System.out.println(line);
				// }
				sb.append(line);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (isr != null) {
					isr.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (fis != null) {
					fis.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return sb;

	}

}
