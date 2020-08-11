package com.actitime.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
//Declaration
@FindBy(name="username") private WebElement untb;
//Utilization
 public WebElement getUntb()
 {
	 return untb;
 }
public void setUntb(String un)
{
	untb.sendKeys(un);
}

@FindBy(name="pwd") private WebElement pwd;
public WebElement getPwd()
{
	return pwd;
}

public  void setPwd(String pw)
{
	pwd.sendKeys(pw);
}

@FindBy(xpath="//a[.='Login']")  private WebElement loginBtn;
public WebElement getLoginBtn()
{
	return loginBtn;
	
}

public void clickLoginBtn()
{
loginBtn.click();
}	
public void login(String un,String pw)
{
	untb.sendKeys(un);
	pwd.sendKeys(pw);
	loginBtn.click();

}

//intialization
public Loginpage( WebDriver driver)
{
	PageFactory.initElements(driver, this);
}


}