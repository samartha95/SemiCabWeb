package com.genriclib.flipkart;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Base {
	public FileLib fl = new FileLib();
	public DesiredCapabilities cap = new DesiredCapabilities();
	public AndroidDriver<MobileElement> driver = null;
	public String prop="C:\\Users\\Samartha\\git\\repository\\FlipkartTest\\testdata\\commondata.properties";
	public String excel="C:\\Users\\Samartha\\git\\repository\\FlipkartTest\\testdata\\Flipkart.xlsx";
	
	@BeforeTest
	public void configBC() throws Throwable{
		cap.setCapability("platformName", "Android");
		cap.setCapability("appPackage", fl.getPropertyKeyValue(prop, "appPackage"));
		cap.setCapability("appActivity", fl.getPropertyKeyValue(prop, "appActivity"));
		cap.setCapability("autoGrantPermissions", "true");
		driver = new AndroidDriver<>(new URL(fl.getPropertyKeyValue(prop, "URL")), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	@AfterTest
	public void configAC() {
		driver.quit();
}

}
