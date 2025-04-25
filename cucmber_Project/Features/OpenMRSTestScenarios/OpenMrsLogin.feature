

Feature: OpenMrsLogin 

  	#Background: 
  	#Given User is on OpenMRS login page
	
    Scenario: Successful login
    Given User is on OpenMRS login page
    #Given User is on the OpenMRS login page
    #And User select location "<location1>"
    When User enters logon details "<username>" and "<password>" and "<location>"
    #When User enter username "<username>"
   # And User enter password "<password>"
    #And User select location "<location>"
    And User clicks on login button
    Then User should be redirected to the OpenMRS home page with "<username>" and "<location>" in headers
    

    Examples: 
      |username |  password  |  location      |
      | admin   | Admin123   | Inpatient Ward |
      #| admin   | Admin123   |  Pharmacy      |
      
      
		Scenario: Invalid login credentials
		 Given User is on OpenMRS login page
#		When User enter username "<username>"
    #And User enter password "<password>"
    #When User select location "<location>"
    When User enters logon details "<username>" and "<password>" and "<location>"
    And User clicks on login button
    Then User verify invalid login error text 
    
		Examples: 
      |username   |  password  |  location     |
      | admin134  | Admin123   | Inpatient Ward |
     # | admin     | admin123   |  Pharmacy      |
      #|           | admin123   |  Laboratory    |
      #| admin     | 			     |  Pharmacy      |
      #|           |            | Inpatient Ward |
      
		