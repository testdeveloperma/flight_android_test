package com.appium.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import elong.android.domesticflight.activity.PageAddCustomer;
import elong.android.domesticflight.activity.PageDomesticCabinDetail;
import elong.android.domesticflight.activity.PageDomesticFlightList;
import elong.android.domesticflight.activity.PageDomesticOrderEdit;
import elong.android.domesticflight.activity.PageFlightFirstPage;
import elong.android.domesticflight.activity.PageHome;
import elong.android.domesticflight.activity.PageLogin;
import elong.android.domesticflight.activity.PageOrderConfirm;
import elong.android.domesticflight.activity.PageOrderPay;
import elong.android.domesticflight.activity.PageSelectCity;
import elong.android.domesticflight.activity.PageSelectCustomer;
import elong.android.internationalflight.activity.PageInternationalFlightDetail;
import elong.android.internationalflight.activity.PageInternationalFlightEdit;
import elong.android.internationalflight.activity.PageInternationalFlightList;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageManager {
	AppiumDriver<WebElement> driver;
	
	PageHome pageHome;
	
	PageAddCustomer pageAddCustomer;
	
	PageDomesticFlightList pageDomesticFlightList;
	
	PageDomesticCabinDetail pageDomesticCabinDetail;
	
	PageDomesticOrderEdit pageDomesticOrderEdit;
	
	PageFlightFirstPage pageFlightFirstPage;
	
	PageLogin pageLogin;
	
	PageOrderConfirm pageOrderConfirm;
	
	PageOrderPay pageOrderPay;
	
	PageSelectCity pageSelectCity;
	
	PageSelectCustomer pageSelectCustomer;
	
	AppiumFieldDecorator decorator;

	PageInternationalFlightList pageInternationalFlightList;

	PageInternationalFlightDetail pageInternationalFlightDetail;

	PageInternationalFlightEdit pageInternationalFlightEdit;
	
	private String build;
	
	private String jenkinsHome;
	private String projectName;
	
	public PageManager(AppiumDriver<WebElement> driver,String jenkinsHome,String projectName,String build) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		decorator = new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS);
		this.jenkinsHome = jenkinsHome;
		this.projectName = projectName;
		this.build = build;
	}

	public  PageHome getPageHome() {
		if(pageHome == null){
			pageHome = new PageHome(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageHome);
		
		return pageHome;
	}
	
	public  PageAddCustomer getPageAddCustomer() {
		if(pageAddCustomer == null){
			pageAddCustomer = new PageAddCustomer(driver);
		}
		
		pageAddCustomer.initViews();
		
		return pageAddCustomer;
	}


	public PageDomesticFlightList getPageDomesticFlightList() {
		if(pageDomesticFlightList == null){
			pageDomesticFlightList = new PageDomesticFlightList(driver,jenkinsHome,projectName,build);
		}
		PageFactory.initElements(decorator, pageDomesticFlightList);
		
		return pageDomesticFlightList;
	}


	public PageDomesticCabinDetail getPageDomesticCabinDetail() {
		if(pageDomesticCabinDetail == null){
			pageDomesticCabinDetail = new PageDomesticCabinDetail(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageDomesticCabinDetail);
		
		return pageDomesticCabinDetail;
	}


	public PageDomesticOrderEdit getPageDomesticOrderEdit() {
		if(pageDomesticOrderEdit == null){
			pageDomesticOrderEdit = new PageDomesticOrderEdit(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageDomesticOrderEdit);		
		return pageDomesticOrderEdit;
	}


	public PageLogin getPageLogin() {
		if(pageLogin == null){
			pageLogin = new PageLogin(driver);
		}
		PageFactory.initElements(decorator, pageLogin);
		
		return pageLogin;
	}


	public PageOrderConfirm getPageOrderConfirm() {
		if(pageOrderConfirm == null){
			pageOrderConfirm = new PageOrderConfirm(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageOrderConfirm);		
		return pageOrderConfirm;
	}


	public PageOrderPay getPageOrderPay() {
		
		if(pageOrderPay == null){
			pageOrderPay = new PageOrderPay(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageOrderPay);		
		return pageOrderPay;
	}


	public PageSelectCity getPageSelectCity() {
		if(pageSelectCity == null){
			pageSelectCity = new PageSelectCity(driver);
		}
		
		PageFactory.initElements(decorator, pageSelectCity);		
		return pageSelectCity;
	}


	public PageSelectCustomer getPageSelectCustomer() {
		if(pageSelectCustomer == null){
			pageSelectCustomer = new PageSelectCustomer(driver);
		}
		
		PageFactory.initElements(decorator, pageSelectCustomer);		
		return pageSelectCustomer;
	}

	public PageFlightFirstPage getPageFlightFirstPage(){
		if(pageFlightFirstPage == null){
			pageFlightFirstPage = new PageFlightFirstPage(driver,jenkinsHome,projectName,build);
		}
		
		PageFactory.initElements(decorator, pageFlightFirstPage);		
		return pageFlightFirstPage;
	}

	public PageInternationalFlightList getPageInternationalFlightList(){
		if(pageInternationalFlightList == null){
			pageInternationalFlightList = new PageInternationalFlightList();
		}
		
		PageFactory.initElements(decorator, pageInternationalFlightList);		
		return pageInternationalFlightList;
	}


	public PageInternationalFlightDetail getPageInternationalFlightDetail(){
		
		if(pageInternationalFlightDetail == null){
			pageInternationalFlightDetail = new PageInternationalFlightDetail();
		}
		
		PageFactory.initElements(decorator, pageInternationalFlightDetail);
		return pageInternationalFlightDetail;
	}

	public PageInternationalFlightEdit getPageInternationalFlightEdit(){
		
		if(pageInternationalFlightEdit == null){
			pageInternationalFlightEdit = new PageInternationalFlightEdit();
		}
		
		PageFactory.initElements(decorator, pageInternationalFlightEdit);
		return pageInternationalFlightEdit;
	}
	
	
	
	
}
