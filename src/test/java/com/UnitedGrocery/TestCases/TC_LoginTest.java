package com.UnitedGrocery.TestCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UnitedGrocery.PageObject.Homepage;
import com.UnitedGrocery.PageObject.LoginPage;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import io.qameta.allure.*;

@Listeners(com.UnitedGrocery.TestCases.ListenerClass.class)
public class TC_LoginTest extends BaseClass
{
	
	ExtentTest test;
	LoginPage lp;
	Homepage hp;
	
	@Test(priority = 1)
	@Description("Verify the logo presence on homepage")
	@Epic("EP0001")
	@Feature("Feature01:Logo")
	@Story("Story:Logo Presence")
	@Step("Verify Logo Presence")
	@Severity(SeverityLevel.BLOCKER)
	
	public void logopresence() throws Throwable
	{
		Thread.sleep(3000);
		WebElement logo = driver.findElement(By.xpath("//div[@class='img']"));	
		Assert.assertTrue(logo.isDisplayed(),"Logo is displayed");
	}
	
	
	@Test(priority = 2)
	@Description("Verify the LoginPage")
	@Epic("EP0002")
	@Feature("Feature02:LoginPage")
	@Story("Story:LoginPage")
	@Step("Verify LoginPage")
	@Severity(SeverityLevel.BLOCKER)
    public void verifylogin() throws Exception
    {

		 test = extent.createTest("LoginPage", "It should navigate to United Grocery homepage");

         
		// log with snapshot
		test.pass("LoginPageTest");

		// test with snapshot
		//test.addScreenCaptureFromPath("screenshot.png");
		 lp=new LoginPage(driver);
		lp.setLogin(username, password);
		
		Assert.assertEquals(driver.getTitle(),"United Groceries");
		test = extent.createTest("Dashboard", "It should display all the dashboard data's");
	}
	
	@Test(priority = 3)
	@Description("Verify the PendingOrder List details")
	@Epic("EP0003")
	@Feature("Feature03:OrderTab_PendingOrder")
	@Story("Story:PendingOrder Details")
	@Step("Verify Pending order details")
	@Severity(SeverityLevel.MINOR)
	public void PendingOrder() throws Throwable
	{
		test = extent.createTest("PendingorderList", "Click on pending orderlist tab");
		 hp=new Homepage(driver);
		hp.OrderList();
		test.pass("Successfully captured the pending order list details");
        test.info("PendingOrder Test Completed");
	}
	
	@Test(priority = 4)
	@Description("Verify the AcceptOrder List details")
	@Epic("EP0003")
	@Feature("Feature04:OrderTab_Accept")
	@Story("Story:AcceptOrder Details")
	@Step("Verify AcceptOrder details")
	@Severity(SeverityLevel.MINOR)
	public void AcceptOrder() throws Throwable
	{
		test = extent.createTest("AcceptOderList", "Click on accept orderlist tab");
		hp.AcceptOderList();
		test.pass("Successfully captured the accept order list details");
        test.info("AcceptOrder Test Completed");
	}
	
	
	@Test(priority = 5)
	@Description("Verify the RejectOrder List details")
	@Epic("EP0003")
	@Feature("Feature05:OrderTab_Reject")
	@Story("Story:RejectOrder Details")
	@Step("Verify RejectOrder details")
	@Severity(SeverityLevel.MINOR)
	public void RejectOrder() throws Throwable
	{
		test = extent.createTest("RejectOderList", "Click on reject orderlist tab");
		hp.rejectOderList();
		test.pass("Successfully captured the reject order list details");
        test.info("Reject Order Test Completed");
		
	}
	
	@Test(priority = 6)
	@Description("Verify the PendingDeliveryOrder List details")
	@Epic("EP0003")
	@Feature("Feature06:OrderTab_PendingDelivery")
	@Story("Story:PendingDeliveryOrder Details")
	@Step("Verify PendingDeliveryOrder details")
	@Severity(SeverityLevel.MINOR)
	public void PendingDelivery() throws Throwable
	{
		test = extent.createTest("PendingDeliveryOderList", "Click on pending deliveryorderlist tab");
		hp.pendingDelivery();
		test.pass("Successfully captured the pending delivery order list details");
        test.info("PendingDelivery Test Completed");
	}
	
	
	@Test(priority = 7)
	@Description("Verify the DeliveredOrder List details")
	@Epic("EP0003")
	@Feature("Feature07:OrderTab_DeliveredList")
	@Story("Story:DeliveredOrder Details")
	@Step("Verify DeliveredOrder details")
	@Severity(SeverityLevel.MINOR)
	public void delivered() throws Throwable
	{
		test = extent.createTest("DeliveredList", "Click on delivered tab");
		hp.Delivered();
		test.pass("Successfully captured the delivered order list details");
        test.info("Delivered Test Completed");
	}
	
	
	
