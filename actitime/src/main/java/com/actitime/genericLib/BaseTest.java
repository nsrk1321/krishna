package com.actitime.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest implements IAutoConstants 
{
	
	//AVOID REPEATATIVE TASKS LIKE  OPEN BROWSER AND CLOSER BROWSER
	
	public static WebDriver driver;
	
	@BeforeClass
	public void openBrowser() throws Throwable
	{
		FileLib flib=new FileLib();
		 String browservalue=flib.getProkeyValue(PROP_PATH, "Browser");
		 if(browservalue.equalsIgnoreCase("chrome"))
		 	{
			 System.setProperty(CHROME_KEY, CHROME_VLAUE);
			  driver=new ChromeDriver();
		 	}
		 
		 		else if (browservalue.equalsIgnoreCase("firefox"))
		 				{
		 				System.setProperty(GECKO_KEY, GECKO_VALUE);
		 				driver=new FirefoxDriver();
			
		 				}
		 					else
		 						{
		 							System.out.println("please Enter correct browser name");
		 						}
		 						driver.manage().window().maximize(); 
		 						String appurl=flib.getProkeyValue(PROP_PATH, "url");
		 						driver.get(appurl);	
		 						
		 						//VERIFY LOGINPAGE IS DISPLAYED
		 						WebDriverCommonLib wlib=new WebDriverCommonLib();
		 						wlib.verifypage(wlib.getPageTitle(), flib.getProkeyValue(PROP_PATH, "loginTitle"), "Loginpage");
	}
	@AfterClass
	public void closeBrowser()
	 		{
			 driver.quit();
	 		}
		 
		 
	

}
