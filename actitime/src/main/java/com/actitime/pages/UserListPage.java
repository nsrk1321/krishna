package com.actitime.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;


public class UserListPage {


	@FindBy(name="username") private WebElement untb;
	public WebElement getUntb() {
		return untb;
	}

	public WebElement getPwtb() {
		return pwtb;
	}

	public WebElement getRepwtb() {
		return repwtb;
	}

	public WebElement getFirstNameTb() {
		return firstNameTb;
	}

	public WebElement getLastNameTb() {
		return lastNameTb;
	}

	public WebElement getMidddleNameTb() {
		return midddleNameTb;
	}

	public WebElement getEmailTb() {
		return emailTb;
	}

	public WebElement getCreateUSerBtn() {
		return createuserbtn;
	}


	@FindBy(name="passwordText") private WebElement pwtb;
	@FindBy(name="passwordTextRetype") private WebElement repwtb;
	@FindBy(name="firstName") private WebElement firstNameTb;
	@FindBy(name="lastName") private WebElement lastNameTb;
	@FindBy(name="middleName") private WebElement midddleNameTb;
	@FindBy(name="email") private WebElement emailTb;
	@FindBy(xpath="//input[@type='submit']") private WebElement createuserbtn;
	
	
	@FindBy(xpath="//td[@class='listtblcell userNameTableCell userWithoutGroupCell']") private List<WebElement> users;


	
	public void createUser(String un,String pwd,String repwd,String fn,String ln,String mn,String email)
	{
		untb.sendKeys(un);
		pwtb.sendKeys(pwd);
		repwtb.sendKeys(repwd);
		firstNameTb.sendKeys(fn);
		lastNameTb.sendKeys(un);
		midddleNameTb.sendKeys(un);
		emailTb.sendKeys(email);
		createuserbtn.click();
	}
	
public List<WebElement> getUSers()
{
	return users;
}
public void getUSerText(String expText)
{
	for(int i=0;i<users.size();i++)
	{
		String text=users.get(i).getText();
		if(text.contains(expText))
		{
			System.out.println(users.get(i).getText());
			Assert.assertTrue(true);
			Reporter.log("user is successfully created and Displayed in List of users", true);
			break;
		}
		else
		{
			Reporter.log("user is not successfully created and  Displayed in List of users", true);
			Assert.assertTrue(false);
			
		}
		
	}
}
	
	
	
	
		

	
	



	@FindBy(xpath="//td[@class='pagetitle']/..//input[@type='button']")  private WebElement createubtn;
	public WebElement getAddUSerBtn()
	{
		return createubtn;
	}
	
	public void clickAddUserBtn()
	{
		createubtn.click();
	}
	
	@FindBy(xpath="//td[contains(text(),'New User')]") private WebElement createuserText;
	public WebElement  getcreateUSerText()
	{
		return createuserText;
	}
public String getTextCreateUser()
{
	return createuserText.getText();
}
   //initiallization
	public UserListPage( WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
}
