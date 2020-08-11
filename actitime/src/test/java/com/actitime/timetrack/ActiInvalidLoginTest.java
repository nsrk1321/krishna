package com.actitime.timetrack;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.actitime.genericLib.BaseTest;
import com.actitime.genericLib.FileLib;
import com.actitime.genericLib.WebDriverCommonLib;
import com.actitime.pages.Loginpage;

@Listeners(com.actitime.genericLib.MyListner.class)
public class ActiInvalidLoginTest extends BaseTest{

	
	@Test
 public void InvalidLoginTest() throws Throwable {
Assert.fail();
		
		FileLib flib= new FileLib();
    int rcount = flib.getRowCount(EXCEL_PATH, "Invalid");
    for(int i=1;i<rcount;i++) {
    WebDriverCommonLib wlib=new WebDriverCommonLib();	
     Loginpage lp= new Loginpage(driver);
     lp.login(flib.getCellData(EXCEL_PATH, "Invalid", i, 0),flib.getCellData(EXCEL_PATH, "Invalid", i, 1));
     Thread.sleep(2000);
     wlib.waitForPageTitle(flib.getProkeyValue(PROP_PATH, "loginTitle"));
     wlib.verifypage(wlib.getPageTitle(), flib.getProkeyValue(PROP_PATH, "loginTitle"), "Loginpage");
     System.out.println( flib.getCellData(EXCEL_PATH, "Invalid", i, 0)+ "  " + flib.getCellData(EXCEL_PATH, "Invalid", i, 1));
     flib.setCellData(EXCEL_PATH, "Invalid", i, 2, "Passed");
     Thread.sleep(3000);
    lp.getUntb().clear();
   
    }
    
 
    
	 
	 
	 
}	


}
