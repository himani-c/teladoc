package hooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class hooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	ConfigReader configReader;
	Properties prop;
	
	public hooks()
	{
		this.driver=driver;
	}
	
	@Before()
	public void beforeMethod()
	{
		configReader=new ConfigReader();
		driverFactory=new DriverFactory();		
		prop=configReader.readFile();
		//prop=configReader.readFile();
		driver=DriverFactory.factoryMethod(prop.getProperty("browser"));
		driver=DriverFactory.getDriver();
		System.out.println(prop.getProperty("browser"));
		driverFactory.navigatetoUrl(driver);
		
	}
	
	@After
	public void afterMethod()
	{
		driver.quit();
	}
}
