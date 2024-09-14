package com.factory;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.utils.ConfigReader;

public class DriverFactory {

	public static WebDriver driver;
	ConfigReader configReader;
	Properties prop;
	
	public DriverFactory()
	{
		this.driver=driver;
	}
	
	public static WebDriver factoryMethod(String browser)
	
	{		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\himani.jain\\Downloads\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
	    
		if(driver!=null)
			return driver;
		if(browser.equalsIgnoreCase("Chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("Mozilla"))
		{
			driver=new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		return driver;
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}
	
	public WebDriver navigatetoUrl(WebDriver driver)
	{
		configReader=new ConfigReader();
		prop=configReader.readFile();
		System.out.println("Url to be entered is:"+prop.getProperty("url"));
		driver.get(prop.getProperty("url"));
		return driver;
		
	}
}
