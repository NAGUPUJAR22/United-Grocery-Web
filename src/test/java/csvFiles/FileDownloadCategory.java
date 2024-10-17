package csvFiles;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FileDownloadCategory 
{
	@Test
	public void FiledownloadCategoryList() throws Exception
	{
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
        driver.quit();
        
	}

}
