package com.UnitedGrocery.PageObject;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
	WebDriver driver;
    public Homepage(WebDriver driver)
    {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[.='Order List']")
    WebElement orderbtn;
    
    @FindBy(xpath = "//a[.='Pending orders']")
    WebElement pendingorderbtn;
    
    @FindBy(xpath = "//div[contains(@class,'MuiPaper-root MuiPaper-elevation MuiPaper-rounded MuiPaper-elevation1 MuiTableContainer-root css-13xy2my')]")
    WebElement table;
    
    
    
    public void OrderList() throws Throwable
    {
 	   //click on order major tab
 	   
 	   orderbtn.click();
 	   Thread.sleep(2000);
 	   
 	   //click on pending order minor tab
 	   pendingorderbtn.click();
 	   
 	   System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Pending Order List details");
        System.out.println("----------------------------");
        
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
    }
    
    
    @FindBy(xpath = "//a[.='Accept']")
    WebElement Acceptorderbtn;
    
    public void AcceptOderList() throws Throwable
    {
    	 Thread.sleep(2000);  
         
         //CLICKING ON ORDER LIST MAJOR TAB 
         
         driver.navigate().back();
    	orderbtn.click();
    	
    	Thread.sleep(2000);
    	Acceptorderbtn.click();
    	
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
         
     }
    
    
    @FindBy(xpath = "//a[.='Rejected']")
    WebElement rejectorderbtn;
    
    public void rejectOderList() throws Throwable
    {
        Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        
        orderbtn.click();
        Thread.sleep(3000);
        
        rejectorderbtn.click();
        
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
      }
    
    
    
    @FindBy(xpath = "//a[.='Pending Delivery']")
    WebElement pedingdeliverybtn;
    
    public void pendingDelivery() throws Throwable
    {
         Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        orderbtn.click();
        Thread.sleep(2000);
        
        pedingdeliverybtn.click();
        
        
        
        System.out.println("================================================");
        System.out.println("\n");
        Thread.sleep(2000);
        System.out.println("Pending delivery Order List details");
        System.out.println("----------------------------------------");
        
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
}
    
    
    @FindBy(xpath = "//a[.='Delivered']")
    WebElement deliveredbtn;
    
    public void Delivered() throws Throwable
    {

        Thread.sleep(2000);  
       
       //CLICKING ON ORDER LIST MAJOR TAB 
       
       driver.navigate().back();
       orderbtn.click();
       
       Thread.sleep(3000);
       
       deliveredbtn.click();
       
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
    }
    
    
    
    
    @FindBy(xpath = "//button[.='Masters']")
    WebElement masterbtn;
    
    @FindBy(xpath = "//a[.='Stores']")
    WebElement storesbtn;
    
    public void MasterTab_Stores() throws Throwable
    {
    	Thread.sleep(3000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        //driver.navigate().back();
        masterbtn.click();
        
        Thread.sleep(3000);
        storesbtn.click();
        
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
            System.out.println();
        }
    }
    
    
    @FindBy(xpath = "//a[.='Categories']")
    WebElement categorybtn;
    
    @FindBy(xpath = "//button[.='Download template']")
    WebElement categorydownbtn;
    
    public void categoryDownload() throws Throwable
    {
    	Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        
        masterbtn.click();
        Thread.sleep(3000);
        categorybtn.click();
        Thread.sleep(1000);
        categorydownbtn.click();
        Thread.sleep(2000);
        
        File file = new File(System.getProperty("user.dir") + "\\Test data\\CategoryList.csv");
        Scanner sc = new Scanner(file);
        System.out.println("The Category  List from csv file....");
        System.out.println("-----------------------------------------");
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] columns = line.split(",");
            
            
            for (String column : columns)
            {
            	
                System.out.printf("%-20s", column);
            }
            System.out.println();
            System.out.println("");
        }
        
   }
    
    @FindBy(xpath="//label[.='Upload']")
    WebElement categoryupbtn;
    
    public void categoryUpload() throws Throwable
    {
    	Thread.sleep(2000);
    	categoryupbtn.click();
    	
    	Actions act=new Actions(driver);
        act.moveToElement(categoryupbtn).click().perform();
        
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
        System.out.println("successfully uploaded the categorylist csv  file");
        System.out.println("");
    }
    
    
    
    @FindBy(xpath = "//a[.='Vendors']")
    WebElement vendorbtn;
    
    @FindBy(xpath = "//button[.='Download template']")
    WebElement vendordownloadbtn;
    
    public void VendorsDownload() throws Throwable
    {
       Thread.sleep(2000);  
        
        //CLICKING ON ORDER LIST MAJOR TAB 
        
        driver.navigate().back();
        
        masterbtn.click();
        Thread.sleep(3000);
        vendorbtn.click();
        Thread.sleep(2000);
        
        vendordownloadbtn.click();
        
        File file = new File(System.getProperty("user.dir") + "\\Test data\\Vendorlist.csv");
        Scanner sc = new Scanner(file);
        System.out.println("The vendorlist from csv file");
        System.out.println("--------------------------------");

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] columns = line.split(",");
            
            
            for (String column : columns)
            {
                System.out.printf("%-20s", column);
            }
            System.out.println();
        }
    }
    
    
    
    @FindBy(xpath = "//label[.='Upload']")
    WebElement vendoruploadbtn;
    public void vendorUpload() throws AWTException, Throwable
    {
    	Thread.sleep(2000);
    	vendoruploadbtn.click();
    	
    	 Actions act=new Actions(driver);
         act.moveToElement(vendoruploadbtn).click().perform();
         
         Robot rb=new Robot();
         rb.delay(2000);
         StringSelection ss=new StringSelection("C:\\workspace\\UNITED_GROCERY\\Test data\\Vendorlist.csv");
         Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
         
         
         rb.keyPress(KeyEvent.VK_CONTROL);
         rb.keyPress(KeyEvent.VK_V);
         
         rb.keyRelease(KeyEvent.VK_CONTROL);
         rb.keyRelease(KeyEvent.VK_V);
         
         rb.keyPress(KeyEvent.VK_ENTER);
         rb.keyRelease(KeyEvent.VK_ENTER);
         System.out.println();
    }
    
    
    public void vendorlist() throws Throwable
    {
    	Thread.sleep(2000);
    	System.out.println("===========================================");
        System.out.println("\n");
    	 System.out.println("The vedor list details.....!");
    	 System.out.println("=================================");
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
    }
    
    
    
    @FindBy(xpath="//button[.='Return List']")
    WebElement returnListTabbtn;
    
    @FindBy(xpath = "//a[.='Return Pending']")
    WebElement returnpendingbtn;
    
    @FindBy(xpath = "//a[.='Return Accepted']")
    WebElement returnacceptedbtn;
    
    @FindBy(xpath = "//a[.='Return Rejected']")
    WebElement returnrejectedbtn;
    
    
    
    public void ReturnListtab() throws Throwable
    {
    	Thread.sleep(3000);
    	driver.navigate().back();
    	returnListTabbtn.click();
    	Thread.sleep(1000);
    	returnpendingbtn.click();
    	
    	System.out.println("===========================================");
        System.out.println("\n");
    	System.out.println("The Return pending List Details.....!");
    	System.out.println("===========================================");
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
         System.out.print("");
    	
    }
    
    
    
    public void returnAccepted() throws Exception
    {

    	Thread.sleep(2000);
    	driver.navigate().back();
    	returnListTabbtn.click();
    	Thread.sleep(1000);
    	returnacceptedbtn.click();
    	
    	
    	System.out.println("===========================================");
        System.out.println("\n");
    	System.out.println("The ReturnAccepted List Details.....!");
    	System.out.println("===========================================");
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
         System.out.print("");
    }
    
    public void retrunRejected() throws Throwable
    {
    	Thread.sleep(2000);
    	driver.navigate().back();
    	returnListTabbtn.click();
    	Thread.sleep(1000);
    	returnrejectedbtn.click();
    	
    	
    	System.out.println("============================================");
        System.out.println("\n");
    	System.out.println("The ReturnRejected List Details.....!");
    	System.out.println("===========================================");
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
         System.out.print("");
    }
}
