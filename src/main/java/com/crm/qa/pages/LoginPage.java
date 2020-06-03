package com.crm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class LoginPage extends TestBase {
	
	// Page Factory - Object repository = OR
	
	@FindBy(name="username") // getting element by name // You can use any required locator.
	WebElement username;

	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	// Verify OR check some Elements in Login page i.e. signUp button , Logo etc.
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	// Constructor class OR Initialization of page objects.
	public LoginPage()
	{
		// create page factory class
		PageFactory.initElements(driver, this); // driver is coming from TestBase Class & "This" keyword is showing as current class object (LogniPage)
		
	}
	
	// Actions
	/*public String validateTitleOfThePage()
	{
		return driver.getTitle();
	}*/
	
	public boolean validateCRMLogo()
	{
		return crmLogo.isDisplayed();
	
	}
	
	public HomePage login(String USERNAME, String PASSWORD)
	{
		username.sendKeys(USERNAME);
		password.sendKeys(PASSWORD);
		JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", loginBtn);		
		return new HomePage();
	}
}
