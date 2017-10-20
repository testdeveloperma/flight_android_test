package com.appium.util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.PageFactory;

import elong.android.domesticflight.activity.PageAddCustomer;
import elong.android.domesticflight.activity.PageDomesticCabinDetail;
import elong.android.domesticflight.activity.PageDomesticFlightList;
import elong.android.domesticflight.activity.PageDomesticOrderEdit;
import elong.android.domesticflight.activity.PageFlightFirstPage;
import elong.android.domesticflight.activity.PageLogin;
import elong.android.domesticflight.activity.PageOrderConfirm;
import elong.android.domesticflight.activity.PageOrderPay;
import elong.android.domesticflight.activity.PageSelectCity;
import elong.android.domesticflight.activity.PageSelectCustomer;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class PageManager {
	AndroidDriver driver;
	
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
	
	public PageManager(AndroidDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		decorator = new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS);
	
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
			pageDomesticFlightList = new PageDomesticFlightList(driver);
		}
		PageFactory.initElements(decorator, pageDomesticFlightList);
		
		return pageDomesticFlightList;
	}


	public PageDomesticCabinDetail getPageDomesticCabinDetail() {
		if(pageDomesticCabinDetail == null){
			pageDomesticCabinDetail = new PageDomesticCabinDetail(driver);
		}
		
		PageFactory.initElements(decorator, pageDomesticCabinDetail);
		
		return pageDomesticCabinDetail;
	}


	public PageDomesticOrderEdit getPageDomesticOrderEdit() {
		if(pageDomesticOrderEdit == null){
			pageDomesticOrderEdit = new PageDomesticOrderEdit(driver);
		}
		
		PageFactory.initElements(decorator, pageDomesticOrderEdit);		
		return pageDomesticOrderEdit;
	}


	public PageLogin getPageLogin() {
		if(pageLogin == null){
			pageLogin = new PageLogin(driver);
		}
		
		pageLogin.initViews();
		
		return pageLogin;
	}


	public PageOrderConfirm getPageOrderConfirm() {
		if(pageOrderConfirm == null){
			pageOrderConfirm = new PageOrderConfirm(driver);
		}
		
		PageFactory.initElements(decorator, pageOrderConfirm);		
		return pageOrderConfirm;
	}


	public PageOrderPay getPageOrderPay() {
		
		if(pageOrderPay == null){
			pageOrderPay = new PageOrderPay(driver);
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
			pageFlightFirstPage = new PageFlightFirstPage(driver);
		}
		
		PageFactory.initElements(decorator, pageFlightFirstPage);		
		return pageFlightFirstPage;
	}






	
	
	
	
}
