package com.actitime.timetrack;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.genericLib.WebDriverCommonLib;
import com.actitime.pages.EnterTimeTrackpage;
import com.actitime.pages.Loginpage;

@Listeners(com.actitime.genericLib.MyListner.class)
public class ValidLoginTest extends BaseTest  {
	         @Test
	        public void validLogin() throws Throwable {
		  
		  FileLib flib = new FileLib();
		  Loginpage lp=new Loginpage(driver);
		  lp.login(flib.getProkeyValue(PROP_PATH, "username"),flib.getProkeyValue(PROP_PATH, "password"));
		  WebDriverCommonLib wlib=new WebDriverCommonLib();
		  wlib.waitForPageTitle(flib.getProkeyValue(PROP_PATH, "homeTitle"));
		  wlib.verifypage(wlib.getPageTitle(), flib.getProkeyValue(PROP_PATH, "homeTitle"), "homepage");
		  
		     }
	         
	        
	          
}
