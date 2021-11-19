package com.testscripts.flipkart;

import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.genriclib.flipkart.Base;
import com.genriclib.flipkart.CommonUtils;
import com.objectrepository.flipkart.Elements;

public class Flipkart extends Base {
	@Test
	public void productSpecs() throws Exception, Throwable {
		Elements e= PageFactory.initElements(driver, Elements.class);
		e.getLanguage().click();
		e.getContinuelangauage().click();
		e.getCloseContactDetails().click();
		CommonUtils.explicitWaitTillVisible(driver, e.getSearch());
		e.getSearch().click();
		e.getSearchTextbox().sendKeys(fl.getDataFromExcel(excel, 0, 0, "Sheet1"));
		CommonUtils.explicitWaitTillVisible(driver, e.getIphone12SearchSuggetion());
		//Runtime.getRuntime().exec("adb shell input keyevent 66");
		e.getIphone12SearchSuggetion().click();
		CommonUtils.explicitWaitTillVisible(driver, e.getFirstSearchResult());
		e.getFirstSearchResult().click();
		CommonUtils.explicitWaitStale(driver, e.getProductName());
		Reporter.log(e.getProductName().getText(), true);
		Reporter.log("Rs "+e.getProductPrice().getText().substring(1), true);
		CommonUtils.swipeTillElement(e.getAllDetails(), driver);
		e.getAllDetails().click();
		CommonUtils.explicitWaitTillVisible(driver, e.getSpecifications());
		e.getSpecifications().click();
		CommonUtils.explicitWaitTillVisible(driver, e.getKeyFeatures());
		CommonUtils.takeScreenshot(driver);
	}
}
