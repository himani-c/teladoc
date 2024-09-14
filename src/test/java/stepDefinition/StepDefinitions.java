package stepDefinition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.internal.AbstractParallelWorker.Arguments;

import com.factory.DriverFactory;
import com.pages.HomePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinitions {

	WebDriver driver=DriverFactory.getDriver();
	HomePage homePage=new HomePage(driver);	
	Map<String,String> record;
	
	@Given("User is on home page of the application")
	public void user_is_on_home_page_of_the_application() {		  
		//Validating that home page is loaded successfully 
		homePage.searchBox.isDisplayed();		 
	}
	
	@When("User click on Add User button and add new user")
	public void User_click_on_Add_User_button_and_add_new_user(DataTable datatable) {
		
		//Click on add user 
		 homePage.addUserButton.click();
		 List<String> data=datatable.asLists().get(0);
		 
		 //Fetching Data from DataTable and storing into a HashMap 
		 record=new HashMap<String,String>();
		 record.put("FirstName", data.get(0));
		 record.put("LastName", data.get(1));
		 record.put("UserName", data.get(2));
		 record.put("Password", data.get(3));
		 record.put("Role", data.get(5));
		 record.put("email", data.get(6));
		 record.put("mobilePhone", data.get(7));		 
		 		 		 
		 //Entering user details in the form
		 homePage.FirstName.clear();
		 homePage.FirstName.sendKeys(record.get("FirstName"));
		 
		 homePage.LastName.clear();
		 homePage.LastName.sendKeys(record.get("LastName"));
		 
		 homePage.UserName.clear();
		 homePage.UserName.sendKeys(record.get("UserName"));
		 
		 homePage.Password.clear();
		 homePage.Password.sendKeys(record.get("Password"));
		 
		 homePage.email.clear();
		 homePage.email.sendKeys(record.get("email"));
		 
		 homePage.mobilePhone.clear();
		 homePage.mobilePhone.sendKeys(record.get("mobilePhone"));
		 
		 //homePage.customer.clear();
		 homePage.customer.click();
		 		 
		 homePage.selectDropDownValueByIndex(homePage.dropDownRole);		 
		 //Submit the Form to save the user details 
		 homePage.saveButton.click();
	}
	@Then("validate the user has been added to the table")
	public void validate_the_user_has_been_added_to_the_table()
	{		
		 //Validate details of added user on the shown UI table 
		 Assert.assertEquals(record.get("FirstName"),homePage.getXpathforTableData(record.get("FirstName")));
		 Assert.assertEquals(record.get("LastName"),homePage.getXpathforTableData(record.get("LastName")));
		 Assert.assertEquals(record.get("UserName"),homePage.getXpathforTableData(record.get("UserName")));
		 Assert.assertEquals(record.get("email"),homePage.getXpathforTableData(record.get("email")));
		 Assert.assertEquals(record.get("mobilePhone"),homePage.getXpathforTableData(record.get("mobilePhone")));		 
		
	} 
	
	@When("User click on delete User button for {string}")
	public void user_click_on_delete_user_button_for(String name) {
		 //delete the user
		 homePage.getxPathforDeleteIcon(name).click();
		 homePage.deleteOk.click();	
	}
	@Then("validate the {string} has been Delete from the table")
	public void validate_the_user_has_been_delete_from_the_table(String name) {
		
		//Validate that deleted user is not showing in the Table		 		 
		 Assert.assertFalse(homePage.checkName(name));	
	}

	}
	

