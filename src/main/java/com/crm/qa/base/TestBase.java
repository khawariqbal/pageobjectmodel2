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
			FileInputStream propfile = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\PageObjectModel\\src\\main\\java\\com\\crm\\"
					+ "qa\\config\\config.properties");

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
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\PageObjectModel\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("FF"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Admin\\eclipse-workspace\\PageObjectModel\\geckodriver.exe");
			driver=new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implecite_Wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url")); // url => comes from config properties file
	}

}
