package com.genriclib.flipkart;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtils {
	public static void swipeTillElement(WebElement m ,AndroidDriver driver) {
		TouchAction touch =new TouchAction(driver);
		for(int i=1;i<=8;i++) {
			touch.longPress(PointOption.point(700, 2600)).moveTo(PointOption.point(700,1200)).release().perform();
			Reporter.log("Swipe "+i);
			try {
				m.isDisplayed();
				break;
			}
			catch (Exception e){
				
			}
		}
	}
	public static void explicitWaitTillVisible(AndroidDriver driver, WebElement e ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(e));
	}
	
	public static void explicitWaitStale(AndroidDriver driver, WebElement e ) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(e)));
	}
	
	public static void takeScreenshot(AndroidDriver driver) throws Exception {
		Date d= new Date();
		String s = d.toString().replaceAll(" ", "_").replaceAll(":", "_");
		EventFiringWebDriver ef = new EventFiringWebDriver(driver);
		File src = ef.getScreenshotAs(OutputType.FILE);
		File dest = new File("./Screenshot/"+s+".png");
		FileUtils.copyFile(src, dest);
	}
}
