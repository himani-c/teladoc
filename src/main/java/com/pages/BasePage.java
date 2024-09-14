package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	public WebDriver driver;
	
	public BasePage()
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnElement(By ele)
	{
		
		driver.findElement(ele).click();
	}
	
	public void clickOnElement(WebElement ele)
	{
		ele.click();
	}
	

	public boolean isElementPresent(WebElement ele)
	{
		return ele.isDisplayed();
		
	}
}
