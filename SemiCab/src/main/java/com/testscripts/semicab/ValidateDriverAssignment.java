package com.testscripts.semicab;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.semicab.Base;
import com.genericlib.semicab.EventList;
import com.objectrep.semicab.Administration;
import com.objectrep.semicab.LoadManagement;
import com.relevantcodes.extentreports.LogStatus;

@Listeners(EventList.class)
public class ValidateDriverAssignment extends Base {
	@Test(groups = {"regression"})
	public void ValidateDriverCreation() throws Throwable {
		Administration ad=PageFactory.initElements(driver, Administration.class);
		LoadManagement l=PageFactory.initElements(driver, LoadManagement.class);
		test=report.startTest("ValidateDriverAssignment");
		test.log(LogStatus.PASS,"Logged into SemiCab as "+fl.getDataFromProperty(prop, "username"));
		l.getLoadManagement().click();
		test.log(LogStatus.PASS, "Navigated to Load Management");
		l.getCreateload().click();
		test.log(LogStatus.PASS, "Landed on Create Load Page");
		//Pickup Location
		l.getCreateStop().click();
		l.getActivity().click();
		l.getCreateStopPickup().click();
		l.getCreateStopName().sendKeys(fl.getDataFromExel(exel, 24, 1, "LoadData"));
		l.getCreateStopAdd1().sendKeys(fl.getDataFromExel(exel, 25, 1, "LoadData"));
		l.getCreateStopCity().sendKeys(fl.getDataFromExel(exel, 26, 1, "LoadData"));
		cu.keyBoardActionsTab(driver);
		cu.waitTillElementToBeClickable(driver, l.getCreateStopState());
		l.getCreateStopState().sendKeys(fl.getDataFromExel(exel, 27, 1, "LoadData"));
		l.getCreateStopStatefirstSuggetion().click();
		l.getCreateStopZip().sendKeys(fl.getDataFromExel(exel, 28, 1, "LoadData"));
		cu.keyBoardActionsBackspace(driver);
		cu.keyBoardActionsBackspace(driver);
		l.getCreateStopArraiveTime().click();
		l.getCreateStopEArraivalCalendar().click();
		l.getCreateStopCalendarOk().click();
		l.getCreateStopLArraivalCalendar().click();
		l.getCreateStopCalendarOk().click();
		l.getCreateStopSubmit().click();
		test.log(LogStatus.PASS, "Added Pickup Location");
		Reporter.log("Added Pickup location", true);
		//Drop Off Location
		l.getCreateStop().click();
		l.getActivity().click();
		l.getCreateStopDrop().click();
		l.getCreateStopName().sendKeys(fl.getDataFromExel(exel, 24, 2, "LoadData"));
		l.getCreateStopAdd1().sendKeys(fl.getDataFromExel(exel, 25, 2, "LoadData"));
		l.getCreateStopCity().sendKeys(fl.getDataFromExel(exel, 26, 2, "LoadData"));
		cu.keyBoardActionsTab(driver);
		cu.waitTillElementToBeClickable(driver, l.getCreateStopState());
		l.getCreateStopState().sendKeys(fl.getDataFromExel(exel, 27, 2, "LoadData"));
		l.getCreateStopStatefirstSuggetion().click();
		l.getCreateStopZip().sendKeys(fl.getDataFromExel(exel, 28, 2, "LoadData"));
		cu.keyBoardActionsBackspace(driver);
		cu.keyBoardActionsBackspace(driver);
		l.getCreateStopArraiveTime().click();
		l.getCreateStopEArraivalCalendar().click();
		l.getCreateStopCalendarOk().click();
		l.getCreateStopLArraivalCalendar().click();
		l.getCreateStopCalendarOk().click();
		l.getCreateStopSubmit().click();
		test.log(LogStatus.PASS, "Added Drop Off Location");
		Reporter.log("Added Drop Off location", true);
		//Customer
		Thread.sleep(2000);
		cu.waitTillElementToBeClickable(driver, l.getCreateLoadCustomer());
		l.getCreateLoadCustomer().sendKeys(fl.getDataFromExel(exel, 23, 1, "LoadData"));
		cu.waitTillElementToBeVisible(driver, l.getCreateLoadFirstCustomer());
		l.getCreateLoadFirstCustomer().click();
		test.log(LogStatus.PASS, "Customer has been added");
		l.getCreateLoadNum().clear();
		String LoadNum=cu.getCurrentDateTime();
		l.getCreateLoadNum().sendKeys(LoadNum);
		l.getCreateLoadNext().click();
		test.log(LogStatus.PASS, "Custom Load Number Entered==>"+LoadNum);
		//Shipment and Equipment
		l.getCreateLoadCreateShipment().click();
		l.getCreateShipmentCommodity().sendKeys(fl.getDataFromExel(exel, 11, 1, "LoadData"));
		l.getCreateShipmentWeight().sendKeys(fl.getDataFromExel(exel, 12, 1, "LoadData"));
		l.getCreateShipmentPickup().click();
		cu.waitTillElementToBeClickable(driver, l.getCreateShipmentSelectPickStop());
		Thread.sleep(2000);
		l.getCreateShipmentSelectPickStop().click();
		l.getCreateShipmentDrop().click();
		cu.waitTillElementToBeClickable(driver, l.getCreateShipmentSelectDropStop());
		Thread.sleep(2000);
		l.getCreateShipmentSelectDropStop().click();
		l.getCreateShipmentSubmit().click();
		test.log(LogStatus.PASS, "Added Shipment Details");
		l.getCreateLoadEquipment().click();
		l.getCreateLoadEquipmentFirstSuggetion().click();
		test.log(LogStatus.PASS, "Equipment type has been selected");
		l.getCreateLoadSubmit().click();
		cu.waitTillElementToBeVisible(driver, l.getCreateLoadOK());
		l.getCreateLoadOK().click();
		test.log(LogStatus.PASS, "Load Created Successfully");
		l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
		for(int j=0;j<=1;j++) {
			if(l.getNoRecordsFound().isDisplayed()) {
				driver.navigate().refresh();
				l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
			}
			else
				break;
		}
		cu.waitTillElementToBeVisible(driver, l.getGetLoadNumOfFirstSearchResult());
		String[] Load = l.getGetLoadNumOfFirstSearchResult().getText().split(" ");
		String LoadNum1=Load[1].toString();
		Reporter.log(LoadNum1, true);
		AssertJUnit.assertEquals(LoadNum1.equals(LoadNum), true);
		test.log(LogStatus.PASS, "Load Creation and Load status has been verified");
		l.getLoadEllispsis().click();
		l.getAcceptLoad().click();
		cu.waitTillElementToBeVisible(driver, l.getSuccessMessageTile());
		test.log(LogStatus.PASS, "Load has been Accepted");
		l.getAccepted().click();
		l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
		for(int j=0;j<=1;j++) {
			if(l.getNoRecordsFound().isDisplayed()) {
				driver.navigate().refresh();
				l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
			}
			else
				break;
		}
		l.getLoadEllispsis().click();
		l.getAssignCarrier().click();
		l.getAssignCarrierCarrier().sendKeys(fl.getDataFromExel(exel, 44, 0, "LoadData"));
		cu.waitTillElementToBeClickable(driver, l.getAssignCarrierFirstCarrierSuggetion());
		String carrier = l.getAssignCarrierFirstCarrierSuggetion().getText();
		l.getAssignCarrierFirstCarrierSuggetion().click();
		l.getAssignCarrierSubmit().click();
		cu.waitTillElementToBeVisible(driver, l.getSuccessMessageTile());
		test.log(LogStatus.PASS, "Carrier "+carrier+" has been assigned successfully");
		l.getLoadEllispsis().click();
		l.getAssignDriver().click();
		l.getAddNewDriver().click();
		String fn = RandomStringUtils.randomAlphabetic(3);
		l.getAddNewDriverFirstName().sendKeys(fn);
		String ln = RandomStringUtils.randomAlphabetic(4);
		l.getAddNewDriverLastName().sendKeys(ln);
		String email = fn+"@testdriver.com";
		l.getAddNewDriverEmail().sendKeys(email);
		l.getAddNewDriverAdd().click();
		cu.waitTillElementToBeClickable(driver, l.getAssignDriverTruckNumber());
		Thread.sleep(2000);
		test.log(LogStatus.PASS, "Driver "+fn+" "+ln+" has been created successfully");
		l.getAssignDriverSubmit().click();
		test.log(LogStatus.PASS, fn+" "+ln+" has been assigned successfully");
		cu.waitTillElementToBeClickable(driver, ad.getAdministration());
		Thread.sleep(2000);
		ad.getAdministration().click();
		cu.waitTillElementToBeClickable(driver, ad.getDrivers());
		ad.getDrivers().click();
		ad.getSearchDriver().sendKeys(fn,Keys.ENTER);
		cu.waitTillElementToBeClickable(driver, ad.getFirstSearchResultDriver());
		ad.getFirstSearchResultDriver().click();
		Thread.sleep(3000);
		AssertJUnit.assertTrue(ad.getFirstNameDriverDetails().getText().equals(fn));
		AssertJUnit.assertTrue(ad.getLastNameDriverDetails().getText().equals(ln));
		AssertJUnit.assertTrue(ad.getCarrierDriverDetails().getText().equals(carrier));
		AssertJUnit.assertTrue(ad.getEmailDriverDetails().getText().equalsIgnoreCase(email));
		test.log(LogStatus.PASS, "Driver Creation has been verified successfully");

		
	}
}
