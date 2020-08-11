package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTimeTrackpage {

	@FindBy (xpath="//a[@class='content users']") private WebElement usersTab;
	//
	public WebElement getUsersTab()
	{
		return usersTab;
	}
	
	public void clickUSerTab()
	{
		usersTab.click();
	}
	
	//initialization
	
	public EnterTimeTrackpage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);
	
	}
	
	
}
