package com.appium.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.aspectj.weaver.tools.cache.GeneratedCachedClassHandler;

public class JavaMailWithAttachment {
	private MimeMessage message;
	private Session session;
	private Transport transport;

	private String mailHost = "";
	private String sender_username = "";
	private String sender_password = "";

	// private Properties properties = new Properties();

	/*
	 * 初始化方法
	 */
	public JavaMailWithAttachment(boolean debug) {
		Properties properties = new Properties();
		
		String proPath = this.getClass().getClassLoader().getResource("").getPath();
		
		System.out.println(proPath);
		FileInputStream in = null;
		try {
			in = new FileInputStream(proPath + "mailserver.properties");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		// InputStream in =
		// JavaMailWithAttachment.class.getResourceAsStream("/target/classes/mailserver.properties");

		try {
			properties.load(in);
			this.mailHost = properties.getProperty("mail.smtp.host");
			this.sender_username = properties.getProperty("mail.sender.username");
			this.sender_password = properties.getProperty("mail.sender.password");
			System.out.println(mailHost);
			System.out.println(sender_username);
		} catch (IOException e) {
			e.printStackTrace();
		}

		session = Session.getInstance(properties);
		session.setDebug(debug);// 开启后有调试信息
		message = new MimeMessage(session);
	}

	/**
	 * 发送邮件
	 * 
	 * @param subject
	 *            邮件主题
	 * @param sendHtml
	 *            邮件内容
	 * @param receiveUser
	 *            收件人地址
	 * @param attachment
	 *            附件
	 */
	public void doSendHtmlEmail(String subject, String sendHtml, String[] receiveUser, List<File> attachments) {
		try {
			// 发件人
			InternetAddress from = new InternetAddress(sender_username);
			message.setFrom(from);

			// 收件人
			InternetAddress[] sendTo = new InternetAddress[receiveUser.length];
			for (int i = 0; i < receiveUser.length; i++) {
				sendTo[i] = new InternetAddress(receiveUser[i]);
			}
//			InternetAddress to = new InternetAddress(receiveUser);
			message.setRecipients(Message.RecipientType.TO, sendTo);

			// 邮件主题
			message.setSubject(subject);

			// 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
			Multipart multipart = new MimeMultipart();

			// 添加邮件正文
			BodyPart contentPart = new MimeBodyPart();
			contentPart.setContent(sendHtml, "text/html;charset=UTF-8");
			multipart.addBodyPart(contentPart);
			if (attachments != null) {
				// 添加附件的内容
				for (File attachment : attachments) {
					if (attachment != null) {
						BodyPart attachmentBodyPart = new MimeBodyPart();
						DataSource source = new FileDataSource(attachment);
						attachmentBodyPart.setDataHandler(new DataHandler(source));

						// 网上流传的解决文件名乱码的方法，其实用MimeUtility.encodeWord就可以很方便的搞定
						// 这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
						// sun.misc.BASE64Encoder enc = new
						// sun.misc.BASE64Encoder();
						// messageBodyPart.setFileName("=?GBK?B?" +
						// enc.encode(attachment.getName().getBytes()) + "?=");

						// MimeUtility.encodeWord可以避免文件名乱码
						attachmentBodyPart.setFileName(MimeUtility.encodeWord(attachment.getName()));
						multipart.addBodyPart(attachmentBodyPart);
					}
				}
			}

			// 将multipart对象放到message中
			message.setContent(multipart);
			// 保存邮件
			message.saveChanges();

			transport = session.getTransport("smtp");
			// smtp验证，就是你用来发邮件的邮箱用户名密码
			// transport.connect(mailHost, sender_username, sender_password);
			transport.connect();
			// 发送
			transport.sendMessage(message, message.getAllRecipients());

			System.out.println("send success!");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (transport != null) {
				try {
					transport.close();
				} catch (MessagingException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public static void main(String[] args) {
//		JavaMailWithAttachment se = new JavaMailWithAttachment(false);
//		List<File> affix = new ArrayList<>();
//		File file1 = new File("/Users/user/Documents/QQ20171208-0.jpg");
//		File file2 = new File("/Users/user/Documents/app.png");
//		affix.add(file1);
//		affix.add(file2);
//		String[] to = {"chengjun.ma@corp.elong.com"};
//		se.doSendHtmlEmail("邮件主题", "邮件内容",to, affix);
		JavaMailWithAttachment jm = new JavaMailWithAttachment(false);
		jm.getPath();
		
//		System.out.println(proPath);
	}
	
	public  void getPath(){
		URL resource = this.getClass().getClassLoader().getResource("");
		System.err.println(resource.getPath());
	}
}
