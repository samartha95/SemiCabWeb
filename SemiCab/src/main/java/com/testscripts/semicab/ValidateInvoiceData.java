package com.testscripts.semicab;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.testng.AssertJUnit;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.genericlib.semicab.Base;
import com.genericlib.semicab.EventList;
import com.objectrep.semicab.Invoices;
import com.objectrep.semicab.LoadManagement;
import com.relevantcodes.extentreports.LogStatus;


@Listeners(EventList.class)
public class ValidateInvoiceData extends Base {
	
	
	@Test(groups = {"regression"} , priority = 1)
	public void validateInvoiceCreation() throws Throwable {
		LoadManagement l =PageFactory.initElements(driver, LoadManagement.class);
		Invoices i=PageFactory.initElements(driver, Invoices.class);
		test=report.startTest("validateInvoiceCreation");
		test.log(LogStatus.PASS,"Logged into SemiCab as "+fl.getDataFromProperty(prop, "username"));
		l.getLoadManagement().click();
		test.log(LogStatus.PASS, "Navigated to Load Management");
		l.getCreateload().click();
		test.log(LogStatus.PASS, "Landed on Create Load Page");
		//Pickup Location
		l.getCreateStop().click();
		l.getActivity().click();
		l.getCreateStopPickup().click();
		l.getCreateStopName().sendKeys(fl.getDataFromExel(exel, 3, 1, "LoadData"));
		l.getCreateStopAdd1().sendKeys(fl.getDataFromExel(exel, 4, 1, "LoadData"));
		l.getCreateStopCity().sendKeys(fl.getDataFromExel(exel, 5, 1, "LoadData"));
		cu.keyBoardActionsTab(driver);
		cu.waitTillElementToBeClickable(driver, l.getCreateStopState());
		l.getCreateStopState().sendKeys(fl.getDataFromExel(exel, 6, 1, "LoadData"));
		l.getCreateStopStatefirstSuggetion().click();
		l.getCreateStopZip().sendKeys(fl.getDataFromExel(exel, 7, 1, "LoadData"));
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
		l.getCreateStopName().sendKeys(fl.getDataFromExel(exel, 3, 2, "LoadData"));
		l.getCreateStopAdd1().sendKeys(fl.getDataFromExel(exel, 4, 2, "LoadData"));
		l.getCreateStopCity().sendKeys(fl.getDataFromExel(exel, 5, 2, "LoadData"));
		cu.keyBoardActionsTab(driver);
		cu.waitTillElementToBeClickable(driver, l.getCreateStopState());
		l.getCreateStopState().sendKeys(fl.getDataFromExel(exel, 6, 2, "LoadData"));
		l.getCreateStopStatefirstSuggetion().click();
		l.getCreateStopZip().sendKeys(fl.getDataFromExel(exel, 7, 2, "LoadData"));
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
		l.getCreateLoadCustomer().sendKeys(fl.getDataFromExel(exel, 2, 2, "LoadData"));
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
		Reporter.log("Load Created Successfully", true);
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
		l.getMarkInTransit().click();
		l.getMarkInTransitSubmit().click();
		cu.waitTillElementToBeVisible(driver, l.getSuccessMessageTile());
		test.log(LogStatus.PASS, "Load haas been marked as In-Transit");
		l.getInTransit().click();
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
		l.getMarkDelivered().click();
		l.getMarkDeliveredDelivered().click();
		cu.waitTillElementToBeVisible(driver, l.getSuccessMessageTile());
		l.getDelivered().click();
		l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
		for(int j=0;j<=1;j++) {
			if(l.getNoRecordsFound().isDisplayed()) {
				driver.navigate().refresh();
				l.getSearchLoad().sendKeys(LoadNum,Keys.ENTER);
			}
			else
				break;
		}
		AssertJUnit.assertEquals(l.getLoadEllispsis().isDisplayed(), true);
		test.log(LogStatus.PASS, "Load has been Marked Delivered");
		l.getAccounting().click();
		test.log(LogStatus.PASS, "Navigated to Invoice");
		cu.waitTillElementToBeVisible(driver, i.getInvoiceSearchLoadNum());
		i.getInvoiceSearchLoadNum().sendKeys(LoadNum);
		i.getInvoiceSearch().click();
		cu.waitTillElementToBeVisible(driver, i.getInvoicedetails());
		i.getInvoicedetails().click();
		AssertJUnit.assertEquals(true,i.getInvoiceCustomer().getText().equalsIgnoreCase(fl.getDataFromExel(exel, 2, 2, "LoadData")));
		test.log(LogStatus.PASS, "Verified Customer Name");
		test.log(LogStatus.PASS,"Invoice Status==> "+i.getInvoiceStatus().getText());
		test.log(LogStatus.PASS, "Invoice Creation has been validated succesfully");
		Reporter.log("Invoice Creation has been validated succesfully", true);
		test.log(LogStatus.PASS, "Test Script passed");
		}
	}
