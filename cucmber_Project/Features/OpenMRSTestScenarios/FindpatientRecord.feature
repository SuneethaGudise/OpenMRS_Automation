
Feature: Find Patient Record option

	#Background: 
  #	Given User on login page

  Scenario: Verify Find Patient Record option steps
   Given User is on OpenMRS login page
  
   When User enters logon details "<username>" and "<password>" and "<location>"
   And User clicks on login button
  # Then User should be redirected to the OpenMRS home page with "<username>" and "<location>" in headers
    When User clicks on Find Patient Record option 
    Then User is directed to Find Patient record page
    And User verifies the icon text and header text macthes with selected option
    And User veriifes search box dispalyed under the header
    Then User verifies the patient record table is displayed.
    And User veriifes all the column values are clickable
    When User clicks on any of the column value.
    Then User lands on Patient record page  
    
    Examples: 
      |username |  password  |  location      |
      | admin   | Admin123   | Inpatient Ward |
    
    
      

 