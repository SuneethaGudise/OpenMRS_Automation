

Feature: OpenMRS

Background: 
		
 
  Scenario: Login
    Given Verify browser is open 
    And User in on the openMrs site
    Then User enters the username
    And User enters the password
    And User selects the Location session
    Then User clicks on Login button
   

  
  Scenario: Find patient record in Inpatient Ward
  	Given Verify the user is on Inpatient Ward page
  	And User clicks on Find Patient Record option
  	Then User is on Find Patient Record page
  	And User selects the Identifier number under Identifier column.
  	When User lands on the patient page the details on the header should match with clicked row values in Final {atient Record page
  	
  
  Scenario: Scheduling Visit Notes
  
  Scenario: Capture Vital record
   