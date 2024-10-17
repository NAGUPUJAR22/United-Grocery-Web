package Tests;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportDemo1 {

	public static void main(String[] args) throws InterruptedException 
	{
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("ExtentReport.html");
		
		ExtentReports extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        
        ExtentTest test = extent.createTest("UnitedGroceryTest", "Login functionality is working fine or not");
        
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        
        
        test.log(Status.INFO, "Starting the test case");
        driver.get("http://3.7.168.189:8080/ugweb/login");
        test.pass("Successsfully navigated to login page");
        
        
        driver.findElement(By.id("username")).sendKeys("admin");
        test.pass("User enter valid username in username textfield");
        
        
        driver.findElement(By.id("password")).sendKeys("Admin@123");
        test.pass("User enter valid password in password textfield");        
        
        driver.findElement(By.xpath("//button[.='Login']")).click();
        test.pass("User clicks on login button");
        
        
        String text = driver.findElement(By.xpath("//div[@class='layout_content']")).getText();
        System.out.println("\n"+text);
        test.pass("the text are successfully captured");
        
        
        driver.findElement(By.xpath("//button[.='Order List']")).click();
        test.pass("Successfully clicked on order list button");
        
        
        driver.findElement(By.xpath("//a[.='Pending orders']")).click();
        test.pass("Successfully clicked on pending order button");
        
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(3000);
        WebElement table = driver.findElement(By.xpath("//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]"));
        
        
        WebElement headerRow = table.findElement(By.xpath("//tr[@class='MuiTableRow-root MuiTableRow-head css-1gqug66']"));
        List<WebElement> headers = headerRow.findElements(By.tagName("th"));
        
        for (WebElement header : headers) {
            System.out.printf("%-20s", header.getText()); 
            test.info("Adjust the width of header");
        }
        System.out.println();

        
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        test.pass("Get all the rows from the table");

        
        for (WebElement row : rows) {
            
            List<WebElement> cells = row.findElements(By.tagName("td"));
            test.pass("Get all the cells from the current row");
            
            
            if (cells.isEmpty()) {
                continue;
            }

           
            for (WebElement cell : cells) {
                System.out.printf("%-20s", cell.getText()); 
                test .info("Adjust teh width of cell");
            }
            System.out.println();
        }
         
         
        
        test.pass("Successfully captured the pending order list details");
        
        driver.quit();
        test.pass("Chrome browser is closed");
        
        test.info("Test Completed");
        
        extent.flush();
        
        
		

	}

}
