package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends BasePage {

	
	private WebDriver driver;

	@FindBy(xpath="//input[@class='pull-right ng-pristine ng-valid']")
	public WebElement searchBox;
   
	
	@FindBy(xpath="//button[@class='btn btn-link pull-right']")
	public WebElement addUserButton;	
	
		
	@FindBy(xpath="//input[@name='FirstName']")
	public WebElement FirstName;
	
	@FindBy(xpath="//input[@name='LastName']")
	public WebElement LastName;	
	
	@FindBy(xpath="//input[@name='UserName']")
	public WebElement UserName;
	
	@FindBy(xpath="//input[@name='Password']")
	public WebElement Password;
	
	@FindBy(xpath="//td[@class='ng-scope']/descendant::input[contains(@value, '15')]")
	public WebElement customer;
	
	@FindBy(xpath="//select[@name='RoleId']")
	public WebElement dropDownRole;	
	
	@FindBy(xpath="//input[@name='Email']")
	public WebElement email;
	
	@FindBy(xpath="//input[@name='Mobilephone']")
	public WebElement mobilePhone;
	
	@FindBy(xpath="//button[@class='btn btn-success']")
	public WebElement saveButton;
	
	//tr[@ng-repeat='dataRow in displayedCollection'][1]/td[1]
	@FindBy(xpath="//tr[@ng-repeat='dataRow in displayedCollection']/td[1]")
	public List<WebElement> firstNameListTable;
	
	@FindBy(xpath="//div[@class='modal-footer']/button[2]")
	public WebElement deleteOk;		
		
	public HomePage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void selectDropDownValueByIndex(WebElement ele)
	{
		Select select=new Select(ele);
		select.selectByValue("2");		
	}
	
	public Boolean checkName(String firstName)
	{
		List<String> name=new ArrayList<String>();
		for(int i=0;i<firstNameListTable.size();i++)
		if(firstName.equals(name.add(firstNameListTable.get(i).getText())))
			return true;
				
		System.out.println(name);
		    return false;		
	}
	
	public String getXpathforTableData(String name)
	{
		String xpath="//tr[@ng-repeat='dataRow in displayedCollection']/descendant::td[contains(text(),'"+name+"')]";
		String actualName=driver.findElement(By.xpath(xpath)).getText();
		return actualName;
		
	}
	
	public WebElement getxPathforDeleteIcon(String name)
	{
		String xpath="//tr[@ng-repeat='dataRow in displayedCollection']/descendant::td[contains(text(),'"+name+"')]/following-sibling::td[9]";
		WebElement actualxPath=driver.findElement(By.xpath(xpath));
		return actualxPath;
	}
}

