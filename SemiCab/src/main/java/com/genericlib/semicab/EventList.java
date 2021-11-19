package com.genericlib.semicab;

import java.io.IOException;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.LogStatus;
public class EventList implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
			result.getName().toString().trim();
			try {
				Base.test.log(LogStatus.FAIL,Base.test.addScreenCapture(Base.cu.captureSS(Base.driver))+result.getThrowable());
			} catch (IOException e) {
				e.printStackTrace();
			}
//			EventFiringWebDriver ef=new EventFiringWebDriver(Base.driver);
//			File src=ef.getScreenshotAs(OutputType.FILE);
//			File dest=new File("C:\\Users\\Samartha\\eclipse-workspace\\SemiCab\\test-output\\Screenshot\\"+System.currentTimeMillis()+".png");
//			try {
//				FileUtil.copyFile(src, dest);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			
		}
			
}
