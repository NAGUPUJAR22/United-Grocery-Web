package com.UnitedGrocery.TestCases;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import com.UnitedGrocery.TestCases.BaseClass;

public class ListenerClass extends BaseClass implements ITestListener 
{
	@Test
   public void onTestFailure(ITestResult result)
   {
	   System.out.println("Test is failed....!");
	   try
	   {
		   captureScreenShot(result.getName());
	   }
	   catch (Exception e)
	   {
		e.getMessage();
	}
	  
   }
}