	@Test(priority = 8)
	@Description("Verify the MasterTab")
	@Epic("EP0004")
	@Feature("Feature08:MasterTab_Stores")
	@Story("Story:Stores Details")
	@Step("Verify Stores details")
	@Severity(SeverityLevel.MINOR)
	public void MasterTab() throws Throwable
	{
		test = extent.createTest("MasterTab", "Click on master tab");
		hp.MasterTab_Stores();
		test.pass("Successfully captured the store list details");
        test.info("Store details Test Completed");
	}
	
	
	
    @Test(priority = 9)
	@Description("Verify the MasterTab")
	@Epic("EP0004")
	@Feature("Feature09:MasterTab_CategoriesDownload")
	@Story("Story:Verify the Category download button ")
	@Step("Verify CategoryDownload details")
	@Severity(SeverityLevel.MINOR)
	public void CategoriesDownload() throws Throwable
	{
		test = extent.createTest("Categories", "Click on master tab");
		hp.categoryDownload();
		test.pass("Successfully captured the Category list details");
        test.info("Category tab Test Completed");
	}
	
	@Test(priority = 10)
	@Description("Verify the MasterTab")
	@Epic("EP0004")
	@Feature("Feature010:MasterTab_CategoriesUpload")
	@Story("Story:Verify the Category upload button ")
	@Step("Verify CategoryUpload details")
	@Severity(SeverityLevel.MINOR)
	public void CategoriesUpload() throws Throwable
	{
		test = extent.createTest("Categories", "Click on master tab");
		hp.categoryUpload();
		test.pass("Successfully captured the Category list details");
        test.info("Category tab Test Completed");
	}
	
	
	
	    @Test(priority = 11)
		@Description("Verify the MasterTab")
		@Epic("EP0004")
		@Feature("Feature011:MasterTab_VendorsDownload")
		@Story("Story:Verify the Vendor download button ")
		@Step("Verify Vendor download button")
		@Severity(SeverityLevel.MINOR)
		public void VendorDownload() throws Throwable
		{
			test = extent.createTest("Vendors", "Click on master tab");
			hp.VendorsDownload();
			test.pass("Successfully captured the Category list details");
	        test.info("Vendor tab Test Completed");
		}
	
	@Test(priority = 12)
	@Description("Verify the MasterTab")
	@Epic("EP0004")
	@Feature("Feature011:MasterTab_VendorsUpload")
	@Story("Story:Verify the Vendor upload button ")
	@Step("Verify Vendor download button")
	@Severity(SeverityLevel.MINOR)
	public void VendorUpload() throws Throwable
	{
		test = extent.createTest("Vendors", "Click on master tab");
		hp.vendorUpload();
		test.pass("Successfully captured the Category list details");
        test.info("Vendor tab Test Completed");
	}
	
	@Test(priority = 13)
	@Description("Verify the MasterTab")
	@Epic("EP0004")
	@Feature("Feature012:MasterTab_VendorsList Details")
	@Story("Story:Verify the Vendor upload button ")
	@Step("Verify Vendor download button")
	@Severity(SeverityLevel.MINOR)
	public void VendorListDetails()throws Throwable
	{
		test = extent.createTest("VendorsList", "Click on master tab");
		hp.vendorlist();
		test.pass("Successfully captured the vendor list details");
        test.info("Vendor tab Test Completed");
	}
	
	@Test(priority = 14)
	@Description("Verify the Return List Tab")
	@Epic("EP0005")
	@Feature("Feature013:ReturnListTab_ReturnPending List Details")
	@Story("Story:Verify the ReturnPending  button ")
	@Step("Verify return pending list  details")
	@Severity(SeverityLevel.MINOR)
	public void returnList() throws Throwable
	{
		test = extent.createTest("ReturnList_Pending", "Click on ReturnList tab");
		hp.ReturnListtab();
		test.pass("Successfully captured the Return pending list details");
        test.info("Return Pending tab Test Completed");
	}
	
	
	@Test(priority = 15)
	@Description("Verify the Return List Tab")
	@Epic("EP0005")
	@Feature("Feature014:ReturnListTab_ReturnAccepted List Details")
	@Story("Story:Verify the ReturnAccepted button ")
	@Step("Verify returnaccepted list details")
	@Severity(SeverityLevel.MINOR)
	public void returnAccepted() throws Throwable
	{
		test = extent.createTest("ReturnList_Accepted", "Click on ReturnList tab");
		hp.returnAccepted();
		test.pass("Successfully captured the Return accepted list details");
        test.info("Return Acceptedtab Test Completed");
	}
	
	
	@Test(priority = 16)
	@Description("Verify the Return List Tab")
	@Epic("EP0005")
	@Feature("Feature015:ReturnListTab_ReturnRejected List Details")
	@Story("Story:Verify the ReturnRejected  button ")
	@Step("Verify return rejected  list details")
	@Severity(SeverityLevel.MINOR)
	public void returnRejected() throws Throwable
	{
		test = extent.createTest("ReturnList_Rejected", "Click on ReturnList tab");
		hp.retrunRejected();
		test.pass("Successfully captured the Return rejected list details");
        test.info("Return Rejected tab Test Completed");
	}
}
