package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class ReportEmailStyle {

	public static void main(String[] args) {
		 URL classUrl =
		 Thread.currentThread().getContextClassLoader().getResource("");
		 String agentPath = classUrl.getPath();
		 System.out.println(agentPath);
//		String path = "/Users/user/elong_flight_android_test/test-output/";
//		String htmlContent = getFileContent(path + "emailable-report.html").toString();
//
//		StringBuilder contentFromCss = getContentFromCss(path, "testng-reports.css");
//		StringBuilder jquery = getContentFromJS(path, "jquery-1.7.1.min.js");
//
//		StringBuilder testng_reports = getContentFromJS(path, "testng-reports.js");
//		String replace = htmlContent
//				.replace("<link type=\"text/css\" href=\"testng-reports.css\" rel=\"stylesheet\" />",
//						contentFromCss.toString())
//				.replace("<script type=\"text/javascript\" src=\"jquery-1.7.1.min.js\"></script>", jquery.toString())
//				.replace("<script type=\"text/javascript\" src=\"testng-reports.js\"></script>", testng_reports.toString())
//				.replaceAll("skipped.png", path + "skipped.png").replaceAll("failed.png", path + "failed.png")
//				.replaceAll("bullet_point.png", path + "bullet_point.png")
//				.replaceAll("collapseall.gif", path + "collapseall.gif")
//				.replaceAll("// Extract the panel for this link", "")
//				.replaceAll("// hide passed methods by default", "")
//				.replaceAll("// Mark this link as currently selected", "")
//				// .replaceAll("// Hide all the panels and display the first one
//				// (do this last", "")
//				// .replaceAll("// to make sure the click() will invoke the
//				// listeners)", "")
//
//				.replaceAll("// Collapse/expand the suites", "")
//				.replaceAll("// The handlers that take care of showing/hiding the methods", "")
//				.replaceAll(
//						"<!--      <script type=\"text/javascript\" src=\"jquery-ui/js/jquery-ui-1.8.16.custom.min.js\"></script>     -->",
//						"")
//				.replace("<script type=\"text/javascript\" src=\"https://www.google.com/jsapi\"></script>", "");

//		System.out.println("------>"+ replace);
		try {
			
//			EmailUtil.sendHtmlEmailWithImg(replace);
//			EmailUtil.sendHtmlEmailWithImg(htmlContent);
//					String html = htmlContent.replaceAll("white-space: pre;", "");
//					EmailUtil.sendEmail("图片测试", html);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
