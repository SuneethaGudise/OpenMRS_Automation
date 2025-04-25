
Feature: Patient Visit Notes
 
 Background:
    #Given User is on OpenMRS login page
 
  #Scenario: Current Visit Actions1.
    #Given Log on to OpenMRS "<username>" and "<password>" and "<location>"
    #When Select Patient Record option "<patient_name>"
    #And Select End Visit Action
    #When click on No stays on same page
    #When click on Yes stays on same page
    #Then User again clicks on end visit and clicks confirm and check Recent Visit value.    
   # When General Action box is only displayed.
    #
    #Examples: 
      #|username |  password  |  location      |  patient_name      |
      #| admin   | Admin123   | Inpatient Ward |	New Mark Nattawat	 |
  
  Scenario: Current Visit Actions.
   Given User is on OpenMRS login page
    When User enters logon details "<username>" and "<password>" and "<location>"
    And User clicks on login button
    When User clicks on Find Patient Record option 
    Then User is directed to Find Patient record page
    When User clicks on any of the column value.
		And User Starts and End Vist Action	
     
    Examples: 
      |username |  password  |  location      |
      | admin   | Admin123   | Inpatient Ward |
    
 
    Scenario: General Actions.
   Given User is on OpenMRS login page
    When User enters logon details "<username>" and "<password>" and "<location>"
    And User clicks on login button
    When User clicks on Find Patient Record option 
    Then User is directed to Find Patient record page
    When User clicks on any of the column value.
    And User Starts and End Vist Action	
    
     Examples: 
      |username |  password  |  location      |
      | admin   | Admin123   | Inpatient Ward |
    

 #Scenario: Patient Visit and Visit Note 
 #		Given User is on OpenMRS login page
    #When User enters logon details "<username>" and "<password>" and "<location>"
    #And User clicks on login button
    #When User clicks on Find Patient Record option 
    #Then User is directed to Find Patient record page
    #When User clicks on any of the column value.
    #Then User looks for Current visit Action and General Action boxes.
  #  And User switch to Alert and clicks Cancel and stays on same page.
    #Then User again clicks on start visit and clicks confirm and check Recent Visit value. 
   # And User validates the patient visit page bread crumb links has Visit
    #Then User clicks on visit note and user is directed to Patient Visit note page.
    #Then User Add presumed or confirmed diagnosis message and verifies diagnosis section 
    #And User clicks on Save button is directed back to patient visit page
     #Examples: 
      #|username |  password  |  location      |
      #| admin   | Admin123   | Inpatient Ward |

 
 
    
