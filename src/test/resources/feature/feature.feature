Feature: Webtables Automation
Story:
As an Engr. Candidate
I need to automate http://www.way2automation.com/angularjs-protractor/webtables/
So that I can show my awesome automation skills
  
  Scenario: Add a user and validate the user has been added to the table
    Given User is on home page of the application
    When User click on Add User button and add new user
     | TestUser | Lname | Uname | password | Company AAA | Admin | admin@gmail.com | 9988776655 |
    Then validate the user has been added to the table
    
   Scenario: Delete the user "Novak" from the table and validate the user has been deleted.
    Given User is on home page of the application
    When User click on delete User button for "Novak"
        Then validate the "Novak" has been Delete from the table
    
 
     
     

   
