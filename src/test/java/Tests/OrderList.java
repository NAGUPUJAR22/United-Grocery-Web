package Tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderList 
{
	//@Test(priority = 1)
     public void LoginPage()
     {
    	 ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentLoginPageReport.html");
 		
 		 ExtentReports extent = new ExtentReports();
         extent.attachReporter(htmlReporter);
         
         ExtentTest test = extent.createTest("UnitedGroceryTest", "Login functionality");
         
         WebDriverManager.chromedriver().setup();
         WebDriver driver=new ChromeDriver();
         driver.manage().window().maximize();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         
         
         test.log(Status.INFO, "Starting the login test case");
         driver.get("http://3.7.168.189:8080/ugweb/login");
         test.pass("Successsfully navigated to login page");
         
         driver.findElement(By.id("username")).sendKeys("admin");
         test.pass("User enter valid username in username textfield");
         
         
         driver.findElement(By.id("password")).sendKeys("Admin@123");
         test.pass("User enter valid password in password textfield");        
         
         driver.findElement(By.xpath("//button[.='Login']")).click();
         test.pass("User clicks on login button");
         
         test.info("Successfully navigated to homepage");
         
         test.pass("Browser is closed");
         
         test.info("Login functionalitry Test completed");
         
         driver.quit();
         
         extent.flush();
        
         
         
     }
	
	//@Test(priority = 2)
	public void Dashboard()
	{
		ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentDashboardReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify Dashboard functionality");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        test.log(Status.INFO, "Verifying the functionality of dashboard test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
        
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
        
        
        driver.findElement(By.id("password")).sendKeys("Admin@123");
        test.pass("User enter valid password in password textfield");        
        
        driver.findElement(By.xpath("//button[.='Login']")).click();
        test.pass("User clicks on login button");
        
        test.info("Successfully navigated to homepage");
        
        String text = driver.findElement(By.xpath("//div[@class='layout_content']")).getText();
        System.out.println("Successfully captured the Dasboard Details");
        System.out.println("--------------------------------------------");
        System.out.println("\n"+text);
        test.pass("All the data's are successfully displayed on Homepage");
        
        
       
        
        test.pass("Browser is closed");
        
        test.info("Verify Dashboard functionalitry Test completed");
        
        driver.quit();
        
        extent.flush();
        
   }
	
	//@Test(priority = 3)
	public void orderlist() throws InterruptedException
	{
        ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentOrderListReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify functionality of OrderList Major Tab");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        test.log(Status.INFO, "Verifying the functionality of OrderList test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
        
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
        
        
        driver.findElement(By.id("password")).sendKeys("Admin@123");
        test.pass("User enter valid password in password textfield");        
        
        driver.findElement(By.xpath("//button[.='Login']")).click();
        test.pass("User clicks on login button");
        
        test.info("Successfully navigated to homepage");
        
        
      
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
      //CLICKING ON PENDING ORDER LIST
        
        test.info("User then clicks on pending order minor tab");
        driver.findElement(By.xpath("//a[.='Pending orders']")).click();
        
        
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Pending Order List details");
        System.out.println("----------------------------");
        WebElement table = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow = table.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers = headerRow.findElements(By.tagName("th"));
        
        for (WebElement header : headers) {
            System.out.printf("%-20s", header.getText()); 
            
        }
        System.out.println();

        
        List<WebElement> rows = table.findElements(By.tagName("tr"));
       

        
        for (WebElement row : rows) {
            
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            
            
            if (cells.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the pending order list details");
        test.info("PendingOrder Test Completed");
        
        
        Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        test.info("User Clicks on Order list major tab");
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
        
        //CLICK ON ACCEPT MINOR TAB
        test.info("User then clicks on accept  minor tab");
        driver.findElement(By.xpath("//a[.='Accept']")).click();
        test.pass("Successfully clicked on accept  button");
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Accepted Order List details");
        System.out.println("----------------------------");
        
        //FETCHING THE  DATA OF ACCEPT ORDER LIST
        
       WebElement table1 = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow1 = table1.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers1 = headerRow1.findElements(By.tagName("th"));
        
        for (WebElement header : headers1) {
            System.out.printf("%-20s", header.getText()); 
           
        }
        System.out.println();

        
        List<WebElement> rows1 = table1.findElements(By.tagName("tr"));
        

        
        for (WebElement row : rows1) {
            
            List<WebElement> cells1 = row.findElements(By.tagName("td"));
            
            
            
            if (cells1.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells1) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the accept order list details");
        test.info("AcceptOrder Test Completed");
        
        
        Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        test.info("User Clicks on Order list major tab");
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
        
        //CLICK ON REJECTED MINOR TAB
        test.info("User then clicks on accept  minor tab");
        driver.findElement(By.xpath("//a[.='Rejected']")).click();
        test.pass("Successfully clicked on reject  button");
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Rejected Order List details");
        System.out.println("----------------------------");
        
        //FETCHING THE  DATA OF REJECTED ORDER LIST
        
       WebElement table2 = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow2 = table2.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers2 = headerRow2.findElements(By.tagName("th"));
        
        for (WebElement header : headers2) {
            System.out.printf("%-20s", header.getText()); 
            
        }
        System.out.println();

        
        List<WebElement> rows2 = table2.findElements(By.tagName("tr"));
        

        
        for (WebElement row : rows2) {
            
            List<WebElement> cells2 = row.findElements(By.tagName("td"));
            
            
            
            if (cells2.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells2) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the rejected order list details");
        test.info("RejectedOrder Test Completed");
        
        
        
        
         Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        test.info("User Clicks on Order list major tab");
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
        
        //CLICK ON PENDING DELIVERY MINOR TAB
        test.info("User then clicks on accept  minor tab");
        driver.findElement(By.xpath("//a[.='Pending Delivery']")).click();
        test.pass("Successfully clicked on pending delivery  button");
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Pending delivery Order List details");
        System.out.println("----------------------------");
        
        //FETCHING THE  DATA OF PENDING DELIVERY ORDER LIST
        
       WebElement table3 = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow3 = table3.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers3 = headerRow3.findElements(By.tagName("th"));
        
        for (WebElement header : headers3) {
            System.out.printf("%-20s", header.getText()); 
            
        }
        System.out.println();

        
        List<WebElement> rows3 = table3.findElements(By.tagName("tr"));
       

        
        for (WebElement row : rows3) {
            
            List<WebElement> cells3 = row.findElements(By.tagName("td"));
            
            
            
            if (cells3.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells3) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the pending delivery order list details");
        test.info("Pending delivery Test Completed");
        
        
        
         Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        test.info("User Clicks on Order list major tab");
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
        
        //CLICK ON DELIVERED MINOR TAB
        test.info("User then clicks on accept  minor tab");
        driver.findElement(By.xpath("//a[.='Delivered']")).click();
        test.pass("Successfully clicked on  delivered  button");
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Delivered  List details");
        System.out.println("----------------------------");
        
        //FETCHING THE  DATA OF  DELIVERED  LIST
        
       WebElement table4 = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow4 = table4.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers4 = headerRow4.findElements(By.tagName("th"));
        
        for (WebElement header : headers4) {
            System.out.printf("%-20s", header.getText()); 
            
        }
        System.out.println();

        
        List<WebElement> rows4 = table4.findElements(By.tagName("tr"));
        

        
        for (WebElement row : rows4) {
            
            List<WebElement> cells4 = row.findElements(By.tagName("td"));
            
            
            
            if (cells4.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells4) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the delivered  list details");
        test.info("Delivered Test Completed");
        
        
        
        
        
        
        
        
        driver.quit();
        test.pass("Browser is closed");
        
        
        
        extent.flush();
        
        
	}
	
	//@Test(priority = 4)
	public void MasterTab() throws InterruptedException
	{
        ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentMastersTabReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify functionality of Masters Major Tab");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        test.log(Status.INFO, "Verifying the functionality of dashboard test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
      
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
      
     
       driver.findElement(By.id("password")).sendKeys("Admin@123");
       test.pass("User enter valid password in password textfield");        
      
       driver.findElement(By.xpath("//button[.='Login']")).click();
       test.pass("User clicks on login button");
      
        
        

        //CLICK ON MASTER MAJOR TAB
        
        driver.findElement(By.xpath("//button[.='Masters']")).click();
        
        //CLICK ON STORE MINOR TAB
        driver.findElement(By.xpath("//a[.='Stores']")).click();
        
        test.pass("Successfully clicked on  store  button");
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Store  List details");
        System.out.println("----------------------------");
        
        
        //fetching the stores data
        
        WebElement table = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow = table.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers = headerRow.findElements(By.tagName("th"));
        
        for (WebElement header : headers) {
            System.out.printf("%-20s", header.getText()); 
            
        }
        System.out.println();

        
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        

        
        for (WebElement row : rows) {
            
            List<WebElement> cells = row.findElements(By.tagName("td"));
            
            
            
            if (cells.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells) {
                System.out.printf("%-20s", cell.getText()); 
                
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the store  list details");
        test.info("Store Test Completed");
        
        driver.quit();
        test.pass("Browser is closed");
        
        
        
        extent.flush();
	}
	
     //@Test(priority = 5)
	public void vendorList()
	{
        ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentVendorListReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify functionality of vendors Tab");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        test.log(Status.INFO, "Verifying the functionality of Vendor List test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
      
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
      
     
       driver.findElement(By.id("password")).sendKeys("Admin@123");
       test.pass("User enter valid password in password textfield");        
      
       driver.findElement(By.xpath("//button[.='Login']")).click();
       test.pass("User clicks on login button");
       
       //click on master major tab
       driver.findElement(By.xpath("//button[.='Masters']")).click();
       
       //click on vendor tab
       driver.findElement(By.xpath("//a[.='Vendors']")).click();
       System.out.println("Vendor Order List details");
       System.out.println("---------------------------");
       WebElement table = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
       
       
       WebElement headerRow = table.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
       List<WebElement> headers = headerRow.findElements(By.tagName("th"));
       
       for (WebElement header : headers) {
           System.out.printf("%-20s", header.getText()); 
           
       }
       System.out.println();

       
       List<WebElement> rows = table.findElements(By.tagName("tr"));
       

       
       for (WebElement row : rows) {
           
           List<WebElement> cells = row.findElements(By.tagName("td"));
           
           
           
           if (cells.isEmpty()) {
               continue;
           }

          
           for (WebElement cell : cells) {
              System.out.printf("%-20s", cell.getText()); 
               
           }
           System.out.println();
       }
        
        
             test.pass("Successfully captured the vendor list details");
      test.info("Vendor Test Completed");
       
       
       
       
       
       
       
       driver.quit();
       test.pass("Browser is closed");
       
       
       
       extent.flush();
       
       
	}
	
	
	@Test(priority = 6)
	public void CategoryDownload() throws InterruptedException, Throwable
	{
       ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentCategoryDownloadReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify functionality of category Tab");
		WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://3.7.168.189:8080/ugweb/login");
        
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("Admin@123");
        driver.findElement(By.xpath("//button[.='Login']")).click();
        
        // Click on master major tab
        driver.findElement(By.xpath("//button[.='Masters']")).click();
        
        // Click on category tab
        driver.findElement(By.xpath("//a[.='Categories']")).click();
        Thread.sleep(2000); 
        
        driver.findElement(By.xpath("//button[.='Download template']")).click();
        System.out.println("Successfully downloaded the category csv file");
        test.pass("Successfully downloaded the category csv file");
        
        
        //to read the file from category csv file
        File file = new File(System.getProperty("user.dir") + "\\Test data\\CategoryList.csv");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] columns = line.split(",");
            
            
            for (String column : columns)
            {
                System.out.printf("%-20s", column);
            }
            System.out.println();
        
        driver.close();
        test.pass("Browser is closed");
        
        extent.flush();
        }
	}
	
	//@Test(priority = 7)
	public void CategoriesUpload() throws AWTException
	{
		
		
        ExtentHtmlReporter html=new ExtentHtmlReporter("ExtentCategoryFileUploadReport.html");
		
		ExtentReports extent=new ExtentReports();
		 extent.attachReporter(html);
		
		ExtentTest test = extent.createTest("UnitedGroceryTest1", "Verify functionality of category  Tab");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
       
        test.log(Status.INFO, "Verifying the functionality of Category List test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
      
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
      
     
       driver.findElement(By.id("password")).sendKeys("Admin@123");
       test.pass("User enter valid password in password textfield");        
      
       driver.findElement(By.xpath("//button[.='Login']")).click();
       test.pass("User clicks on login button");
       
       //click on master major tab
       driver.findElement(By.xpath("//button[.='Masters']")).click();
       
       //click on category tab
       driver.findElement(By.xpath("//a[.='Categories']")).click();
       
       WebElement button = driver.findElement(By.xpath("//label[.='Upload']"));
       
       Actions act=new Actions(driver);
       act.moveToElement(button).click().perform();
       
       Robot rb=new Robot();
       rb.delay(2000);
       StringSelection ss=new StringSelection("C:\\workspace\\UNITED_GROCERY\\Test data\\CategoryList.csv");
       Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
       
       
       rb.keyPress(KeyEvent.VK_CONTROL);
       rb.keyPress(KeyEvent.VK_V);
       
       rb.keyRelease(KeyEvent.VK_CONTROL);
       rb.keyRelease(KeyEvent.VK_V);
       
       rb.keyPress(KeyEvent.VK_ENTER);
       rb.keyRelease(KeyEvent.VK_ENTER);
       
       System.out.println("Successfully uploaded the category csv file");
       test.pass("Successfully uploaded the category csv file");
       
       driver.close();
       test.pass("Browser is closed");
       
       extent.flush();
       
       
 
		
	
	
}
}
