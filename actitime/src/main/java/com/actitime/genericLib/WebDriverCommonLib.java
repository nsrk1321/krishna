package com.actitime.genericLib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class WebDriverCommonLib extends BaseTest {
	//get the Title of the Webpage
	public String getPageTitle() {
		String title=driver.getTitle();
		return title;
	}
	//page verification
public void verifypage(String actualpage,String expectedpage,String pageName)
{
 Assert.assertEquals(actualpage, expectedpage);
 Reporter.log(pageName+"Is Displayed ",true);
}
public void waitForPageTitle(String title)
{
	WebDriverWait w = new WebDriverWait(driver, 20);
	w.until(ExpectedConditions.titleIs(title));
}
public void waitForElementVisibility(WebElement element)
{
	WebDriverWait w = new WebDriverWait(driver, 20);
	w.until(ExpectedConditions.visibilityOf(element));
	
}

//Dropdown method
public void selectOption(WebElement element,int index)
{
	Select sel=new Select(element);
	sel.selectByIndex(index);
}

public void selectOption( String value,WebElement element)
{
	Select sel = new Select(element);
	sel.selectByValue(value);
}
public void SelectOption(String text,WebElement element)
{
	Select sel = new Select(element);
	sel.selectByVisibleText(text);
	
}

public void frameSwitch(int index)
{
	driver.switchTo().frame(index);
}
public void frameSwitch( String attributeValue)
{
	driver.switchTo().frame(attributeValue);
}
public void frameSwitch(WebElement element)
{
	driver.switchTo().frame(element);
}
public void mouseHover(WebElement element)
{
	Actions a=new Actions(driver);
	a.moveToElement(element).perform();

}
public  void elementDisplayed(WebElement element) {
	if(element.isDisplayed())
	{
		Assert.assertTrue(true);
		Reporter.log(element.getText()+"is Displayed",true);
	}
	else
	{
		Reporter.log(element.getText()+"is not Displayed",true);
		Assert.assertTrue(false);
	}
}
}
