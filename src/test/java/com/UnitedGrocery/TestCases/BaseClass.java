package com.UnitedGrocery.TestCases;



import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.UnitedGrocery.Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
   
    
public static WebDriver driver;
	
   ReadConfig read=new ReadConfig();
   
   String url=read.getbaseurl();
   String browser=read.getbrowser();
   String username=read.getUsername();
   String password=read.getPassword();
   
   
   ExtentHtmlReporter htmlReporter;
   ExtentReports extent;
   
   @BeforeSuite
   public void setUp()
   {
	   // start reporters
        htmlReporter = new ExtentHtmlReporter("LoginPageExtent.html");
   
       // create ExtentReports and attach reporter(s)
       extent = new ExtentReports();
       extent.attachReporter(htmlReporter);
   }
   
  
   
   
  
	
	@BeforeClass
	@Parameters("browser")
	public void LauchBrowser( @Optional("chrome")String browser)
	{
		if (browser.equals("chrome")) 
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Chrome Browser  is launched");
			driver.get(url);
		}
		
		else if (browser.equals("firefox")) 
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Firefox  Browser is launched");
			driver.get(url);
		}
		
		else if (browser.equals("ie")) 
		{
			WebDriverManager.iedriver().setup();
			driver=new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Inter Explorer Browser is Launched");
			driver.get(url);
			
		}
		
}
	
	
	public void captureScreenShot(String methodname)
	{
		Date date=new Date();
		String timestamp=date.toString();
		
		try 
		{
		    File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		    FileUtils.copyFile(file, new File("C:\\workspace\\UNITED_GROCERY\\ScreenShots\\"+methodname+timestamp+ "ug.jpg"));
		} 
		catch (Exception e) 
		{
			
		}
	}
    
    @AfterClass
    public void tearDown()
    {
    	if(driver!=null)
    	driver.quit();
    }
    
    @AfterSuite
    public void teardown()
    {
 	   extent.flush();
    }
    
    
}
