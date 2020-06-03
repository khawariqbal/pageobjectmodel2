package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.util.TestUtil;

public class TestBase {


	public static WebDriver driver;
	public static Properties prop;

	// Constructor
	public TestBase()
	{

		try {
			prop=new Properties();

			// Read properties file
			FileInputStream propfile = new FileInputStream("/home/khawer/eclipse-workspace/PageObjectModel2/src/main/java/com/crm/qa/config/config.properties");

			prop.load(propfile);
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();	
		} 
		catch (IOException e) 
		{

			e.printStackTrace();
		} /*catch (Exception e) {
			Log.debug("Null pointer exception");
			e.printStackTrace();
		}*/

	}
	
	// To initialization of browser
	public static void initilization() 
	{

		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "/home/khawer/eclipse-workspace/PageObjectModel2/chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("ff"))
		{
			System.setProperty("webdriver.gecko.driver", "/home/khawer/eclipse-workspace/PageObjectModel2/geckodriver");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implecite_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url")); // url => comes from config properties file
	}

}
