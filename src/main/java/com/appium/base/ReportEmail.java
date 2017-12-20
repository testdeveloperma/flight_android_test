package com.appium.base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ReportEmail {

	public static void main(String build) {
		URL classUrl = Thread.currentThread().getContextClassLoader().getResource("");
		String agentPath = classUrl.getPath();
		String[] split = agentPath.split("target");
		System.out.println(agentPath);
		String pathin = "";
		String path = "";
		Properties properties = System.getProperties();
		String property = properties.getProperty("os.name");
		if (property.contains("Mac")) {
			pathin = split[0] + "test-output/android suite/";
			path = split[0] + "test-output/";
		} else {
			pathin = split[0] + "target\\surefire-reports\\android suite\\";
			path = split[0] + "target\\surefire-reports\\";
		}
		System.out.println("path:" + path);
		String htmlContent = getFileContent(pathin + "flight uitest.html").toString();
		StringBuilder contentFromCss = getAddContentFromCss(path, "testng.css", "pre {white-space: normal;}");
		String replaceAll = htmlContent.replaceAll(
				"<link href=\"../testng.css\" rel=\"stylesheet\" type=\"text/css\" />", contentFromCss.toString());
		Document document = Jsoup.parse(replaceAll);
//		Elements fElements = document.getElementsByClass("invocation-failed");
//		if (fElements != null)
//			fElements.remove();
		Elements elementsByTag = document.getElementsByTag("pre");
		if(elementsByTag != null)
			elementsByTag.remove();
//		try {
//			EmailUtil.sendEmail("安卓自动化测试-执行时间" + DateFormatUtil.getCurrentTime(), document.html());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		// sendTestNgEmail();
		JavaMailWithAttachment se = new JavaMailWithAttachment(false);
		String[] recip = {"chengjun.ma@corp.elong.com"};
		File dirctorypath = new File("E:/jenkins/jobs/android-automation-test/builds/" + build + "/picture/");
		List<String> fileFromDir = FileHandler.getFileFromDir(dirctorypath);
		List<File> attachments = new ArrayList<>();
		for (String filepath : fileFromDir) {
			File f = new File(filepath);
			attachments.add(f);
		}
		se.doSendHtmlEmail("测试", document.html(), recip, attachments);
	}

	public static void sendTestNgEmail() {
		URL classUrl = Thread.currentThread().getContextClassLoader().getResource("");
		String agentPath = classUrl.getPath();
		String[] split = agentPath.split("target");

		System.out.println(agentPath);
		String path = "";
		Properties properties = System.getProperties();
		String property = properties.getProperty("os.name");
		if (property.contains("Mac")) {
			path = split[0] + "test-output/";
		} else {
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

	private static StringBuilder getAddContentFromCss(String path, String fileName, String style) {
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
