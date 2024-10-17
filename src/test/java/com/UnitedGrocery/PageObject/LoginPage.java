package com.UnitedGrocery.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
   public  WebDriver driver;
   
   public LoginPage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   
   @FindBy(id="username")
   WebElement untbx;
   
   @FindBy(id="password")
   WebElement pwtbx;
   
   @FindBy(xpath="//button[.='Login']")
   WebElement lgbtn;
   
  @FindBy(xpath = "//title[.='United Groceries']")
  WebElement title;
   
   public void setLogin(String un,String pw)
   {
	   untbx.sendKeys(un);
	   pwtbx.sendKeys(pw);
	   lgbtn.click();
   }
   
   
   
   
   /*public void Dashboard()
   {
	   String text = driver.findElement(By.xpath("//div[@class='layout_content']")).getText();
       System.out.println("Successfully captured the Dasboard Details");
       System.out.println("--------------------------------------------");
       System.out.println("\n"+text);
   }*/
   
   
   
   
}

 
	  
   
   


