# teladoc
**Selenium-Cucumber-Java**
This repository contains a Cucumber BDD Project which contain two test scenarios for Website : https://www.way2automation.com/angularjs-protractor/webtables/

Scenario 1
Add a user and validate the user has been added to the table
Scenario 2
Delete the user "novak" from the table and validate the user has been deleted.


**Installation & Prerequisites**
JDK 1.7+ (Ensure that the Java class path is properly set)
Maven (Ensure that the .m2 class path is properly set)
Eclipse IDE
Required Eclipse Plugins:
Maven
Cucumber
testng
Browser driver (Ensure that you have the appropriate browser driver for your desired browser and that the class path is correctly configured)
Framework Setup
To set up the framework, you can fork or clone the repository and set it up in your local workspace.

**Running Sample Tests**
Access the CLI of your operating system and navigate to the project directory. Then, run the following command to execute the features: mvn clean test. By default, this command will invoke the Chrome browser and execute the tests.
There is a config file created at location :src\test\resources\configurations\config.properties so if want to change the application url or the browser name to run the tests,we can make changes in that file.Tests will pickup the url and browser name from config file.

Also as of now,data is provided in feature file in the form of data tables as part of the scenario which can be changed in particular scenario.

**Viewing the Report**
Once you have run your tests, html report will be generated in target folder of the Project directy with the name as : myreport.html

Tests are written in the Cucumber framework using the Gherkin syntax and testng testing framework.

**Page Object Design Pattern**
To better organise the code,this project has been desgined using Page Object Design pattern wherein all the Locators and their respectie related methods has been written in separate page classes which al  low for usability.
Another benefit is that we can create tests with different steps and all those steps can have common locators or methods to be used.So if any locator needs to be changed then we need to make changes as one place only.







