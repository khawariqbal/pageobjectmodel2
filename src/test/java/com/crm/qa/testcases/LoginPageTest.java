package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpageobject;
	HomePage homepage;

	// To call TestBase class constructor / Create constructor of LoginPageTest
	public LoginPageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		// To calling browser intilization method
		initilization();

		// create object of Loginpage
		loginpageobject=new LoginPage();
	}

	/*@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title=loginpageobject.validateTitleOfThePage();
		Assert.assertEquals(title,"CRMPRO  - CRM software for customer relationship management, sales, and support.");
	}*/
	@Test(priority=2)
	public void crmLogoImageTest()
	{
		boolean flag=loginpageobject.validateCRMLogo();
		Assert.assertTrue(flag);
		
	}
	@Test(priority=3)
	public void loginTest()
	{
		homepage=loginpageobject.login(prop.getProperty("username"), prop.getProperty("password"));
		
	
	}
	
	@AfterMethod
	public void teaddown()
	{

		driver.quit();
	}

}
