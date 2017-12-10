package com.appium.base;

import java.net.URL;
import java.util.Date;
import java.util.Properties;

//import com.elong.traffic.hubble.logUtil.LogRecordUtil;

import javax.mail.Authenticator;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.mail.DataSourceResolver;
import org.apache.commons.mail.resolver.DataSourceCompositeResolver;
import org.apache.commons.mail.resolver.DataSourceFileResolver;
import org.apache.commons.mail.resolver.DataSourceUrlResolver;

import com.chengjun.email.util.ImageHtmlEmail;

/**
 * Date: 2015/11/10 Time: 15:18
 *
 * @author Tian.Dong
 */
public class EmailUtil {
	// 邮件发送者的地址
	// public static String from = "elong-air@vip.elong.com";
	// public static String from = "Tech-Test-Air@corp.elong.com";
	public static String from = "chengjun.ma@corp.elong.com";

	// 发送邮件的服务器的IP和端口
	private static String mailServerHost = "mta.vip.elong.com";
	private static String mailServerPort = "25";

	public static void sendmail(String subject, String[] to, String text, String mimeType) {
		// 设置默认的发送人
		try {

			String smtp = "smtp.corp.elong.com"; // 设置发送邮件所用到的smtp

			javax.mail.Session mailSession = null; // 邮件会话对象
			javax.mail.internet.MimeMessage mimeMsg = null; // MIME 邮件对象

			Properties props = new Properties();

			props.put("mail.smtp.host", smtp); // 设置SMTP主机
			props.put("mail.smtp.port", mailServerPort); // 设置SMTP主机
			props.put("mail.smtp.auth", "false"); // 是否到服务器用户名和密码验证
			// 到服务器验证发送的用户名和密码是否正确
			// SmtpAuthenticator myEmailAuther = new SmtpAuthenticator(userName,
			// password);
			// 设置邮件会话 注意这里将认证信息放进了Session的创建参数里
			mailSession = javax.mail.Session.getInstance(props);
			// 设置传输协议
			javax.mail.Transport transport = mailSession.getTransport("smtp");
			// 设置from、to等信息
			mimeMsg = new javax.mail.internet.MimeMessage(mailSession);
			if (null != from && !"".equals(from)) {
				InternetAddress sentFrom = new InternetAddress(from);
				mimeMsg.setFrom(sentFrom); // 设置发送人地址
			}

			InternetAddress[] sendTo = new InternetAddress[to.length];
			for (int i = 0; i < to.length; i++) {
				sendTo[i] = new InternetAddress(to[i]);
			}

			mimeMsg.setRecipients(javax.mail.internet.MimeMessage.RecipientType.TO, sendTo);
			mimeMsg.setSubject(subject, "gb2312");

			MimeBodyPart messageBodyPart1 = new MimeBodyPart();
			// messageBodyPart.setText(UnicodeToChinese(text));
			messageBodyPart1.setContent(text, mimeType);

			// 附件传输格式
			Multipart multipart = new MimeMultipart();
			multipart.addBodyPart(messageBodyPart1);

			mimeMsg.setContent(multipart);
			// 设置信件头的发送日期
			mimeMsg.setSentDate(new Date());
			mimeMsg.saveChanges();
			// 发送邮件
			transport.send(mimeMsg);
			transport.close();
		} catch (Exception e) {
			// LogRecordUtil.error("邮件发送异常",e);
			e.printStackTrace();
		}
	}

	private static class SmtpAuthenticator extends Authenticator {
		String username = null;
		String password = null;

		public SmtpAuthenticator(String username, String password) {
			super();
			this.username = username;
			this.password = password;
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(this.username, this.password);
		}
	}

