package testRunner;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



	@CucumberOptions(
			features="src/test/resources/feature",
			glue={"stepDefinition","hooks"},

			plugin="html:target/myreport.html")
			
	public class TestRunner extends AbstractTestNGCucumberTests {

}
