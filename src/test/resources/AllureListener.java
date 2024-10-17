import org.testng.ITestListener;
import org.testng.ITestResult;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener 
{
	private static String getTestMethodName(ITestResult iTestResult)
	{
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	//Text attachment for Allure
	@Attachment(value="Page Screenshot",type="image/png")
	public byte[] saveScreenShot(Webdriver driver)
	{
		
	}

}
