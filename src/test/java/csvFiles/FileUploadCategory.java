package csvFiles;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.File;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FileUploadCategory {

	@Test
    public void FileUploadCategoryList() throws Exception {
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
        // Get the absolute path of the file
        //driver.findElement(By.xpath("//input[@type='file']")).sendKeys("C:\\workspace\\UNITED_GROCERY\\Test data\\CategoryList.csv");
        //System.out.println("File uploaded successfully......!");
        
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
        // Close the browser
        driver.quit();
    }
}
    


