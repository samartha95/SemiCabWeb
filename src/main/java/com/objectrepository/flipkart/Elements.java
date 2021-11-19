package com.objectrepository.flipkart;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.MobileElement;

public class Elements {
	@FindBy(id ="com.flipkart.android:id/custom_back_icon")
	private WebElement closeContactDetails ;
	
	@FindBy(xpath = "//android.widget.RelativeLayout[@content-desc='Search on flipkart']/android.widget.TextView")
	private WebElement search ;
	
	@FindBy(xpath = "//android.widget.EditText[@content-desc='Search grocery products']")
	private WebElement searchTextbox ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='iphone 12']")
	private WebElement iphone12SearchSuggetion ;
	
	@FindBy(xpath = "(//android.view.ViewGroup)[14]")
	private WebElement FirstSearchResult ;
	
	@FindBy(xpath = "//android.widget.TextView")
	private WebElement productName ;
	
	@FindBy(xpath = "(//android.widget.TextView)[2]")
	private WebElement productPrice ;
	
	@FindBy(xpath = "//android.widget.TextView[@text='All Details']")
	private WebElement allDetails;
	
	@FindBy(xpath = "//android.widget.TextView[@text='SPECIFICATIONS']")
	private WebElement specifications;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Key Features']")
	private WebElement keyFeatures;
	
	@FindBy(xpath = "//android.widget.TextView[@text='English']")
	private WebElement language;
	
	@FindBy(xpath = "//android.widget.Button[@text='CONTINUE']")
	private WebElement continueLangauage;

	public WebElement getLanguage() {
		return language;
	}

	public WebElement getContinuelangauage() {
		return continueLangauage;
	}

	public WebElement getKeyFeatures() {
		return keyFeatures;
	}

	public WebElement getCloseContactDetails() {
		return closeContactDetails;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getSearchTextbox() {
		return searchTextbox;
	}

	public WebElement getIphone12SearchSuggetion() {
		return iphone12SearchSuggetion;
	}

	public WebElement getFirstSearchResult() {
		return FirstSearchResult;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductPrice() {
		return productPrice;
	}

	public WebElement getAllDetails() {
		return allDetails;
	}

	public WebElement getSpecifications() {
		return specifications;
	}

}