	public static void main(String[] args) throws Exception {
		// String title = "测试邮件";// 所发送邮件的标题
		// String from = "chengjun.ma@corp.elong.com";// 从那里发送
		// String sendTo[] = { "chengjun.ma@corp.elong.com" };// 发送到那里
		// // 邮件的文本内容，可以包含html标记则显示为html页面
		// String content = "这是一张用于测试的图片，请查收。 <img
		// src=\"/Users/user/Downloads/QQ20171202-155529.png\"> "
		// + " <img
		// src=\"http://commons.apache.org/proper/commons-email/images/commons-logo.png\">";
		// // 所包含的附件，及附件的重新命名
		//
		// try {
		// // MailSender mailsender = new MailSender();
		// EmailUtil.sendmail(title, sendTo, content,
		// "text/html;charset=utf-8");
		// } catch (Exception ex) {
		// ex.printStackTrace();
		// }
		String htmlEmailContent = "这是一张用于测试的图片，请查收。setUp(http://10.20.254.206/busapp/man.php?type=download&filedir=apk/busandroid/Elong_Trunk_9360_108.apk)"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/collapseall.gif\">"
				+ " <img src=\"/Users/user/Downloads/QQ20171202-155529.png\"> "
				// + " <img
				// src=\"http://commons.apache.org/proper/commons-email/images/commons-logo.png\">"				
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">"
				+ "<img src=\"/Users/user/elong_flight_android_test/test-output/skipped.png\">" + "<h1>我是html</h1>";
		sendHtmlEmailWithImg(htmlEmailContent);
	}

	public static void sendEmail(String title, String content) {
		// String title = "测试邮件";// 所发送邮件的标题
		String from = "chengjun.ma@corp.elong.com";// 从那里发送
		String sendTo[] = { "chengjun.ma@corp.elong.com"};// 发送到那里
		// 邮件的文本内容，可以包含html标记则显示为html页面
		// String content = "test java send mail !!!!!!<br><a
		// href=\"http://sjsky.javaeye.com/\">My blog</a>";
		// 所包含的附件，及附件的重新命名

		try {
			// MailSender mailsender = new MailSender();
			EmailUtil.sendmail(title, sendTo, content, "text/html;charset=utf-8");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public static void sendHtmlEmailWithImg(String htmlEmailContent) throws Exception {
		// String htmlEmailContent = "这是一张用于测试的图片，请查收。 <img
		// src=\"/Users/user/Downloads/QQ20171202-155529.png\"> "
		// + " <img
		// src=\"http://commons.apache.org/proper/commons-email/images/commons-logo.png\">";
		ImageHtmlEmail email = new ImageHtmlEmail();// 用ImageHtmlEmail来发送
		email.setDebug(true);// 可以看到执行过程的debug信息
		email.setCharset("UTF-8");// 防止乱码
		email.setSSLCheckServerIdentity(true);
		email.setSslSmtpPort("25"); // 设定SSL端口

		// 解析本地图片和网络图片都有的html文件重点就是下面这两行；
		// ImageHtmlEmail通过setDataSourceResolver来识别并嵌入图片
		// 查看DataSourceResolver的继承结构发现有几个好用的子类
		DataSourceResolver[] dataSourceResolvers = new DataSourceResolver[] { new DataSourceFileResolver(), // 添加DataSourceFileResolver用于解析本地图片
				new DataSourceUrlResolver(new URL("http://")) };// 添加DataSourceUrlResolver用于解析网络图片，注意：new
																// URL("http://")
		// DataSourceCompositeResolver类可以加入多个DataSourceResolver,
		// 把需要的DataSourceResolver放到一个数组里传进去就可以了；
		email.setDataSourceResolver(new DataSourceCompositeResolver(dataSourceResolvers));

		email.setHostName("smtp.corp.elong.com");
		email.addTo("chengjun.ma@corp.elong.com", "Jo");
		email.setFrom("chengjun.ma@corp.elong.com", "Me");
		// email.setAuthenticator(new DefaultAuthenticator("906615361@qq.com",
		// ""));
		email.setSubject("发送一张图片，看看是否可以收到。");

		email.setHtmlMsg(htmlEmailContent);

		// 如果客户端不去持HTML格式会显示这句话，不过应该很少有不支持HTML格式的客户端了吧
		email.setTextMsg("你的邮箱客户端不支持HTML格式邮件");
		email.send();
	}

}
